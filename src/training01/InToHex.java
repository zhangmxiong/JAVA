package training01;
//����ת��Ϊʮ�������ַ���
//������������
import java.util.Scanner;
public class InToHex {

	public static void main(String[] args) {
		//��������ַ���
		String s = "";
		//���������������
		Scanner scan = new Scanner(System.in);		
		System.out.println("������һ������");
		int x = scan.nextInt();
		scan.close();//�ر�ɨ����
		
		System.out.print("����"+x);
		//�������������ж�������������ȡ������������ַ���ȷ��������
		int a = x;
		if(a < 0){
			x = -x;
		}

		//��������ѭ������16��ȡ������Ϊ16����ĩλ��
		for(;x >= 16;){

		    s =  inToHex(x%16) + s;
		    x = x/16;
		}
		s = inToHex(x%16) + s;
		
		System.out.print("��ʮ��������Ϊ��");
		if(a < 0){
			s = '-' + s;
		}
		System.out.println(s);
	}
	//����intohex��1-16ת��Ϊ�ַ���
	private static String inToHex(int n){
		String s = "";
	    if(n%16 == 10){
			s = s + 'a';
		}else if(n%16 == 11){
			s = s + 'b';
		}else if(n%16 == 12){
			s = s + 'c';
		}else if(n%16 == 13){
			s = s + 'd';
		}else if(n%16 == 14){
			s = s + 'e';
		}else if(n%16 == 15){
			s = s + 'f';
		}else{
			s = s + n;
		}
		return s;
	}
}
