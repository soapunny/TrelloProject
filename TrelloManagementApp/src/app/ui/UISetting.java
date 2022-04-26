package app.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class UISetting {
	public static final String TITLE = "Trello Management App";
	public static final String COPYRIGHT = "Copyright©2022. SMARTLAND. All rights reserved.";
	
	//===========================================Size===================================================
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	public static final int LOGINFRAME_HORIZONTAL_BLANK = 50;
	public static final int LOGINFRAME_VERTICAL_BLANK = HEIGHT/8;
	public static final int MAINFRAME_HORIZONTAL_BLANK = 50;
	public static final int MAINFRAME_VERTICAL_BLANK = HEIGHT/9;

	public static final int EMAIL_LABEL_X = LOGINFRAME_HORIZONTAL_BLANK;
	public static final int EMAIL_LABEL_Y = LOGINFRAME_VERTICAL_BLANK;
	public static final int EMAIL_LABEL_WIDTH = WIDTH - LOGINFRAME_HORIZONTAL_BLANK*2;
	public static final int EMAIL_LABEL_HEIGHT = 40;
	
	public static final int EMAIL_FIELD_X = LOGINFRAME_HORIZONTAL_BLANK;
	public static final int EMAIL_FIELD_Y = EMAIL_LABEL_Y+EMAIL_LABEL_HEIGHT;
	public static final int EMAIL_FIELD_WIDTH = WIDTH - LOGINFRAME_HORIZONTAL_BLANK*2;
	public static final int EMAIL_FIELD_HEIGHT = 40;

	public static final int PWD_LABEL_X = LOGINFRAME_HORIZONTAL_BLANK;
	public static final int PWD_LABEL_Y = EMAIL_FIELD_Y + LOGINFRAME_VERTICAL_BLANK;
	public static final int PWD_LABEL_WIDTH = WIDTH - LOGINFRAME_HORIZONTAL_BLANK*2;
	public static final int PWD_LABEL_HEIGHT = 40;
	
	public static final int PWD_FIELD_X = LOGINFRAME_HORIZONTAL_BLANK;
	public static final int PWD_FIELD_Y = PWD_LABEL_Y + PWD_LABEL_HEIGHT;
	public static final int PWD_FIELD_WIDTH = WIDTH - LOGINFRAME_HORIZONTAL_BLANK*2;
	public static final int PWD_FIELD_HEIGHT = 40;

	public static final int RM_CHECKBOX_X = LOGINFRAME_HORIZONTAL_BLANK + 10;
	public static final int RM_CHECKBOX_Y = PWD_FIELD_Y + LOGINFRAME_VERTICAL_BLANK/2 + 10;
	public static final int RM_CHECKBOX_WIDTH = 30;
	public static final int RM_CHECKBOX_HEIGHT = 40;
	
	public static final int RM_LABEL_X = RM_CHECKBOX_X + RM_CHECKBOX_WIDTH;
	public static final int RM_LABEL_Y = RM_CHECKBOX_Y;
	public static final int RM_LABEL_WIDTH = WIDTH - RM_CHECKBOX_X - RM_LABEL_X;
	public static final int RM_LABEL_HEIGHT = 40;
	
	public static final int LOGIN_BTN_X = LOGINFRAME_HORIZONTAL_BLANK;
	public static final int LOGIN_BTN_Y = RM_CHECKBOX_Y + LOGINFRAME_VERTICAL_BLANK;
	public static final int LOGIN_BTN_WIDTH = WIDTH - LOGINFRAME_HORIZONTAL_BLANK*2;
	public static final int LOGIN_BTN_HEIGHT = 60;
	
	public static final int MAINFRAME_LOGIN_BTN_X = MAINFRAME_HORIZONTAL_BLANK;
	public static final int MAINFRAME_LOGIN_BTN_Y = MAINFRAME_VERTICAL_BLANK;
	public static final int MAINFRAME_LOGIN_BTN_WIDTH = WIDTH - MAINFRAME_HORIZONTAL_BLANK*2;
	public static final int MAINFRAME_LOGIN_BTN_HEIGHT = MAINFRAME_VERTICAL_BLANK*2;

	public static final int START_BTN_X = MAINFRAME_HORIZONTAL_BLANK;
	public static final int START_BTN_Y = MAINFRAME_LOGIN_BTN_Y + MAINFRAME_LOGIN_BTN_HEIGHT + MAINFRAME_VERTICAL_BLANK;
	public static final int START_BTN_WIDTH = MAINFRAME_LOGIN_BTN_WIDTH;
	public static final int START_BTN_HEIGHT = MAINFRAME_LOGIN_BTN_HEIGHT;

	public static final int SETTING_BTN_X = 0;
	public static final int SETTING_BTN_Y = 0;
	public static final int SETTING_BTN_WIDTH = 150;
	public static final int SETTING_BTN_HEIGHT = 100;
	
	//3 rows design
	public static final int THREE_ROWS_HORIZONTAL_BLANK = 50;
	public static final int THREE_ROWS_VERTICAL_BLANK = HEIGHT/12;
	
	public static final int THREE_ROWS_LABEL_FIRST_X = THREE_ROWS_HORIZONTAL_BLANK;
	public static final int THREE_ROWS_LABEL_FIRST_Y = THREE_ROWS_VERTICAL_BLANK;
	public static final int THREE_ROWS_LABEL_FIRST_WIDTH = WIDTH - THREE_ROWS_HORIZONTAL_BLANK*2;
	public static final int THREE_ROWS_LABEL_FIRST_HEIGHT = 40;

	public static final int THREE_ROWS_FIELD_FIRST_X = THREE_ROWS_HORIZONTAL_BLANK;
	public static final int THREE_ROWS_FIELD_FIRST_Y = THREE_ROWS_LABEL_FIRST_Y + THREE_ROWS_LABEL_FIRST_HEIGHT;
	public static final int THREE_ROWS_FIELD_FIRST_WIDTH = WIDTH - THREE_ROWS_HORIZONTAL_BLANK*2;
	public static final int THREE_ROWS_FIELD_FIRST_HEIGHT = 40;
	
	public static final int THREE_ROWS_LABEL_SECOND_X = THREE_ROWS_HORIZONTAL_BLANK;
	public static final int THREE_ROWS_LABEL_SECOND_Y = THREE_ROWS_FIELD_FIRST_Y + THREE_ROWS_VERTICAL_BLANK;
	public static final int THREE_ROWS_LABEL_SECOND_WIDTH = WIDTH - THREE_ROWS_HORIZONTAL_BLANK*2;
	public static final int THREE_ROWS_LABEL_SECOND_HEIGHT = 40;

	public static final int THREE_ROWS_FIELD_SECOND_X = THREE_ROWS_HORIZONTAL_BLANK;
	public static final int THREE_ROWS_FIELD_SECOND_Y = THREE_ROWS_LABEL_SECOND_Y + THREE_ROWS_LABEL_SECOND_HEIGHT;
	public static final int THREE_ROWS_FIELD_SECOND_WIDTH = WIDTH - THREE_ROWS_HORIZONTAL_BLANK*2;
	public static final int THREE_ROWS_FIELD_SECOND_HEIGHT = 40;

	public static final int THREE_ROWS_LABEL_THIRD_X = THREE_ROWS_HORIZONTAL_BLANK;
	public static final int THREE_ROWS_LABEL_THIRD_Y = THREE_ROWS_FIELD_SECOND_Y + THREE_ROWS_VERTICAL_BLANK;
	public static final int THREE_ROWS_LABEL_THIRD_WIDTH = WIDTH - THREE_ROWS_HORIZONTAL_BLANK*2;
	public static final int THREE_ROWS_LABEL_THIRD_HEIGHT = 40;

	public static final int THREE_ROWS_FIELD_THIRD_X = THREE_ROWS_HORIZONTAL_BLANK;
	public static final int THREE_ROWS_FIELD_THIRD_Y = THREE_ROWS_LABEL_THIRD_Y + THREE_ROWS_LABEL_THIRD_HEIGHT;
	public static final int THREE_ROWS_FIELD_THIRD_WIDTH = WIDTH - THREE_ROWS_HORIZONTAL_BLANK*2;
	public static final int THREE_ROWS_FIELD_THIRD_HEIGHT = 40;
	
	//===========================================Font===================================================
	public static final Font TITLE_LABEL_FONT = new Font("Century Gothic", Font.BOLD, 40);
	public static final Font ANNOTATION_LABEL_FONT = new Font("Century Gothic", Font.PLAIN, 18);
	public static final Font BOTTOM_LABEL_FONT = new Font("Century Gothic", Font.BOLD, 18);
	public static final Font COMMON_LABEL_FONT = new Font("Century Gothic", Font.PLAIN, 30);
	public static final Font COMMON_TEXTFIELD_FONT = new Font("Century Gothic", Font.PLAIN, 20);
	public static final Font COMMON_BTN_FONT = new Font("Courier New", Font.BOLD, 30);
	
	
	//===========================================Color===================================================
	public static final Color TITLE_PANEL_COLOR = new Color(255, 243, 212);
	public static final Color PANEL_COLOR = new Color(222, 219, 227);
	public static final Color BTN_COLOR = new Color(245, 196, 172);
	public static final Color BTN_LINE_COLOR = new Color(112, 186, 108);
}