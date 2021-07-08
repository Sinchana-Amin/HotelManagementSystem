/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class PickupService extends JFrame implements ActionListener{
        JButton b1,b2;
        Choice c1;
        JTable t1;
    PickupService(){
               
        JLabel l1 = new JLabel("PickUp Service");
        l1.setFont(new Font("Tahoma",Font.PLAIN,18));
        l1.setBounds(300,30,200,30);
        add(l1);
        
        JLabel l2 = new JLabel("Car Brand");
        l2.setBounds(50,100,100,20);
        add(l2);
       
        c1=new Choice();
        try{
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from driver");
            while(rs.next()){
                c1.add(rs.getString("brand"));
            }
            c1.setBounds(150,100,200,25);
            add(c1);
        }
        catch(Exception e){System.out.println(e);};
               
        t1=new JTable();
        t1.setBounds(0,200,980,300);
        add(t1);
        
        b1=new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(300,520,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBounds(500,520,120,30);
        add(b2);
        
        JLabel l3 = new JLabel("Name");
        l3.setBounds(50,160,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Age");
        l4.setBounds(200,160,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Gender");
        l5.setBounds(330,160,100,20);
        add(l5);
        
        JLabel l6= new JLabel("Company");
        l6.setBounds(460,160,100,20);
        add(l6);
        
        JLabel l7 = new JLabel("Brand");
        l7.setBounds(590,160,100,20);
        add(l7);
        
        JLabel l8 = new JLabel("Available");
        l8.setBounds(730,160,100,20);
        add(l8);
        
        JLabel l9 = new JLabel("Location");
        l9.setBounds(870,160,100,20);
        add(l9);
        
        getContentPane().setVisible(true);
        setLayout(null);
        setBounds(300,150,980,650);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                String str="select * from driver where brand='"+c1.getSelectedItem()+"'";
                conn c=new conn();
                ResultSet rs;
                rs=c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                
            }
            catch(Exception e){System.out.println(e);};
        }
        else if(ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[]args){
        new PickupService().setVisible(true);
    }
}

