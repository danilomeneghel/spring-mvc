package mvc.service;

import java.util.List;

import mvc.form.UserForm;
import mvc.model.User;

public interface UserService {

	public String findUserByUsername(String username);
	
	public List<User> listAllUsers();

	public void signUp(UserForm userForm);
	
	public void addUser(User user);

	public void updateUser(User user);

	public void deleteUser(int id);

	public User findUserById(int id);
	
	public boolean userExists(String username);
}