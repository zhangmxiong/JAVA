package simplewebserver;

import java.io.InputStream;
import java.io.IOException;
import java.net.URLDecoder;

public class Request {

	private InputStream input;
	private String uri;

	public Request(InputStream input) {
		System.out.println("request请求开始，解析uri");
		this.input = input;
	}

	public String getUri() {
		return uri;
	}

	public void parse() throws IOException {

		byte[] buffer = new byte[2048];
		// 读取输入流，并转换为字符串
		input.read(buffer);
		String rq = new String(buffer);

		System.out.println("input输入流:" + input);
		System.out.println("网址数据:" + rq);
		uri = parseUri(rq);
		uri = URLDecoder.decode(uri, "utf-8");
		System.out.println("截取后uri=" + uri);
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