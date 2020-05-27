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
        for(int i=0;i<numOfJunctions;i++)
        {

            for(int j=0;j<driving.getMap().getJunctions().get(i).getEnteringRoads().size();j++)
            {
                double x1 = driving.getMap().getJunctions().get(i).getEnteringRoads().get(j).getStartJunction().getX();
                double y1 = driving.getMap().getJunctions().get(i).getEnteringRoads().get(j).getStartJunction().getY();
                double x2 = driving.getMap().getJunctions().get(i).getEnteringRoads().get(j).getEndJunction().getX();
                double y2 = driving.getMap().getJunctions().get(i).getEnteringRoads().get(j).getEndJunction().getY();
                g.drawLine((int)x1,(int)y1,(int)x2,(int)y2);

            }

        }




    }
}
