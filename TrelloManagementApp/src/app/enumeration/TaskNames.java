package app.enumeration;

public enum TaskNames {
	LOGIN_APP("Trello Management App"),
	LOGIN_EMAIL("Gmail"),
	LOGIN_TRELLO("Trello"),
	LOGIN_APPFOLIO("Appfolio"),
	ACTIVITY("Activity"),
	REFINING_DATA("Refining data"),
	ADDING_LABEL("Label Edit"),
	ADDING_CARD("Add card");
	
	private final String name;
	
	private TaskNames(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
