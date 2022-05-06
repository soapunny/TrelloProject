package app.logic;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

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
		return (boolean)loginTask.doTask(task, loginDTO);
	}

	public boolean addLabel(LabelDTO labelDTO) {
		return (boolean)trelloTask.doTask(TaskNames.ADDING_LABEL, labelDTO);
	}

	public boolean refreshLabels(DefaultTableModel model) {
		
		return (boolean)trelloTask.doTask(TaskNames.REFRESH_LABEL, model);
	}

	public int deleteLabels(ArrayList<Integer> seqList) {
		
		return (int)trelloTask.doTask(TaskNames.DELETE_LABEL, seqList);
	}
}
