package app.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import app.logic.Automation;
import app.ui.util.UIUtil;

public class SettingFrame extends CommonFrame{
	private static final long serialVersionUID = -4600596406262154034L;
	
	private JScrollPane jScrollPane;
	private JTable labelTable;
	private JPanel btnPanel;
	private JButton addBtn;
	private JButton deleteBtn;
	
	private AddingLabelFrame addingLabelFrame;

	public SettingFrame() {
		start();
		refreshLabels();
		displayApp(); //at last
	}
	
	public void refreshLabels() {
		Automation.getInstance().refreshLabels((DefaultTableModel)labelTable.getModel());
	}

	@Override
	protected void initPrivateSetting() {
		titleL.setText("Label Table");
		
		rootPanel.setLayout(new BorderLayout());
		labelTable = new JTable();
		jScrollPane = new JScrollPane();
		
        labelTable.setModel(
    		new DefaultTableModel(
        		new Object[][] {},
        		new String[] {"Seq", "Address1", "Address2", "Label"}
    		){
	        	Class[] types = new Class[] {
	        			Integer.class, String.class, String.class, String.class
	        	};
	        	boolean[] canEdit = new boolean[] {
	        			false, false, false, false
	        	};
	        	public Class getColumnClass(int columnIndex) {
	        		return types[columnIndex];
	        	}
	        	public boolean isCellEditable(int rowIndex, int columnIndex) {
	        		return canEdit[columnIndex];
	        	}
		});
        jScrollPane.setViewportView(labelTable);
        if(labelTable.getColumnModel().getColumnCount() > 0) {
        	labelTable.getColumnModel().getColumn(0).setMaxWidth(50);
        }
        
        btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnPanel.setSize(UISetting.WIDTH, UISetting.SETTING_BTN_HEIGHT);
        
        JLabel blankL = new JLabel("                                                                                        ");
		deleteBtn = UIUtil.getCustomBtn("Delete", UISetting.SETTING_BTN_X, UISetting.SETTING_BTN_Y, UISetting.SETTING_BTN_WIDTH, UISetting.SETTING_BTN_HEIGHT);
		addBtn = UIUtil.getCustomBtn("Add", UISetting.SETTING_BTN_X, UISetting.SETTING_BTN_Y, UISetting.SETTING_BTN_WIDTH, UISetting.SETTING_BTN_HEIGHT);
		
		btnPanel.add(deleteBtn);
		btnPanel.add(blankL);
		btnPanel.add(addBtn);
        
        rootPanel.add(jScrollPane, BorderLayout.CENTER);
        rootPanel.add(btnPanel, BorderLayout.SOUTH);
	}

	@Override
	protected void initPrivateEvents() {

		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openAddingLabel();
			}
		});
		
		deleteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteLabels();
			}
		});
	}
	
	private void deleteLabels() {
		int[] rowIdxArray = labelTable.getSelectedRows();
		if(rowIdxArray.length < 1) {
			System.out.println("Select rows first!");
			return;
		}
		
		ArrayList<Integer> seqList = new ArrayList<>();
		for(int i =0;i<rowIdxArray.length;i++) {
			seqList.add((Integer)labelTable.getValueAt(rowIdxArray[i], 0));
		}
		int deletedRowsCnt = Automation.getInstance().deleteLabels(seqList);
		if(deletedRowsCnt > 0)
			System.out.println(deletedRowsCnt+" labels are deleted from table successfully");
		else
			System.out.println("Label delete fail");
		refreshLabels();
	}

	protected void openAddingLabel() {
		if(addingLabelFrame == null || !addingLabelFrame.isShowing())
			addingLabelFrame = new AddingLabelFrame(this);
	}

	@Override
	protected void returnResources() {

	}
}
