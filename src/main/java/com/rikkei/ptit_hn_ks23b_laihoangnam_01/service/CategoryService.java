package com.rikkei.ptit_hn_ks23b_laihoangnam_01.service;

import com.rikkei.ptit_hn_ks23b_laihoangnam_01.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(int id);
    boolean save(Category category);
    boolean update(Category category);
    boolean delete(int id);
}
