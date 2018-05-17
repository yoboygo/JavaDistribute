package tk.codecube.nio.tcp;

import java.util.concurrent.Executors;

import org.apache.mina.transport.socket.SocketConnector;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

/**
 * @page 11 
 * @author songjianlong
 *
 */
public class MinaClient {

	//创建一个线程池大小为CPU核数+1的SocketConnector对象
	SocketConnector ioConnector =  new NioSocketConnector(Runtime.getRuntime().availableProcessors() + 1);
}
