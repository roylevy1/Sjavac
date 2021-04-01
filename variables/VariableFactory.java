package oop.ex6.main.variables;

import oop.ex6.main.Factory;
import oop.ex6.main.compiler.Compiler;
import oop.ex6.main.exceptions.variables.GeneralError;
import oop.ex6.main.exceptions.variables.NotFound;
import oop.ex6.main.exceptions.variables.NullPointer;
import oop.ex6.main.language.Keywords;
import oop.ex6.main.language.Messages;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent the factory that create variables in our compiler.
 */
public class VariableFactory implements Factory {
    public static final java.lang.String BOOLEAN = Boolean.NAME;
    private static final java.lang.String FACTORY_NAME = Keywords.VARIABLE_FACTORY;
    private static final java.lang.String CHAR = Char.NAME;
    private static final java.lang.String DOUBLE = Double.NAME;
    private static final java.lang.String INT = Int.NAME;
    private static final java.lang.String STRING = String.NAME;
    private static final java.lang.String VOID = Void.NAME;

    @Override
    public Variable create(java.lang.String variable) throws GeneralError {
        return create(variable, null);
    }

    /**
     * this method create variable object
     *
     * @param variable variable name
     * @param parent   parent of thr variable
     * @return Variable object
     * @throws GeneralError in case we got problem by create it
     */
    public Variable create(java.lang.String variable, Compiler parent) throws GeneralError {
        try {
            if (variable == null)
                throw new NullPointer(Messages.NULL_POINTER);
            switch (variable) {
                case BOOLEAN:
                    return new Boolean(variable, parent);
                case CHAR:
                    return new Char(variable, parent);
                case DOUBLE:
                    return new Double(variable, parent);
                case INT:
                    return new Int(variable, parent);
                case STRING:
                    return new String(variable, parent);
                case VOID:
                    return new Void(variable);
                default:
                    throw new NotFound(Messages.NOT_FOUND + FACTORY_NAME);
            }
        } catch (NullPointer | NotFound e) {
            throw new GeneralError(Messages.GENERAL_ERROR + FACTORY_NAME, e);
        }
    }

    @Override
    public Map<java.lang.String, java.lang.String> getKeywords() {
        Hashtable<java.lang.String, java.lang.String> keys =
                new Hashtable<java.lang.String, java.lang.String>();
        keys.put(BOOLEAN, FACTORY_NAME);
        keys.put(CHAR, FACTORY_NAME);
        keys.put(DOUBLE, FACTORY_NAME);
        keys.put(INT, FACTORY_NAME);
        keys.put(STRING, FACTORY_NAME);
        keys.put(VOID, FACTORY_NAME);
        return keys;
    }

    @Override
    public java.lang.String getName() {
        return FACTORY_NAME;
    }
}
