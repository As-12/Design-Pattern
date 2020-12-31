package StrategyPattern;

/*
  The strategy pattern,
  the behaviors of a class should not be inherited. Instead, they should be encapsulated using interfaces.

  This is compatible with the open/closed principle (OCP),
  which proposes that classes should be open for extension but closed for modification.
 */


interface BrakeBehavior {
    public void brake();
}

class BrakeWithABS implements BrakeBehavior {
    public void brake() {
        System.out.println("Brake with ABS");
    }
}

class Brake implements BrakeBehavior {
    public void brake() {
        System.out.println("Brake");
    }
}

/* Car can now use the brake algorithms above interchangeably */
abstract class Car {
   private BrakeBehavior brakeStrategy;

    public Car(BrakeBehavior brakeBehavior) {
        this.brakeStrategy = brakeBehavior;
    }

    public void applyBrake() {
        brakeStrategy.brake();
    }
}

/*This sedan uses ABS Brake */
class Sedan extends Car {
    Sedan() {
        super(new BrakeWithABS());
    }
}

public class main {

    public static void main(String[] args) {
        Car myCar = new Sedan();
        System.out.println("Sedan: ");
        myCar.applyBrake();
    }

}
