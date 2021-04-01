package oop.ex6.main.variables;

import oop.ex6.main.compiler.Compiler;
import oop.ex6.main.exceptions.variables.GeneralError;
import oop.ex6.main.exceptions.variables.IllegalVariableName;
import oop.ex6.main.language.Const;
import oop.ex6.main.language.Keywords;

import java.lang.String;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent the boolean variable in our compiler.
 */
public class Boolean extends Variable {
    static final java.lang.String NAME = Keywords.BOOLEAN;

    /**
     * contractor of empty Boolean
     */
    public Boolean() {
        this.setName(NAME);
    }

    /**
     * contractor of Boolean
     *
     * @param parent  the section that the variable belongs to it.
     * @param varName void name
     * @throws GeneralError in case we got error by create the variable
     */
    public Boolean(java.lang.String varName, Compiler parent) throws GeneralError {
        super(varName, parent);
        this.setName(NAME);
    }

    /**
     * contractor of Boolean
     *
     * @param varValue value of the boolean
     * @param parent   the section that the variable belongs to it.
     * @param varName  void name
     * @throws GeneralError in case we got error by create the variable
     */
    public Boolean(java.lang.String varName, java.lang.String varValue, Compiler parent) throws GeneralError {
        super(varName, parent);
        this.setName(NAME);
        this.setVarValue(varValue);
    }

    @Override
    public boolean checkValidValue(String varValue) {
        return new Int().checkValidValue(varValue) || new Double().checkValidValue(varValue)
                || varValue.matches(Keywords.TRUE) || varValue.matches(Keywords.FALSE);
    }

    @Override
    boolean checkValidName(String varName) throws IllegalVariableName {
        return super.checkValidName(varName) || varName.equals(Const.DEFAULT_BOOLEAN_NAME);
    }
}

