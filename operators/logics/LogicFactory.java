package oop.ex6.main.operators.logics;

import oop.ex6.main.Factory;
import oop.ex6.main.exceptions.operators.GeneralError;
import oop.ex6.main.exceptions.operators.NotFound;
import oop.ex6.main.exceptions.operators.NullPointer;
import oop.ex6.main.language.Keywords;
import oop.ex6.main.language.Messages;
import oop.ex6.main.operators.Operator;
import oop.ex6.main.variables.Boolean;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent the factory that create a logic lines in our compiler.
 */
public class LogicFactory implements Factory {
    private static final String AND = And.NAME;
    private static final String OR = Or.NAME;
    private static final String FACTORY_NAME = Keywords.LOGIC_FACTORY;

    @Override
    public Operator create(java.lang.String operator) throws GeneralError {
        return create(operator, null, null);
    }

    /**
     * this method create logic operator object
     *
     * @param operator      logic operator name
     * @param firstElement  first boolean for logic operator
     * @param secondElement second boolean for logic operator
     * @return logic operator
     * @throws GeneralError in case we got problem with create the operator
     */
    public Operator create(java.lang.String operator, Boolean firstElement, Boolean secondElement)
            throws GeneralError {
        try {
            if (operator == null)
                throw new NullPointer(Messages.NULL_POINTER);
            switch (operator) {
                case AND:
                    return new And(firstElement, secondElement);
                case OR:
                    return new Or(firstElement, secondElement);
                default:
                    throw new NotFound(Messages.NOT_FOUND + FACTORY_NAME);
            }
        } catch (NullPointer | NotFound e) {
            throw new GeneralError(Messages.GENERAL_ERROR + FACTORY_NAME, e);
        }

    }

    @Override
    public Map<String, String> getKeywords() {
        Hashtable<String, String> keys = new Hashtable<java.lang.String, java.lang.String>();
        keys.put(AND, FACTORY_NAME);
        keys.put(OR, FACTORY_NAME);
        return keys;
    }

    @Override
    public java.lang.String getName() {
        return FACTORY_NAME;
    }
}
