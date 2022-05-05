package app.logic.dto;

import app.db.entity.LoginEntity;

public class LoginDTO {
	private String email;
	private String password;
	private boolean isRemembered;
	private String lastLoginTime;
	
	public LoginDTO(LoginEntity loginEntity) {
		this.email = loginEntity.getEmail();
		this.password = loginEntity.getPassword();
		this.isRemembered = loginEntity.getRemembered();
		this.lastLoginTime = loginEntity.getLastLoginTime();
	}
	
	public LoginDTO(String email, String password, boolean isRemebered, String lastLoginTime) {
		this.email = email;
		this.password = password;
		this.isRemembered = isRemebered;
		this.lastLoginTime = lastLoginTime;
	}
	public Object toLoginEntity() {
		LoginEntity loginEntity = new LoginEntity();
		loginEntity.setEmail(this.email);
		loginEntity.setPassword(this.password);
		loginEntity.setRemembered(this.isRemembered);
		loginEntity.setLastLoginTime(this.lastLoginTime);

		return loginEntity;
	}
	
	
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
