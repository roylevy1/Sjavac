package oop.ex6.main.keywords.brackets;

import oop.ex6.main.Factory;
import oop.ex6.main.exceptions.keywords.brackets.GeneralError;
import oop.ex6.main.exceptions.keywords.brackets.NotFound;
import oop.ex6.main.exceptions.keywords.brackets.NullPointer;
import oop.ex6.main.language.Keywords;
import oop.ex6.main.language.Messages;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent the factory that create bracket object in our compiler.
 */
public class BracketFactory implements Factory {
    private static final String FACTORY_NAME = Keywords.BRACKET_FACTORY;
    private static final String BRACES_LEFT = BracesLeft.NAME;
    private static final String BRACES_RIGHT = BracesRight.NAME;
    private static final String PARENTHESES_LEFT = ParenthesesLeft.NAME;
    private static final String PARENTHESES_RIGHT = ParenthesesRight.NAME;

    @Override
    public Bracket create(java.lang.String bracket) throws GeneralError {
        try {
            if (bracket == null)
                throw new NullPointer(Messages.NULL_POINTER);
            switch (bracket) {
                case BRACES_LEFT:
                    return new BracesLeft();
                case BRACES_RIGHT:
                    return new BracesRight();
                case PARENTHESES_LEFT:
                    return new ParenthesesLeft();
                case PARENTHESES_RIGHT:
                    return new ParenthesesRight();
                default:
                    throw new NotFound(Messages.NOT_FOUND + FACTORY_NAME);
            }
        } catch (NullPointer | NotFound e) {
            throw new GeneralError(Messages.GENERAL_ERROR + FACTORY_NAME, e);
        }
    }

    @Override
    public Map<String, String> getKeywords() {
        Hashtable<String, String> keys = new Hashtable<String, String>();
        keys.put(BRACES_LEFT, FACTORY_NAME);
        keys.put(BRACES_RIGHT, FACTORY_NAME);
        keys.put(PARENTHESES_LEFT, FACTORY_NAME);
        keys.put(PARENTHESES_RIGHT, FACTORY_NAME);
        return keys;
    }

    @Override
    public String getName() {
        return FACTORY_NAME;
    }
}
