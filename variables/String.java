package oop.ex6.main.variables;

import oop.ex6.main.compiler.Compiler;
import oop.ex6.main.exceptions.variables.GeneralError;
import oop.ex6.main.language.Keywords;
import oop.ex6.main.language.Regexs;


/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent the string variable in our compiler.
 */
public class String extends Variable {
    static final java.lang.String NAME = Keywords.STRING;

    /**
     * contractor of string
     */
    public String() {
        this.setName(NAME);
    }

    /**
     * contractor of string
     *
     * @param parent  the section that the variable belongs to it.
     * @param varName void name
     * @throws GeneralError in case we got error by create the variable
     */
    public String(java.lang.String varName, Compiler parent) throws GeneralError {
        super(varName, parent);
        this.setName(NAME);
    }

    @Override
    public boolean checkValidValue(java.lang.String varValue) {
        return super.checkValidValue(varValue) ||
                (varValue != null && varValue.matches(Regexs.STRING_VALUE_CHECKER));
    }
}
