package twinky;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class Server extends JFrame {
	private ServerSocket serverSocket;
	private JPanel contentPane;
	 private JTextField port;
	 static int pNo;
	 static Socket socket;
	
	public Server() {
		try {
			this.serverSocket = new ServerSocket(6666);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setResizable(false);
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     setBounds(100,100,313,400);
	     contentPane =new JPanel();
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
	     lblWhatsapp.setBounds(43, 11, 215,33 );
	     panel.add(lblWhatsapp);
	     
	      JPanel panel_1=new JPanel();
	     panel_1.setBorder(new LineBorder(new Color(0,0,0),2,true));
	     panel_1.setBackground(new Color(60,179,113));
	     panel_1.setBounds(0, 56, 297, 298);
	     contentPane.add(panel_1);
	     panel_1.setLayout(null);
	     
	    
	     
	     JButton btnNewButton =new JButton("START");
	     btnNewButton.setBackground(new Color(46,139,87));
	     btnNewButton.setFont(new Font("Helvetica",Font.BOLD,18));
	     btnNewButton.setBounds(21, 151, 254, 32);
	     panel_1.add(btnNewButton);
	}
	public void startServer() {
		try {
			while(!serverSocket.isClosed()) {
				Socket socket = serverSocket.accept();
				ClientHandler c = new ClientHandler(socket);
				Thread t = new Thread(c);
				t.start();
			}
		}catch(IOException e) {
			
		}
	}
	public void closeServerSocket() {
		try {
			if(serverSocket != null) {
				serverSocket.close();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}


