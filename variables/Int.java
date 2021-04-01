package oop.ex6.main.variables;

import oop.ex6.main.compiler.Compiler;
import oop.ex6.main.exceptions.variables.GeneralError;
import oop.ex6.main.language.Keywords;
import oop.ex6.main.language.Regexs;

import java.lang.String;


/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent the int variable in our compiler.
 */
public class Int extends Variable {
    static final java.lang.String NAME = Keywords.INT;

    /**
     * contractor of empty Boolean
     */
    public Int() {
        this.setName(NAME);
    }

    /**
     * contractor of int
     *
     * @param parent  the section that the variable belongs to it.
     * @param varName void name
     * @throws GeneralError in case we got error by create the variable
     */
    public Int(java.lang.String varName, Compiler parent) throws GeneralError {
        super(varName, parent);
        this.setName(NAME);
    }

    @Override
    public boolean checkValidValue(String varValue) {
        return super.checkValidValue(varValue) ||
                (varValue != null && varValue.matches(Regexs.INT_VALUE_CHECKER));
    }

}
