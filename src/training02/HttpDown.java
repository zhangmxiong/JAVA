package training02;

import java.io.*;
import java.net.*;

public class HttpDown {

	public static void saveToFile(String destUrl, String fileName) throws IOException {
		//��������������������
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		HttpURLConnection httpUrl = null;
		byte[] buf = new byte[4048];
		int size = 0;
		URL url =null;
		//��������
		url = new URL(destUrl);
		httpUrl = (HttpURLConnection) url.openConnection();
		// ����ָ������Դ
		httpUrl.connect();
		// ��ȡ����������  
		bis = new BufferedInputStream(httpUrl.getInputStream());
		//�����ļ�
		fos = new FileOutputStream(fileName);
		//�����ļ�
		while ((size = bis.read(buf)) != -1)
			fos.write(buf, 0, size);
		fos.close();
		bis.close();
		httpUrl.disconnect();
	}
	public static void main(String[] args) {
		// ����URL�����غ���ļ���
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
