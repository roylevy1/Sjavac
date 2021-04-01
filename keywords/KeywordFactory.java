package oop.ex6.main.keywords;

import oop.ex6.main.Factory;
import oop.ex6.main.exceptions.keywords.GeneralError;
import oop.ex6.main.exceptions.keywords.NotFound;
import oop.ex6.main.exceptions.keywords.NullPointer;
import oop.ex6.main.keywords.brackets.BracketFactory;
import oop.ex6.main.keywords.comments.CommentFactory;
import oop.ex6.main.keywords.marks.MarkFactory;
import oop.ex6.main.language.Keywords;
import oop.ex6.main.language.Messages;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent the factory that create Keyword object in our compiler.
 */
public class KeywordFactory implements Factory {
    private static final String FACTORY_NAME = Keywords.KEYWORD_FACTORY;
    private static final String FALSE = False.NAME;
    private static final String TRUE = True.NAME;
    private static final String RETURN = Return.NAME;

    @Override
    public Keyword create(java.lang.String keyword) throws GeneralError {
        try {
            if (keyword == null)
                throw new NullPointer(Messages.NULL_POINTER);
            switch (keyword) {
                case FALSE:
                    return new False();
                case TRUE:
                    return new True();
                case RETURN:
                    return new Return();
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
        keys.put(FALSE, FACTORY_NAME);
        keys.put(TRUE, FACTORY_NAME);
        keys.put(RETURN, FACTORY_NAME);
        keys.putAll(new MarkFactory().getKeywords());
        keys.putAll(new BracketFactory().getKeywords());
        keys.putAll(new CommentFactory().getKeywords());
        return keys;
    }

    @Override
    public String getName() {
        return FACTORY_NAME;
    }
}
