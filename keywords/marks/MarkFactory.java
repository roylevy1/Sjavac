package oop.ex6.main.keywords.marks;

import oop.ex6.main.Factory;
import oop.ex6.main.exceptions.keywords.marks.GeneralError;
import oop.ex6.main.exceptions.keywords.marks.NotFound;
import oop.ex6.main.exceptions.keywords.marks.NullPointer;
import oop.ex6.main.language.Keywords;
import oop.ex6.main.language.Messages;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent the factory that create marks in our compiler.
 */
public class MarkFactory implements Factory {
    public static final String COMMA = Comma.NAME;
    private static final String FACTORY_NAME = Keywords.MARK_FACTORY;
    private static final String SEMICOLON = Semicolon.NAME;

    @Override
    public Mark create(java.lang.String operator) throws GeneralError {
        try {
            if (operator == null)
                throw new NullPointer(Messages.NULL_POINTER);
            switch (operator) {
                case COMMA:
                    return new Comma();
                case SEMICOLON:
                    return new Semicolon();
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
        keys.put(COMMA, FACTORY_NAME);
        keys.put(SEMICOLON, FACTORY_NAME);
        return keys;
    }

    @Override
    public java.lang.String getName() {
        return FACTORY_NAME;
    }
}
