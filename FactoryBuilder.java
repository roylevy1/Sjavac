package oop.ex6.main;

import oop.ex6.main.exceptions.factories.GeneralError;
import oop.ex6.main.exceptions.factories.NotFound;
import oop.ex6.main.exceptions.factories.NullPointer;
import oop.ex6.main.keywords.KeywordFactory;
import oop.ex6.main.language.Keywords;
import oop.ex6.main.language.Messages;
import oop.ex6.main.loops.LoopFactory;
import oop.ex6.main.modifiers.ModifierFactory;
import oop.ex6.main.operators.OperatorFactory;
import oop.ex6.main.variables.VariableFactory;

import java.util.ArrayList;
import java.util.Collection;


/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent the factory that create all the compiler facctroies and collect them keywords.
 */
public class FactoryBuilder {
    public static final String LOOPS = Keywords.LOOP_FACTORY;
    public static final String MODIFIERS = Keywords.MODIFIER_FACTORY;
    public static final String VARIABLES = Keywords.VARIABLE_FACTORY;
    private static final String FACTORY_NAME = Keywords.FACTORY_BUILDER;
    private static final String KEYWORDS = Keywords.KEYWORD_FACTORY;
    private static final String OPERATORS = Keywords.OPERATOR_FACTORY;

    /**
     * this create a Factory from a string
     *
     * @param factory the name of factory we want to create
     * @return factory
     * @throws GeneralError in case we got error by create the factory
     */
    Factory createFactory(String factory) throws GeneralError {
        try {
            if (factory == null)
                throw new NullPointer(Messages.NULL_POINTER);
            switch (factory) {
                case KEYWORDS:
                    return new KeywordFactory();
                case LOOPS:
                    return new LoopFactory();
                case MODIFIERS:
                    return new ModifierFactory();
                case VARIABLES:
                    return new VariableFactory();
                case OPERATORS:
                    return new OperatorFactory();
                default:
                    throw new NotFound(Messages.NOT_FOUND + FACTORY_NAME);
            }
        } catch (NullPointer | NotFound e) {
            throw new GeneralError(Messages.GENERAL_ERROR + FACTORY_NAME, e);
        }

    }

    /**
     * @return the factories that in factory builder
     */
    public Collection<String> getFactories() {
        Collection<String> factories = new ArrayList<String>();
        factories.add(KEYWORDS);
        factories.add(LOOPS);
        factories.add(MODIFIERS);
        factories.add(VARIABLES);
        factories.add(OPERATORS);
        return factories;
    }
}
