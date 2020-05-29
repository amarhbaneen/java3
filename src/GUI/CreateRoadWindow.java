package GUI;

import components.Driving;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;

public class CreateRoadWindow extends  JFrame implements ActionListener{

    public JPanel getNewpanel() {
        return newpanel;
    }

    private JPanel newpanel = new JPanel();
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
    private  HomePage homePage;
    private static  final String nameslider1 = "Number Of Junctions";
    private static  final String nameslider2 = "Number Of Vehicels";
    private JSlider junctionSlider ;
    private JSlider vehiclesSlider;

    public JButton getCancelButton() {
        return cancelButton;
    }


    private JButton cancelButton = new JButton("Cancel");


    public JButton getOkButton() {
        return okButton;
    }

    private JButton okButton= new JButton("Ok");
    public ArrayList<Integer> getValue() {
        return value;
    }

    private ArrayList<Integer> value ;
   // private BorderLayout MyBorderLayout;
    private  JPanel myPanel;
    private  JPanel buttonPanel;
    private  JFrame myframe;
    public CreateRoadWindow(HomePage homePage)
    {
        this.homePage = homePage;
        myPanel = new JPanel();
        buttonPanel= new JPanel();
        myPanel.setLayout(new GridLayout(5,1));
        buttonPanel.setLayout(new GridLayout(1,2));


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
        okButton.addActionListener(this);



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
    public  void createDialog(HomePage homePage, HomePage.OnOkClick listener)
    {
        myframe = new JFrame("Road System");
        myframe.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
       // CreateRoadWindow road = new CreateRoadWindow(homePage);

        myframe.add(myPanel);

        myframe.add(buttonPanel,BorderLayout.SOUTH);
       getCancelButton().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent actionEvent) {
               myframe.dispose();
           }

       });

      getOkButton().addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent actionEvent) {
               listener.save(junctionSlider.getValue(),vehiclesSlider.getValue());

//               newpanel.setLayout(new OverlayLayout(newpanel));
//               Driving newdriving = new Driving(junctionSlider.getValue(),vehiclesSlider.getValue());
//               DrawingJunctions newdraw = new DrawingJunctions(newdriving, newdriving.getMap().getJunctions().size(), newdriving.getVehicles().size());
//               DrawingRoads newdraw1 = new DrawingRoads(newdriving, newdriving.getMap().getJunctions().size(), newdriving.getVehicles().size());
//              newpanel.add(newdraw);
//              newpanel.add(newdraw1);

               myframe.dispose();

           }
       });

        myframe.setSize(600,300);
        myframe.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (actionEvent.getActionCommand().equals("Ok")){
            //okButton.setText("yes");
            homePage.setFlag(true);
            myframe.dispose();







        }
    }
}
