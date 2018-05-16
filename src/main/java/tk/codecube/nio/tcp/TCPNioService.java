package tk.codecube.nio.tcp;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

/**
 * TCP NIO Service
 * @page 7
 * @author songjianlong
 *
 */
public class TCPNioService extends TCPNioBase {

	public static void main(String[] args) throws Exception {
		try(ServerSocketChannel ssc = ServerSocketChannel.open();
				ServerSocket serverSocket = ssc.socket()){
			//绑定要监听的端口
			serverSocket.bind(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			ssc.configureBlocking(false);
			Selector selector = Selector.open();
			//注册感兴趣的连接建立事件
			ssc.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("Server 启动监听...");
			int nKeys = selector.select();
			if(nKeys != 0){
				Set<SelectionKey> keys = selector.selectedKeys();
				for(SelectionKey key : keys){
					if(key.isAcceptable()){
						System.out.println("Server 接受连接...");
						ServerSocketChannel server = (ServerSocketChannel) key.channel();
						try {
							SocketChannel channel = server.accept();
							if(channel == null){
								return;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
			
			
		}
		
	}
}
