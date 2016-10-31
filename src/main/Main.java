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
		ProcessOrderView view = new ProcessOrderView(controller);
		controller.setView(view);
		mFrame.getContentPane().add(view);
		mFrame.setVisible(true);
	
	}

}
