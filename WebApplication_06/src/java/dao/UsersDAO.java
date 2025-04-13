/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.UsersDTO;
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
public class UsersDAO implements I_DAO<UsersDTO, String>{

    @Override
    public boolean create(UsersDTO entity) {
     String sql = "INSERT [dbo].[tblUsers] ([userID], [fullName], [roleID], "
             + "[password]) VALUES (N'"+entity.getUserID()+"', N'"+entity.getFullName()
             +"', N'"+entity.getRoleID()+"', N'"+entity.getPassword()+"')";
     
        try {
            Connection conn = DBUtils.getConnection();
            Statement stament = conn.createStatement();
            int n = stament.executeUpdate(sql);
            return n > 0;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<UsersDTO> readAll() {
        List<UsersDTO> list = new ArrayList<>();
        String sql = "select * from dbo.tblUsers";
        
        try {
            Connection conn = DBUtils.getConnection();
            Statement stament = conn.createStatement();
            ResultSet rs = stament.executeQuery(sql);
            while(rs.next()){
                UsersDTO user = new UsersDTO(rs.getString("fullName"),rs.getString("userID"), rs.getString("roleID"), rs.getString("password"));
                list.add(user);
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public UsersDTO readById(String id) {
      
        String sql = "select * from dbo.tblUsers where userID = '" +id +"'";
        
        try {
            Connection conn = DBUtils.getConnection();
            Statement stament = conn.createStatement();
            ResultSet rs = stament.executeQuery(sql);
            if(rs.next()){
                UsersDTO user = new UsersDTO(rs.getString("fullName"),rs.getString("userID"), rs.getString("roleID"), rs.getString("password"));
                return user;
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean update(UsersDTO entity) {
         String sql = " update dbo.tblUsers\n" +
"  set userID = N'"+entity.getUserID()+"', fullName = N'"+entity.getFullName()+"', roleID ='"+entity.getRoleID()+"', password ='"+entity.getPassword()+"'where userID = '"+entity.getUserID()+" '";
     
        try {
            Connection conn = DBUtils.getConnection();
            Statement stament = conn.createStatement();
            int n = stament.executeUpdate(sql);
            return n > 0;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
      String sql = "delete from tblUsers\n" +
            "  where userID = '" + id+"'";
     
        try {
            Connection conn = DBUtils.getConnection();
            Statement stament = conn.createStatement();
            int n = stament.executeUpdate(sql);
            return n > 0;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UsersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<UsersDTO> search(String searchTerm) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
