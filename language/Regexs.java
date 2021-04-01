package oop.ex6.main.language;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This is final class that represent all regex in our compiler.
 */
public final class Regexs {
    public static final String EMPTY_STRING = "";
    public static final String ONE_WHITE_SPACE = " ";
    public static final String AT_LEAST_WHITE_SPACE = "\\s+";
    public static final String PARENTHESES_LEFT = "\\" + Keywords.PARENTHESES_LEFT;
    public static final String PARENTHESES_RIGHT = "\\" + Keywords.PARENTHESES_RIGHT;
    public static final String OR = "\\|\\|";

    public static final String CHAR_VALUE_CHECKER = "^\'[^/',\"]\'$";
    public static final String DOUBLE_VALUE_CHECKER = "^[+-]?\\d+\\.?\\d*$";
    public static final String INT_VALUE_CHECKER = "^[+-]?\\d+$";
    public static final String STRING_VALUE_CHECKER = "^\"[^/',\"]*\"$";

    public static final String VOID_NAME_CHECKER = "^[^_\\d]\\w*$";
    public static final String VAR_NAME_CHECKER = "^([_]\\w+|[a-zA-Z]+\\w*)$";
    public static final String VAR_NAME_CLEANER = "^\\w*[\\s]$";
}
