package entities.order.state;

import entities.order.Order1;


public class Delivered implements DeliveryState {
    public static final String name = "Delivered";

    public static Delivered instance = new Delivered();

    public Delivered() {
    }

    public static Delivered getInstance() {
        return instance;
    }

    @Override
    public void updateState(Order1 order) {
        order.setDeliveryState(Delivered.getInstance());
    }

    @Override
    public String getName() {
        return "Delivered";
    }
}

