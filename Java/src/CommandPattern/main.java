package CommandPattern;

/**
 * Command pattern decouple requester from requests by encapsulating the request as an object.
 * This allow you to parameterize request with other objects.
 *
 * Some use case:
 *  Macro - series of command
 *  Undo operation
 *  Log request
 *  Queue requests
 *  Or simply capture series of complicate tasks into a single command
 */

//Command interface
interface Command {
    void execute();
    void undo();
}

//Receiver
// Receiver knows how to perform the action
class TV {
    boolean isOn;

    public TV() {
        this.isOn = false;
    }
    public void turnOn() {
        this.isOn = true;
    }

    public void turnOff() {
        this.isOn = false;
    }

    public String toString() {
        if(this.isOn) {
            return "TV is on";
        } else {
            return "TV is off";
        }
    }
}

//Command
// The command encapsulate the receiver
class TVOnCommand implements Command {

    TV tv;

    public TVOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOn();
    }

    @Override
    public void undo() {
        tv.turnOff();
    }
}

//Command
// The command encapsulate the receiver
class TVOffCommand implements Command {
    TV tv;

    public TVOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOff();
    }

    @Override
    public void undo() {
        tv.turnOn();
    }
}


//Invoker
// Remote control is an invoker that holds the command and carry out requests
class RemoteControl {
    Command onCommand;
    Command offCommand;
    Command undoCommand;

    public RemoteControl() {

    }

    public void setCommand(Command on, Command off) {
        this.onCommand = on;
        this.offCommand = off;
    }

    public void pushOnButton() {
        onCommand.execute();
        undoCommand = onCommand;
    }

    public void pushOffButton() {
        offCommand.execute();
        undoCommand = offCommand;
    }

    public void pushUndoButton() {
        undoCommand.undo();
    }
}


public class main {


    // Client
    // Main class is the client using the command
    public static void main(String[] args) {
        TV tv = new TV();
        System.out.println(tv);

        Command onSwitch = new TVOnCommand(tv);
        Command offSwitch = new TVOffCommand(tv);

        RemoteControl remote = new RemoteControl();
        remote.setCommand(onSwitch, offSwitch);

        remote.pushOnButton();
        System.out.println(tv);
        remote.pushUndoButton();
        System.out.println(tv);

        remote.pushOnButton();
        System.out.println(tv);
        remote.pushOffButton();
        System.out.println(tv);
        remote.pushUndoButton();
        System.out.println(tv);

    }

}
