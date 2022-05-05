package app.logic;

import app.enumeration.TaskNames;
import app.logic.dto.LabelDTO;
import app.logic.dto.LoginDTO;

public class Automation {
	private static Automation instance;
	
	private Task loginTask;
	private Task aiTask;
	private Task trelloTask;
	//Chromedriver
	
	public static Automation getInstance() {
		synchronized(Automation.class){
			if(instance == null) {
				instance = new Automation();
			}
		}
		return instance;
	}
	
	private Automation() {
		loginTask = new LoginTask();
		aiTask = new AITask();
		trelloTask = new TrelloTask();
		//TODO make instance of Chromedriver
	}
	

	public LoginDTO checkIsRemembered(TaskNames task) {
		return (LoginDTO)loginTask.doTask(task, null);
	}
	
	//Add the instance of Chromedriver on the parameter of the method below.
	public boolean login(TaskNames task, LoginDTO loginDTO) {
		Object result = loginTask.doTask(task, loginDTO);
		if(result == null)
			return true;
		else
			return false;
	}

	public boolean addLabel(LabelDTO labelDTO) {
		
		return false;
	}
}
