package simplewebserver;

import java.io.OutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.File;

public class Response {

  private static final int BUFFER_SIZE = 1024;
  Request request;
  OutputStream output;

  public Response(OutputStream output) {
    this.output = output;
  }

  public void receiveRequest(Request request) {
	System.out.println("��������:"+request);
    this.request = request;
  }

  public void sendResource() throws IOException {
    //��request�н�ȡ����Ϣת��Ϊ�ļ�·��
    String rpath = request.getUri();
    System.out.println("rpath :"+rpath);
    System.out.println("rpath������ :"+rpath.length());
    System.out.println("rpath /��λ�� :"+rpath.indexOf("/"));
    String path = null;
    if(rpath.length()==2){
    	path = rpath.substring(1,2)+":"+"/";
    }else{
    	path = rpath.substring(1,2)+":"+rpath.substring(2, rpath.length());
    }
    System.out.println("path :"+path);

    try {
      //File file = new File(path.replaceAll("/", "\\"));
      File file = new File(path);
      if (file.exists()){
    	  //output.write((file.getPath()+"\r\n").getBytes());// ׷��\r\n�Ǵ�����
    	  //Ŀ¼�ļ���ȡ�ļ��б�
	      if (file.isDirectory()){
    		  /*
	    	  File[] filelist = file.listFiles();
	    	  for(File e:filelist){
	    		  if(e.isDirectory()){
	    			  if(!e.isHidden())
	    			 output.write(("<a href= \"http://localhost" + request.getUri()
	  							 + "\">"
	  							 + "�ļ���"+e.getPath()+"\r\n"
	  							 + "</a>").getBytes());
	    			 // output.write(("�ļ���"+e.getPath()+"\r\n").getBytes());
	    		  }else{
	    			  if(!e.isHidden())
	    			  output.write(("�ļ�"+e.getPath()+"\r\n").getBytes());
	    		  }
	  	  	   }	  
    		   */
	    	  	File[] filelist = file.listFiles();
	    	  	for (File f : filelist){
	    	  	System.out.println(f.getPath());
	    	  	}
				StringBuilder sb = new StringBuilder();
				sb.append("HTTP/1.1 200 OK\r\n");
				sb.append("Connection:keep-alive\r\n");
				sb.append("Server:HttpServer\r\n");
				sb.append("\r\n");
				sb.append("<html>");
				sb.append("<head>");
				sb.append("<title>");
				sb.append(file.getPath());
				sb.append("</title>");
				sb.append("</head>");
				sb.append("<body>");
				for (File f : filelist) {
					sb.append("<a href=\"http://localhost" + request.getUri()		
							+ "/" + f.getName() + "\">");
					System.out.println("http://localhost" + request.getUri()
                            + "/" + f.getName());
					sb.append(f.getName() + "</a>");
					sb.append("</br>");
				}
				sb.append("</body>");
				sb.append("</html>");
				output.write(sb.toString().getBytes());
	    	  
	    	 //��ײ��ļ���Դ�������ļ�����������ȡ���������飬��д������� 
	      }else{
	    	   byte[] bytes = new byte[BUFFER_SIZE];
	    	   FileInputStream fis = null;
		       fis = new FileInputStream(file);
		       int ch = fis.read(bytes, 0, BUFFER_SIZE);
		       while (ch!=-1) {
		            output.write(bytes, 0, ch);
		            ch = fis.read(bytes, 0, BUFFER_SIZE);
	          }
		       if (fis!=null) {
		           fis.close();
		       }
	      }
      } else {
    	  if(rpath.equals("/EXIT")){
    		  output.write(("�������ѹر�").getBytes());
    	  }else{
	        // file not found
	        String errorMessage = "HTTP/1.1 404 File Not Found\r\n" +
	          "Content-Type: text/html\r\n" +
	          "Content-Length: 23\r\n" +
	          "\r\n" +
	          "<h1>�ļ�δ�ҵ�</h1>";
	        output.write(errorMessage.getBytes());
    	  }
      	}
    }
    catch (Exception e) {
      System.out.println(e.toString() );
    }
  }
}