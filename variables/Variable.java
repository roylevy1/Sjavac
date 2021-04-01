package oop.ex6.main.variables;


import oop.ex6.main.Symbol;
import oop.ex6.main.compiler.Compiler;
import oop.ex6.main.exceptions.operators.CantAssigned;
import oop.ex6.main.exceptions.variables.GeneralError;
import oop.ex6.main.exceptions.variables.IllegalVariableName;
import oop.ex6.main.exceptions.variables.IllegalVariableValue;
import oop.ex6.main.language.Const;
import oop.ex6.main.language.Messages;
import oop.ex6.main.language.Regexs;
import oop.ex6.main.modifiers.Final;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This abstract class represent the variable in our compiler.
 */
public abstract class Variable extends Symbol {
    private java.lang.String varName, varValue;
    private Compiler parent;
    private Final varFinal;
    private boolean useAsMethod, useAsVariable;

    /**
     * contractor of empty Void
     */
    public Variable() {
    }

    /**
     * contractor of Void
     *
     * @param parent  the section that the variable belongs to it.
     * @param varName void name
     * @throws GeneralError in case we got error by create the variable
     */
    public Variable(java.lang.String varName, Compiler parent) throws GeneralError {
        this.parent = parent;
        this.setUseAsVariable(true);
        this.setUseAsMethod(false);
        this.setVarName(varName);
        Final varFinal = new Final();
        varFinal.setModifierUse(false);
        this.varFinal = varFinal;
    }

    /**
     * @return variable name
     */
    public java.lang.String getVarName() {
        return this.varName;
    }

    /**
     * this method set name for variable
     *
     * @param varName variable name
     * @throws GeneralError in case we got error of illegal name by create the variable
     */
    public void setVarName(java.lang.String varName) throws GeneralError {
        try {
            if (varName.matches(Regexs.VAR_NAME_CLEANER))
                varName = varName.split(Regexs.ONE_WHITE_SPACE)[0];
            if (!this.checkValidName(varName))
                throw new IllegalVariableName(Messages.ILLEGAL_VAR_NAME);
            this.varName = varName;
        } catch (IllegalVariableName e) {
            throw new GeneralError(e);
        }
    }

    /**
     * @return variable value
     */
    public java.lang.String getVarValue() {
        return this.varValue;
    }

    /**
     * this method set the value for variable
     *
     * @param varValue variable value
     * @throws GeneralError in case we got error of illegal value by create the variable
     */
    public void setVarValue(java.lang.String varValue) throws GeneralError {
        try {
            if (!this.checkValidValue(varValue)) {
                throw new IllegalVariableValue(Messages.ILLEGAL_VAR_VALUE);
            }
            if (this.varFinal == null || this.varFinal.getModifierUse()) {
                throw new CantAssigned(Messages.FINAL_CANT_REASSIGNED);
            }
            this.varValue = varValue;
        } catch (IllegalVariableValue | CantAssigned e) {
            throw new GeneralError(e);
        }
    }

    /**
     * @return variable final modifier
     */
    public Final getVarFinal() {
        return this.varFinal;
    }

    /**
     * this method set variable final modifier
     *
     * @param varFinal variable final modifier
     */
    public void setVarFinal(Final varFinal) {
        this.varFinal = varFinal;
    }

    /**
     * this method check if variable name is valid
     *
     * @param varName variable name
     * @return true if it valid
     * @throws IllegalVariableName in case we got illegal var name
     */
    boolean checkValidName(java.lang.String varName) throws IllegalVariableName {
        return varName != null && varName.matches(Regexs.VAR_NAME_CHECKER);
    }

    /**
     * this method check if variable value is valid
     *
     * @param varValue variable value
     * @return true if it valid
     */
    public boolean checkValidValue(java.lang.String varValue) {
        return varValue != null && varValue.equals(Const.METHOD_UN_INIT_VAR);
    }

    /**
     * @return if the variable can use as method
     */
    public boolean isUseAsMethod() {
        return this.useAsMethod;
    }

    /**
     * set the variable so he can/cant use as method
     *
     * @param useAsMethod chose if variable can use as method
     */
    public void setUseAsMethod(boolean useAsMethod) {
        this.useAsMethod = useAsMethod;
    }

    /**
     * @return if the variable can use as variable
     */
    public boolean isUseAsVariable() {
        return this.useAsVariable;
    }

    /**
     * set the variable so he can/cant use as variable
     *
     * @param useAsVariable chose if variable can use as variable
     */
    public void setUseAsVariable(boolean useAsVariable) {
        this.useAsVariable = useAsVariable;
    }

    /**
     * @return variable parent
     */
    public Compiler getParent() {
        return this.parent;
    }
}
