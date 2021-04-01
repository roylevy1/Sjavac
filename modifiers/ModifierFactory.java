package oop.ex6.main.modifiers;

import oop.ex6.main.Factory;
import oop.ex6.main.exceptions.modifiers.GeneralError;
import oop.ex6.main.exceptions.modifiers.NotFound;
import oop.ex6.main.exceptions.modifiers.NullPointer;
import oop.ex6.main.language.Keywords;
import oop.ex6.main.language.Messages;

import java.util.Hashtable;
import java.util.Map;


/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent factory that produce Modifier from a string
 */
public class ModifierFactory implements Factory {
    private static final String FACTORY_NAME = Keywords.MODIFIER_FACTORY;
    private static final String FINAL = Final.NAME;

    @Override
    public Modifier create(java.lang.String modifier) throws GeneralError {
        try {
            if (modifier == null)
                throw new NullPointer(Messages.NULL_POINTER);
            switch (modifier) {
                case FINAL:
                    return new Final();
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
        keys.put(FINAL, FACTORY_NAME);
        return keys;
    }

    @Override
    public String getName() {
        return FACTORY_NAME;
    }
}
