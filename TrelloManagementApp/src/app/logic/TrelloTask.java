package app.logic;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import app.db.TrelloDAO;
import app.enumeration.TaskNames;
import app.logic.dto.LabelDTO;

public class TrelloTask extends Task {

	@Override
	public Object doTask(TaskNames task, Object param) {
		Object object = null;
		
		if(task == TaskNames.ADDING_LABEL) {
			if(param instanceof LabelDTO)
				object = addLabel((LabelDTO)param);
		}else if(task == TaskNames.REFRESH_LABEL) {
			if(param instanceof DefaultTableModel) {
				object = refreshLabels((DefaultTableModel)param);
			}
		}else if(task == TaskNames.DELETE_LABEL) {
			if(param instanceof ArrayList) {
				object = deleteLabels((ArrayList<Integer>)param);
			}
		}
		
		return object;
	}
	
	private int deleteLabels(ArrayList<Integer> param) {
		return TrelloDAO.getInstance().deleteLabels(param);
	}

	private boolean refreshLabels(DefaultTableModel param) {
		return TrelloDAO.getInstance().refreshLabels(param);
	}

	private boolean addLabel(LabelDTO labelDTO) {
		return TrelloDAO.getInstance().addLabel(labelDTO.toLabelEntity());
	}

}
