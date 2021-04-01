package oop.ex6.main.variables;

import oop.ex6.main.exceptions.variables.GeneralError;
import oop.ex6.main.exceptions.variables.IllegalVariableName;
import oop.ex6.main.exceptions.variables.MethodNotAllowed;
import oop.ex6.main.language.Keywords;
import oop.ex6.main.language.Messages;
import oop.ex6.main.language.Regexs;
import oop.ex6.main.modifiers.Final;

import java.lang.String;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent the Void method in our compiler.
 */
public class Void extends Variable {
    static final java.lang.String NAME = Keywords.VOID;

    /**
     * contractor of empty Void
     */
    public Void() {
        this.setName(NAME);
    }

    /**
     * contractor of Void
     *
     * @param varName void name
     * @throws IllegalVariableName in case we got illegalVariableName by create the void
     */
    public Void(java.lang.String varName) throws GeneralError {
        this.setName(NAME);
        this.setUseAsMethod(true);
        this.setUseAsVariable(false);
        this.setVarName(varName);
        Final varFinal = new Final();
        varFinal.setModifierUse(false);
        this.setVarFinal(varFinal);
    }

    @Override
    boolean checkValidName(String varName) throws IllegalVariableName {
        try {
            if (!this.isUseAsMethod())
                throw new MethodNotAllowed(Messages.METHOD_NOT_ALLOWED);
            return varName != null && varName.matches(Regexs.VOID_NAME_CHECKER);
        } catch (MethodNotAllowed e) {
            throw new IllegalVariableName(e);
        }
    }

    @Override
    public void setVarName(String varName) throws GeneralError {
        super.setVarName(varName.split(Regexs.PARENTHESES_LEFT)[0]);
    }

    @Override
    public boolean checkValidValue(String varValue) {
        return false;
    }

}
