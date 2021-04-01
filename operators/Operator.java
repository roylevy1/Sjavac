package oop.ex6.main.operators;

import oop.ex6.main.Symbol;
import oop.ex6.main.variables.Variable;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This abstract class represent operator in our compiler.
 */
public abstract class Operator extends Symbol {
    private Variable variable;

    /**
     * @return operator variable
     */
    public Variable getVariable() {
        return this.variable;
    }

    /**
     * this method set the operator variable
     *
     * @param variable variable to set
     */
    public void setVariable(Variable variable) {
        this.variable = variable;
    }
}
