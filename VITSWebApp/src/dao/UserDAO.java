package dao;


import java.util.HashMap;
import java.util.List;

import dto.UserTO;
import forms.UserForm;

public interface UserDAO extends CommonDAO{
	
public UserTO findUserByName(String username);
public UserTO findUserById(Integer userId);
public List findAll();
public HashMap getUserMap();
public UserTO insert(UserForm userForm);
public UserTO update(UserForm userForm);
public boolean delete(UserForm userForm);

}
