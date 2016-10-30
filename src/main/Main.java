package main;

import javax.swing.JFrame;
import javax.swing.JPanel;

import presentation.controller.ProcessOrderViewController;
import presentation.view.ProcessOrderView;

public class Main {
	
	public static void main(String[] args){
		JFrame mFrame = new JFrame();
		mFrame.setSize(800, 600);
		mFrame.setLocation(300, 300);
		ProcessOrderViewController controller = new ProcessOrderViewController();
		JPanel panel = new ProcessOrderView(controller);
		mFrame.getContentPane().add(panel);
		mFrame.setVisible(true);
	}

}
