package training02;

import java.io.*;
import java.net.*;

public class HttpDown {

	public static void saveToFile(String destUrl, String fileName) throws IOException {
		//输出流，输入流，缓冲池
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		HttpURLConnection httpUrl = null;
		byte[] buf = new byte[4048];
		int size = 0;
		URL url =null;
		//建立链接
		url = new URL(destUrl);
		httpUrl = (HttpURLConnection) url.openConnection();
		// 连接指定的资源
		httpUrl.connect();
		// 获取网络输入流  
		bis = new BufferedInputStream(httpUrl.getInputStream());
		//建立文件
		fos = new FileOutputStream(fileName);
		//保存文件
		while ((size = bis.read(buf)) != -1)
			fos.write(buf, 0, size);
		fos.close();
		bis.close();
		httpUrl.disconnect();
	}
	public static void main(String[] args) {
		// 定义URL、下载后的文件名
		String url = "http://www.23wx.com/html/42/42214/18706421.html";
		String fileName = "e:/test.html";
		try{
			System.out.println("begin");
			saveToFile(url,fileName);
			System.out.println("successful");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
