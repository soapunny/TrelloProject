package app;

import app.enumeration.TaskNames;
import app.ui.LoginFrame;

public class StartApp {

	public static void main(String[] args) {
		new LoginFrame(TaskNames.LOGIN_APP);
	}
}
