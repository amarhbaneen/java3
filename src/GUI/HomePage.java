package utilities;

import GUI.DrawingJunctions;
import GUI.DrawingRoads;
import GUI.Shape;
import components.Driving;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HomePage {
    private ArrayList<String> menu;

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
    public HomePage(){
         myBorderLayout = new BorderLayout();

         myPanel = new JPanel();
        initButton();
        myPanel.setLayout(new GridLayout(1,buttonslist.size()));




        menu=new ArrayList<>();
        menu.add("File");
        menu.add("Background");
        menu.add("Vehciles color");
        menu.add("Help");
        menuBar=new JMenuBar();
        for (String s:menu){
            JMenu item=new JMenu(s);
            menuBar.add(item);
        }
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public static void main(String[] args) {
        Driving newdriving = new Driving(10,10);
        DrawingJunctions newdraw = new DrawingJunctions(newdriving , 10,10);
        DrawingRoads newdraw1 = new DrawingRoads(newdriving , 10,10);
        JFrame myframe = new JFrame("Road System");
        myframe.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        HomePage homePage=new HomePage();
        myframe.setLayout(homePage.getMyBorderLayout());
        myframe.add(homePage.getMyPanel(),BorderLayout.SOUTH);
        myframe.setJMenuBar(homePage.getMenuBar());

        myframe.add(newdraw);
        myframe.add(newdraw1);
        myframe.setSize(800,600);

        myframe.setVisible(true);
    }
    private void initButton()
    {
        buttonslist = new ArrayList<JButton>();
        buttonslist.add(new JButton("Create road system"));
        buttonslist.add(new JButton("Start"));
        buttonslist.add(new JButton("Stop"));
        buttonslist.add(new JButton("Resume"));
        buttonslist.add(new JButton("info"));
        for (int i=0;i<buttonslist.size();i++)
        {

            myPanel.add(buttonslist.get(i));
            buttonslist.get(i).setBackground(Color.lightGray);

        }

    }

}

