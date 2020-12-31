package DecoratorPattern;


/* Decorator Pattern
    Attaches additional responsibility to an object dynamically without
    breaking open/close and single responsibility pattern.

    Decorator Pattern provides a much better alternative than having million subclasses
 */
abstract class Sword {
    String name;

    public String getName() {
        return name;
    }

    public abstract double damage();
}

class SilverSword extends Sword {

    @Override
    public String getName() {
        return "Silver Sword";
    }

    @Override
    public double damage() {
        return 5 ;
    }
}

class IronSword extends Sword {

    @Override
    public String getName() {
        return "Silver Sword";
    }

    @Override
    public double damage() {
        return 7 ;
    }

}

abstract class EnchantmentDecorator extends Sword {
    public abstract double damage();
}

class IceEnchant extends EnchantmentDecorator {

    Sword sword;
    IceEnchant(Sword sword) {
        this.sword = sword;
    }
    @Override
    public String getName() {
        return "Ice Enchanted " + sword.getName();
    }

    @Override
    public double damage() {
        return 100 + this.sword.damage() ;
    }
}

class FireEnchant extends EnchantmentDecorator{
    Sword sword;
    FireEnchant(Sword sword) {
        this.sword = sword;
    }
    @Override
    public String getName() {
        return "Fire Enchanted " + sword.getName();
    }

    @Override
    public double damage() {
        return 200 + this.sword.damage() ;
    }
}

public class main {
    public static void main(String[] args) {
        Sword mySword = new IronSword();
        mySword = new IceEnchant(mySword);

        System.out.println(mySword.getName());
        System.out.println(mySword.damage());

        mySword = new SilverSword();
        mySword = new IceEnchant(mySword);

        System.out.println(mySword.getName());
        System.out.println(mySword.damage());

        mySword = new IronSword();
        mySword = new IceEnchant(mySword);
        mySword = new FireEnchant(mySword);

        System.out.println(mySword.getName());
        System.out.println(mySword.damage());
    }
}
