package TemplateMethodPattern;


/**
 * Template Method Pattern defines the skeleton of an algorithm and deferred the implementation to the subclass.
 * Essentially encapsulating the algorithm implementations without changing its structure.
 *
 * This is different than strategy as Strategy Pattern compose an entire algorithm class. Template Method Pattern, however,
 * only abstract the implementation for each step of the algorithm.
 */

abstract class As12Algorithm {

    final void algorithmMethod() {
        step1();
        step2();
        concreteStep1();
        if(optionalStep1()) {
            hook();
        }
    }

    abstract void step1();
    abstract void step2();

    final void concreteStep1() {
        System.out.println("As12Algorithm concrete unchangale step");
    }

    // Optional step decides whether subclass will use optional hook function
    boolean optionalStep1() {
        return true;
    }

    abstract void hook();
}

class Custom1As12WithHook extends As12Algorithm {

    boolean callHook;
    Custom1As12WithHook(boolean callHook) {
        this.callHook = callHook;
    }
    @Override
    void step1() {
        System.out.println("CustomAs12 step1");
    }

    @Override
    void step2() {
        System.out.println("CustomAs12 step2");
    }

    @Override
    void hook() {
        System.out.println("CustomAs12 hook is called");
    }

    @Override
    boolean optionalStep1() {
        return callHook;
    }
}

public class main {

    public static void main(String[] args) {
        As12Algorithm algoWithHook = new Custom1As12WithHook(true);
        As12Algorithm algoNoHook = new Custom1As12WithHook(false);

        System.out.println("----- With Hook -----");
        algoWithHook.algorithmMethod();
        System.out.println("----- No Hook -----");
        algoNoHook.algorithmMethod();
    }
}
