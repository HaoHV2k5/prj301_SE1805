/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.UsersDAO;
import dto.UsersDTO;
import java.util.List;

/**
 *
 * @author asus
 */
public class UserTest {
    public static void main(String[] args) {
        UsersDAO usersDAO = new UsersDAO();

//        List<UsersDTO> list = usersDAO.readAll();
//        for (UsersDTO u : list) {
//            System.out.println(u);
//        }

        System.out.println(usersDAO.readById("TNL0"));
    }
}
