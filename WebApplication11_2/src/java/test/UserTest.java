/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.UserDAO;
import dto.UserDTO;

/**
 *
 * @author asus
 */
public class UserTest {
    public static void main(String[] args) {
        UserDAO user = new UserDAO();
        UserDTO u = new UserDTO("HHV", "huynh van hao", "AD", "toi khong co biet ma");
        user.delete("HHV");
    }
}
