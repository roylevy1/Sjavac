package oop.ex6.main.variables;

import oop.ex6.main.compiler.Compiler;
import oop.ex6.main.exceptions.variables.GeneralError;
import oop.ex6.main.language.Keywords;
import oop.ex6.main.language.Regexs;

import java.lang.String;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent the char variable in our compiler.
 */
public class Char extends Variable {
    public static final java.lang.String NAME = Keywords.CHAR;

    /**
     * contractor of string
     */
    public Char() {
        this.setName(NAME);
    }

    /**
     * contractor of Char
     *
     * @param parent  the section that the variable belongs to it.
     * @param varName void name
     * @throws GeneralError in case we got error by create the variable
     */
    public Char(java.lang.String varName, Compiler parent) throws GeneralError {
        super(varName, parent);
        this.setName(NAME);
    }

    @Override
    public boolean checkValidValue(String varValue) {
        return super.checkValidValue(varValue) ||
                (varValue != null && varValue.matches(Regexs.CHAR_VALUE_CHECKER));
    }
}
