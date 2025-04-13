/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author asus
 */
public class UsersDTO {
     private String fullName;
    private String UserID;
    private String roleID;
    private String password;
    private String address;

    public UsersDTO() {
    }

    public UsersDTO(String fullName, String UserID, String roleID, String password) {
        this.fullName = fullName;
        this.UserID = UserID;
        this.roleID = roleID;
        this.password = password;
       
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UsersDTO{" + "fullName=" + fullName + ", UserID=" + UserID + ", roleID=" + roleID + ", password=" + password  + '}';
    }

   
    
    
}
