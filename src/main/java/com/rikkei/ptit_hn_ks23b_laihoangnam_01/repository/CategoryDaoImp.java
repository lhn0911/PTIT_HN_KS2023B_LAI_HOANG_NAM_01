package com.rikkei.ptit_hn_ks23b_laihoangnam_01.repository;

import com.rikkei.ptit_hn_ks23b_laihoangnam_01.utils.ConnectionDB;
import com.rikkei.ptit_hn_ks23b_laihoangnam_01.model.Category;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CategoryDaoImp implements CategoryDao{
    @Override
    public List<Category> findAll() {
        List<Category> list = new ArrayList<>();
        Connection conn = null;
        CallableStatement callSt = null;
        try{
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_Category()}");
            callSt.execute();
            ResultSet rs = callSt.executeQuery();
            while(rs.next()){
                Category categories = new Category();
                categories.setCategory_id(rs.getInt("category_id"));
                categories.setCategory_name(rs.getString("category_name"));
                categories.setDescription(rs.getString("description"));
                categories.setStatus(rs.getBoolean("status"));
                list.add(categories);
            }
        }catch(SQLException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return list;
    }

    @Override
    public Category findById(int id) {
        Category category = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try{
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_byId(?)}");
            callSt.setInt(1, id);
            callSt.execute();
            ResultSet rs = callSt.executeQuery();
            while (rs.next()){
                category = new Category();
                category.setCategory_id(rs.getInt("category_id"));
                category.setCategory_name(rs.getString("category_name"));
                category.setDescription(rs.getString("description"));
                category.setStatus(rs.getBoolean("status"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return category;
    }

    @Override
    public boolean save(Category category) {
        Connection conn = null;
        CallableStatement callSt = null;
        try{
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call save_Category(?, ?)}");
            callSt.setString(1, category.getCategory_name());
            callSt.setString(2, category.getDescription());
            callSt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public boolean update(Category category) {
        Connection conn = null;
        CallableStatement callSt = null;
        try{
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_Category(?, ?, ?, ?)}");
            callSt.setInt(1, category.getCategory_id());
            callSt.setString(2, category.getCategory_name());
            callSt.setString(3, category.getDescription());
            callSt.setBoolean(4, category.isStatus());
            callSt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
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
            callSt = conn.prepareCall("{call delete_Category(?)}");
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
