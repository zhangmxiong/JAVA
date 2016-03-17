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
	System.out.println("接收请求:"+request);
    this.request = request;
  }

  public void sendResource() throws IOException {
    byte[] bytes = new byte[BUFFER_SIZE];
    FileInputStream fis = null;
    //将request中截取的信息转换为文件路径
    String path = request.getUri();
    path = path.substring(0, 2)+":"+path.substring(2, path.length());
    try {
      File file = new File(path.replaceAll("/", "\\"+"\\"));
      if (file.exists()){
    	  output.write((file.getPath()+"\r\n").getBytes());// 追加\r\n是代表换行
    	  //目录文件读取文件列表
	      if (file.isDirectory()){
	    	  File[] filelist = file.listFiles();
	    	  for(File e:filelist){
	    		  if(e.isDirectory()){
	    			  if(!e.isHidden())
	    			  output.write(("文件夹"+e.getPath()+"\r\n").getBytes());
	    		  }else{
	    			  if(!e.isHidden())
	    			  output.write(("文件"+e.getPath()+"\r\n").getBytes());
	    		  }
	    	  }
	    	 //最底层文件资源，构建文件输入流，读取到缓冲数组，再写入输出流 
	      }else{
		       fis = new FileInputStream(file);
		       int ch = fis.read(bytes, 0, BUFFER_SIZE);
		       while (ch!=-1) {
		            output.write(bytes, 0, ch);
		            ch = fis.read(bytes, 0, BUFFER_SIZE);
	          }
	      }
      } else {
	        // file not found
	        String errorMessage = "HTTP/1.1 404 File Not Found\r\n" +
	          "Content-Type: text/html\r\n" +
	          "Content-Length: 23\r\n" +
	          "\r\n" +
	          "<h1>File Not Found</h1>";
	        output.write(errorMessage.getBytes());
      	}
    }
    catch (Exception e) {
      System.out.println(e.toString() );
    }
    finally {
      if (fis!=null)
        fis.close();
    }
  }
}