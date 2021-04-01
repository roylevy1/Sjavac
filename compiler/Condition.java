package oop.ex6.main.compiler;

import oop.ex6.main.exceptions.sections.conditions.CantCreateCondition;
import oop.ex6.main.exceptions.sections.conditions.CantHandleAndLogic;
import oop.ex6.main.exceptions.sections.conditions.GeneralError;
import oop.ex6.main.exceptions.sections.conditions.NumberOfElementLow;
import oop.ex6.main.exceptions.variables.CantCastingNotBoolean;
import oop.ex6.main.language.Const;
import oop.ex6.main.language.Keywords;
import oop.ex6.main.language.Messages;
import oop.ex6.main.language.Regexs;
import oop.ex6.main.operators.logics.And;
import oop.ex6.main.operators.logics.Logic;
import oop.ex6.main.operators.logics.Or;
import oop.ex6.main.variables.Boolean;
import oop.ex6.main.variables.Variable;
import oop.ex6.main.variables.VariableFactory;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent the a condition of a file in the compiler.
 */
public class Condition extends Loop {
    private static final String NAME = Keywords.CONDITION;
    private Boolean defaultAndCondition;
    private Boolean defaultOrCondition;
    private Stack<Logic> andLogic = new Stack<Logic>();
    private Stack<Logic> orLogic = new Stack<Logic>();
    private Logic finalCondition;

    /**
     * this is empty contractor of Condition
     */
    Condition() {
        this.setName(NAME);
    }

    /**
     * this is contractor of section
     *
     * @param dataInLine our condition as string.
     * @param parent     the parent of the condition.
     * @throws GeneralError in case we had problem with create the condition.
     */
    Condition(String dataInLine, Compiler parent) throws GeneralError {
        try {
            this.setName(NAME);
            this.parent = parent;
            this.variables = this.parent.getVariableStack();
            this.methods = this.parent.getMethodStack();
            this.defaultAndCondition = new Boolean(Const.DEFAULT_BOOLEAN_NAME, Keywords.TRUE, this);
            this.defaultOrCondition = new Boolean(Const.DEFAULT_BOOLEAN_NAME, Keywords.FALSE, this);
            String[] orSplinter = dataInLine.split(Regexs.OR);
            if (orSplinter.length == Const.SOLO_CONDITION) {
                this.handleSoloOrElement(orSplinter);
            } else if (orSplinter.length > Const.SOLO_CONDITION) {
                this.handleAndLogic(orSplinter);
                this.handleOrLogic(this.andLogic);
            } else throw new NumberOfElementLow(Messages.NUMBER_OF_ELEMENT_LOW);
            try {
                this.setFinalCondition(this.orLogic.pop());
            } catch (EmptyStackException e) {
                throw new NumberOfElementLow(Messages.NUMBER_OF_ELEMENT_LOW, e);
            }
        } catch (NumberOfElementLow | CantHandleAndLogic | oop.ex6.main.exceptions.variables.GeneralError e) {
            throw new GeneralError(Messages.GENERAL_ERROR + NAME, e);
        }

    }

    /**
     * @param condition the condition we got in string
     * @throws CantHandleAndLogic                             if we cant handle the logic And.
     * @throws CantCreateCondition                            if we cant assigned the boolean variable.
     * @throws NumberOfElementLow                             if we got un positive size of the stack.
     * @throws oop.ex6.main.exceptions.variables.GeneralError in case we had problem with create the boolean.
     */
    private void handleSoloOrElement(String[] condition) throws CantHandleAndLogic, CantCreateCondition,
            NumberOfElementLow, oop.ex6.main.exceptions.variables.GeneralError {
        Boolean booleanElement;
        if (this.searchInVarStack(this.parent.getVariableStack(), condition[0])
                >= Const.SEARCH_FOUND_OBJECT) {
            Variable variable = this.parent.getVariableStack().get
                    (this.searchInVarStack(parent.getVariableStack(), condition[0]));
            if (variable.getName().equals(VariableFactory.BOOLEAN) && variable.getVarValue() != null) {
                booleanElement = (Boolean) this.parent.getVariableStack().get
                        (this.searchInVarStack(this.parent.getVariableStack(), condition[0]));
                this.orLogic.push(new Or(booleanElement, this.defaultOrCondition));
            } else throw new CantCastingNotBoolean(Messages.CANT_CASTING_NOT_BOOLEAN);
        } else {
            this.handleAndLogic(condition);
            if (this.andLogic.size() > 0)
                this.handleOrLogic(this.andLogic);
            else {
                booleanElement = new Boolean(Const.DEFAULT_BOOLEAN_NAME, parent);
                booleanElement.setVarValue(condition[0]);
                this.orLogic.push(new Or(booleanElement, this.defaultOrCondition));
            }
        }
    }

    /**
     * this method handle the condition that are type of or
     *
     * @param andLogic the stack of And Logic we got
     * @throws NumberOfElementLow if we got un positive size of the stack
     */
    private void handleOrLogic(Stack<Logic> andLogic) throws NumberOfElementLow {
        if (this.andLogic.size() < Const.SOLO_CONDITION)
            throw new NumberOfElementLow(Messages.NUMBER_OF_ELEMENT_LOW);
        else if (this.andLogic.size() == Const.SOLO_CONDITION) {
            this.orLogic.push(new Or(this.andLogic.pop(), this.defaultOrCondition));
        } else {
            Logic firstElement = this.andLogic.pop();
            Logic secondElement = this.andLogic.pop();
            this.orLogic.push(new Or(firstElement, secondElement));
            for (int i = Const.MAX_CONDITION_IN_LOGIC; i < this.andLogic.size(); i++)
                this.andLogic.push(new And(this.orLogic.pop(), this.andLogic.pop()));
        }
    }

    /**
     * this method handle the condition that are type of and
     *
     * @param condition the condition we got in string
     * @throws CantHandleAndLogic if we cant handle the logic And
     */
    private void handleAndLogic(String[] condition) throws CantHandleAndLogic {
        try {
            for (String andSplinter : condition) {
                String[] elements = andSplinter.split(Keywords.AND);
                Boolean firstElement = this.assignedBoolean(elements[0].trim());
                if (elements.length == Const.SOLO_CONDITION) {

                    this.andLogic.push(new And(firstElement, this.defaultAndCondition));
                    continue;
                }
                Boolean secondElement = this.assignedBoolean(elements[1].trim());
                this.andLogic.push(new And(firstElement, secondElement));
                for (int i = Const.MAX_CONDITION_IN_LOGIC; i < elements.length; i++) {
                    Boolean booleanElement = new Boolean(this.cleanStringFromSpace(elements[i]), parent);
                    booleanElement.setVarValue(this.cleanStringFromSpace(elements[i]));
                    this.andLogic.push(new And(this.andLogic.pop(), booleanElement));
                }
            }
        } catch (CantCreateCondition | oop.ex6.main.exceptions.variables.GeneralError e) {
            throw new CantHandleAndLogic(Messages.CANT_HANDLE_AND_LOGIC, e);
        }
    }

    /**
     * this method check if the boolean already exist and if so assigned it, else create a new boolean
     * with varName
     *
     * @param varName the var name of boolean
     * @return boolean
     * @throws CantCreateCondition if we cant assigned the boolean variable
     */
    private Boolean assignedBoolean(String varName) throws CantCreateCondition {
        try {
            Boolean variable;
            if (this.searchInVarStack(parent.getVariableStack(), varName) >= Const.SEARCH_FOUND_OBJECT) {
                int varId = this.searchInVarStack(parent.getVariableStack(), varName);
                if (this.parent.getVariableStack().get(varId).getName().equals(Keywords.BOOLEAN))
                    variable = (Boolean) this.parent.getVariableStack().get(varId);
                else throw new CantCastingNotBoolean(Messages.CANT_CASTING_NOT_BOOLEAN);
            } else {
                variable = new Boolean(this.cleanStringFromSpace(Const.DEFAULT_BOOLEAN_NAME), parent);
                variable.setVarValue(this.cleanStringFromSpace(varName));
            }
            return variable;
        } catch (oop.ex6.main.exceptions.variables.GeneralError e) {
            throw new CantCreateCondition(Messages.GENERAL_ERROR + NAME, e);
        }
    }

    /**
     * @param string string we want to clean
     * @return a clean string from white space
     */
    private String cleanStringFromSpace(String string) {
        return string.trim().split(Regexs.ONE_WHITE_SPACE)[0];
    }

    /**
     * @return the final condition that we created
     */
    public Logic getFinalCondition() {
        return this.finalCondition;
    }

    /**
     * set final condition that we created
     *
     * @param finalCondition logic condition
     */
    private void setFinalCondition(Logic finalCondition) {
        this.finalCondition = finalCondition;
    }
}

