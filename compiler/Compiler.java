package oop.ex6.main.compiler;

import oop.ex6.main.Symbol;
import oop.ex6.main.exceptions.compiler.*;
import oop.ex6.main.exceptions.sections.NotFound;
import oop.ex6.main.exceptions.sections.RightBracesNotFound;
import oop.ex6.main.exceptions.sections.lines.IllegalLine;
import oop.ex6.main.keywords.comments.CommentFactory;
import oop.ex6.main.language.Keywords;
import oop.ex6.main.language.Messages;
import oop.ex6.main.language.Regexs;
import oop.ex6.main.variables.Variable;
import oop.ex6.main.variables.VariableFactory;

import java.util.*;

import static oop.ex6.main.FactoryBuilder.MODIFIERS;


/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent the compiler of the program.
 */
public class Compiler extends Symbol {
    private static final String START_OF_SECTION = Keywords.BRACES_LEFT;
    private static final String END_OF_SECTION = Keywords.BRACES_RIGHT;
    private static final String END_OF_METHOD = Keywords.RETURN;
    private static final String END_OF_LINE = Keywords.SEMICOLON;
    private static final String NAME = Keywords.COMPILER;
    private static Map<String, String> keywordsInSJava;
    private Stack<Variable> parameters;
    private Stack<Variable> variables = new Stack<Variable>();
    private Stack<Method> methods = new Stack<Method>();
    private Iterator<String> iterator;

    /**
     * this is empty contractor of compiler
     */
    Compiler() {
        this.setName(NAME);
    }

    /**
     * this is contractor of compiler
     *
     * @param file            file we want to compile
     * @param keywordsInSJava all keywords that in our compiler system
     * @throws GeneralError in case we had problem with create the section.
     */
    public Compiler(FileRead file, Map<String, String> keywordsInSJava) throws GeneralError {
        try {
            this.setName(NAME);
            this.keywordsInSJava = keywordsInSJava;
            this.initMethods(file);
            this.iterator = file.fileIterator();
            while (this.iterator.hasNext())
                this.readCommend(this.iterator.next().trim(), this);
        } catch (CantCreateMethod | CantReadCommend e) {
            throw new GeneralError(Messages.GENERAL_ERROR + NAME, e);
        }
    }

    /**
     * this method is init the method stack with all the method that create in the compiler section aka
     * global section
     *
     * @param file file we want to compile
     * @throws CantCreateMethod if we cant create the method
     */
    private void initMethods(FileRead file) throws CantCreateMethod {
        this.iterator = file.fileIterator();
        while (this.iterator.hasNext()) {
            String line = this.iterator.next().trim();
            String[] dataInLine = line.split(Regexs.AT_LEAST_WHITE_SPACE);
            if (!this.checkIfLineIsComment(dataInLine) && !dataInLine[0].equals(Regexs.EMPTY_STRING)
                    && this.checkIfSectionStart(dataInLine) && this.checkIfThisIsMethod(dataInLine[0]))
                this.createMethod(dataInLine, this);
        }
    }

    /**
     * this method read the commend line of a file
     *
     * @param line   line in string
     * @param parent the parent of this line.
     * @throws CantReadCommend if we cant read the commend line of a file
     */
    private void readCommend(String line, Compiler parent) throws CantReadCommend {
        try {
            String[] dataInLine = line.split(Regexs.AT_LEAST_WHITE_SPACE);
            if (!this.checkIfLineIsComment(dataInLine) && !dataInLine[0].equals(Regexs.EMPTY_STRING)) {
                if (this.checkIfThisIsLine(dataInLine))
                    this.createLine(dataInLine, parent);
                else if (this.checkIfSectionStart(dataInLine))
                    this.createSection(dataInLine, parent);
                else
                    throw new IllegalLine(Messages.LINE_IS_ILLEGAL);
            }
        } catch (IllegalLine | CantCreateSection | CantCreateLine e) {
            throw new CantReadCommend(Messages.COMPILER_UNABLE_TO_READ_COMMEND, e);
        }

    }

    /**
     * this method create a section
     *
     * @param dataInLine line in string
     * @param parent     the parent of this line.
     * @throws CantCreateSection if we cant create the section
     */
    private void createSection(String[] dataInLine, Compiler parent) throws CantCreateSection {
        try {
            Section section;
            if (this.checkIfThisIsMethod(dataInLine[0])) {
                section = this.createMethod(dataInLine, parent);
            } else if (this.checkIfThisIsLoop(dataInLine[0].split(Regexs.PARENTHESES_LEFT)[0]))
                section = new Loop(dataInLine, parent);
            else throw new NotFound(Messages.NOT_FOUND);
            String line = this.iterator.next().trim();
            while (!line.equals(END_OF_SECTION) && !line.equals(END_OF_METHOD + END_OF_LINE)) {
                this.readCommend(line, section);
                line = this.iterator.next().trim();
            }
            if (line.equals(END_OF_METHOD + END_OF_LINE))
                if (!this.iterator.next().trim().equals(END_OF_SECTION))
                    throw new RightBracesNotFound(Messages.END_OF_SECTION_NOT_FOUND);
        } catch (CantReadCommend | CantCreateMethod | oop.ex6.main.exceptions.sections.GeneralError e) {
            throw new CantCreateSection(Messages.COMPILER_UNABLE_TO_CREATE_SECTION, e);
        }
    }

    /**
     * this method create a method
     *
     * @param dataInLine line in string
     * @param parent     the parent of this line.
     * @return a section that represent this method.
     * @throws CantCreateMethod if we cant create the method
     */
    private Section createMethod(String[] dataInLine, Compiler parent) throws CantCreateMethod {
        try {
            List<String> data = new ArrayList<String>(Arrays.asList(dataInLine));
            data.remove(dataInLine[0]);
            String allVarsAndValues = String.join(Regexs.ONE_WHITE_SPACE, data.toArray(new String[0]));
            Variable methodType = new VariableFactory().create(dataInLine[0], parent);
            methodType.setVarName(allVarsAndValues.split(Regexs.PARENTHESES_LEFT)[0]);
            return new Method(dataInLine, this, methodType);
        } catch (oop.ex6.main.exceptions.sections.GeneralError |
                oop.ex6.main.exceptions.variables.GeneralError e) {
            throw new CantCreateMethod(Messages.COMPILER_UNABLE_TO_CREATE_METHOD, e);
        }
    }

    /**
     * this method create a line
     *
     * @param dataInLine line in string
     * @param parent     the parent of this line.
     * @throws CantCreateLine if we cant create the line
     */
    private void createLine(String[] dataInLine, Compiler parent) throws CantCreateLine {
        try {
            Line line = new Line(dataInLine, parent);
        } catch (oop.ex6.main.exceptions.sections.lines.GeneralError e) {
            throw new CantCreateLine(Messages.COMPILER_UNABLE_TO_CREATE_LINE, e);
        }
    }

    /**
     * this method check if the line start with variable declare aka variable type
     *
     * @param dataInLine line in string
     * @return true if we got a variable declare aka variable type
     */
    boolean isVariable(String dataInLine) {
        return dataInLine != null && this.keywordsInSJava.containsKey(dataInLine)
                && this.keywordsInSJava.get(dataInLine).equals(Keywords.VARIABLE_FACTORY);
    }

    /**
     * this method check if the line start with modifier
     *
     * @param dataInLine line in string
     * @return true if we got a modifier
     */
    boolean isModifier(String dataInLine) {
        return dataInLine != null && this.keywordsInSJava.containsKey(dataInLine) &&
                this.keywordsInSJava.get(dataInLine).equals(MODIFIERS);
    }

    /**
     * this method check if this section is a loop
     *
     * @param dataInLine line in string
     * @return true if we got a loop
     */
    private boolean checkIfThisIsLoop(String dataInLine) {
        return dataInLine != null && this.keywordsInSJava.containsKey(dataInLine)
                && this.keywordsInSJava.get(dataInLine).equals(Keywords.LOOP_FACTORY);
    }

    /**
     * this method check if this section is a method
     *
     * @param dataInLine line in string
     * @return true if we got a method
     */
    private boolean checkIfThisIsMethod(String dataInLine) {
        return dataInLine != null && this.keywordsInSJava.containsKey(dataInLine)
                && this.keywordsInSJava.get(dataInLine).equals(Keywords.VARIABLE_FACTORY);
    }

    /**
     * this method check if the got symbol that represent that the we got a line
     *
     * @param dataInLine line in string
     * @return true if we got a line
     */
    private boolean checkIfThisIsLine(String[] dataInLine) {
        return this.getLastCharOfLine(dataInLine).equals(END_OF_LINE);
    }

    /**
     * this method check if the got symbol that represent that the section need to start
     *
     * @param dataInLine line in string
     * @return true if we go the symbol
     */
    private boolean checkIfSectionStart(String[] dataInLine) {
        return this.getLastCharOfLine(dataInLine).equals(START_OF_SECTION);
    }

    /**
     * @param dataInLine line in string
     * @return this method get the last char of the line
     */
    private String getLastCharOfLine(String[] dataInLine) {
        int lengthOfLine = dataInLine.length;
        return dataInLine[lengthOfLine - 1].substring(dataInLine[lengthOfLine - 1].length() - 1);
    }

    /**
     * this method check if line is a comment line
     *
     * @param dataInLine line in string
     * @return true if it a comment line
     */
    private boolean checkIfLineIsComment(String[] dataInLine) {
        Map<String, String> allComments = new CommentFactory().getKeywords();
        for (String commentType : allComments.keySet())
            if (dataInLine[0].startsWith(commentType) && this.keywordsInSJava.containsKey(commentType))
                return true;
        return false;
    }

    /**
     * @return the parameter list stack
     */
    public Stack<Variable> getParameters() {
        return this.parameters;
    }

    /**
     * @return the variable stack
     */
    public Stack<Variable> getVariableStack() {
        return this.variables;
    }

    /**
     * this method set a stack into the variable stack
     *
     * @param stack stack we want to set
     */

    public void setVariableStack(Stack<Variable> stack) {
        this.variables = stack;
    }

    /**
     * @return the method stack
     */
    public Stack<Method> getMethodStack() {
        return this.methods;
    }

    /**
     * this method search in stack of variable and check if the keyword there
     *
     * @param stack   stack to search in
     * @param keyword keyword to search
     * @return the distance from the top of the stack that the item there
     */
    int searchInVarStack(Stack<Variable> stack, String keyword) {
        int elementsCounter = 0;
        for (Variable variable : stack) {
            if (variable.getVarName().equals(keyword))
                break;
            elementsCounter++;
        }
        return stack.size() - elementsCounter - 1;
    }

    /**
     * this method search in stack of method and check if the keyword there
     *
     * @param stack   stack to search in
     * @param keyword keyword to search
     * @return the distance from the top of the stack that the item there
     */
    int searchInMethodStack(Stack<Method> stack, String keyword) {
        int elementsCounter = 0;
        for (Method method : stack) {
            if (method.getMethodAsVariable().getVarName().equals(keyword))
                break;
            elementsCounter++;
        }
        return stack.size() - elementsCounter - 1;
    }
}
