package mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mvc.dao.LoginDao;

@Service
public class LoginServiceImpl implements UserDetailsService {

	LoginDao loginDao;

	@Autowired
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		mvc.model.User user = loginDao.findUserInfo(username);

		if (user == null) {
			throw new UsernameNotFoundException("Usuário não encontrado.");
		}

		List<String> roles = loginDao.getUserRoles(username);

		List grantList = new ArrayList();

		if (roles != null) {
			for (String role : roles) {
				GrantedAuthority authority = new SimpleGrantedAuthority(role);
				grantList.add(authority);
			}
		}

		UserDetails userDetails = new User(user.getUsername(), user.getPassword(), grantList);

		return userDetails;
	}
	
}