package com.rikkei.ptit_hn_ks23b_laihoangnam_01.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    private int product_id;
    private String product_name;
    private String description;
    private Double price;
    private String image_url;
    private boolean status;
    private LocalDate created_at;
    private int category_id;
}
