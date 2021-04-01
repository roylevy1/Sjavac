package oop.ex6.main;

import oop.ex6.main.exceptions.SystemGeneralError;

import java.util.Map;


/**
 * @author sharonbash
 * @author roy.levy3
 *         This interface represent the factory of the program.
 */
public interface Factory {
    /**
     * this create a Symbol from a factory
     *
     * @param symbol symbol name
     * @return Symbol Object fit to the name
     * @throws SystemGeneralError in case we got error by create it.
     */
    Symbol create(java.lang.String symbol) throws SystemGeneralError;

    /**
     * @return the name of the Symbol meaning his type
     */
    String getName();

    /**
     * @return all the keywords of the factory
     */
    Map<String, String> getKeywords();
}
