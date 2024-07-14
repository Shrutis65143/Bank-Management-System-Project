

import  javax.swing.*;
import  java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login,clear,signup;
    JTextField cardText;
    JPasswordField  pinno;

    Login(){

        setTitle("AUTOMATED TELLER MACHINE");

        //make the system layout default to null to move image or text anywhere
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Screenshot 2023-09-07 141242.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        //to write something on the frame
        JLabel text = new JLabel("welcome to atm");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,450,40);
        add(text);

        JLabel cardno = new JLabel("Card no:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,150,30);
        add(cardno);

        //to make the box infront of cardno
        cardText = new JTextField();
        cardText.setFont(new Font("Arial",Font.BOLD,14));
        cardText.setBounds(300,150,250,30);
        add(cardText);

        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,50,30);
        add(pin);

        pinno = new JPasswordField();
        pinno.setFont(new Font("Arial",Font.BOLD,14));
        pinno.setBounds(300,220,250,30);
        add(pinno);

        //to add buttons
        login = new JButton("SIGN IN");
        login.setBounds(300,270,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(450,270,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300,320,250,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        //to set the background color of the frame
        getContentPane().setBackground(Color.white);

        setSize(800, 400);
        setVisible(true);
        setLocation(350,200);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==clear)
        {
            cardText.setText("");
            pinno.setText("");
        } else if(ae.getSource()==login) {
           Conn conn = new Conn();
           String cardnumber = cardText.getText();
           String pinnumber = pinno.getText();
           String query = "select * from login where cardnumber = '"+cardnumber+"' and pinnumber = '"+pinnumber+"'";
           try{
               ResultSet rs = conn.s.executeQuery(query);
               if(rs.next()) {
                   setVisible(false);
                   new Transactions(pinnumber).setVisible(true);
               } else {
                   JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
               }
           } catch (Exception e) {
               System.out.println(e);
           }
           }else if (ae.getSource()==signup) {
                setVisible(false);
                new SignupOne().setVisible(true);
        }
    }

    public static void main(String args[]){

        new Login();
    }
}
