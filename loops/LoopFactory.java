package oop.ex6.main.loops;

import oop.ex6.main.Factory;
import oop.ex6.main.exceptions.loops.GeneralError;
import oop.ex6.main.exceptions.loops.NotFound;
import oop.ex6.main.exceptions.loops.NullPointer;
import oop.ex6.main.language.Keywords;
import oop.ex6.main.language.Messages;

import java.util.Hashtable;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent factory that create loop object
 */
public class LoopFactory implements Factory {
    private static final String FACTORY_NAME = Keywords.LOOP_FACTORY;
    private static final String IF = If.NAME;
    private static final String WHILE = While.NAME;

    @Override
    public Loop create(java.lang.String loop) throws GeneralError {
        try {
            if (loop == null)
                throw new NullPointer(Messages.NULL_POINTER);
            switch (loop) {
                case IF:
                    return new If();
                case WHILE:
                    return new While();
                default:
                    throw new NotFound(Messages.NOT_FOUND + FACTORY_NAME);
            }
        } catch (NullPointer | NotFound e) {
            throw new GeneralError(Messages.GENERAL_ERROR + FACTORY_NAME, e);
        }
    }

    @Override
    public Hashtable<String, String> getKeywords() {
        Hashtable<String, String> keys = new Hashtable<String, String>();
        keys.put(IF, FACTORY_NAME);
        keys.put(WHILE, FACTORY_NAME);
        return keys;
    }

    @Override
    public String getName() {
        return FACTORY_NAME;
    }
}
