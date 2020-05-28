package GUI;

import components.Driving;

import javax.swing.*;
import java.awt.*;

public class DrawingSystem extends JPanel {
    public JPanel getDrawPanel() {
        return drawPanel;
    }

    public void setDrawPanel(JPanel drawPanel) {
        this.drawPanel = drawPanel;
    }

    private JPanel drawPanel;
    private  int jnum;
    private  int vnum;

    public DrawingSystem(int junc , int veh)
    {
        jnum =junc;
        vnum = veh;

        Driving newdriving = new Driving(jnum,vnum);
        DrawingJunctions newdraw = new DrawingJunctions(newdriving, jnum,vnum);
        DrawingRoads newdraw1 = new DrawingRoads(newdriving,jnum,vnum);
        drawPanel = new JPanel();
        drawPanel.setLayout(new OverlayLayout(drawPanel));
        drawPanel.add(newdraw);
        drawPanel.add(newdraw1);


    }



}
