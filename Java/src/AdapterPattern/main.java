package AdapterPattern;

/*
 * Adapter Pattern converts interface of a class into another interface the client expects.
 * Adapter enable classes to work together that couldn't otherwise.
 *
 * Adapter may be similar to decorator BUT
 *   Decorator one add extra responsibility
 *   Adapter converts interface to another
 */

class UKElectricalPlug {
    void ukCharge() {
        System.out.println("UK charging");
    }
}

interface USAElectricalPlug {
    void usCharge();
}


//Use inheritance
class ClassAdapter extends UKElectricalPlug implements USAElectricalPlug {
    @Override
    public void usCharge() {
        this.ukCharge();
    }
}

//Use composition
class ObjectAdapter implements USAElectricalPlug {

    UKElectricalPlug plug;

    ObjectAdapter(UKElectricalPlug plug) {
        this.plug = plug;
    }

    @Override
    public void usCharge() {
        this.plug.ukCharge();
    }
}


public class main {

    public static void main(String[] args) {

        //Convert UK to US Plug using ObjectAdapter
        USAElectricalPlug plug = new ObjectAdapter (new UKElectricalPlug());
        plug.usCharge();

        //Convert UK to US Plug using classAdapter
        USAElectricalPlug plug2 = new ClassAdapter();
        plug2.usCharge();
    }

}
