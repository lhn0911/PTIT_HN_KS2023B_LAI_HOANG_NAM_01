package com.rikkei.ptit_hn_ks23b_laihoangnam_01.repository;


import com.rikkei.ptit_hn_ks23b_laihoangnam_01.utils.ConnectionDB;
import com.rikkei.ptit_hn_ks23b_laihoangnam_01.model.Product;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImp implements ProductDao {
    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_Product()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProduct_id(rs.getInt("product_id"));
                product.setProduct_name(rs.getString("product_name"));
                product.setPrice(rs.getDouble("price"));
                product.setDescription(rs.getString("description"));
                product.setImage_url(rs.getString("image"));
                product.setStatus(rs.getBoolean("status"));
                product.setCreated_at(rs.getDate("create_at").toLocalDate());
                product.setCategory_id(rs.getInt("category_id"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return products;
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_by_Id(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                product = new Product();
                product.setProduct_id(rs.getInt("product_id"));
                product.setProduct_name(rs.getString("product_name"));
                product.setPrice(rs.getDouble("price"));
                product.setDescription(rs.getString("description"));
                product.setImage_url(rs.getString("image"));
                product.setStatus(rs.getBoolean("status"));
                product.setCreated_at(rs.getDate("create_at").toLocalDate());
                product.setCategory_id(rs.getInt("category_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return product;
    }

    @Override
    public boolean save(Product product) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call save_product(?, ?, ?, ?)}");
            callSt.setString(1, product.getProduct_name());
            callSt.setDouble(2, product.getPrice());
            callSt.setString(3, product.getDescription());
            callSt.setString(4, product.getImage_url());
            callSt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public boolean update(Product product) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_Product(?, ?, ?, ?, ?, ?, ?, ?)}");
            callSt.setInt(1, product.getProduct_id());
            callSt.setString(2, product.getProduct_name());
            callSt.setDouble(3, product.getPrice());
            callSt.setString(4, product.getDescription());
            callSt.setString(5, product.getImage_url());
            callSt.setBoolean(6, product.isStatus());
            callSt.setDate(7, Date.valueOf(product.getCreated_at()));
            callSt.setInt(8, product.getCategory_id());
            callSt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_product(?)}");
            callSt.setInt(1, id);
            callSt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }
}
