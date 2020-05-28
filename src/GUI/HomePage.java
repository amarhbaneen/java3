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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class HomePage {


    private ArrayList<String> menu;
    private CreateRoadWindow createRoadWindow;

    public JPanel getDrawpanel() {
        return drawpanel;
    }

    private JPanel drawpanel = new JPanel(

    );

    public int getJsliderNum() {

        return jsliderNum;
    }

    public int getVsliderNum() {

        return vsliderNum;
    }

    public void setJsliderNum(int jsliderNum) {
        this.jsliderNum = jsliderNum;
    }

    public void setVsliderNum(int vsliderNum) {
        this.vsliderNum = vsliderNum;
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


        JFrame myframe = new JFrame("Road System");

        HomePage homePage = new HomePage();
        homePage.getDrawpanel().setLayout(new OverlayLayout(homePage.getDrawpanel()));

         DrawingSystem newdraw = new DrawingSystem(4,0);
         myframe.add(newdraw.getDrawPanel());

        CreateRoadWindow road = new CreateRoadWindow(newdraw);
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        homePage.buttonslist.get(0).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                road.createDialog(newdraw);


            }
        });
        newdraw.getDrawPanel().removeAll();


       myframe.add(homePage.getMyPanel(),BorderLayout.SOUTH);
      myframe.add(homePage.getMenuBar(),BorderLayout.NORTH);

        myframe.setSize(800, 600);

        myframe.setVisible(true);
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

