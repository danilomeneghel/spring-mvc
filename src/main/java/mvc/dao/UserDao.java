package mvc.dao;

import java.util.List;

import mvc.form.UserForm;
import mvc.model.User;

public interface UserDao {

	public List<User> listAllUsers();

	public User findUserById(int id);

	public String findUserByUsername(String username);

	public boolean userExists(String username);

	public void signUp(UserForm userForm);
	
	public void addUser(User user);

	public void updateUser(User user);

	public void deleteUser(int id);
}