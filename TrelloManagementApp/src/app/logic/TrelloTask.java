package app.logic;

import app.enumeration.TaskNames;
import app.logic.dto.LabelDTO;

public class TrelloTask extends Task {

	@Override
	public Object doTask(TaskNames task, Object param) {
		Object object = null;
		boolean hasSucceeded = false;
		if(task == TaskNames.ADDING_LABEL) {
			if(param instanceof LabelDTO)
				hasSucceeded = addLabel((LabelDTO)param);
		}
		return object;
	}
	
	private boolean addLabel(LabelDTO labelDTO) {
		
		return false;
	}

}
