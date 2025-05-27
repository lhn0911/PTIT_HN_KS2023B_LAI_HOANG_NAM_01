package com.rikkei.ptit_hn_ks23b_laihoangnam_01.service;

import com.rikkei.ptit_hn_ks23b_laihoangnam_01.model.Product;
import com.rikkei.ptit_hn_ks23b_laihoangnam_01.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product findById(int id) {
        return productDao.findById(id);
    }

    @Override
    public boolean save(Product product) {
        return productDao.save(product);
    }

    @Override
    public boolean update(Product product) {
        return productDao.update(product);
    }

    @Override
    public boolean delete(int id) {
        return productDao.delete(id);
    }
}
