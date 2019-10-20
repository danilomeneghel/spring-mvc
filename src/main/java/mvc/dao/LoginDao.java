package mvc.dao;

import java.util.List;

import mvc.model.UserInfo;

public interface LoginDao {

	UserInfo findUserInfo(String username);

	List getUserRoles(String username);
}