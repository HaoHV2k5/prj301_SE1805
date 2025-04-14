/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.UserDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DBUtils;

/**
 *
 * @author asus
 */
public class UserDAO implements I_DAO<UserDTO,String>{

    @Override
    public boolean create(UserDTO entity) {
        String sql = "INSERT INTO tblUsers (userID, fullName, roleID, password) VALUES\n" +
"('"+entity.getUserID()+"', N'"+entity.getFullName()+"', '"+entity.getRoleID()+"', '"+entity.getPassword()+"')";
        
        try {
            Connection conn = DBUtils.getConnection();
            Statement st = conn.createStatement();
            int n = st.executeUpdate(sql);
            return n> 0;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
       
    }

    @Override
    public boolean update(UserDTO entity) {
        String sql = "update tblUsers set userID = '"+entity.getUserID()+"', "
                + "fullName = '"+entity.getFullName()+"', roleID = '"+entity.getRoleID()+"'"
                + ",password='"+entity.getPassword()+"' where userID = '"+entity.getUserID()+"'";
        
        try {
            Connection conn = DBUtils.getConnection();
            Statement st = conn.createStatement();
            int n = st.executeUpdate(sql);
            return n> 0;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        String sql = "delete from tblUsers where userID = '"+id+"'";
        
        try {
            Connection conn = DBUtils.getConnection();
            Statement st = conn.createStatement();
            int n = st.executeUpdate(sql);
            return n> 0;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<UserDTO> readAll() {
       String sql = "select * from tblUsers";
        List<UserDTO> list = new ArrayList<>();
        try {
            Connection conn = DBUtils.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                UserDTO user = new UserDTO(rs.getString("userID"), rs.getString("fullName"), rs.getString("roleID"), rs.getString("password"));
                list.add(user);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public UserDTO readById(String id) {
       String sql = "select * from tblUsers where userID = '"+id+"'";
       
        try {
            Connection conn = DBUtils.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                UserDTO user = new UserDTO(rs.getString("userID"), rs.getString("fullName"), rs.getString("roleID"), rs.getString("password"));
               return user;
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
