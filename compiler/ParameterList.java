package oop.ex6.main.compiler;

import oop.ex6.main.exceptions.sections.parameterList.BadNumberOfParameters;
import oop.ex6.main.exceptions.sections.parameterList.GeneralError;
import oop.ex6.main.exceptions.variables.NotFound;
import oop.ex6.main.exceptions.variables.VariableAlreadyExist;
import oop.ex6.main.keywords.marks.MarkFactory;
import oop.ex6.main.language.Const;
import oop.ex6.main.language.Keywords;
import oop.ex6.main.language.Messages;
import oop.ex6.main.language.Regexs;
import oop.ex6.main.modifiers.Final;
import oop.ex6.main.variables.Variable;
import oop.ex6.main.variables.VariableFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent the a prameter list of a method in the compiler.
 */
public class ParameterList extends Method {
    private static final String NAME = Keywords.PARAMETER_LIST;
    private Stack<Variable> parameters;

    /**
     * this is contractor of parameterList
     *
     * @param parameterList parameter list in string
     * @param parent        the parent of the parameter list aka method.
     * @throws GeneralError in case we had problem with create the parameter list of variables
     */
    ParameterList(String parameterList, Compiler parent) throws GeneralError {
        this.setName(NAME);
        this.variables = new Stack<Variable>();
        this.parameters = new Stack<Variable>();
        String[] allParameters = parameterList.split(MarkFactory.COMMA);
        if (allParameters.length > 0 && !allParameters[0].equals(Regexs.EMPTY_STRING))
            this.createParameterListVariables(allParameters);
        this.parent = parent;
        this.parent.getVariableStack().addAll(this.variables);
        this.setVariableStack(this.parent.getVariableStack());
    }

    /**
     * this method handle the create of parameter list variables.
     *
     * @param allParameters parameter list in string
     * @throws GeneralError in case we had problem with create the parameter list of variables
     */
    private void createParameterListVariables(String[] allParameters) throws GeneralError {
        try {
            for (String allParameter : allParameters) {
                String[] parameterData = allParameter.trim().split(Regexs.ONE_WHITE_SPACE);
                if (this.searchInVarStack(this.variables, parameterData[1]) >= Const.SEARCH_FOUND_OBJECT)
                    throw new VariableAlreadyExist(Messages.VARIABLE_CREATE_ALREADY);
                if (this.isModifier(parameterData[0]))
                    this.paramHasModifier(parameterData);
                else if (this.isVariable(parameterData[0]))
                    this.paramNotHasModifier(parameterData);
                else throw new BadNumberOfParameters(Messages.BAD_NUM_OF_ARGUMENTS);
            }
        } catch (oop.ex6.main.exceptions.variables.GeneralError e) {
            throw new oop.ex6.main.exceptions.sections.parameterList.GeneralError
                    (Messages.GENERAL_ERROR + NAME, e);
        }
    }

    /**
     * this method handle the create of parameter variable in case that it has modifier
     *
     * @param parameterData string data of the variable
     * @throws oop.ex6.main.exceptions.variables.GeneralError in case we had problem with create the variable
     */
    private void paramNotHasModifier(String[] parameterData)
            throws oop.ex6.main.exceptions.variables.GeneralError {
        List<String> data = new ArrayList<String>(Arrays.asList(parameterData));
        data.remove(parameterData[0]);
        String varName = String.join(Regexs.ONE_WHITE_SPACE, data.toArray(new String[0]));
        Variable variable = new VariableFactory().create(parameterData[0], this);
        variable.setVarName(varName.trim());
        variable.setVarValue(Const.METHOD_UN_INIT_VAR);
        this.parameters.push(variable);
        this.variables.push(variable);
    }

    /**
     * this method handle the create of parameter variable in case that it has not modifier
     *
     * @param parameterData string data of the variable
     * @throws oop.ex6.main.exceptions.variables.GeneralError in case we had problem with create the variable
     */
    private void paramHasModifier(String[] parameterData)
            throws oop.ex6.main.exceptions.variables.GeneralError {
        if (this.isVariable(parameterData[1])) {
            Variable variable = new VariableFactory().create(parameterData[1], this);
            variable.setVarFinal(new Final());
            variable.setVarName(parameterData[2].trim());
            variable.setVarValue(Const.METHOD_UN_INIT_VAR);
            this.parameters.push(variable);
            this.variables.push(variable);
        } else throw new NotFound(Messages.PARAMETER_VARIABLE_TYPE_NOT_FOUND);
    }

    @Override
    public Stack<Variable> getParameters() {
        return this.parameters;
    }
}
