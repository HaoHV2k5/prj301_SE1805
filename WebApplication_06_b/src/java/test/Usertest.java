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

//        for(int i =0 ; i<= 9 ; i++){
//            UserDTO u = new UserDTO("LTN"+i, "huynh van hao "+i, "US", "0000"+1);
//            user.create(u);
//        }
//        UserDTO u = new UserDTO("LTN", "huynh van hao " , "US", "toi ko co pass");
//        user.update(u);
//            user.delete("LTN");

            System.out.println(user.readById("QL002"));

    }
}
