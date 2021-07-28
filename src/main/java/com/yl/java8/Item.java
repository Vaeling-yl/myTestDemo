package com.yl.java8;

import lombok.Data;

import javax.naming.Name;
import java.math.BigDecimal;

/**
 * @author vaeling.you
 */
@Data
public class Item {

    private String name;
    private int qty;
    private BigDecimal price;

    public Item(String name, int qty, BigDecimal price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }


    //constructors, getter/setters
}