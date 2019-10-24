package mvc.service;

import java.util.List;

import mvc.form.UserForm;
import mvc.model.User;

public interface UserService {

	public List<User> listAllUsers();

	public User findUserById(int id);

	public User findUserByUsername(String username);

	public boolean userExists(String username);

	public void signUp(UserForm userForm);

	public void addUser(User user);

	public void updateUser(User user);

	public void deleteUser(int id);
}