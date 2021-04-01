package oop.ex6.main.language;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This is final class that represent all the messages in our compiler.
 */
public final class Messages {
    public static final String UNEXPECTED_EXCEPTION =
            "(Rly bad if u got here) No statement can catch the ChuckNorrisException";
    public static final String ERROR = "ERROR: ";
    public static final String SYSTEM_GENERAL_ERROR = "A system general error accrue!!!";
    public static final String GENERAL_ERROR = "A general error accrue in ";

    public static final String COMPILING_SUCCEEDED = "0";
    public static final String COMPILING_FAIL = "1";
    public static final String COMPILING_FILE_FAIL = "2";

    public static final String VARIABLE_NOT_ALLOWED = "You cant use this as var";
    public static final String METHOD_NOT_ALLOWED = "You cant use this as method";

    public static final String ILLEGAL_VAR_VALUE =
            "Seems like you are trying to assign illegal value for a variable";
    public static final String ILLEGAL_VAR_NAME = "Seems like you are trying to set illegal variable name";


    public static final String FINAL_CANT_REASSIGNED = "Final modifier not allow to reassigned";
    public static final String FINAL_MUST_ASSIGNED = "Final modifier must be assigned";


    public static final String BAD_NUM_OF_ARGUMENTS = "Seems like your got bad number of arguments";
    public static final String PARAMETER_VARIABLE_TYPE_NOT_FOUND =
            "The var type of the parameter list has not found";
    public static final String VARIABLE_CREATE_ALREADY =
            "A variable name already exist therefor cant create variable with the same name";


    public static final String IO_ERROR = "An IO error occurred.";
    public static final String CANT_CLOSE_FILE = "Could not close the file: ";
    public static final String FILE_NOT_FOUND = "Could not find the file: ";

    public static final String NULL_POINTER = "Seems that you got a null pointer";
    public static final String NOT_FOUND = "Seems that we cant find the an object of";
    public static final String CANT_CASTING_NOT_BOOLEAN =
            "Seems that your are trying to cast variable that is not boolean to boolean type";
    public static final String CANT_HANDLE_AND_LOGIC =
            "Seems that we got problem with handling the And logic";
    public static final String NUMBER_OF_ELEMENT_LOW = "Seems that we got low number of element";
    public static final String CANT_CREATE_MULTI_VAR_IN_LINE =
            "Seems that you some error accrue in the create of multi variables from one line";
    public static final String LINE_WITH_MODIFIER_AND_VARIABLE_TYPE =
            "Seems that you got some error accrue in the create of variables from line that " +
                    "has modifier and variable type";
    public static final String LINE_WITH_ONLY_VARIABLE_TYPE =
            "Seems that you got some error accrue in the create of variables from line that " +
                    "has only variable type";
    public static final String ASSIGNED_VARIABLE_IN_LINE_FAIL =
            "Seems that you got some error accrue in the assigned of variable from line that " +
                    "has no variable type and no modifier";
    public static final String METHOD_CALL_FAIL = "Seems that the call to method from a line has been failed";
    public static final String LINE_IS_ILLEGAL = "Seems that the line you reading is illegal";

    public static final String COMPILER_UNABLE_TO_CREATE_LINE = "Seems that the compiler cant create a line";
    public static final String COMPILER_UNABLE_TO_CREATE_METHOD =
            "Seems that the compiler cant create a method";
    public static final String COMPILER_UNABLE_TO_CREATE_SECTION =
            "Seems that the compiler cant create a section";
    public static final String COMPILER_UNABLE_TO_READ_COMMEND =
            "Seems that the compiler cant read the commend line that in the file";

    public static final String END_OF_SECTION_NOT_FOUND = "Seems that we cant find the end of the section";
    public static final String ARGS_NUMBER_WRONG =
            "Seems that you enter wrong number of arguments, pls enter" + Const.ARG_NUMBER + "argument only!";
}
