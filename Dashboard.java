/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Dashboard extends JFrame implements ActionListener{
    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4;
    
    Dashboard(){
        mb = new JMenuBar();
        add(mb);
        
        m1=new JMenu("HOTEL MANAGEMENT");
        m1.setForeground(Color.red);
        mb.add(m1);
        
        m2=new JMenu("ADMIN");
        m2.setForeground(Color.blue);
        mb.add(m2);
        
        i1=new JMenuItem("RECEPTION");
        i1.addActionListener(this);
        m1.add(i1);
        
        i2=new JMenuItem("ADD EMPLOYEES");
        i2.addActionListener(this);
        m2.add(i2);
        
        i3=new JMenuItem("ADD ROOMS");
        i3.addActionListener(this);
        m2.add(i3);
        
        i4=new JMenuItem("ADD DRIVERS");
        i4.addActionListener(this);
        m2.add(i4);
        
        mb.setBounds(-5,-5,1600,30);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/icons/third.jpg"));
        Image i2= i1.getImage().getScaledInstance(1950,850,Image.SCALE_DEFAULT );/*1950,850*/
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i1);
        l1.setBounds(-5,-5,1600,850);/*1600,850*/
        add(l1);
        
        JLabel l2 = new JLabel("THE TAJ GROUP WELCOMES YOU");
        l2.setBounds(480,60,600,50);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Tahoma",Font.PLAIN,40));
        l1.add(l2);
        
        
        setLayout(null);
        setBounds(-5,-5,1600,1020);/*1600,1020*/
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("RECEPTION")){
            new Reception().setVisible(true);
        }
        else if(ae.getActionCommand().equals("ADD EMPLOYEES")){
            new AddEmployee().setVisible(true);
        }
        else if(ae.getActionCommand().equals("ADD ROOMS")){
            new AddRooms().setVisible(true);
        }
        else if(ae.getActionCommand().equals("ADD DRIVERS")){
            new AddDriver().setVisible(true);
        }
    }
    public static void main(String[] args){
        new Dashboard().setVisible(true);
    }
    
}
