package app.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import app.enumeration.TaskNames;
import app.ui.util.UIUtil;

public class AddingLabelFrame extends CommonFrame{
	private static final long serialVersionUID = -6146489958023948516L;
	
	private JLabel address1L;
	private JLabel address2L;
	private JLabel labelL;
	
	private JTextField address1F;
	private JTextField address2F;
	private JTextField labelF;
	
	private JButton addBtn;
	
	public AddingLabelFrame(){
		start();
		titleL.setText(TaskNames.ADDING_LABEL.getName());
	}
	
	@Override
	protected void initPrivateSetting() {
		
		address1L = new JLabel("Address1");
		address1L.setBounds(UISetting.THREE_ROWS_LABEL_FIRST_X, UISetting.THREE_ROWS_LABEL_FIRST_Y, 
				UISetting.THREE_ROWS_LABEL_FIRST_WIDTH, UISetting.THREE_ROWS_LABEL_FIRST_HEIGHT);
		address1L.setFont(UISetting.COMMON_LABEL_FONT);
		address1F = new JTextField();
		address1F.setToolTipText("Type Address1");
		address1F.setBorder(null);
		address1F.setBounds(UISetting.THREE_ROWS_FIELD_FIRST_X, UISetting.THREE_ROWS_FIELD_FIRST_Y, 
				UISetting.THREE_ROWS_FIELD_FIRST_WIDTH,	UISetting.THREE_ROWS_FIELD_FIRST_HEIGHT);
		address1F.setFont(UISetting.COMMON_TEXTFIELD_FONT);
		
		address2L = new JLabel("Address2");
		address2L.setBounds(UISetting.THREE_ROWS_LABEL_SECOND_X, UISetting.THREE_ROWS_LABEL_SECOND_Y, 
				UISetting.THREE_ROWS_LABEL_SECOND_WIDTH, UISetting.THREE_ROWS_LABEL_SECOND_HEIGHT);
		address2L.setFont(UISetting.COMMON_LABEL_FONT);
		address2F = new JTextField();
		address2F.setToolTipText("Type Address2");
		address2F.setBorder(null);
		address2F.setBounds(UISetting.THREE_ROWS_FIELD_SECOND_X, UISetting.THREE_ROWS_FIELD_SECOND_Y, 
				UISetting.THREE_ROWS_FIELD_SECOND_WIDTH, UISetting.THREE_ROWS_FIELD_SECOND_HEIGHT);
		address2F.setFont(UISetting.COMMON_TEXTFIELD_FONT);

		labelL = new JLabel("Label");
		labelL.setBounds(UISetting.THREE_ROWS_LABEL_THIRD_X, UISetting.THREE_ROWS_LABEL_THIRD_Y, 
				UISetting.THREE_ROWS_LABEL_THIRD_WIDTH, UISetting.THREE_ROWS_LABEL_THIRD_HEIGHT);
		labelL.setFont(UISetting.COMMON_LABEL_FONT);
		labelF = new JTextField();
		labelF.setToolTipText("Type Label");
		labelF.setBorder(null);
		labelF.setBounds(UISetting.THREE_ROWS_FIELD_THIRD_X, UISetting.THREE_ROWS_FIELD_THIRD_Y, 
				UISetting.THREE_ROWS_FIELD_THIRD_WIDTH, UISetting.THREE_ROWS_FIELD_THIRD_HEIGHT);
		labelF.setFont(UISetting.COMMON_TEXTFIELD_FONT);
		
		addBtn = UIUtil.getCustomBtn("Add", UISetting.LOGIN_BTN_X, UISetting.LOGIN_BTN_Y, UISetting.LOGIN_BTN_WIDTH, UISetting.LOGIN_BTN_HEIGHT);
		
		rootPanel.add(address1L);
		rootPanel.add(address1F);
		rootPanel.add(address2L);
		rootPanel.add(address2F);
		rootPanel.add(labelL);
		rootPanel.add(labelF);
		rootPanel.add(addBtn);
	}

	@Override
	protected void initPrivateEvents() {
		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addLabel();
			}
		});
	}

	protected void addLabel() {
		//TODO add the label in the db.
		this.exit();
	}

	@Override
	protected void returnResources() {
		
	}
}
