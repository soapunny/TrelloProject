package app.ui.util;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import app.ui.UISetting;

public class UIUtil {

	public static JButton getCustomBtn(String btnName, int posX, int posY, int width, int height){
		JButton btn = new JButton(btnName);
		
		btn.setFont(UISetting.COMMON_BTN_FONT);
		btn.setBorder(new LineBorder(UISetting.TITLE_PANEL_COLOR, 3));
		btn.setForeground(Color.black);
		btn.setBounds(posX, posY, width, height);
		btn.setBackground(UISetting.BTN_COLOR);
		
		return btn;
	}
}
