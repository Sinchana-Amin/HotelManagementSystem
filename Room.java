/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener{
        JTable t1;
        JButton b1,b2;
        JLabel l1,l2,l3,l4,l5;
    
    Room(){
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/icons/eight.jpg"));
        Image i2= i1.getImage().getScaledInstance(500, 600,Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon=new JLabel(i3);
        icon.setBounds(500,0,500,600);
        add(icon);
        
        t1=new JTable();
        t1.setBounds(0,40,500,400);
        add(t1);
        
        l1=new JLabel("Room Number");
        l1.setBounds(9,10,100,20);
        add(l1);
        
        l2=new JLabel("Available");
        l2.setBounds(120,10,100,20);
        add(l2);
        
        l3=new JLabel("Status");
        l3.setBounds(230,10,100,20);
        add(l3);
        
        l4=new JLabel("Price");
        l4.setBounds(330,10,100,20);
        add(l4);
        
        l5=new JLabel("Bed Type");
        l5.setBounds(420,10,100,20);
        add(l5);
        
        b1=new JButton("Load Data");
        b1.setBounds(100,460,120,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Back");
        b2.setBounds(250,460,120,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(300,140,1000,600);
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==b1){
            try{
                conn c=new conn();
                String str="select * from room";
                ResultSet rs=c.s.executeQuery(str);
                
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()== b2){
           new Reception().setVisible(true);
           this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new Room().setVisible(true);
    }
}
