package oop.ex6.main;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This abstract class represent the symbol in our compiler.
 */
public abstract class Symbol implements SymbolBasic {
    private String name;

    /**
     * @return Symbol name
     */
    public String getName() {
        return this.name;
    }

    /**
     * this method set the name of Symbol
     *
     * @param name symbol name for set
     */
    public void setName(String name) {
        this.name = name;
    }
}
