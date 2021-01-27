package Iterator;

/*
 * Iterator Pattern provides a consistent way to access element of a collection sequentially without exposing the
 * implementation.
 */

import java.util.*;

abstract class Item {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Item(final String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

class Produce extends Item {
    public Produce(final String name) {
       super(name);
    }
}

class Storage implements Iterable<Item>  {

    private Map<Item, Integer> inventory;

    public Storage() {
        inventory = new HashMap<>();
    }

    public void addItem(final Item item) {
        if(inventory.containsKey(item)) {
            inventory.put(item, inventory.get(item) + 1);
        } else {
            inventory.put(item, 1);
        }
    }

    //Using custom iterator
    public Iterator<Item> iterator() {
        return new StorageIterator(this.inventory);
    }
}

class FarmerInventory implements Iterable<Item> {
    private List<Item> inventory;

    public FarmerInventory() {
        inventory = new ArrayList<>();
    }
    public void addItem(final Item item) {
        inventory.add(item);
    }

    //Using java default iterator
    public Iterator<Item> iterator() {
        return inventory.iterator();
    }
}


//This iterator provide sequential access to Storage which may contain multiple item in the inventory.
class StorageIterator implements Iterator {

    private Iterator<Item> iterator;
    private int index;
    public StorageIterator(final Map<Item, Integer> inventory) {
        List<Item> inv = new ArrayList<>();
        this.index = 0;
        for(Map.Entry<Item, Integer> entry : inventory.entrySet()) {
            for(int i = 0; i != entry.getValue(); ++i) {
                inv.add(entry.getKey());
            }
        }
        this.iterator = inv.iterator();
    }
    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override
    public Object next() {
        return this.iterator.next();
    }
}


public class main {

    public static void main(String[] args) {
        final Storage storage = new Storage();
        storage.addItem(new Produce("Veggie"));
        storage.addItem(new Produce("Veggie"));
        storage.addItem(new Produce("Cabbage"));
        storage.addItem(new Produce("Carrot"));

        final FarmerInventory farmerInventory = new FarmerInventory();
        farmerInventory.addItem(new Produce("Cabbage"));
        farmerInventory.addItem(new Produce("Cabbage"));

        System.out.println("Storage Inventory");
        for(Item item : storage) {
            System.out.println(item.getName());
        }

        System.out.println("Farmer Inventory");
        for(Item item: farmerInventory) {
            System.out.println(item.getName());
        }
    }
}
