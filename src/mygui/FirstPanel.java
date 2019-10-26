package mygui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class FirstPanel extends JPanel {

    private JButton button;
    private JPanel mainPanel;

    public FirstPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
        setPreferredSize(new Dimension(400, 200));
        setBackground(Color.GRAY);
        add(createButton());        
    }   

    private JButton createButton() {
        button = new JButton("Switch to the second Panel");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu_V1 main = new MainMenu_V1();
                main.switchPanel(mainPanel, "SECOND");                
            }
        });
        return button;
    }
}