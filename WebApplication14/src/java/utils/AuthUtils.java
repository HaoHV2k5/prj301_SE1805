/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import dao.UserDAO;
import dto.UserDTO;
import javax.servlet.http.HttpSession;

/**
 *
 * @author asus
 */
public class AuthUtils {
    private static final String ADMIN_ROLE = "AD";
    private static final String USER_ROLE = "US";
    
    public static boolean isLoggedIn(HttpSession session){
        return session.getAttribute("user")!= null;
        
    }
    public static UserDTO getUser(HttpSession session){
        if(!isLoggedIn(session)){
            return null;
        }
        return (UserDTO) session.getAttribute("user");
    }
    public static UserDTO getUserByID(String id) {
        UserDAO user = new UserDAO();
        return user.readById(id);
    }

    public static boolean isValidLogin(String username, String password) {
        UserDTO user = getUserByID(username);
        return user != null && user.getPassword().equals(password);
    }
    public static boolean isAdmin(HttpSession session){
        if(!isLoggedIn(session)){
            return false;
        }
        return getUser(session).getRoleId().equals(ADMIN_ROLE);
        
        
        
    }
    
}
