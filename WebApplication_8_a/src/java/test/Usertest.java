/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.UserDAO;
import dto.UserDTO;
import java.util.List;

/**
 *
 * @author asus
 */
public class Usertest {
    public static void main(String[] args) {
        UserDAO user = new UserDAO();
        System.out.println(user.readById("LNT"));
    }
          
}
