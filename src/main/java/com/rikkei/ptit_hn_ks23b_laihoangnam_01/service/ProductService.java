package com.rikkei.ptit_hn_ks23b_laihoangnam_01.service;

import com.rikkei.ptit_hn_ks23b_laihoangnam_01.model.Product;

import java.util.List;

public interface ProductService{
    List<Product> findAll();
    Product findById(int id);
    boolean save(Product product);
    boolean update(Product product);
    boolean delete(int id);
}
