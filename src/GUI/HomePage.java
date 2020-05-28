package GUI;

import GUI.DrawingJunctions;
import GUI.DrawingRoads;
import GUI.Shape;
import components.Driving;
import GUI.CreateRoadWindow;

import javax.script.ScriptEngine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HomePage {
    public JFrame getMyframe() {
        return myframe;
    }

    private  JFrame myframe = new JFrame("Road System");
    private ArrayList<String> menu;
    private CreateRoadWindow createRoadWindow;

    public JPanel getDrawpanel() {
        return drawpanel;
    }

    private JPanel drawpanel = new JPanel();

    public int getJsliderNum() {

        return jsliderNum;
    }

    public int getVsliderNum() {

        return vsliderNum;
    }

    private int jsliderNum;
    private int vsliderNum;


    public ArrayList<String> getMenu() {
        return menu;
    }

    public BorderLayout getMyBorderLayout() {
        return myBorderLayout;
    }

    private JMenuBar menuBar;

    public void setMenu(ArrayList<String> menu) {
        this.menu = menu;
    }

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public void setMyPanel(JPanel myPanel) {
        this.myPanel = myPanel;
    }

    public ArrayList<JButton> getButtonslist() {
        return buttonslist;
    }

    public void setButtonslist(ArrayList<JButton> buttonslist) {
        this.buttonslist = buttonslist;
    }

    public void setMyBorderLayout(BorderLayout myBorderLayout) {
        this.myBorderLayout = myBorderLayout;
    }

    private JPanel myPanel;
    private ArrayList<JButton> buttonslist;

    public JPanel getMyPanel() {
        return myPanel;
    }

    private BorderLayout myBorderLayout;

    public HomePage() {
        myBorderLayout = new BorderLayout();

        myPanel = new JPanel();
        initButton();
        myPanel.setLayout(new GridLayout(1, buttonslist.size()));

        designButtons();



        /*
        ArrayList<Integer> sliderValue = createRoadWindow.getValue();
        jsliderNum =  sliderValue.get(0);
        vsliderNum = sliderValue.get(1);

         */

    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public void designButtons() {
        menu = new ArrayList<>();
        menu.add("File");
        menu.add("Background");
        menu.add("Vehciles color");
        menu.add("Help");
        menuBar = new JMenuBar();
        for (String s : menu) {
            JMenu item = new JMenu(s);
            menuBar.add(item);
        }
        JButton exitButton = new JButton("exit");
        JButton blueBackground = new JButton("BLUE");
        JButton noneBackgroud = new JButton("None");
        menuBar.getMenu(1).add(blueBackground);
        menuBar.getMenu(1).add(noneBackgroud);
        menuBar.getMenu(0).add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        blueBackground.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                drawpanel.setBackground(Color.BLUE);
                myPanel.setBackground(Color.BLUE);


            }
        });
        noneBackgroud.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }

    public static void main(String[] args) {


        HomePage homePage = new HomePage();
        CreateRoadWindow road = new CreateRoadWindow(homePage);

        homePage.getMyframe().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        homePage.buttonslist.get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                road.createDialog(homePage);


            }
        });
        homePage.getMyframe().add(road.getNewpanel(),BorderLayout.CENTER);
       // homePage.getMyframe().add(homePage.drawpanel, BorderLayout.CENTER);
       // homePage.getMyframe().setLayout(homePage.getMyBorderLayout());
        homePage.getMyframe().add(homePage.getMyPanel(), BorderLayout.SOUTH);

        homePage.getDrawpanel().setLayout(new OverlayLayout(homePage.drawpanel));



        homePage.getMyframe().setJMenuBar(homePage.getMenuBar());

        homePage.getMyframe().setSize(800, 600);

        homePage.getMyframe().setVisible(true);
    }

    private void initButton() {
        buttonslist = new ArrayList<JButton>();
        buttonslist.add(new JButton("Create road system"));
        buttonslist.add(new JButton("Start"));
        buttonslist.add(new JButton("Stop"));
        buttonslist.add(new JButton("Resume"));
        buttonslist.add(new JButton("info"));
        for (int i = 0; i < buttonslist.size(); i++) {

            myPanel.add(buttonslist.get(i));
            buttonslist.get(i).setBackground(Color.lightGray);

        }

    }



}

