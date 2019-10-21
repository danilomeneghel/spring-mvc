package mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import mvc.form.UserForm;
import mvc.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public List listAllUsers() {
		String sql = "SELECT * FROM users";

		List<User> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new UserMapper());

		return list;
	}

	private SqlParameterSource getSqlParameterByModel(User user) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if (user != null) {
			parameterSource.addValue("id", user.getId());
			parameterSource.addValue("name", user.getName());
			parameterSource.addValue("email", user.getEmail());
			parameterSource.addValue("address", user.getAddress());
			parameterSource.addValue("username", user.getUsername());
			if (user.getPassword() != null) {
				parameterSource.addValue("password", user.getPassword());
			}
		}
		return parameterSource;
	}

	private static final class UserMapper implements RowMapper {

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setAddress(rs.getString("address"));
			user.setUsername(rs.getString("username"));

			return user;
		}

	}

	public User findUserById(int id) {
		String sql = "SELECT * FROM users WHERE id = :id";

		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new User(id)), new UserMapper());
	}

	private SqlParameterSource getSqlParameterSource(String username) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("username", username);

		return parameterSource;
	}

	public String findUserByUsername(String username) {
		String sql = "select username from users where username = :username";

		List<String> list = namedParameterJdbcTemplate.queryForList(sql, getSqlParameterSource(username), String.class);

		return list.get(0);
	}

	public boolean userExists(String username) {
		String sql = "select * from users where username = :username";

		List list = namedParameterJdbcTemplate.query(sql, getSqlParameterSource(username), new UserMapper());

		if (list.size() > 0) {
			return true;
		}

		return false;
	}

	public void addUser(User user) {
		String sql = "INSERT INTO users(name, email, address, username, password) VALUES(:name, :email, :address, :username, :password)";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user));

		sql = "INSERT INTO user_roles(username, role) VALUES(:username, 'ROLE_USER')";
		
		namedParameterJdbcTemplate.update(sql, getSqlParameterSource(user.getUsername()));
	}

	public void updateUser(User user) {
		String sql = "UPDATE users SET name = :name, email = :email, address = :address, username = :username, password = :password WHERE id = :id";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(user));
	}

	public void deleteUser(int id) {
		String sql = "DELETE FROM users WHERE id = :id";

		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new User(id)));
	}

	public void signUp(UserForm userForm) {
		User user = new User();
		user.setName(userForm.getName());
		user.setEmail(userForm.getEmail());
		user.setAddress(userForm.getAddress());
		user.setUsername(userForm.getUsername());
		user.setPassword(userForm.getPassword());

		addUser(user);
	}

}