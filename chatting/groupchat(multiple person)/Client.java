package twinky;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Client extends JFrame {
	private JPanel contentPane;
    private static JTextArea textArea;
    private JTextField message;
    static ServerSocket server;
    static Socket client;
    static BufferedReader br;
    static PrintWriter out;
    String cName;
   
     public Client(String cName){
         this.cName = cName;
          setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100,100,322,522);
        contentPane=new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel=new JPanel();
       
    panel.setBorder(new LineBorder(new Color(0,0,0),2,true));
    panel.setBackground(new Color(46,139,87));
    panel.setBounds(0, 0, 316, 55);
    contentPane.add(panel);
    panel.setLayout(null);
    
    JLabel back=new JLabel("");
    back.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent e){
          try{
           int yesOrNo=JOptionPane.showConfirmDialog(null,"Do you want to close connection with server...?");
            if(yesOrNo==0){
                dispose();
                client.close();
                JOptionPane.showMessageDialog(null, "Connection closed!");
                
               
               
            }      
          }catch(Exception e1){
              
          }  
        }
    });
    
    back.setBounds(0, 11, 33, 33);
    ImageIcon i= new ImageIcon("C:\\Users\\joy\\Desktop\\3 (1).png");
    Image Image=i.getImage();
    Image imgScale= Image.getScaledInstance(back.getWidth(),back.getHeight(),Image.SCALE_SMOOTH);
    ImageIcon scaledIcon=new ImageIcon(imgScale);
    back.setIcon(scaledIcon);
    panel.add(back);
    
    JLabel profile=new JLabel("");
    profile.setBounds(32, 9, 39, 40);
    ImageIcon i1= new ImageIcon("C:\\Users\\joy\\Desktop\\mirzapur.png");
    Image Image1=i1.getImage();
    Image imgScale1= Image1.getScaledInstance(profile.getWidth(),profile.getHeight(),Image.SCALE_SMOOTH);
    ImageIcon scaledIcon1=new ImageIcon(imgScale1);
    profile.setIcon(scaledIcon1);
    panel.add(profile);
    
    JLabel lblMurad=new JLabel(cName.toUpperCase());
    lblMurad.setForeground(Color.WHITE);
    lblMurad.setFont(new Font("Helvetica",Font.BOLD,15));
    lblMurad.setBounds(71, 11, 140, 24);
    panel.add(lblMurad);
    
    JLabel phone=new JLabel("");
    phone.setBounds(208, 11, 33, 33);
    /*ImageIcon i2= new ImageIcon("C:\\Users\\joy\\Desktop\\phone (1).png");
    Image Image2=i2.getImage();
    Image imgScale2= Image2.getScaledInstance(phone.getWidth(),phone.getHeight(),Image.SCALE_SMOOTH);
    ImageIcon scaledIcon2=new ImageIcon(imgScale2);
    phone.setIcon(scaledIcon2);*/
    panel.add(phone);
    
    JLabel video=new JLabel("");
    video.setBounds(251,11, 33, 33);
    /*ImageIcon i3= new ImageIcon("C:\\Users\\joy\\Desktop\\video (1).png");
    Image Image3=i3.getImage();
    Image imgScale3= Image3.getScaledInstance(video.getWidth(),video.getHeight(),Image.SCALE_SMOOTH);
    ImageIcon scaledIcon3=new ImageIcon(imgScale3);
    video.setIcon(scaledIcon3);*/
    panel.add(video);
    
     JLabel option=new JLabel("");
    option.setBounds(291, 15, 15, 29);
   /* ImageIcon i4= new ImageIcon("C:\\Users\\joy\\Desktop\\3icon (1).png");
    Image Image4=i4.getImage();
    Image imgScale4= Image4.getScaledInstance(option.getWidth(),option.getHeight(),Image.SCALE_SMOOTH);
    ImageIcon scaledIcon4=new ImageIcon(imgScale4);
    option.setIcon(scaledIcon4);*/
    panel.add(option);
    
            
    JPanel panel_1=new JPanel();
    panel_1.setBounds(0, 440, 316, 40);
    contentPane.add(panel_1);
    panel_1.setLayout(null);
    
    JLabel emoji=new JLabel("");
    emoji.setBounds(0,0,39,40);
    /*ImageIcon i5= new ImageIcon("C:\\Users\\joy\\Desktop\\emoji.png");
    Image Image5=i5.getImage();
    Image imgScale5= Image5.getScaledInstance(emoji.getWidth(),emoji.getHeight(),Image.SCALE_SMOOTH);
    ImageIcon scaledIcon5=new ImageIcon(imgScale5);
    emoji.setIcon(scaledIcon5);*/
    panel_1.add(emoji);
    
    message=new JTextField();
    message.setBounds(40,0,189,40);
    panel_1.add(message);
    message.setColumns(10);
    
    JLabel send=new JLabel("");
    send.addMouseListener(new MouseAdapter(){
        public void mousePressed(MouseEvent e){
          startWriting();
        }
    });
    
    send.setBounds(261,0,45,40);
    ImageIcon i6= new ImageIcon("C:\\Users\\joy\\Downloads\\send-icon.png");
    Image Image6=i6.getImage();
    Image imgScale6= Image6.getScaledInstance(send.getWidth(),send.getHeight(),Image.SCALE_SMOOTH);
    ImageIcon scaledIcon6=new ImageIcon(imgScale6);
    send.setIcon(scaledIcon6);
    panel_1.add(send);
    
    JLabel documents=new JLabel("");
   /* documents.setBounds(229,0,32,40);
    ImageIcon i7= new ImageIcon("C:\\Users\\joy\\Desktop\\document.png");
    Image Image7=i7.getImage();
    Image imgScale7= Image7.getScaledInstance(documents.getWidth(),documents.getHeight(),Image.SCALE_SMOOTH);
    ImageIcon scaledIcon7=new ImageIcon(imgScale7);
    documents.setIcon(scaledIcon7);*/
    panel_1.add(documents);
    
    JScrollPane scrollPane=new JScrollPane();
    scrollPane.setBounds(0,55,308,386);
    contentPane.add(scrollPane);
    
    textArea=new JTextArea();
    textArea.setEditable(false);
    textArea.setFont(new Font("Helvetica",Font.BOLD,15));
    scrollPane.setViewportView(textArea);
    
    startClient();
    startReading();
     }
     
    public static void startClient()
    {
        try{
            client=new Socket(ClientStart.ip,ClientStart.cpNo);
            br=new BufferedReader(new InputStreamReader(client.getInputStream()));
            out=new PrintWriter(client.getOutputStream());

        }catch(Exception e){
            
        }
    }
    public void startReading(){
        Runnable r1=()->{
            try{
                while(true){
                    String msg=br.readLine();
                    if(!msg.isEmpty()){
                        if(textArea.getText().isEmpty())
                        {
                            Calendar cal=Calendar.getInstance();
                            SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
                            textArea.setText(msg+"\n"+sdf.format(cal.getTime()));
                            msg=cName+": ";
                            
                        }else{
                            Calendar cal=Calendar.getInstance();
                            SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
                            textArea.setText(textArea.getText()+"\n"+msg+"\n"+sdf.format(cal.getTime()));
                            msg=cName+": ";
                        }
                    }
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Connection closed!");
            }
        };
        new Thread(r1).start();
    }
    public void startWriting(){
        try{
            String msg=cName+": "+message.getText();
            if(!msg.isEmpty()){
               if(textArea.getText().isEmpty()){
                   Calendar cal=Calendar.getInstance();
                            SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
                            textArea.setText("\t\t"+msg+"\n\t\t\t"+sdf.format(cal.getTime()));
                            message.setText("");
                            out.println(msg);
                            out.flush();
               }
               else{
                  Calendar cal=Calendar.getInstance();
                            SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
                            textArea.setText(textArea.getText()+"\n\t\t"+msg+"\n\t\t\t"+sdf.format(cal.getTime()));
                            message.setText("");
                            out.println(msg);
                            out.flush(); 
               }
            }
        }catch(Exception e){
            
        }
    }
    

}
