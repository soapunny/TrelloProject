package app.logic;

import app.db.AppDAO;
import app.db.entity.LoginEntity;
import app.enumeration.TaskNames;
import app.logic.dto.LoginDTO;

public class LoginTask extends Task {

	@Override
	public Object doTask(TaskNames task, Object param) {
		Object object = null;
		
		if(task == TaskNames.LOGIN_APP) {
			if(param == null) {
				object = checkRememberedOnApp();
			}
			else {
				object = loginApp((LoginDTO)param);
			}
		}
		else if(task == TaskNames.LOGIN_APPFOLIO) {
			if(param == null) {
				object = checkRememberedOnAppfolio();
			}
			else {
				object = loginAppfolio((LoginDTO)param);
			}
		}
		else if(task == TaskNames.LOGIN_EMAIL) {
			if(param == null) {
				object = checkRememberedOnGmail();
			}
			else {
				object = loginGmail((LoginDTO)param);
			}
		}
		else if(task == TaskNames.LOGIN_TRELLO) {
			if(param == null) {
				object = checkRememberedOnTrello();
			}
			else {
				object = loginTrello((LoginDTO)param);
			}
		}
		
		return object;
	}
	
	public LoginDTO checkRememberedOnApp() {
		LoginDTO loginDTO = null;
		//Check isRemembered from DB and get the login data.
		AppDAO loginDAO = AppDAO.getInstance();
		LoginEntity loginEntity = loginDAO.getRememberedAppAccount();
		if(loginEntity != null)
			loginDTO = new LoginDTO(loginEntity);
		return loginDTO;
	}

	public LoginDTO checkRememberedOnAppfolio() {
		LoginDTO loginDTO = null;
		//Check isRemembered from DB and get the login data.
		return loginDTO;
	}

	public LoginDTO checkRememberedOnGmail() {
		LoginDTO loginDTO = null;
		//Check isRemembered from DB and get the login data.
		return loginDTO;
	}

	public LoginDTO checkRememberedOnTrello() {
		LoginDTO loginDTO = null;
		//Check isRemembered from DB and get the login data.
		return loginDTO;
	}

	public boolean loginApp(LoginDTO loginDTO) {
		//TODO login logic
		AppDAO loginDAO = AppDAO.getInstance();
		return loginDAO.loginApp(loginDTO.toLoginEntity());
	}
	
	public boolean loginAppfolio(LoginDTO loginDTO) {
		//TODO Appfolio login logic
		return false;
	}
	
	public boolean loginGmail(LoginDTO loginDTO) {
		//TODO Gmail login logic
		return false;
	}
	
	public boolean loginTrello(LoginDTO loginDTO) {
		//TODO Trello login logic
		return false;
	}
}
