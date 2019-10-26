package mygui;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;


@SuppressWarnings("serial")
public class Slideshow extends JFrame {
	
	
	 public static void addComponentsToPane(Container pane) {
		 pane.setLayout(new GridBagLayout());
		 GridBagConstraints c = new GridBagConstraints();
		 c.fill = GridBagConstraints.HORIZONTAL;
		 
		 JTextField blankarea = new JTextField();
		 c.fill = GridBagConstraints.HORIZONTAL;
		 c.weightx = 1.5;
		 c.weighty = 3;
		 c.gridx = 1;
		 c.gridy = 0;
		 pane.add(blankarea, c);
		 
		 //First button
		 JButton jb1 = new JButton("Animals");   
		 c.fill = GridBagConstraints.HORIZONTAL;
		 c.weightx = 0.5;
		 c.gridx = 1;
		 c.gridy = 4;
		 pane.add(jb1, c);
		 
		 JButton jb2 = new JButton("Flowers");
		 c.fill = GridBagConstraints.HORIZONTAL;
		 c.weightx = 0.5;
		 c.gridx = 2;
		 c.gridy = 4;
		 pane.add(jb2, c);
		 
		 JButton jb3 = new JButton("Food"); 
		 c.fill = GridBagConstraints.HORIZONTAL;
		 c.weightx = 0.5;
		 c.gridx = 3;
		 c.gridy = 4;
		 pane.add(jb3, c);
	 }
	 private static void createAndShowGUI() {
	        //Create and set up the window.
	        JFrame frame = new JFrame("GridBagLayoutDemo");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	        //Set up the content pane.
	        addComponentsToPane(frame.getContentPane());
	 
	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	    }
	 
	 public static void main(String[] args) {
	        //Schedule a job for the event-dispatching thread:
	        //creating and showing this application's GUI.
	        javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                createAndShowGUI();
	            }
	        });
	    }


}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
