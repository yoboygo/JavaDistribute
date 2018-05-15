package tk.codecube.nio.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;


/**
 * TCP NIO
 * @page 5
 * @author songjianlong
 *
 */
public class TCPNioClient extends TCPNioBase{
	
	public static void main(String[] args) throws IOException {
		try(SocketChannel socketChannel = SocketChannel.open();){
			//设置为非阻塞模式
			socketChannel.configureBlocking(false);
			InetSocketAddress socketAddress = InetSocketAddress.createUnresolved(SERVER_IP, SERVER_PORT);
			socketChannel.connect(socketAddress);
			Selector selector = Selector.open();
			//向channle注册selector以及感兴趣的连接事件
			socketChannel.register(selector, SelectionKey.OP_CONNECT);
			//阻塞至有感兴趣的IO事发生，或到达超时时间，如果希望一直等至有感兴趣的IO事件发生
			//可调用无参的select方法，如果希望不阻塞直接返回目前是否有感兴趣的事件发生，可调用
			//selectNow方法
			int nKeys = selector.select();
			SelectionKey skey = null;
			if(){
				
			}
		}
	}

}
