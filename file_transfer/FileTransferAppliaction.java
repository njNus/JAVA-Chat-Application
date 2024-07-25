import java.net.ServerSocket;
public class FileTransferAppliaction {
	private static final int PORT = 9001;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
	        System.out.println("The chat server is running. Password for connecting is 1234");
	        ServerSocket listener = new ServerSocket(PORT);
	        try {
	            while (true) {
	                new Handler(listener.accept()).start();
	            }
	        } finally {
	            listener.close();
	        }

	}

}
