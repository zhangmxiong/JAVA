package training01;
//整数转换为十六进制字符串
//导入键盘输入包
import java.util.Scanner;
public class InToHex {

	public static void main(String[] args) {
		//定义输出字符串
		String s = "";
		//定义键盘输入数据
		Scanner scan = new Scanner(System.in);		
		System.out.println("请输入一个整数");
		int x = scan.nextInt();
		scan.close();//关闭扫描器
		
		System.out.print("整数"+x);
		//根据输入数字判定正负数，负数取反，方便输出字符串确定正负号
		int a = x;
		if(a < 0){
			x = -x;
		}

		//输入数据循环除以16获取余数，为16进制末位，
		for(;x >= 16;){

		    s =  inToHex(x%16) + s;
		    x = x/16;
		}
		s = inToHex(x%16) + s;
		
		System.out.print("的十六进制数为：");
		if(a < 0){
			s = '-' + s;
		}
		System.out.println(s);
	}
	//方法intohex将1-16转化为字符串
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
