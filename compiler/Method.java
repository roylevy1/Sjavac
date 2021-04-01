package oop.ex6.main.compiler;

import oop.ex6.main.exceptions.sections.GeneralError;
import oop.ex6.main.exceptions.variables.MethodNotAllowed;
import oop.ex6.main.language.Keywords;
import oop.ex6.main.language.Messages;
import oop.ex6.main.language.Regexs;
import oop.ex6.main.variables.Variable;


/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent the a method of a file in the compiler.
 */
class Method extends Section {
    private static final String NAME = Keywords.METHOD;
    private ParameterList parameterList;
    private Variable MethodAsVariable;

    /**
     * this is empty contractor of section
     */
    Method() {
        this.setName(NAME);
    }

    /**
     * this is contractor of section
     *
     * @param dataInLine       data for use of lower classes such as parameter list.
     * @param parent           the parent of the method.
     * @param MethodAsVariable the variable that represent the method.
     * @throws GeneralError in case we had problem with create the method.
     */
    Method(String[] dataInLine, Compiler parent, Variable MethodAsVariable) throws GeneralError {
        super(dataInLine, parent);
        try {
            this.setName(NAME);
            if (!MethodAsVariable.isUseAsMethod())
                throw new MethodNotAllowed(Messages.METHOD_NOT_ALLOWED);
            this.MethodAsVariable = MethodAsVariable;
            String findParameterList = String.join(Regexs.ONE_WHITE_SPACE, dataInLine).
                    split(Regexs.PARENTHESES_LEFT)[1].split(Regexs.PARENTHESES_RIGHT)[0];
            this.parameterList = new ParameterList(findParameterList, this);
            this.methods.push(this);
            this.parameters = this.parameterList.getParameters();
        } catch (oop.ex6.main.exceptions.variables.GeneralError e) {
            throw new GeneralError(Messages.GENERAL_ERROR + NAME, e);
        }

    }

    /**
     * @return the variable that represent the method
     */
    Variable getMethodAsVariable() {
        return this.MethodAsVariable;
    }

    /**
     * @return the variables of parameter list
     */
    ParameterList getParameterList() {
        return this.parameterList;
    }
}
