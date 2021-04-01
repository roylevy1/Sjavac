package oop.ex6.main.loops;

import oop.ex6.main.Symbol;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This abstract class represent loop in our compiler.
 */
public abstract class Loop extends Symbol {
    private String conditions;

    /**
     * @return the condition of a loop
     */
    public String getConditions() {
        return this.conditions;
    }

    /**
     * this method set the condition of a loop
     *
     * @param conditions condition
     */
    public void setConditions(String conditions) {
        this.conditions = conditions;
    }


}
