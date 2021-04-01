package oop.ex6.main.compiler;


import oop.ex6.main.exceptions.sections.GeneralError;
import oop.ex6.main.language.Keywords;
import oop.ex6.main.language.Messages;
import oop.ex6.main.language.Regexs;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent the a method of a loop in the compiler.
 */
public class Loop extends Section {
    private static final String NAME = Keywords.LOOP;
    private Condition condition;

    /**
     * this is empty contractor of loop
     */
    Loop() {
        this.setName(NAME);
    }

    /**
     * this is contractor of section
     *
     * @param dataInLine data for use of lower classes such as method and loop.
     * @param parent     the parent of the section.
     * @throws GeneralError in case we had problem with create the loop.
     */
    Loop(String[] dataInLine, Compiler parent) throws GeneralError {
        super(dataInLine, parent);
        try {
            this.setName(NAME);
            String conditionClean = String.join(Regexs.ONE_WHITE_SPACE, dataInLine).
                    split(Regexs.PARENTHESES_LEFT)[1].split(Regexs.PARENTHESES_RIGHT)[0];
            this.setCondition(new Condition(conditionClean, this));
        } catch (oop.ex6.main.exceptions.sections.conditions.GeneralError e) {
            throw new GeneralError(Messages.GENERAL_ERROR + NAME, e);
        }
    }

    /**
     * @return the condition of the loop
     */
    public Condition getCondition() {
        return condition;
    }

    /**
     * set the condition of the loop
     *
     * @param condition a condition
     */
    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
