import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class linksql {
	
	/**
	 * AS�������ݿⲢע���û�
	 * @param username   ���û���
	 * @param cipher     ����
	 */
	public void Linksql(String username,String cipher){
		String driver = "com.mysql.jdbc.Driver";
		//URLָ��Ҫ���ʵ����ݿ���word
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
	
	}
	
	/**
	 * AS��֤����
	 * @param username   �û���
	 * @param cipher     ����
	 * @return 1 Ϊ��֤�ɹ�     0Ϊ��֤ʧ��
	 */
	public static int Authen(String username,String cipher){
		String driver = "com.mysql.jdbc.Driver";
		//URLָ��Ҫ���ʵ����ݿ���word
		String url = "jdbc:mysql://127.0.0.1:3306/word?";
		String user = "root";
		String password = "love523023";  
		Connection conn = null;
		String name = null;
		String mi =null;
		int h;
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
			if(!conn.isClosed())
				 h=0;
			     Statement statement = conn.createStatement();
			     String sql =  "select * from persons where username ='"+username+"'";
			     ResultSet rs = statement.executeQuery(sql);
			     while(rs.next())  {
			    	 name= rs.getString("username");
			    	 System.out.println(name);
			    	 if(name.equals(username)){
			    		mi= rs.getString("cipher");
			    		System.out.println(mi);
			    		if(mi.equals(cipher)){
			    		System.out.println(username + "��֤�ɹ���");
			    		return 1;
			    		}
			    		else{
			    			System.out.println("������󣡣�");
			    			break;
			    		}
			    	 }
			    	 
			     }
			     rs.close();       
			      
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
		return 0;
	
	}
	

	
	
	public static void main(String[] args){
		
		System.out.println("����");
		Scanner c = new Scanner(System.in);
		String n=c.nextLine();
		String m=c.nextLine();
		int num=Authen(n,m);
		System.out.println(num);

	}



}
