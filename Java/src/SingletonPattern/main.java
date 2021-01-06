package SingletonPattern;

/**
 * Singleton ensures a class only has one instance and provide a global access to it.
 * Accessing singleton should be synchronize to ensure thread safety.
 *
 * Some of the examples use synchronize method and  monitor to restrict one thread access to instance creation.
 * See http://tutorials.jenkov.com/java-concurrency/synchronized.html for more tutorial on Java concurrency.
 */

class UnSafeSingleton {

    static private UnSafeSingleton instance;

    private int number;
    private UnSafeSingleton () {
        number = 100;
    }
    static public UnSafeSingleton getInstance() {
        if(instance == null) {
            instance = new UnSafeSingleton();
        }
        return instance;
    }

    public int getNumber() {
        return this.number;
    }
}

class SafeSingleton {
    static private SafeSingleton instance;

    private int number;
    private SafeSingleton () {
        number = 200;
    }
    static public synchronized SafeSingleton getInstance() {
        if(instance == null) {
            instance = new SafeSingleton();
        }
        return instance;
    }

    public int getNumber() {
        return this.number;
    }
}
class EagerSafeSingleton {

    static private EagerSafeSingleton instance = new EagerSafeSingleton();

    private int number;
    private EagerSafeSingleton () {
        number = 300;
    }
    static public EagerSafeSingleton getInstance() {
        return instance;
    }

    public int getNumber() {
        return this.number;
    }
}

class DoubleLockSingleton {
    static volatile private DoubleLockSingleton instance;

    private int number;
    private DoubleLockSingleton () {
        number = 400;
    }
    static public DoubleLockSingleton getInstance() {
        if(instance == null) {
            synchronized (DoubleLockSingleton.class) {
                if(instance == null) {
                    instance = new DoubleLockSingleton();
                }
            }
        }
        return instance;
    }

    public int getNumber() {
        return this.number;
    }
}

public class main {
    public static void main(String[] args) {
        System.out.println(UnSafeSingleton.getInstance().getNumber());
        System.out.println(SafeSingleton.getInstance().getNumber());
        System.out.println(EagerSafeSingleton.getInstance().getNumber());
        System.out.println(DoubleLockSingleton.getInstance().getNumber());
    }
}
