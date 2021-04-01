package oop.ex6.main;

import oop.ex6.main.compiler.Compiler;
import oop.ex6.main.compiler.FileRead;
import oop.ex6.main.exceptions.SystemGeneralError;
import oop.ex6.main.exceptions.file.IllegalArgsNumber;
import oop.ex6.main.language.Const;
import oop.ex6.main.language.Messages;

import java.io.File;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;


/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent the main of our system that run the compiler.
 */
public class Sjavac {
    /**
     * this is the main method
     *
     * @param args file path that we want to compile
     */
    public static void main(String[] args) {
        try {
            try {
                if (args.length == Const.ARG_NUMBER) {
                    Map<String, String> keywordsInSJava = keysLoader(new FactoryBuilder().getFactories());
                    Compiler compiler = new Compiler(new FileRead(new File(args[0])), keywordsInSJava);
                    System.out.println(Messages.COMPILING_SUCCEEDED);
                } else throw new IllegalArgsNumber(Messages.ARGS_NUMBER_WRONG);
            } catch (oop.ex6.main.exceptions.file.GeneralError e) {
                System.out.println(Messages.COMPILING_FILE_FAIL);
                System.err.print(Messages.ERROR);
                e.printStackTrace();
            } catch (oop.ex6.main.exceptions.compiler.GeneralError e) {
                throw new SystemGeneralError(Messages.SYSTEM_GENERAL_ERROR, e);
            }
        } catch (SystemGeneralError e) {
            System.out.println(Messages.COMPILING_FAIL);
            System.err.print(Messages.ERROR);
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(Messages.UNEXPECTED_EXCEPTION);
            e.printStackTrace();
        }
    }

    /**
     * this method load all the keywords into a map. the keywords are special words and symbol that our
     * compiler support.
     *
     * @param factories collection of our factories in our compiler
     * @return map of all of our keywords
     * @throws SystemGeneralError if some error accrue when we load the keywords
     */
    private static Map<String, String> keysLoader(Collection<String> factories) throws SystemGeneralError {
        Map<String, String> keys = new Hashtable<String, String>();
        for (String factory : factories)
            keys.putAll(initializeKeywordsFromFactory(factory));
        return keys;
    }

    /**
     * this method load all the keywords from one factories into a map.
     * the keywords are special words and symbol that our compiler support.
     *
     * @param factoryName a factory name that we want to get his keys
     * @return map of all of our keywords in this factories
     * @throws SystemGeneralError if some error accrue when we load the keywords
     */
    private static Map<String, String> initializeKeywordsFromFactory(String factoryName) throws SystemGeneralError {
        return new FactoryBuilder().createFactory(factoryName).getKeywords();
    }

}
