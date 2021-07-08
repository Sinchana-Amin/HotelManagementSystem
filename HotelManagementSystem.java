/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener{
    
    HotelManagementSystem(){
        setBounds(100,150,1366,565);//in setBounds both setsize and location value will be given
        /*setSize(100,150);
          setLocation(300,300);*/
           setVisible(true);
           ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/icons/first.jpg"));
           JLabel L1 = new JLabel(I1);
           L1.setBounds(0,0,1366,565);/*1249*614, 1366,565*/
           add(L1);
           
           JLabel L2 = new JLabel("Hotel Management System");
           L2.setBounds(20,430,700,90);/* 340,20*/
           L1.add(L2);
           L2.setForeground(Color.WHITE);
           L2.setFont(new Font("serif",Font.PLAIN,50));
           
           JButton b1 = new JButton("Next");
           b1.setBackground(Color.WHITE);
           b1.setForeground(Color.BLACK);
           b1.setFont(new Font("serif",Font.PLAIN,25));
           b1.setBounds(1070, 450, 150, 50);/*1070,450   150,50*/
            b1.addActionListener(this);
           L1.add(b1);
           
           setLayout(null);
           setVisible(true);
           
          /*  while(true){
               L2.setVisible(false);
               try{
                   Thread.sleep(500);
               }
               catch(Exception e){
                   
               }
               L2.setVisible(true);
               try{
                   Thread.sleep(500);
               }
               catch(Exception e){
           }
        }*/
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        new Login().setVisible(true);
        this.setVisible(false);
    }
    
    public static void main(String[] args) {
        new HotelManagementSystem();
    }
    
}
