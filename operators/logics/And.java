package oop.ex6.main.operators.logics;

import oop.ex6.main.language.Keywords;
import oop.ex6.main.variables.Boolean;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent the And logic operator in our compiler.
 */
public class And extends Logic {
    static final String NAME = Keywords.AND;

    /**
     * contractor of And
     *
     * @param firstElement  boolean of the first condition
     * @param secondElement boolean of the second condition
     */
    public And(Boolean firstElement, Boolean secondElement) {
        super(firstElement, secondElement);
        this.setName(NAME);
    }

    /**
     * contractor of And
     *
     * @param firstElement  logic that contains 2 booleans
     * @param secondElement logic that contains 2 booleans
     */
    public And(Logic firstElement, Logic secondElement) {
        super(firstElement, secondElement);
        this.setName(NAME);
    }

    /**
     * contractor of And
     *
     * @param logic      logic that contains 2 booleans
     * @param booleanVar boolean of with 1 condition
     */
    public And(Logic logic, Boolean booleanVar) {
        super(logic, booleanVar);
        this.setName(NAME);
    }
}
