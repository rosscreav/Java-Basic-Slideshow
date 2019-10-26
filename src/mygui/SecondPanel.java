package mygui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SecondPanel extends JPanel {

    private JButton button;
    private JPanel mainPanel;

    public SecondPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
        setPreferredSize(new Dimension(400, 200));
        setBackground(Color.ORANGE);
        add(createButton());
    }   

    private JButton createButton() {
        button = new JButton("Switch to the first Panel");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu_V1 main = new MainMenu_V1();
                main.switchPanel(mainPanel, "FIRST");                
            }
        });
        return button;
    }
}