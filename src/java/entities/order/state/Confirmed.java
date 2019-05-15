package entities.order.state;

import entities.order.Order1;


public class Confirmed implements OrderState {
    public static final String name = "Confirmed";


    private static Confirmed instance = new Confirmed();

    public Confirmed() {
    }

    public static Confirmed getInstance() {
        return instance;
    }

    @Override
    public void updateState(Order1 order) {
        order.setOrderState(Paid.getInstance());
    }

    @Override
    public String getName() {
        return "Confirmed";
    }
}
