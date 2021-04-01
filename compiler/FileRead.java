package oop.ex6.main.compiler;

import oop.ex6.main.exceptions.file.*;
import oop.ex6.main.language.Keywords;
import oop.ex6.main.language.Messages;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent the a file reader that read the file and reorder his global vars before
 *         sections(etc method, compiler...).
 */
public class FileRead {
    private File SjavaFile;
    private List<String> fileData;
    private List<String> fileOrdered = new ArrayList<String>();
    private List<int[]> innerReorderFile = new ArrayList<int[]>();
    private Iterator<String> iterator;
    private int lineIndex = 1;

    /**
     * this is constructor of if File read.
     *
     * @param SjavaFile the file we want to read
     * @throws GeneralError if some error accrue in our processes to read the file
     */
    public FileRead(File SjavaFile) throws GeneralError {
        this.SjavaFile = SjavaFile;
        fileData = this.fileToArray();
        this.reorderFile();
    }

    /**
     * @return the file that ordered as list
     */
    public List<String> getFileOrdered() {
        return this.fileOrdered;
    }

    /**
     * @return the file as list
     * @throws GeneralError if some error accrue in our processes to read the file
     */
    private List<String> fileToArray() throws GeneralError {
        try {
            if (this.SjavaFile == null)
                throw new NullPointer(Messages.NULL_POINTER);
            ArrayList<String> fileAsArray = new ArrayList<String>();
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(this.SjavaFile));
                String line = reader.readLine();
                while (line != null) {
                    fileAsArray.add(line);
                    line = reader.readLine();
                }
            } catch (FileNotFoundException e) {
                throw new NotFound(Messages.FILE_NOT_FOUND + this.SjavaFile, e);
            } catch (IOException e) {
                throw new IOProblem(Messages.IO_ERROR, e);
            } finally {
                try {
                    if (reader != null)
                        reader.close();
                    else
                        throw new GeneralError(Messages.GENERAL_ERROR + Keywords.FILE);
                } catch (IOException e) {
                    throw new CantCloseFile(Messages.CANT_CLOSE_FILE + this.SjavaFile, e);
                }
            }
            return fileAsArray;
        } catch (NullPointer | CantCloseFile | NotFound | IOProblem e) {
            throw new GeneralError(Messages.GENERAL_ERROR + Keywords.FILE, e);
        }
    }

    /**
     * @return iterator of the ordered file
     */
    Iterator<String> fileIterator() {
        return this.fileOrdered.iterator();
    }

    /**
     * this method finish reorder the file that the global var will be before the sections
     *
     * @throws GeneralError if some error accrue in our processes to read the file
     */
    private void reorderFile() throws GeneralError {
        this.ordering(this.fileToArray());
        if (this.innerReorderFile.size() > 0)
            for (int[] lines : this.innerReorderFile)
                this.fileOrdered.addAll(this.fileToArray().subList(lines[0], lines[1]));
    }

    /**
     * this method reorder the file that the global var will be before the sections
     *
     * @param fileAsList the file as list
     */
    private void ordering(List<String> fileAsList) {
        this.iterator = fileAsList.iterator();
        String line = iterator.next();
        while (this.iterator.hasNext()) {
            if (line.contains(Keywords.BRACES_LEFT))
                this.sectionSkip();
            else
                this.fileOrdered.add(line);
            if (this.iterator.hasNext())
                line = this.iterator.next();
            this.lineIndex++;
        }
        if (line.contains(Keywords.SEMICOLON) || line.contains(Keywords.COMMENT_LINE) ||
                line.contains(Keywords.BRACES_RIGHT))
            this.fileOrdered.add(line);
    }

    /**
     * this method skip lines that are inside sections.
     */
    private void sectionSkip() {
        String line;
        int startLine = this.lineIndex;
        int bracesLeftNumber = 1;
        int bracesRightNumber = 0;
        while (this.iterator.hasNext() && bracesRightNumber != bracesLeftNumber) {
            line = this.iterator.next();
            lineIndex++;
            if (line.contains(Keywords.BRACES_LEFT))
                bracesLeftNumber++;
            else if (line.contains(Keywords.BRACES_RIGHT))
                bracesRightNumber++;
        }
        this.innerReorderFile.add(new int[]{startLine - 1, this.lineIndex});
    }
}
