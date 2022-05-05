package app.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import app.enumeration.TaskNames;
import app.logic.Automation;
import app.logic.dto.LoginDTO;
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
		displayApp();
	}
	
	private void initLoginInformation() {
		titleL.setText(currentTask.getName());
		Automation automation = Automation.getInstance();
		
		//TODO get account information from DB
		LoginDTO loginDTO = null;
		switch(currentTask){
		case LOGIN_APP: loginDTO = automation.checkIsRemembered(TaskNames.LOGIN_APP);
			break;
		case LOGIN_EMAIL: //loginDTO = automation.checkIsRemembered(TaskNames.LOGIN_EMAIL);
			break;
		case LOGIN_TRELLO: //loginDTO = automation.checkIsRemembered(TaskNames.LOGIN_TRELLO);
			break;
		case LOGIN_APPFOLIO: //loginDTO = automation.checkIsRemembered(TaskNames.LOGIN_APPFOLIO);
			break;	
		}
		
		if(loginDTO != null) {
			emailF.setText(loginDTO.getEmail());
			pwdF.setText(loginDTO.getPassword());
			rememberMeC.setSelected(loginDTO.getRemembered());
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
			loginApp();
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

	private void loginApp() {
		//validation check first
		String email = emailF.getText();
		String pwd = new String(pwdF.getPassword());
		boolean isRemembered = rememberMeC.isSelected();
		LocalDateTime nyNow = LocalDateTime.now(ZoneId.of("US/Eastern"));
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy/HH:mm:ss");
		String loginTime = nyNow.format(dateTimeFormatter);
		LoginDTO loginDTO = new LoginDTO(email, pwd, isRemembered, loginTime);
		boolean hasLoginSucceeded = Automation.getInstance().login(TaskNames.LOGIN_APP, loginDTO);
		if(hasLoginSucceeded) {
			new MainFrame();
			this.exit();
		}else
			System.out.println("Login Fail");
	}
}
