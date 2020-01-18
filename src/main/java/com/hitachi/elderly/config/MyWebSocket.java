package com.hitachi.elderly.config;

/**
 * @Description:WebSocket
 * @ Author     ：RMH.
 * @ Date       ：Created in 下午 4:39 2019/1/4 0004
 * @ Modified By：
 */
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;

public class MyWebSocket extends WebSocketServer {
    public MyWebSocket(int port) {
        super(new InetSocketAddress(port));
    }

    public MyWebSocket(InetSocketAddress address) {
        super(address);
    }

    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {

    }


    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        //断开连接时候触发代码
        userLeave(conn);
        System.out.println(reason);
    }

    @Override
    public void onMessage(WebSocket conn, String userName) {
//        System.out.println(message);
        if(null != userName &&userName.startsWith("socket")){ //只有用socket开头的才创建长链接
            userJoin(conn,userName);//用户加入
        }
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        //错误时候触发的代码
        System.out.println("on error");
        ex.printStackTrace();
    }
    /**
     * 去除掉失效的websocket链接
     * @param conn
     */
    private void userLeave(WebSocket conn){
        MyWebSocketPool.removeUser(conn);
    }
    /**
     * 将websocket加入用户池
     * @param conn
     * @param userName
     */
    private void userJoin(WebSocket conn,String userName){
        MyWebSocketPool.addUser(userName, conn);
    }

}