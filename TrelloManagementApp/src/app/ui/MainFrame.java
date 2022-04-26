package app.ui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import app.enumeration.TaskNames;
import app.ui.util.UIUtil;

public class MainFrame extends CommonFrame {
	private static final long serialVersionUID = 8924308466844158184L;
	
	private JLabel settingBtn;
	private JButton loginBtn;
	private JButton startBtn;
	
	private ImageIcon settingIcon;
	
	private CommonFrame commonFrame;

	public MainFrame() {
		start();
	}

	@Override
	protected void initPrivateSetting() {
		settingIcon = new ImageIcon("image/setting.png");
		Image settingImg = settingIcon.getImage();
		settingImg = settingImg.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		settingBtn = new JLabel(new ImageIcon(settingImg));
		settingBtn.setBounds(UISetting.WIDTH-50, 0, 40, 40);
		
		loginBtn = UIUtil.getCustomBtn("Login", UISetting.MAINFRAME_LOGIN_BTN_X, UISetting.MAINFRAME_LOGIN_BTN_Y, UISetting.MAINFRAME_LOGIN_BTN_WIDTH, UISetting.MAINFRAME_LOGIN_BTN_HEIGHT);
		startBtn = UIUtil.getCustomBtn("Start", UISetting.START_BTN_X, UISetting.START_BTN_Y, UISetting.START_BTN_WIDTH, UISetting.START_BTN_HEIGHT);
		
		rootPanel.add(settingBtn);
		rootPanel.add(loginBtn);
		rootPanel.add(startBtn);
	}


	@Override
	protected void initPrivateEvents() {

		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		

		startBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startBot();
			}
		});

		settingBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				openSetting();
			}
		});
	}


	protected void openSetting() {
		if(commonFrame == null || !commonFrame.isShowing())
			commonFrame = new SettingFrame();
	}

	protected void startBot() {
		
	}

	@Override
	protected void returnResources() {
		
	}

	@Override
	public void login() {
		if(commonFrame == null || !commonFrame.isShowing())
			commonFrame = new LoginFrame(TaskNames.LOGIN_EMAIL);
	}
	
	
}
