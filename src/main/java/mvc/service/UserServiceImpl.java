package mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import mvc.dao.UserDao;
import mvc.form.UserForm;
import mvc.model.User;

@Service
public class UserServiceImpl implements UserService {

	UserDao userDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public List listAllUsers() {
		return userDao.listAllUsers();
	}

	public void addUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDao.addUser(user);
	}

	public void updateUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDao.updateUser(user);
	}

	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}

	public User findUserById(int id) {
		return userDao.findUserById(id);
	}

	public boolean userExists(String username) {
		return userDao.userExists(username);
	}

	public String findUserByUsername(String username) {
		return userDao.findUserByUsername(username);
	}

	public void signUp(UserForm userForm) {
		userForm.setPassword(passwordEncoder.encode(userForm.getPassword()));
		userDao.signUp(userForm);		
	}

}