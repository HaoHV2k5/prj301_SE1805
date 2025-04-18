/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.BookDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DBUtils;

/**
 *
 * @author asus
 */
public class BookDAO implements I_DAO<BookDTO, String>{

    @Override
    public boolean create(BookDTO entity) {
        return false;
    }

    @Override
    public boolean update(BookDTO entity) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<BookDTO> readAll() {
        return null;
    }

    @Override
    public BookDTO readById(String id) {
        return null;
    }

    public List<BookDTO> searchByTitle(String searchTerm) {
        String sql = "select * from tblBooks where title like ? and quantity >0";
        List<BookDTO> list = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" +searchTerm +"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                BookDTO book = new BookDTO(
                        rs.getString("BookID"),
                         rs.getString("Title"), 
                         rs.getString("Author"), 
                         rs.getInt("PublishYear"),
                         rs.getDouble("Price"),
                         rs.getInt("Quantity"));
                
                list.add(book);
            }
            
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
    
    
    

    public boolean updateQuantityToZero(String id) {
       String sql = "update tblBooks set quantity = 0 where bookID = ?";
        
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            int i = ps.executeUpdate();
            return i>0;
            
                                            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
}
