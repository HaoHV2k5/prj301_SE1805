/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.UserDTO;
import java.util.List;

/**
 *
 * @author asus
 */
public interface I_DAO <T, K>{
    public boolean create(T entity);
    public boolean update(T entity);
    public boolean delete(K id);
    public List<UserDTO> readAll();
    public T readById(K id);
}
