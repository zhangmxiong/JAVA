package simplewebserver;


import java.net.Socket;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class HttpServer {
  //WEB_ROOT ��һ����Ŀ¼
  //public static final String WEB_ROOT = "d:";
  // ���ùرշ���������
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
    	//�󶨱��ص�����Ϊ���������˿�8089������1.
      serverSocket =  new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
    }
    catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }
    // ������������ֱ���ر��������
    while (!shutdown) {
      Socket socket = null;
      InputStream input = null;
      OutputStream output = null;
      try {
        socket = serverSocket.accept(); //�ȴ�socket��
        input = socket.getInputStream();
        output = socket.getOutputStream();

        System.out.println("��ʼ���ݷ���");
        Request request = new Request(input);
        request.parse();

        System.out.println("Ѱ����Դ����");
        Response response = new Response(output);
        response.receiveRequest(request);
        response.sendResource();

        // �ر�ͨ��
        socket.close();
        //�жϹرշ����������Ƿ����
        shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
      }
      catch (Exception e) {
        e.printStackTrace();
        continue;
      }
    }
  }
}
