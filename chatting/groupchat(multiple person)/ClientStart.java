package twinky;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ClientStart extends JFrame  {
	private JPanel contentPane;
    private JTextField name;
    private JTextField port;
    static String cName;
    static int cpNo;
    static String ip;
    private JTextField i;
   
    public ClientStart(){
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,313,393);
        contentPane=new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel=new JPanel();
       
    panel.setBorder(new LineBorder(new Color(0,0,0),2,true));
    panel.setBackground(new Color(46,139,87));
    panel.setBounds(0, 0, 297, 55);
    contentPane.add(panel);
    panel.setLayout(null);
    
     JLabel logo =new JLabel("");
    logo.setBounds(10,11,52,33);
    ImageIcon r= new ImageIcon("C:\\Users\\joy\\Desktop\\mirzapur.png");
    Image rImage=r.getImage();
    Image ringScale= rImage.getScaledInstance(logo.getWidth(),logo.getHeight(),Image.SCALE_SMOOTH);
    ImageIcon rscaledIcon=new ImageIcon(ringScale);
    logo.setIcon(rscaledIcon);
    panel.add(logo);
    
     JLabel lblWhatsapp=new JLabel("CHATROOM");
    lblWhatsapp.setFont(new Font("Helvetica",Font.BOLD,25));
    lblWhatsapp.setForeground(new Color(0,0,0));
    lblWhatsapp.setHorizontalAlignment(SwingConstants.CENTER);
    lblWhatsapp.setBounds(43, 11, 200,33 );
    panel.add(lblWhatsapp);
    
     JPanel panel_1=new JPanel();
    panel_1.setBorder(new LineBorder(new Color(0,0,0),2,true));
    panel_1.setBackground(new Color(60,179,110));
    panel_1.setBounds(0, 56, 297, 298);
    contentPane.add(panel_1);
    panel_1.setLayout(null);
    
    JLabel lblChatAs=new JLabel("Chat As:-");
    lblChatAs.setFont(new Font("Helvetica",Font.BOLD,12));
 
    lblChatAs.setHorizontalAlignment(SwingConstants.CENTER);
    lblChatAs.setBounds(21,42,84,23);
    panel_1.add(lblChatAs);
    
    name= new JTextField();
    name.setBounds(125, 45, 160, 23);
    panel_1.add(name);
    name.setColumns(10);
        
    JLabel v1=new JLabel("*");
    v1.setForeground(new Color (255, 9,0));
    v1.setHorizontalAlignment(SwingConstants.CENTER);
    v1.setBounds(115,71,160,17);
    panel_1.add(v1);
   
    JButton btnNewButton =new JButton("START");
    btnNewButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

          String n=name.getText();
        int p=6666;
        String ipadress="localhost";
        
        if (n.isEmpty()){
            v1.setText("this field is required");
            
        }
        
       
        
        if (ipadress.isEmpty()){
            v1.setText("this field is required");
            
        }
        else{
            int po=p;
            cName=n;
            cpNo=po;
            ip=ipadress;
          Client c=new Client(cName);
            dispose();
           c.setVisible(true);
    
    }
        }
    });
     btnNewButton.setBackground(new Color(46,139,87));
    btnNewButton.setFont(new Font("Helvetica",Font.BOLD,18));
    btnNewButton.setBounds(21, 200, 254, 32);
    panel_1.add(btnNewButton);

}
	

}
