package oop.ex6.main.modifiers;

import oop.ex6.main.Symbol;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This abstract class represent a modifier.
 */
public abstract class Modifier extends Symbol {
    private Boolean modifierUse;

    /**
     * this method declare if we use the modifier and return true else return false
     *
     * @return true if we use the modifier
     */
    public Boolean getModifierUse() {
        return this.modifierUse;
    }

    /**
     * this function declare if we use in modifier  or not.
     *
     * @param modifierUse value to set if we use the modifier or not
     */
    public void setModifierUse(Boolean modifierUse) {
        this.modifierUse = modifierUse;
    }
}
