package entities.order.state;

import entities.order.Order1;


public class OutForDelivery implements DeliveryState {
    public static final String name = "Out For Delivery";

    public static OutForDelivery instance = new OutForDelivery();

    public OutForDelivery() {
    }

    public static OutForDelivery getInstance() {
        return instance;
    }

    @Override
    public void updateState(Order1 order) {
        order.setDeliveryState(Delivered.getInstance());
    }

    @Override
    public String getName() {
        return "OutForDelivery";
    }
}
