
package com.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
public class MyWindow extends JFrame {
    
    private JLabel heading;
    private JLabel clockLabel;
    private Font font = new Font("",Font.BOLD,35);
    
    
    MyWindow()
    {
        super.setTitle("MyClock");
        super.setSize(400,400);
        super.setLocation(300,100);
        this.createGUI();
        super.setVisible(true);
       
    }
   public void createGUI()
   {
       //method for creating the GUI of our clock
       heading = new JLabel("My Clock");
       clockLabel = new JLabel("clock");
       heading.setFont(font);
       clockLabel.setFont(font);
   
   this.setLayout(new GridLayout(2,1));
   
   this.add(heading);
   this.add(clockLabel);
   
}
   public void startClock()
   {

       Thread t = new Thread()
       {
           public void run()
           {
               try 
               {
                   while(true)
                   {
                       Date d = new Date();
                       
                       SimpleDateFormat sdf = new SimpleDateFormat("hh : mm : ss a");
                       
                       String dateTime = sdf.format(d);
                       
                       clockLabel.setText(dateTime);
                       
                       Thread.sleep(1000);
                   }
               }catch(InterruptedException e)
               {
                   e.printStackTrace();
               }
           }
       };
               
       t.start();
}
}