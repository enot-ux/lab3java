package org.university;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CartTest {

    Product tea;
    Product rice;
    Cart cart;
    @BeforeEach
    void setUp(){
        tea = new Product("0","Tea", 29.99);
        rice = new Product("2","Rice", 34.79);
        cart = new Cart();
    }

    @Test
    void addProductFromCartTest(){
        cart.addProductToCart(tea);
        cart.addProductToCart(rice);
        assertTrue(cart.getProductList().contains(tea), "Product was successfully added");
        assertTrue(cart.getProductList().contains(rice),"Product was successfully added");
    }

    @Test
    void removeProductFromCartTest(){
        cart.addProductToCart(tea);
        cart.addProductToCart(rice);
        cart.removeProductFromCart(tea);
        cart.removeProductFromCart(rice);
        assertFalse(cart.getProductList().contains(tea),"Product was successfully removed");
        assertFalse(cart.getProductList().contains(rice),"Product was successfully removed");

    }

    @Test
    void removeAbsentProductFromCartTest(){
        assertThrows(IllegalArgumentException.class, () -> cart.removeProductFromCart(tea));
    }
}


