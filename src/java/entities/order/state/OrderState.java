package entities.order.state;

import entities.order.Order1;


public interface OrderState {
    public void updateState(Order1 order);
    public String getName();
}
