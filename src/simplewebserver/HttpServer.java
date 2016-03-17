package simplewebserver;


import java.net.Socket;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class HttpServer {
  //WEB_ROOT 是一个主目录
  //public static final String WEB_ROOT = "d:";
  // 设置关闭服务器命令
  private static final String SHUTDOWN_COMMAND = "/EXIT";
  private boolean shutdown = false;

  public static void main(String[] args) {
    HttpServer server = new HttpServer();
    server.await();
  }

  public void await() {
    ServerSocket serverSocket = null;
    int port = 8089;
    try {
    	//绑定本地电脑作为服务器，端口8089，队列1.
      serverSocket =  new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
    }
    catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }
    // 开启服务器，直到关闭命令出现
    while (!shutdown) {
      Socket socket = null;
      InputStream input = null;
      OutputStream output = null;
      try {
        socket = serverSocket.accept(); //等待socket打开
        input = socket.getInputStream();
        output = socket.getOutputStream();

        System.out.println("开始数据分析");
        Request request = new Request(input);
        request.parse();

        System.out.println("寻找资源链接");
        Response response = new Response(output);
        response.receiveRequest(request);
        response.sendResource();

        // 关闭通道
        socket.close();
        //判断关闭服务器命令是否存在
        shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
      }
      catch (Exception e) {
        e.printStackTrace();
        continue;
      }
    }
  }
}
