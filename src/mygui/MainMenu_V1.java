package mygui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainMenu_V1 extends JFrame {

    private JMenuBar menuBar;
    private JMenu file;
    private JMenuItem exit;
    private JPanel mainPanel;

    public MainMenu_V1() {
        setTitle("Main Panel");
        setResizable(false);
        setSize(new Dimension(400, 200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(createMainMenu());
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setLayout(new CardLayout());
        mainPanel.add(new FirstPanel(mainPanel), "FIRST");
        mainPanel.add(new SecondPanel(mainPanel), "SECOND");

        setContentPane(mainPanel);
    }

    public JMenuBar createMainMenu() {
        menuBar = new JMenuBar();
        file = new JMenu("File");
        exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        file.add(exit);
        menuBar.add(file);

        return menuBar;
    }

    public void switchPanel(Container container, String panelName) {
        CardLayout card = (CardLayout) (container.getLayout());
        card.show(container, panelName);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainMenu_V1().setVisible(true);
            }
        });
    }
}
