package oop.ex6.main.keywords.comments;

import oop.ex6.main.language.Keywords;

/**
 * @author roy.levy3
 * @author sharonbash
 *         This class present a comment line object in our compiler.
 */
public class CommentLine extends Comment {
    static final String NAME = Keywords.COMMENT_LINE;

    /**
     * constructor of a comment line
     */
    public CommentLine() {
        this.setName(NAME);
    }
}
