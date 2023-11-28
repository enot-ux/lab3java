package org.university;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public class Cart {


    private final List<Product> productList = new ArrayList<>();

    public void addProductToCart(Product product){
        productList.add(product);
    }

//    Making the Method throwable to handle an exception higher in a stack
    public void removeProductFromCart(Product product) throws IllegalArgumentException{
        if (!productList.contains(product)){
            throw new IllegalArgumentException("There is no such item in a cart!");
        }
        else {
            productList.remove(product);
        }
    }


}
