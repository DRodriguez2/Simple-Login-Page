package hibernateClasses;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	private String username;
	private String password;

	public UserEntity(String _user, String _password) {
		this.username = _user;
		this.password = _password;
	}
	public UserEntity() {
		
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
