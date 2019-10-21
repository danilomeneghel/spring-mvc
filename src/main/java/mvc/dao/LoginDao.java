package mvc.dao;

import java.util.List;

import mvc.model.User;

public interface LoginDao {
	
	User findUserInfo(String username);

	List<String> getUserRoles(String username);
}