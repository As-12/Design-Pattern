package StatePattern;

/* The State Pattern allows an object to alter its behavior when internal state changes.
 * The pattern implements a state object in a way that is easily extensible such as adding more states.
 *
 * We could implement state machine using switch or bunch of if else on each function, but it is not extensible as
 * adding or removing states lead to big refactor.
 */


/* Context contain states */
class Context {
    private State openState;
    private State closeState;

    private State currentState;

    public Context() {
        this.openState = new OpenState(this);
        this.closeState = new CloseState(this);
        this.currentState = openState;
    }

    void openContext() {
        currentState.open();
    }

    void closeContext() {
        currentState.close();
    }


    public void setState(State newState) {
        this.currentState = newState;
    }

    public State getOpenState() {
        return openState;
    }

    public State getCloseState() {
        return closeState;
    }

    @Override
    public String toString() {
        return this.currentState.toString();
    }
}

interface State {
    public void open();
    public void close();
}

class OpenState implements State {
    private Context context;
    OpenState(Context context) {
        this.context = context;
    }

    public void open() {
        System.out.println("Invalid operation. Open twice");
        // throw exception here perhaps
    }

    public void close() {
        this.context.setState(this.context.getCloseState());
    }

    @Override
    public String toString() {
        return "state: open";
    }
}

class CloseState implements State {
    private Context context;
    CloseState(Context context) {
        this.context = context;
    }

    public void open() {
        this.context.setState(this.context.getOpenState());
    }

    public void close() {

        System.out.println("Invalid operation. Close twice");
        // throw exception here perhaps
    }

    @Override
    public String toString() {
        return "state: closed";
    }
}


public class main {

    public static void main(String[] args) {

        Context context = new Context();

        System.out.println("Current State");
        System.out.println(context);

        System.out.println("-------------");
        System.out.println("Closing....");
        context.closeContext();
        System.out.println(context);

        System.out.println("-------------");
        System.out.println("Closing again....");
        context.closeContext();
        System.out.println(context);

        System.out.println("-------------");
        System.out.println("Open it!");
        context.openContext();
        System.out.println(context);

    }


}
