package IO;

/**
 * @author John
 *���տ���̨��Ϣ��ӡ������̨
 */
import java.io.*;
public class BufferedReaderData {

	public static void main(String[] args) {
		BufferedReader in = 
				new BufferedReader(
						new InputStreamReader(System.in));
		String s = null;
		int i = 0;
		try{
			//while((s = in.readLine()).length()!=0)
			do{
				i++;
				s =  in.readLine();
				System.out.println(s);
			}
			while(s.length()!=0&& i<5);
			//����Ĵ����޷������������Ķ�ȡ
			//in.close();
		}catch(IOException e){
			e.printStackTrace();
		}

	}
}
