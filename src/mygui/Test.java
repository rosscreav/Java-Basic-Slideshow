package mygui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder; 

public class Test {
	//Frame and all its panels
	private static JFrame f; 
	private static JPanel container;
	private static JPanel Comboarea;
	private static JPanel Picturearea;
	private static JPanel ColorButtons;
    //Image Arrays
    static Icon[] Animals = new Icon[3];
    static Icon[] Flowers = new Icon[3];
    static Icon[] Foods = new Icon[3];
    static JComboBox<String> combo;
    //3 cards to hold the images
    static JLabel pic1;
    static JLabel pic2;
    static JLabel pic3;

	
	public static void main(String args[]) {
		loadimages();
		create();
	}
	
	public static void create() {
		f=new JFrame("Slideshow"); 
		//Declaring area
		container=new JPanel();
		container.setLayout(new BorderLayout());
		Comboarea=new JPanel(new BorderLayout());
		Picturearea=new JPanel(new CardLayout());
		ColorButtons=new JPanel(new FlowLayout());
		
		//Color Buttons
		//Button Action Listener
		class ColorActionListener implements ActionListener {
	            public void actionPerformed(ActionEvent e) {
	                String cmd = e.getActionCommand();
	                if (cmd.equals("RED")) {
	                    changebackground(255,0,0);
	                } else if (cmd.equals("GREEN")) {
	                	changebackground(0,255,0);
	                } else if (cmd.equals("BLUE")) {
	                	changebackground(0,0,255);
	                }
	            }
	        }
		ColorActionListener colorlistener = new ColorActionListener();
		//Declaring the actual buttons
		JButton button_1 = new JButton("Red");
		button_1.setActionCommand("RED");
		button_1.addActionListener(colorlistener);
		JButton button_2 = new JButton("Green");
		button_2.setActionCommand("GREEN");
		button_2.addActionListener(colorlistener);
		JButton button_3 = new JButton("Blue");
		button_3.setActionCommand("BLUE");
		button_3.addActionListener(colorlistener);
		ColorButtons.add(button_1);
		ColorButtons.add(button_2);
		ColorButtons.add(button_3);
		container.add(ColorButtons,BorderLayout.PAGE_END);
		
		
		//Combo Box
		String Choice[]={"Animals","Flowers","Foods"};        
	    combo=new JComboBox<String>(Choice);
	    Comboarea.add(combo,BorderLayout.CENTER);
	    container.add(Comboarea,BorderLayout.PAGE_START);
	    combo.addActionListener (new ActionListener () {
	        public void actionPerformed(ActionEvent e) {
	            ChangeSlides();
	        }
	    });

	    //Picture area
        class PictureActionListener implements MouseListener {
        	//cycles image on click
        	public void mouseClicked(MouseEvent event) {                   
		        Object source = event.getSource();
		        if(source instanceof JLabel){ nextImage();}}
        	//Unused methods
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			}
        //Intializes Images
        pic1 = new JLabel();
	    pic2 = new JLabel();
	    pic3 = new JLabel();
	    pic1.setIcon(Animals[0]);
	    pic2.setIcon(Animals[1]);
	    pic3.setIcon(Animals[2]);
        PictureActionListener cardlis = new PictureActionListener();
        pic1.addMouseListener(cardlis);
        pic2.addMouseListener(cardlis);
        pic3.addMouseListener(cardlis);
        Picturearea.add(pic1,"card1");
        Picturearea.add(pic2,"card2");
        Picturearea.add(pic3,"card3");
        //Creates a background around the image
        Picturearea.setBorder( new EmptyBorder( 10, 10, 10, 10) );
        Picturearea.setBackground(new Color(0,0,0));
        container.add(Picturearea,BorderLayout.CENTER);
        
        //Finalizes and starts the program
        f.add(container);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1080, 720);
        f.setVisible(true);
	}
	//Changes the border color of the image
	public static void changebackground(int r,int g,int b) {
		Color color=new Color(r,g,b);
		Picturearea.setBackground(color);
	}
	//Loads images into icon arrays
	public static void loadimages() {
		//Loads the image files into the icon arrays
		try {
			//Animals
			Animals[0]=new ImageIcon(ImageIO.read(new File("Pictures/Animals 1.jpg")));
			Animals[1]=new ImageIcon(ImageIO.read(new File("Pictures/Animals 2.jpg")));
			Animals[2]=new ImageIcon(ImageIO.read(new File("Pictures/Animals 3.jpg")));
			//Flowers
			Flowers[0]=new ImageIcon(ImageIO.read(new File("Pictures/Flowers 1.jpg")));
			Flowers[1]=new ImageIcon(ImageIO.read(new File("Pictures/Flowers 2.jpg")));
			Flowers[2]=new ImageIcon(ImageIO.read(new File("Pictures/Flowers 3.jpg")));
			//Foods
			Foods[0]=new ImageIcon(ImageIO.read(new File("Pictures/Foods 1.jpg")));
			Foods[1]=new ImageIcon(ImageIO.read(new File("Pictures/Foods 2.jpg")));
			Foods[2]=new ImageIcon(ImageIO.read(new File("Pictures/Foods 3.jpg")));
		} catch (IOException e) {e.printStackTrace();}
	}
	
	//Goes to next image
	public static void nextImage() {
		CardLayout cl = (CardLayout) (Picturearea.getLayout());
		cl.next(Picturearea);
	}
	//Sets the current set of images
	public static void ChangeSlides() {
		//Sets the current set of images and shows the first
		String cs = (String) combo.getSelectedItem();
		CardLayout cl = (CardLayout) (Picturearea.getLayout());
		if(cs.equals("Animals")) {
			pic1.setIcon(Animals[0]);
			pic2.setIcon(Animals[1]);
			pic3.setIcon(Animals[2]);
			cl.show(Picturearea,"card1");
		}
		else if(cs.equals("Flowers")) {
			pic1.setIcon(Flowers[0]);
			pic2.setIcon(Flowers[1]);
			pic3.setIcon(Flowers[2]);
			cl.show(Picturearea,"card1");
		}
		else if(cs.equals("Foods")) {
			pic1.setIcon(Foods[0]);
			pic2.setIcon(Foods[1]);
			pic3.setIcon(Foods[2]);
			cl.show(Picturearea,"card1");
		}
		
	}
}
