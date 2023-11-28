package org.university;

import lombok.Getter;

@Getter
public class Order {
    private final Cart cart;
    private final String orderId;
    private  final String status;


//    Making it private to use a Fabric Method
    private Order(Cart cart, String orderId, String status) {
        this.cart = cart;
        this.orderId = orderId;
        this.status = status;
    }


//    Fabric Method to ensure that Order is creating properly
    public static Order createOrder(Cart cart, String orderId, String status) throws IllegalArgumentException{
        if(cart.getProductList().isEmpty()){
            throw new IllegalArgumentException("You cannot create order with an empty cart!");
        }

        return new Order(cart,orderId,status);
    }
}
