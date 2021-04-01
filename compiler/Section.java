package oop.ex6.main.compiler;

import oop.ex6.main.exceptions.sections.GeneralError;
import oop.ex6.main.variables.Variable;

import java.util.Stack;

/**
 * @author sharonbash
 * @author roy.levy3
 *         This class represent the a section of a file in the compiler.
 */
public abstract class Section extends Compiler {
    Stack<Variable> variables;
    Stack<Method> methods = new Stack<Method>();
    Stack<Variable> parameters;
    Compiler parent;

    /**
     * this is empty contractor of section
     */
    Section() {
    }

    /**
     * this is contractor of section
     *
     * @param dataInLine data for use of lower classes such as method and loop.
     * @param parent     the parent of the section.
     * @throws GeneralError in case we had problem with create the section.
     */
    Section(String[] dataInLine, Compiler parent) throws GeneralError {
        this.variables = new Stack<Variable>();
        this.parent = parent;
        this.setMethods(parent.getMethodStack());
        this.setVariableStack(parent.getVariableStack());
    }

    /**
     * @return the parent of section
     */
    public Compiler getParent() {
        return this.parent;
    }

    /**
     * @return the current stack of variables
     */
    public Stack<Variable> getVariables() {
        return this.variables;
    }

    /**
     * this method set the stack of method with new stack of method
     *
     * @param methods stack of method
     */
    private void setMethods(Stack<Method> methods) {
        this.methods = methods;
    }

    @Override
    public Stack<Variable> getParameters() {
        return this.parameters;
    }

    @Override
    public Stack<Method> getMethodStack() {
        return this.methods;
    }

    @Override
    public Stack<Variable> getVariableStack() {
        return this.variables;
    }

    @Override
    public void setVariableStack(Stack<Variable> stack) {
        this.variables = stack;
    }
}

