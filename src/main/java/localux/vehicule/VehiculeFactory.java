package localux.vehicule;

import localux.vehicule.items.Daube;
import localux.vehicule.items.Luxe;
import localux.vehicule.items.Standard;

public class VehiculeFactory {

    private VehiculeType type;

    public static Vehicule create(String name, VehiculeType type) {
        return switch (type) {
            case LUXE -> new Luxe(name);
            case STANDARD -> new Standard(name);
            case DAUBE -> new Daube(name);
        };
    }

}