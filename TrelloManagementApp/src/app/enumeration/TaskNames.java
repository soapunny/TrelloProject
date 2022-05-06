package app.enumeration;

public enum TaskNames {
	LOGIN_APP("Trello Management App"),
	LOGIN_EMAIL("Gmail"),
	LOGIN_TRELLO("Trello"),
	LOGIN_APPFOLIO("Appfolio"),
	ACTIVITY("Activity"),
	REFINING_DATA("Refining data"),
	ADDING_LABEL("Label Edit"),
	REFRESH_LABEL("Refresh the labeling table"),
	ADDING_CARD("Add card"), 
	DELETE_LABEL("Delete labels from labeling table");
	
	private final String name;
	
	private TaskNames(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
