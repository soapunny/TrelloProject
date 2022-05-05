package app.db.entity;

public class LoginEntity {
	private String email;
	private String password;
	private boolean isRemembered;
	private String lastLoginTime;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean getRemembered() {
		return isRemembered;
	}
	public void setRemembered(boolean isRemembered) {
		this.isRemembered = isRemembered;
	}
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
}
