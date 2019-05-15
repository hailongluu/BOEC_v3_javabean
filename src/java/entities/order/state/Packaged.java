package entities.order.state;

import entities.order.Order1;


public class Packaged implements DeliveryState {
    public static final String name = "Packaged";

    public static Packaged instance = new Packaged();

    public static Packaged getInstance() {
        return instance;
    }

    public Packaged() {
    }

    @Override
    public void updateState(Order1 order) {
       order.setDeliveryState(Shipped.getInstance());
    }

    @Override
    public String getName() {
        return "Packaged";
    }
}
