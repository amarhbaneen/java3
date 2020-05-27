package GUI;

import components.Driving;

import java.awt.*;

public class DrawingRoads  extends  Shape{
    private Driving driving;

    private  int numOfJunctions;
    private  int numOfVehicles;
    public  DrawingRoads(Driving driving, int numOfJunctions , int numOfVehicles)
    {
        super(numOfJunctions);
        this.numOfJunctions = numOfJunctions;
        this.numOfVehicles = numOfVehicles;
        this.driving = driving;
    }

    @Override
    public void paint(Graphics g) {
       /* for(int i=0;i<numOfJunctions;i++)
        {
            double x= driving.getMap().getJunctions().get(i).getX();
            double y= driving.getMap().getJunctions().get(i).getY();
            g.drawLine((int)x,(int)y,10,10);

        }

        */
       g.drawLine(10,5,3,2);

    }
}
