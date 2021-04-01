package oop.ex6.main.keywords.comments;

import oop.ex6.main.Factory;
import oop.ex6.main.exceptions.keywords.comments.GeneralError;
import oop.ex6.main.exceptions.keywords.comments.NotFound;
import oop.ex6.main.exceptions.keywords.comments.NullPointer;
import oop.ex6.main.language.Keywords;
import oop.ex6.main.language.Messages;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent the factory that create comment object in our compiler.
 */
public class CommentFactory implements Factory {
    private static final String FACTORY_NAME = Keywords.COMMENT_FACTORY;
    private static final String COMMENT_LINE = CommentLine.NAME;

    @Override
    public Comment create(java.lang.String comment) throws GeneralError {
        try {
            if (comment == null)
                throw new NullPointer(Messages.NULL_POINTER);
            switch (comment) {
                case COMMENT_LINE:
                    return new CommentLine();
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
        keys.put(COMMENT_LINE, FACTORY_NAME);
        return keys;
    }

    @Override
    public String getName() {
        return FACTORY_NAME;
    }
}
