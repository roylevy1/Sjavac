package oop.ex6.main.operators.logics;

import oop.ex6.main.operators.Operator;
import oop.ex6.main.variables.Boolean;

/**
 * Created by Roy on 23-Jun-17.
 */
public abstract class Logic extends Operator {
    private Boolean firstBoolean, secondBoolean;
    private Logic firstLogic, secondLogic;

    /**
     * contractor of Logic
     *
     * @param firstElement  boolean of the first condition
     * @param secondElement boolean of the second condition
     */
    Logic(Boolean firstElement, Boolean secondElement) {
        this.setBooleanElements(firstElement, secondElement);
    }

    /**
     * contractor of Logic
     *
     * @param firstElement  logic that contains 2 booleans
     * @param secondElement logic that contains 2 booleans
     */
    Logic(Logic firstElement, Logic secondElement) {
        this.setLogic(firstElement, secondElement);
    }

    /**
     * contractor of Logic
     *
     * @param logic      logic that contains 2 booleans
     * @param booleanVar boolean of with 1 condition
     */
    Logic(Logic logic, Boolean booleanVar) {
        this.setBooleanElements(booleanVar, null);
        this.setLogic(logic, null);
    }

    /**
     * this method set boolean for logic operator
     *
     * @param firstElement  boolean of the first condition
     * @param secondElement boolean of the second condition
     */
    private void setBooleanElements(Boolean firstElement, Boolean secondElement) {
        this.firstBoolean = firstElement;
        if (secondElement != null)
            this.secondBoolean = secondElement;
    }

    /**
     * this method set logic objects for logic operator
     *
     * @param firstLogic  logic that contains 2 booleans
     * @param secondLogic logic that contains 2 booleans
     */
    private void setLogic(Logic firstLogic, Logic secondLogic) {
        this.firstLogic = firstLogic;
        if (secondLogic != null)
            this.secondLogic = secondLogic;
    }

    /**
     * @return first boolean
     */
    public Boolean getFirstBoolean() {
        return this.firstBoolean;
    }

    /**
     * @return Second boolean
     */
    public Boolean getSecondBoolean() {
        return this.secondBoolean;
    }

    /**
     * @return first logic operator
     */
    public Logic getFirstLogic() {
        return this.firstLogic;
    }

    /**
     * @return Second logic operator
     */
    public Logic getSecondLogic() {
        return this.secondLogic;
    }
}

