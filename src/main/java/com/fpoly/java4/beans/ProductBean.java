package com.fpoly.java4.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductBean {
    private int id;
    private String name;
    private int price;
    private int quantity;
    private int catId;
}
