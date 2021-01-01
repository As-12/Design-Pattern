package AbstractFactory;


/* Abstract Factory Pattern
    Defines interface for creating an object, but let the subclass decides implementation.
 */

/* Product */

abstract class Pizza {
    String description;
    String sauce;
    String name;
    abstract void prepare();

    void bake() {
        this.description = "baked " + this.description;
    }

    public void cut() {
        this.description = "cut " + this.description;
    }

    public void box() {
        this.description = "boxed " + this.description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return this.description + this.name + " with " + this.sauce + " sauce";
    }

}

class NewYorkPizza extends Pizza {
    PizzaSauceFactory sauceFactory;

    public NewYorkPizza(PizzaSauceFactory sauceFactory) {
        this.sauceFactory = sauceFactory;
    }

    void prepare() {
        this.setName("New York Pizza");
        this.description = "";
        this.sauce = this.sauceFactory.createSauce();
        this.box();
    }
}

class ChicagoPizza extends Pizza {
    PizzaSauceFactory sauceFactory;

    public ChicagoPizza(PizzaSauceFactory sauceFactory) {
        this.sauceFactory = sauceFactory;
    }

    void prepare() {
        this.setName("Chicago Pizza");
        this.description = "";
        this.sauce = this.sauceFactory.createSauce();

        this.cut();
        this.box();
    }
}

/* Creator */
abstract class PizzaSauceFactory {
    abstract public String createSauce();
}

class WhiteNYSauceFactory extends PizzaSauceFactory{
    public String createSauce() {
        return "White NY";
    }
}

class RedSpanishSauceFactory extends PizzaSauceFactory{
    public String createSauce() {
        return "Red Spanish";
    }
}

/* Main */
public class main {

    public static void main(String[] args) {
        Pizza aPizza = new ChicagoPizza(new WhiteNYSauceFactory());
        aPizza.prepare();
        System.out.println(aPizza);

        aPizza = new ChicagoPizza(new RedSpanishSauceFactory());
        aPizza.prepare();
        System.out.println(aPizza);

        aPizza = new NewYorkPizza(new WhiteNYSauceFactory());
        aPizza.prepare();
        System.out.println(aPizza);
    }
}
