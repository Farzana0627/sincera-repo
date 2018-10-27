package database;


import java.sql.*;
import java.util.ArrayList;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


public class Send {

	
	static ArrayList<String> row = new ArrayList<>();
  //private final static String QUEUE_NAME = "hello1";

	private final static String Q_NAME = "hello1";
  private static void jdbcConnector()
	{
	  
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			java.sql.Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sportsTracker","root","iit123");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from user");  
			while(rs.next()) {
				row.add(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
				//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			}
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
			} 
	

  public static void main(String[] argv) throws Exception {
	  
	  jdbcConnector();
    ConnectionFactory factory = new ConnectionFactory();
    //factory.setHost("10.100.104.17");
    factory.setHost("localhost");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    channel.queueDeclare(Q_NAME, false, false, false, null);
   /*ArrayList<String> m = new ArrayList<>();
    m.add("hi");
    m.add(",hlw");*/
	//channel.basicPublish("", Q_NAME, null, m.get(i).getBytes("UTF-8"));

    //String message = "Hello World!";
    //channel.basicPublish("", Q_NAME, null, message.getBytes("UTF-8"));
    //System.out.println(" [x] Sent '" + message + "'");
    for(int i = 0; i<row.size() ; i++)
    {
    	System.out.println(" [x] Sent '" + row.get(i) + "'");
    	channel.basicPublish("", Q_NAME, null, row.get(i).getBytes("UTF-8"));
    }
    

    /*for (int i = 0; i < m.size(); i++) {
    	System.out.println(" [x] Sent '" + m.get(i) + "'");
	}*/
    /
    channel.close();
    connection.close();
  }
}
