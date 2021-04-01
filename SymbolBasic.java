package oop.ex6.main;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This interface represent a symbol in our compiler.
 */
public interface SymbolBasic {

    /**
     * @return Symbol name
     */
    String getName();

    /**
     * this method set the name of Symbol
     *
     * @param name symbol name for set
     */
    void setName(String name);
}
