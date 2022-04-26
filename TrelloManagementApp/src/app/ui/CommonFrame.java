package app.ui;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CommonFrame extends JFrame {
	private static final long serialVersionUID = 3139907812489584135L;

	protected JPanel titlePanel;
	protected JPanel rootPanel;
	protected JPanel bottomPanel;
	
	protected JLabel titleL;
	protected JLabel bottomL;
	
	public CommonFrame(){
		
	}
	
	public void start() {
		initCommonSetting();
		initPrivateSetting();
		initCommonEvents();
		initPrivateEvents();
		this.setVisible(true);
	}
	

	protected void initPrivateSetting() {
		// TODO for private settings.
	}

	protected void initCommonSetting() {
		titlePanel = new JPanel(new BorderLayout());
		titlePanel.setBackground(UISetting.TITLE_PANEL_COLOR);
		
		rootPanel = new JPanel(null);
		rootPanel.setBackground(UISetting.PANEL_COLOR);
		
		bottomPanel = new JPanel(new BorderLayout());
		bottomPanel.setBackground(UISetting.TITLE_PANEL_COLOR);
		
		titleL = new JLabel(UISetting.TITLE);
		titleL.setHorizontalAlignment(JLabel.CENTER);
		titleL.setFont(UISetting.TITLE_LABEL_FONT);
		
		bottomL = new JLabel(UISetting.COPYRIGHT);
		bottomL.setHorizontalAlignment(JLabel.RIGHT);
		bottomL.setFont(UISetting.BOTTOM_LABEL_FONT);

		this.setLayout(new BorderLayout());
		titlePanel.add(titleL, BorderLayout.CENTER);
		bottomPanel.add(bottomL, BorderLayout.EAST);
		this.add(titlePanel, BorderLayout.NORTH);
		this.add(rootPanel, BorderLayout.CENTER);
		this.add(bottomPanel, BorderLayout.SOUTH);
		
		this.setTitle(UISetting.TITLE);
		this.setResizable(false);
		this.setBounds(UISetting.SCREEN_WIDTH/2-UISetting.WIDTH/2, 
				UISetting.SCREEN_HEIGHT/2 - UISetting.HEIGHT/2, 
				UISetting.WIDTH, UISetting.HEIGHT);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

	protected void initPrivateEvents() {
		// TODO for private event
	}
	
	protected void initCommonEvents() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				exit();
			}
		});
	}
	
	protected void exit() {
		returnResources();
		this.dispose();
	}
	
	protected void returnResources() {
		// TODO return resources.
	}

	public void login() {
		
	}
}
