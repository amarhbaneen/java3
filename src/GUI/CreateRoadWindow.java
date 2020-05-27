package utilities;

import javafx.geometry.HorizontalDirection;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public class CreateRoadWindow {
    public JSlider getJunctionSlider() {
        return junctionSlider;
    }

    public void setJunctionSlider(JSlider junctionSlider) {
        this.junctionSlider = junctionSlider;
    }

    public JSlider getVehiclesSlider() {
        return vehiclesSlider;
    }

    public void setVehiclesSlider(JSlider vehiclesSlider) {
        this.vehiclesSlider = vehiclesSlider;
    }

    private static  final String nameslider1 = "Number Of Junctions";
    private static  final String nameslider2 = "Number Of Vehicels";
    private JSlider junctionSlider ;
    private JSlider vehiclesSlider;
   // private BorderLayout MyBorderLayout;
    private  JPanel myPanel;
    private  JPanel buttonPanel;
    private  JFrame myframe;
    public CreateRoadWindow()
    {

        myPanel = new JPanel();
        buttonPanel= new JPanel();
        myPanel.setLayout(new GridLayout(5,1));
        buttonPanel.setLayout(new GridLayout(1,2));
        JButton okButton= new JButton("Ok");
        JButton cancelButton = new JButton("Cancel");
        JLabel label1 = new JLabel(nameslider1,JLabel.CENTER);
        JLabel label2 = new JLabel(nameslider2,JLabel.CENTER);
        junctionSlider = createSlider(20,3,1);
        vehiclesSlider = createSlider(50,0,5);
        myPanel.add(label1);
        myPanel.add(junctionSlider);
        myPanel.add(label2);
        myPanel.add(vehiclesSlider);
        buttonPanel.add(okButton).setBackground(Color.lightGray);
        buttonPanel.add(cancelButton).setBackground(Color.lightGray);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });








    }
    private void initHashtable(Hashtable poistion , int min , int max , int jump)

    {


        for(Integer i=min;i <=max;i=i+jump)
        {

           poistion.put(i, new JLabel(i.toString()));



        }


    }
    private JSlider createSlider(int max,int min,int jump)
    {
         JSlider slider = new JSlider(min,max,12);

        Hashtable poistion = new Hashtable();

        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);

        initHashtable(poistion,min,max,jump);
        slider.setLabelTable(poistion);
        slider.setPaintLabels(true);
        return slider;


    }
    public  void createDialog()
    {
        myframe = new JFrame("Road System");
        myframe.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        CreateRoadWindow road = new CreateRoadWindow();

        myframe.add(road.myPanel);

        myframe.add(road.buttonPanel,BorderLayout.SOUTH);

        myframe.setSize(600,300);
        myframe.setVisible(true);


    }
   /* private void close()
    {
        myframe.dispose();
    }*/

    public static void main(String[] args) {
        CreateRoadWindow road = new CreateRoadWindow();
        road.createDialog();
    }

}
