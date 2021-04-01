package oop.ex6.main.modifiers;

import oop.ex6.main.language.Keywords;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent a final modifier which is keyword that specify the variable value is unable to
 *         reassigned
 */
public class Final extends Modifier {
    static final String NAME = Keywords.FINAL;

    /**
     * Constructs a final modifier
     */
    public Final() {
        this.setName(NAME);
        this.setModifierUse(true);
    }
}
