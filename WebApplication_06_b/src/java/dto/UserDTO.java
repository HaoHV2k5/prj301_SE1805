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
public class UserDTO {
     private String UserID;
    private String fullName;
    private String roleId;
    private String password;

    public UserDTO() {
    }

    public UserDTO(String UserID, String fullName, String roleId, String password) {
        this.UserID = UserID;
        this.fullName = fullName;
        this.roleId = roleId;
        this.password = password;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "UserID=" + UserID + ", fullName=" + fullName + ", roleId=" + roleId + ", password=" + password + '}';
    }
    
}
