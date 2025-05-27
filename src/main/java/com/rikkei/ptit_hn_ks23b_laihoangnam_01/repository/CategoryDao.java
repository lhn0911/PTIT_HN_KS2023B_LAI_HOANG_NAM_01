package com.rikkei.ptit_hn_ks23b_laihoangnam_01.repository;

import com.rikkei.ptit_hn_ks23b_laihoangnam_01.model.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> findAll();
    Category findById(int id);
    boolean save(Category category);
    boolean update(Category category);
    boolean delete(int id);
}
