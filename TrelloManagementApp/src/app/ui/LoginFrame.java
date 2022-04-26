package app.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import app.enumeration.TaskNames;
import app.ui.util.UIUtil;

public class LoginFrame extends CommonFrame {
	private static final long serialVersionUID = 6806675332063399939L;
	
	private JLabel emailL;
	private JLabel pwdL;
	private JLabel rememberMeL;
	private JTextField emailF;
	private JCheckBox rememberMeC;
	private JPasswordField pwdF;
	private JButton loginBtn;
	
	private TaskNames currentTask;

	public LoginFrame(TaskNames taskName) {
		start();
		currentTask = taskName;
		initLoginInformation();
	}
	
	private void initLoginInformation() {
		titleL.setText(currentTask.getName());
		
		//TODO get account information from DB
		switch(currentTask){
		case LOGIN_APP:
			break;
		case LOGIN_EMAIL:
			break;
		case LOGIN_TRELLO:
			break;
		case LOGIN_APPFOLIO:
			break;	
		}
	}

	@Override
	protected void initPrivateSetting() {
		
		emailL = new JLabel("Email");
		emailL.setBounds(UISetting.EMAIL_LABEL_X, UISetting.EMAIL_LABEL_Y, UISetting.EMAIL_LABEL_WIDTH, UISetting.EMAIL_LABEL_HEIGHT);
		emailL.setFont(UISetting.COMMON_LABEL_FONT);
		emailF = new JTextField();
		emailF.setToolTipText("Type your email");
		emailF.setBorder(null);
		emailF.setBounds(UISetting.EMAIL_FIELD_X, UISetting.EMAIL_FIELD_Y, UISetting.EMAIL_FIELD_WIDTH,	UISetting.EMAIL_FIELD_HEIGHT);
		emailF.setFont(UISetting.COMMON_TEXTFIELD_FONT);
		
		pwdL = new JLabel("Password");
		pwdL.setBounds(UISetting.PWD_LABEL_X, UISetting.PWD_LABEL_Y, UISetting.PWD_LABEL_WIDTH, UISetting.PWD_LABEL_HEIGHT);
		pwdL.setFont(UISetting.COMMON_LABEL_FONT);
		pwdF = new JPasswordField();
		pwdF.setToolTipText("Type your password");
		pwdF.setBorder(null);
		pwdF.setBounds(UISetting.PWD_FIELD_X, UISetting.PWD_FIELD_Y, UISetting.PWD_FIELD_WIDTH, UISetting.PWD_FIELD_HEIGHT);
		pwdF.setFont(UISetting.COMMON_TEXTFIELD_FONT);

		rememberMeC = new JCheckBox();
		rememberMeC.setBackground(UISetting.PANEL_COLOR);
		rememberMeC.setBounds(UISetting.RM_CHECKBOX_X, UISetting.RM_CHECKBOX_Y, UISetting.RM_CHECKBOX_WIDTH, UISetting.RM_CHECKBOX_HEIGHT);
		rememberMeL = new JLabel("Remember Me");
		rememberMeL.setFont(UISetting.ANNOTATION_LABEL_FONT);
		rememberMeL.setBounds(UISetting.RM_LABEL_X, UISetting.RM_LABEL_Y, UISetting.RM_LABEL_WIDTH, UISetting.RM_LABEL_HEIGHT);
		
		loginBtn = UIUtil.getCustomBtn("Login", UISetting.LOGIN_BTN_X, UISetting.LOGIN_BTN_Y, UISetting.LOGIN_BTN_WIDTH, UISetting.LOGIN_BTN_HEIGHT);
		
		rootPanel.add(emailL);
		rootPanel.add(emailF);
		rootPanel.add(pwdL);
		rootPanel.add(pwdF);
		rootPanel.add(rememberMeC);
		rootPanel.add(rememberMeL);
		rootPanel.add(loginBtn);
	}

	@Override
	protected void initPrivateEvents() {
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
	}

	@Override
	protected void returnResources() {
		
	}

	@Override
	public void login() {
		//TODO login validation check
		if(currentTask == TaskNames.LOGIN_APP) {
			new MainFrame();
			this.exit();
		}
		else if(currentTask == TaskNames.LOGIN_EMAIL) {
			this.exit();
		}
		else if(currentTask == TaskNames.LOGIN_TRELLO) {
			this.exit();
		}
		else if(currentTask == TaskNames.LOGIN_APPFOLIO) {
			this.exit();
		}
	}
}
