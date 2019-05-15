package entities.order.state;

import entities.order.Order1;


public class Shipped implements DeliveryState {
    public static final String name = "Shipped";

    public static Shipped instance = new Shipped();

    public static Shipped getInstance() {
        return instance;
    }

    public Shipped() {
    }

    @Override
    public void updateState(Order1 order) {
    order.setDeliveryState(OutForDelivery.getInstance());
    }

    @Override
    public String getName() {
        return "Shipped";
    }
}
