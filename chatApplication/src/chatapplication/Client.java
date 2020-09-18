package chatapplication;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
public class Client extends JFrame implements ActionListener{
    JPanel p1;
    JTextField t1;
    JButton b1;
    static JTextArea a1;
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
    Client(){
        p1 =new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(7,94,84));
        p1.setBounds(0,0,450,55);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("chatapplication/icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel J1 = new JLabel(i3);
        J1.setBounds(1, 15, 30, 30);
        p1.add(J1);
        
        J1.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent ae){
                System.exit(0);
            }
        });
        
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("chatapplication/icons/2.png"));
        Image i5 = i4.getImage().getScaledInstance(45, 45, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel J2 = new JLabel(i6);
        J2.setBounds(32, 8 , 45, 45);
        p1.add(J2);
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("chatapplication/icons/video.png"));
        Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel J5 = new JLabel(i9);
        J5.setBounds(320, 10 , 30, 30);
        p1.add(J5);
        
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("chatapplication/icons/phone.png"));
        Image i11 = i10.getImage().getScaledInstance(35, 35, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel J6 = new JLabel(i12);
        J6.setBounds(373, 10 , 35, 35);
        p1.add(J6);
        
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("chatapplication/icons/3icon.png"));
        Image i14 = i13.getImage().getScaledInstance(13, 25, Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel J7 = new JLabel(i15);
        J7.setBounds(415, 15 , 15, 30);
        p1.add(J7);
        
        
       
        
        
     
        
        
        JLabel J3 = new JLabel("PRACHI");
        J3.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        J3.setForeground(Color.WHITE);
        J3.setBounds(80,12,100,15);
        p1.add(J3);
        
        
        JLabel J4 = new JLabel("Active Now");
        J4.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
        J4.setForeground(Color.WHITE);
        J4.setBounds(80,30,95,18);
        p1.add(J4);
        
        a1 = new JTextArea();
        a1.setBounds(1,47,525,395);
        a1.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        a1.setEditable(false);
        a1.setLineWrap(true);
        a1.setWrapStyleWord(true);
        add(a1);
        
        t1 = new JTextField();
        t1.setBounds(5,440,365,40);
        t1.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        add(t1);
        b1 = new JButton("Send");
        b1.setBounds(375,440,70,40);
        b1.setBackground(new Color(7,94,84));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("SAN_SERIF",Font.PLAIN,15));
        b1.addActionListener(this);
        add(b1);
        
        
        
        
        
        
        
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        setSize(450,500);
        setLocation(800,200);
        setUndecorated(true);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        try{
            String out = t1.getText();
            a1.setText(a1.getText()+"\n\t\t\t"+out);
            dout.writeUTF(out);
            t1.setText("");
        }catch(Exception e){
            
        }
        
    }
    public static void main(String [] args){
        new Client().setVisible(true);
        try{
            s = new Socket("127.0.0.1",6001);
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            String msginput = "";
            msginput = din.readUTF();
            a1.setText(a1.getText()+"\n"+msginput);
        }catch(Exception e){
            
        }
    }
    
}
