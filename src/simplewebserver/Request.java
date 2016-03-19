package simplewebserver;

import java.io.InputStream;
import java.io.IOException;

public class Request {

  private InputStream input;
  private String uri;

  public Request(InputStream input) {
	  System.out.println("request����ʼ������uri");
    this.input = input;
  }
  public String getUri() {
	    return uri;
  }
  public void parse() throws IOException {

    byte[] buffer = new byte[2048];
    //��ȡ����������ת��Ϊ�ַ���
    input.read(buffer);
    String rq = new String(buffer);
    
    System.out.println("������:"+input);    
    System.out.println("��ַ����:"+rq);
    uri = parseUri(rq);
    System.out.println("��ȡ��uri="+uri);
  }

  public String parseUri(String requestString) {
    int index1, index2;
    index1 = requestString.indexOf(' ');
    if (index1 != -1) {
      index2 = requestString.indexOf(' ', index1 + 1);
      if (index2 > index1)
        return requestString.substring(index1 + 1, index2);
    }
    return null;
  }
}