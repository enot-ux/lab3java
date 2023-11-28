package org.university;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class OrderTest {

    Product tea;
    Product rice;
    @Mock
    Cart cart;
    @InjectMocks
    Order order;

    @BeforeEach
    void setUp(){
        tea = new Product("0","Tea", 29.99);
        rice = new Product("2","Rice", 34.79);

    }

    @Test
    void createOrderWithRightArgumentsTest(){
        Mockito.when(cart.getProductList()).thenReturn(List.of(rice, tea));
        order = Order.createOrder(cart, "0", "Processing");
        assertNotNull(order);
    }

    @Test
    void createOrderWithWrongArgumentsTest(){

        Mockito.when(cart.getProductList()).thenReturn(new ArrayList<>());

        assertThrows(IllegalArgumentException.class, () -> order = Order.createOrder(cart, "0", "Processing"));

    }

    @Test
    void getOrderStatusTest(){
        Mockito.when(cart.getProductList()).thenReturn(List.of(rice, tea));
        order = Order.createOrder(cart, "0", "Processing");
        assertEquals("Processing", order.getStatus());
    }
}
