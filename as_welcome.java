
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JPanel;  
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder; 


public class as_welcome {  
	
	private String username;
	private String cipher;
  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
    	as_welcome s=new as_welcome();  
        s.ini();  
    }  
    public void ini(){ 
    	
        JFrame jf=new JFrame();  
        jf.setTitle("AS服务开启"); 
        JPanel jp=new JPanel();  
        JTextField textIP=new JTextField();  
        JTextField textPort=new JTextField();  
        
        JButton btn=new JButton("注册");  
        JLabel ipJLA=new JLabel("ID");  
        JLabel portJLA=new JLabel("密码");  
          
        btn.setPreferredSize(new Dimension(50,30));  
          
        jf.setSize(new Dimension(450,250));  
          
        BorderLayout bla=new BorderLayout();  
        jf.setLayout(bla);  
        jp.setBackground(Color.white);  
        jp.setLayout(null);  
          
        jp.add(ipJLA);  
        jp.add(portJLA);  
        jp.add(textIP);  
        jp.add(textPort);  
        jp.add(btn);  
          
        ipJLA.setBounds(50, 30, 50, 30);  
        portJLA.setBounds(30, 65, 50, 30);  
        textIP.setBounds(65,30 , 300, 30); //
        textPort.setBounds(65,65 , 300, 30); // 
        btn.setBounds(175,100,80,30);  
          
        jf.add(jp);  
        jf.setVisible(true);  
        
        btn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				username = textIP.getText();
				cipher= textPort.getText();
				Runnable Linksql = new Linksql();
				Thread thread1 = new Thread(Linksql);
				thread1.start();
			}
        	
        });
    }
    
    private class Linksql implements Runnable {

		@Override
		public void run() {
				
			String driver = "com.mysql.jdbc.Driver";
			//URL指向要访问的数据库名word
			String url = "jdbc:mysql://127.0.0.1:3306/word?";
			String user = "root";
			String password = "love523023";  
			Connection conn = null;
			int h;
			try{
				Class.forName(driver);
				conn = DriverManager.getConnection(url,user,password);
				if(!conn.isClosed())
					 h=0;
				     Statement statement = conn.createStatement();
				     String sql =  "insert into persons(username,cipher) values('"+username+"','"+cipher+"')";
				     int rs = statement.executeUpdate(sql);      
			}catch(ClassNotFoundException e){
				
				e.printStackTrace();  
			}catch(SQLException e){
				e.printStackTrace();  
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			// TODO Auto-generated method stub
			
		}
    	
    }
    
}  