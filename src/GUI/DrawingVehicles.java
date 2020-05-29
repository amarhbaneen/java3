package GUI;

import components.Driving;
import components.Junction;
import components.Vehicle;

import java.awt.*;
import java.util.Random;

public class DrawingVehicles extends Shape {
    private Driving driving;

    private  int numOfJunctions;
    private  int numOfVehicles;
    public DrawingVehicles (Driving driving,int numOfJunctions , int numOfVehicles)

    {
        super(numOfVehicles);
        this.numOfJunctions = numOfJunctions;
        this.numOfVehicles = numOfVehicles;
        this.driving = driving;


    }

    @Override
    public void paint(Graphics g) {
        for(Vehicle vehicle:driving.getVehicles()){
            Junction startJun=(Junction) vehicle.getCurrentRoute().getRouteParts().get(1);
            Random random=new Random();
           int x=random.nextInt(800);
           int y=random.nextInt(800);
                drawRotetedVehicle(g, (int) startJun.getX(), (int) startJun.getY(),0,0,10,4);
        }

    }
    private void drawRotetedVehicle(Graphics g, int x1, int y1, int x2, int y2, int d, int h) {
        int dx = x2 - x1, dy = y2 - y1, delta = 10;
        double D = Math.sqrt(dx * dx + dy * dy);
        double xm = delta, xn = xm, ym = h, yn = -h, x;
        double xm1 = delta + d, xn1 = xm1, ym1 = h, yn1 = -h, xx;
        double sin = dy / D, cos = dx / D;
        x = xm * cos - ym * sin + x1;
        xx = xm1 * cos - ym1 * sin + x1;
        ym = xm * sin + ym * cos + y1;
        ym1 = xm1 * sin + ym1 * cos + y1;
        xm = x;
        xm1 = xx;
        x = xn * cos - yn * sin + x1;
        xx = xn1 * cos - yn1 * sin + x1;
        yn = xn * sin + yn * cos + y1;
        yn1 = xn1 * sin + yn1 * cos + y1;
        xn = x;
        xn1 = xx;
        int[] xpoints = {(int) xm1, (int) xn1, (int) xn, (int) xm};
        int[] ypoints = {(int) ym1, (int) yn1, (int) yn, (int) ym};
        g.fillPolygon(xpoints, ypoints, 4);
        g.setColor(Color.BLACK);
        g.fillOval((int) xm1 - 2, (int) ym1 - 2, 4, 4);
        g.fillOval((int) xn1 - 2, (int) yn1 - 2, 4, 4);
        g.fillOval((int) xm - 2, (int) ym - 2, 4, 4);
        g.fillOval((int) xn - 2, (int) yn - 2, 4, 4);
    }

}
