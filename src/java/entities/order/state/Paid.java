package entities.order.state;

import entities.order.Order1;


public class Paid implements OrderState {
    public static final String name = "Paid";

    private static Paid instance = new Paid();

    public Paid() {
    }

    public static Paid getInstance() {
        return instance;
    }

    @Override
    public void updateState(Order1 order) {
        order.setOrderState(this.getInstance());
    }

    @Override
    public String getName() {
        return "Paid";
    }
}
