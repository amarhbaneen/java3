package GUI;

import components.Driving;
import components.Junction;
import components.LightedJunction;
import GUI.CreateRoadWindow;

import java.awt.*;
import java.security.PublicKey;

public class DrawingJunctions extends Shape {
    private Driving driving;

    private  int numOfJunctions;
    private  int numOfVehicles;

    public DrawingJunctions (Driving driving,int numOfJunctions , int numOfVehicles)

    {
        super(numOfJunctions);
        this.numOfJunctions = numOfJunctions;
        this.numOfVehicles = numOfVehicles;
        this.driving = driving;


    }

    @Override
    public void paint(Graphics g) {
        //g.drawOval(202,100,20,20);

        for(int i=0;i<numOfJunctions;i++)
        {

            double x= driving.getMap().getJunctions().get(i).getX();
            double y= driving.getMap().getJunctions().get(i).getY();

            if(!(driving.getMap().getJunctions().get(i) instanceof LightedJunction))
            {
                g.setColor(Color.BLACK);
            }
            else {
                LightedJunction  junc = (LightedJunction) driving.getMap().getJunctions().get(i);
                if(junc.getLights().getTrafficLightsOn())
                {
                    g.setColor(Color.RED);
                }
                else
                {
                    g.setColor(Color.GREEN);
                }
            }



           g.fillOval((int)x,(int)y,10,10);


        }
    }
}
