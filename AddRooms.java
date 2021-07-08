/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener{
    JTextField t1,t2;
    JComboBox c1,c2,c3;
    JButton b1,b2;
    AddRooms(){
        
        JLabel l1=new JLabel("Add Rooms");
        l1.setFont(new Font("Tahoma",Font.BOLD,18));
        l1.setBounds(160,20,110,20);
        add(l1);
        
        JLabel room=new JLabel("Room Number");
         room.setFont(new Font("Tahoma",Font.PLAIN,16));
        room.setBounds(60,80,120,30);
        add(room);
        
        t1=new JTextField();
        t1.setBounds(200,80,150,30);
        add(t1);
        
        JLabel available=new JLabel("Available");
        available.setFont(new Font("Tahoma",Font.PLAIN,16));
        available.setBounds(60,130,120,30);
        add(available);
        
        c1=new JComboBox(new String[] {"Available","Occupied"});
        c1.setBounds(200,130,150,30);
        c1.setBackground(Color.WHITE);
        add(c1);
        
        JLabel status =new JLabel("Cleaning Status");
        status.setFont(new Font("Tahoma",Font.PLAIN,16));
        status.setBounds(60,180,120,30);
        add(status);
        
        c2=new JComboBox(new String[] {"Cleaned","Dirty"});
        c2.setBounds(200,180,150,30);
        c2.setBackground(Color.WHITE);
        add(c2);
        
        JLabel price =new JLabel("Price");
        price.setFont(new Font("Tahoma",Font.PLAIN,16));
        price.setBounds(60,230,120,30);
        add(price);
        
        t2=new JTextField();
        t2.setBounds(200,230,150,30);
        add(t2);
        
        JLabel type =new JLabel("Bed Type");
        type.setFont(new Font("Tahoma",Font.PLAIN,16));
        type.setBounds(60,280,120,30);
        add(type);
        
        c3=new JComboBox(new String[] {"Single Bed","Double Bed"});
        c3.setBounds(200,280,150,30);
        c3.setBackground(Color.WHITE);
        add(c3);
        
        b1=new JButton("Add Room");
        b1.setBounds(60,330,130,30);
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);
        
        b2=new JButton("Cancel");
        b2.setBounds(220,330,130,30);
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/icons/twelve.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l5=new JLabel(i3);
        l5.setBounds(400,30,500,330);
        add(l5);
        
        setBounds(300,200,940,430);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String room=t1.getText();
            String available=(String)c1.getSelectedItem();
            String status = (String)c2.getSelectedItem();
            String price=t2.getText();
            String type=(String)c3.getSelectedItem();
            
            conn c=new conn();
            try{
                String str="insert into room values('"+room+"','"+available+"','"+status+"','"+price+"','"+type+"')";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New Employee Added");
                this.setVisible(false);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==b2){
            this.setVisible(false);
        }
    }
    public static void main(String[]args){
        new AddRooms().setVisible(true);
    }
}
