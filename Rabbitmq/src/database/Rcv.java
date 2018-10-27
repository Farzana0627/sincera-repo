package database;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.ArrayList;

public class Rcv {

  //private final static String QUEUE_NAME = "hello";
	private final static String Q_NAME = "hello1";
	
  public static void main(String[] argv) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    channel.queueDeclare(Q_NAME, false, false, false, null);
    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

    Consumer consumer = new DefaultConsumer(channel) {
      @Override
      public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
          throws IOException {
    		//System.out.println(" [x] Received '" +new String(body,"UTF-8") + "'");
    	  //ArrayList<String> m = new ArrayList<>();
    	 /* for (int i = 0; i < m.size(); i++) {
			m.add(new String(body,"UTF-8"));
		
		}*/
       String message = new String(body, "UTF-8");
       System.out.println(" [x] Received '" + message + "'");
      }
    };
    channel.basicConsume(Q_NAME, true, consumer);
    //connection.close();
  }
}