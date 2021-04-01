package oop.ex6.main.compiler;

import oop.ex6.main.exceptions.modifiers.FinalMustAssigned;
import oop.ex6.main.exceptions.sections.lines.*;
import oop.ex6.main.exceptions.sections.parameterList.BadNumberOfParameters;
import oop.ex6.main.exceptions.variables.NotFound;
import oop.ex6.main.exceptions.variables.VariableAlreadyExist;
import oop.ex6.main.exceptions.variables.VariableNotAllowed;
import oop.ex6.main.language.Const;
import oop.ex6.main.language.Keywords;
import oop.ex6.main.language.Messages;
import oop.ex6.main.language.Regexs;
import oop.ex6.main.modifiers.Final;
import oop.ex6.main.operators.Operator;
import oop.ex6.main.operators.OperatorFactory;
import oop.ex6.main.variables.Variable;
import oop.ex6.main.variables.VariableFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent the a line of a file in the compiler.
 */
public class Line extends Compiler {
    private static final String NAME = Keywords.LINE;
    private Compiler parent;
    private Stack<Variable> variables;

    /**
     * this is contractor of a line
     *
     * @param dataInLine data in the line as string.
     * @param parent     the parent of the line.
     * @throws GeneralError in case we had problem with create of the line.
     */
    Line(String[] dataInLine, Compiler parent) throws GeneralError {
        this.setName(NAME);
        this.parent = parent;
        this.variables = new Stack<Variable>();
        String lastElement = dataInLine[dataInLine.length - 1];
        dataInLine[dataInLine.length - 1] = lastElement.substring(0, lastElement.length() - 1);
        String joined = String.join(Regexs.ONE_WHITE_SPACE, dataInLine);
        this.lineManagement(joined.split(Keywords.SEMICOLON));
        this.parent.setVariableStack(this.variables);
    }

    /**
     * this method mange the line and handle its cases
     *
     * @param line line in string
     * @throws GeneralError in case that error accrue during the handle the line
     */
    private void lineManagement(String[] line) throws GeneralError {
        try {
            Final variableFinal = new Final();
            for (String element : line) {
                String[] dataInLine = element.split(Regexs.ONE_WHITE_SPACE);
                if (this.isModifier(dataInLine[0])) {
                    if (this.isVariable(dataInLine[1]))
                        this.lineHasModifierAndVariableType(dataInLine, variableFinal);
                    else throw new NotFound(Messages.NOT_FOUND + Keywords.VARIABLE_FACTORY);
                } else if (this.isVariable(dataInLine[0]))
                    this.lineHasOnlyVariableType(dataInLine, variableFinal);
                else if (this.searchInVarStack(parent.getVariableStack(), dataInLine[0])
                        >= Const.SEARCH_FOUND_OBJECT)
                    this.assignedVariable(dataInLine);
                else if (this.searchInMethodStack(parent.getMethodStack(),
                        dataInLine[0].split(Regexs.PARENTHESES_LEFT)[0]) >= Const.SEARCH_FOUND_OBJECT)
                    this.methodCallInLine(dataInLine);
                else throw new IllegalLine(Messages.LINE_IS_ILLEGAL);
            }
        } catch (NotFound | LineWithModifierAndVarTypeFail | LineWithOnlyVarTypeFail | AssignedVariableFail
                | MethodCallFail e) {
            throw new GeneralError(Messages.GENERAL_ERROR + NAME, e);
        }

    }

    /**
     * this method handle a line that declare without modifier and Variable type, meaning assigned variable
     *
     * @param dataInLine line in string
     * @throws AssignedVariableFail in case that error accrue during the handle the line
     */
    private void assignedVariable(String[] dataInLine) throws AssignedVariableFail {
        try {
            int foundVar = this.searchInVarStack(parent.getVariableStack(), dataInLine[0]);
            String[] getVarValue = String.join(Regexs.ONE_WHITE_SPACE, dataInLine).split(Keywords.ASSIGNED);
            Variable variable;
            if (parent.getVariableStack().get(foundVar).getVarValue() != null)
                variable = parent.getVariableStack().get(foundVar);
            else
                variable = new VariableFactory().create
                        (parent.getVariableStack().get(foundVar).getName(), parent);
            if (!variable.isUseAsVariable())
                throw new VariableNotAllowed(Messages.VARIABLE_NOT_ALLOWED);
            Operator operator = new OperatorFactory().
                    create(Keywords.ASSIGNED, variable, getVarValue[1].trim());
            this.variables.push(operator.getVariable());
        } catch (oop.ex6.main.exceptions.variables.GeneralError |
                oop.ex6.main.exceptions.operators.GeneralError e) {
            throw new AssignedVariableFail(Messages.ASSIGNED_VARIABLE_IN_LINE_FAIL, e);
        }
    }

    /**
     * this method handle a line that declare with Variable type and without modifier
     *
     * @param dataInLine    line in string
     * @param variableFinal final modifier for the variable
     * @throws LineWithOnlyVarTypeFail in case that error accrue during the handle the line
     */
    private void lineHasOnlyVariableType(String[] dataInLine, Final variableFinal)
            throws LineWithOnlyVarTypeFail {
        try {
            List<String> data = new ArrayList<String>(Arrays.asList(dataInLine));
            data.remove(dataInLine[0]);
            String allVarsAndValues = String.join(Regexs.ONE_WHITE_SPACE, data.toArray(new String[0]));
            variableFinal.setModifierUse(false);
            this.createMultiVarInLine(allVarsAndValues.split(Keywords.COMMA), dataInLine[0], variableFinal);
        } catch (CantCreateMultiVariableInLine e) {
            throw new LineWithOnlyVarTypeFail(Messages.LINE_WITH_ONLY_VARIABLE_TYPE, e);
        }
    }

    /**
     * this method handle a line that declare with modifier and Variable type
     *
     * @param dataInLine    line in string
     * @param variableFinal final modifier for the variable
     * @throws LineWithModifierAndVarTypeFail in case that error accrue during the handle the line
     */
    private void lineHasModifierAndVariableType(String[] dataInLine, Final variableFinal)
            throws LineWithModifierAndVarTypeFail {
        try {
            List<String> data = new ArrayList<String>(Arrays.asList(dataInLine));
            String modifier = dataInLine[0];
            String varType = dataInLine[1];
            data.remove(modifier);
            data.remove(varType);
            String allVarsAndValues = String.join(Regexs.ONE_WHITE_SPACE, data.toArray(new String[0]));
            variableFinal.setModifierUse(true);
            this.createMultiVarInLine(allVarsAndValues.split(Keywords.COMMA), dataInLine[1], variableFinal);
        } catch (CantCreateMultiVariableInLine e) {
            throw new LineWithModifierAndVarTypeFail(Messages.LINE_WITH_MODIFIER_AND_VARIABLE_TYPE, e);
        }

    }

    /**
     * this method handle a call to method from a line
     *
     * @param dataInLine line in string
     * @throws MethodCallFail in case that error accrue during the call to method
     */
    private void methodCallInLine(String[] dataInLine) throws MethodCallFail {
        try {
            int methodId = this.searchInMethodStack(
                    parent.getMethodStack(), dataInLine[0].split(Regexs.PARENTHESES_LEFT)[0]);
            String fullLine = String.join(Regexs.ONE_WHITE_SPACE, dataInLine);
            String[] parameters;
            fullLine = fullLine.split(Regexs.PARENTHESES_LEFT)[1];
            if (!fullLine.equals(Keywords.PARENTHESES_RIGHT)) {
                String method = fullLine.split(Regexs.PARENTHESES_RIGHT)[0];
                parameters = method.split(Keywords.COMMA);
            } else parameters = new String[0];
            if (this.parent.getMethodStack().get(methodId).getParameters().size() != parameters.length)
                throw new BadNumberOfParameters(Messages.BAD_NUM_OF_ARGUMENTS);
            else {
                for (int i = 0; i < this.parent.getMethodStack().get(methodId).getParameters().size(); i++) {
                    Variable parameterVariable = this.parent.getMethodStack()
                            .get(methodId).getParameterList().getParameters().get(i);
                    String varType = parameterVariable.getName();
                    String varName = parameterVariable.getVarName();
                    Final varFinal = parameterVariable.getVarFinal();
                    Variable var = new VariableFactory().create(varType, this);
                    var.setVarName(varName);
                    var.setVarFinal(varFinal);
                    int foundVar = this.searchInVarStack(parent.getVariableStack(), parameters[i].trim());
                    if (foundVar >= 0 && parent.getVariableStack().get(foundVar).getVarValue() != null)
                        var.setVarValue(parent.getVariableStack().get(foundVar).getVarValue());
                    else
                        var.setVarValue(parameters[i].trim());
                    this.variables.push(var);
                }
            }
        } catch (BadNumberOfParameters | oop.ex6.main.exceptions.variables.GeneralError e) {
            throw new MethodCallFail(Messages.METHOD_CALL_FAIL, e);
        }
    }

    /**
     * this method create multi variable that declare in the same line.
     *
     * @param allVariableInLine string that contain all the vars that in the line.
     * @param variableType      the type of all variable that in the line.
     * @param variableFinal     the modifier final for all variable that in the line.
     * @throws CantCreateMultiVariableInLine if we has an error by creating the multi vars
     */
    private void createMultiVarInLine(String[] allVariableInLine, String variableType, Final variableFinal)
            throws CantCreateMultiVariableInLine {
        try {
            for (String oneVar : allVariableInLine) {
                if (this.variableAlreadyExist(oneVar))
                    throw new VariableAlreadyExist(Messages.VARIABLE_CREATE_ALREADY);
                Variable variable = new VariableFactory().create(variableType, parent);
                if (!variable.isUseAsVariable())
                    throw new VariableNotAllowed(Messages.VARIABLE_NOT_ALLOWED);
                if (oneVar.contains(Keywords.ASSIGNED)) {
                    String[] getVarValue = oneVar.split(Keywords.ASSIGNED);
                    variable.setVarName(getVarValue[0].trim());
                    String varValue = this.getVariableValueFromParent(getVarValue[1].trim());
                    Operator operator = new OperatorFactory().create(Keywords.ASSIGNED, variable, varValue);
                    variable = operator.getVariable();
                } else
                    variable.setVarName(oneVar.trim());
                variable.setVarFinal(variableFinal);
                this.variables.push(variable);
                if (this.finalNotAssigned(variableFinal))
                    throw new FinalMustAssigned(Messages.FINAL_MUST_ASSIGNED);
            }
        } catch (oop.ex6.main.exceptions.variables.GeneralError | FinalMustAssigned
                | oop.ex6.main.exceptions.operators.GeneralError e) {
            throw new CantCreateMultiVariableInLine(Messages.CANT_CREATE_MULTI_VAR_IN_LINE, e);
        }
    }

    /**
     * this method check if the var we create has the modifier final and it not assigned with value
     *
     * @param variableFinal final modifier of variable
     * @return true if not assigned with value
     */
    private boolean finalNotAssigned(Final variableFinal) {
        return variableFinal.getModifierUse() && this.variables.peek().getVarValue() == null;
    }

    /**
     * this method check if the var we want to create already exist
     *
     * @param varName the name of a var
     * @return true if it already exist
     */
    private boolean variableAlreadyExist(String varName) {
        int varId = Const.SEARCH_UN_FOUND_OBJECT, parameterVarId = Const.SEARCH_UN_FOUND_OBJECT;
        if (this.parent.getVariableStack() != null && this.parent.getVariableStack().size() > 0)
            varId = this.searchInVarStack(this.parent.getVariableStack(), varName.trim());
        if (this.parent.getParameters() != null && this.parent.getParameters().size() > 0)
            parameterVarId = this.searchInVarStack(this.parent.getParameters(), varName.trim());
        boolean isMethod = this.parent.getName().equals(Keywords.METHOD);
        return (isMethod && parameterVarId >= Const.SEARCH_FOUND_OBJECT) ||
                (varId >= Const.SEARCH_FOUND_OBJECT &&
                        this.parent.getVariableStack().get(varId).getParent() == this.parent);
    }

    /**
     * this method find a var by his name
     *
     * @param value var name we want to get his value
     * @return var value as string
     */
    private String getVariableValueFromParent(String value) {
        Stack<Stack<Variable>> stacks = new Stack<Stack<Variable>>();
        stacks.push(this.parent.getVariableStack());
        stacks.push(this.variables);
        for (Stack<Variable> stack : stacks) {
            int distance = this.searchInVarStack(stack, value);
            if (distance >= Const.SEARCH_FOUND_OBJECT) {
                value = stack.get(distance).getVarValue();
                break;
            }
        }
        return value;
    }

    /**
     * @return the stack of variable
     */
    public Stack<Variable> getVariables() {
        return this.variables;
    }
}
