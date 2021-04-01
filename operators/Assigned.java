package oop.ex6.main.operators;


import oop.ex6.main.exceptions.variables.GeneralError;
import oop.ex6.main.language.Keywords;
import oop.ex6.main.variables.Variable;


/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent the assigned operator in our compiler.
 */
public class Assigned extends Operator {
    static final String NAME = Keywords.ASSIGNED;

    /**
     * contractor of empty Assigned
     */
    public Assigned() {
        this.setName(NAME);
    }

    /**
     * contractor of Assigned
     *
     * @param value    value we want to assigned to variable
     * @param variable variable
     * @throws GeneralError in case we got error by use the operator
     */
    public Assigned(Variable variable, String value) throws GeneralError {
        this.setVariable(variable);
        variable.setVarValue(value);
    }
}
