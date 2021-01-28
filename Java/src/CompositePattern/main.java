package CompositePattern;


/*
 * Composite Pattern allows us to build a complex structure in a form of tree that contains both composition and individual objects as nodes.
 *
 * Composition structure allows us to abstract the  complicated structure / nested collections as individual objects.
 * For example, a Menu that can have a sub-menu and so on.
 */


import java.util.ArrayList;
import java.util.List;

//Component
abstract class MenuComponent {

    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }
    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }
    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }
    public String getName() {
        throw new UnsupportedOperationException();
    }
    public void print() {
        throw new UnsupportedOperationException();
    }
}

//Leaf
class MenuItem extends MenuComponent {

    private final String name;

    public MenuItem(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void print() {
        System.out.println(this.name);
    }
}

//Composite
class Menu extends MenuComponent {

    private List<MenuComponent> menus;

    private final String name;

    public Menu(final String name) {
        this.name = name;
        this.menus = new ArrayList<>();
    }

    @Override
    public void add(MenuComponent menuComponent) {
        this.menus.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        this.menus.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(final int index) {
        return this.menus.get(index);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void print() {
        System.out.println("====================");
        System.out.println(this.name + " Menu");
        System.out.println("--------------------");

        for(MenuComponent item : menus) {
            item.print();
        }
    }
}
public class main {

    public static void main(String[] args) {
        MenuComponent dinnerMenu = new Menu("Dinner Menu");
        MenuComponent desertMenu = new Menu("Desert Menu");
        MenuComponent WeekendEntreeMenu = new Menu("Weekend Entree");
        MenuComponent WeekendStarterMenu = new Menu("Weekend Starter");

        dinnerMenu.add(desertMenu);
        dinnerMenu.add(WeekendEntreeMenu);
        dinnerMenu.add(WeekendStarterMenu);

        desertMenu.add(new MenuItem("Ice Cream"));
        desertMenu.add(new MenuItem("Cake"));
        desertMenu.add(new MenuItem("Fruit"));

        WeekendEntreeMenu.add(new MenuItem("Steak"));
        WeekendEntreeMenu.add(new MenuItem("Burger"));

        WeekendStarterMenu.add(new MenuItem("Fish Fingers"));
        WeekendStarterMenu.add(new MenuItem("Fish Soup"));
        WeekendStarterMenu.add(new MenuItem("Cheese Fries"));
        WeekendStarterMenu.add(new MenuItem("Cheese Platter"));


        //Print menu
        dinnerMenu.print();
    }
}
