package twinky;

import java.awt.EventQueue;

public class Starter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 EventQueue.invokeLater(new Runnable(){
	            @Override
	            public void run() {
	               try{
	                   ClientStart frame=new ClientStart();
	                   frame.setVisible(true);
	                   
	               }catch(Exception e){
	                   e.printStackTrace();
	               } 
	            }
	            
	        });

	}

}
