package app.logic;

import app.enumeration.TaskNames;

public abstract class Task {

	public abstract Object doTask(TaskNames task, Object param);
}
