package oop.ex6.main.operators;

import oop.ex6.main.Factory;
import oop.ex6.main.exceptions.operators.GeneralError;
import oop.ex6.main.exceptions.operators.NotFound;
import oop.ex6.main.exceptions.operators.NullPointer;
import oop.ex6.main.language.Keywords;
import oop.ex6.main.language.Messages;
import oop.ex6.main.operators.logics.LogicFactory;
import oop.ex6.main.variables.Variable;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent the factory that create lines in our compiler.
 */
public class OperatorFactory implements Factory {
    private static final String ASSIGNED = Assigned.NAME;
    private static final String FACTORY_NAME = Keywords.OPERATOR_FACTORY;

    @Override
    public Operator create(java.lang.String operator) throws GeneralError {
        return create(operator, null, null);
    }

    /**
     * this method create operator object
     *
     * @param operator operator name
     * @param variable variable we want to use the operator on him
     * @param value    value we want to use on the variable
     * @return operator object
     * @throws GeneralError in case we got problem with create the operator
     */
    public Operator create(String operator, Variable variable, String value) throws GeneralError {
        try {
            if (operator == null)
                throw new NullPointer(Messages.NULL_POINTER);
            switch (operator) {
                case ASSIGNED:
                    return new Assigned(variable, value);
                default:
                    throw new NotFound(Messages.NOT_FOUND + FACTORY_NAME);
            }
        } catch (oop.ex6.main.exceptions.variables.GeneralError | NullPointer | NotFound e) {
            throw new GeneralError(Messages.GENERAL_ERROR + FACTORY_NAME, e);
        }
    }

    @Override
    public Map<String, String> getKeywords() {
        Hashtable<String, String> keys = new Hashtable<java.lang.String, java.lang.String>();
        keys.put(ASSIGNED, FACTORY_NAME);
        keys.putAll(new LogicFactory().getKeywords());
        return keys;
    }

    @Override
    public java.lang.String getName() {
        return FACTORY_NAME;
    }
}
