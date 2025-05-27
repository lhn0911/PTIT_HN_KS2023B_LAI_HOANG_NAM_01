package com.rikkei.ptit_hn_ks23b_laihoangnam_01.service;

import com.rikkei.ptit_hn_ks23b_laihoangnam_01.model.Category;
import com.rikkei.ptit_hn_ks23b_laihoangnam_01.repository.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImp implements CategoryService{
    @Autowired
    private CategoryDao categoryDao;
    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryDao.findById(id);
    }

    @Override
    public boolean save(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public boolean update(Category category) {
        return categoryDao.update(category);
    }

    @Override
    public boolean delete(int id) {
        return categoryDao.delete(id);
    }
}
