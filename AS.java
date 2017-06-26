import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class AS {
	private BufferedReader reader;
	private ServerSocket server;
	private Socket socket;
	
	
	void getserver(){
		try{
			server = new ServerSocket(8998);
			System.out.println("服务器套接字已经创建成功");
			while(true){
				System.out.println("等待客服机的连接");
				socket = server.accept();
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				getClientMessage();
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	private void getClientMessage() {
		try{
			while(true){
				System.out.println("客服机：" + reader.readLine());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			if(reader != null){
				reader.close();
			}
			if(socket != null){
				socket.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
	}
	
	public static void main(String[] args){
		AS as = new AS();
		as.getserver();
	}

}
