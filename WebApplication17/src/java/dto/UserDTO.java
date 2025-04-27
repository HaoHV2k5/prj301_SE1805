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

    private String userID;
    private String fullName;
    private String roleId;
    private String password;
    private String  email;
    private boolean status;
    private String tolen;

    public UserDTO() {
    }

    public UserDTO(String userID, String fullName, String roleId, String password,String  email, boolean status, String tolen ) {
        this.userID = userID;
        this.fullName = fullName;
        this.roleId = roleId;
        this.password = password;
        this.email = email;
        this.status = status;
        this.tolen = tolen;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTolen() {
        return tolen;
    }

    public void setTolen(String tolen) {
        this.tolen = tolen;
    }
    
    
    
}
