package training01;
//根据输入的TREE层数获取对应的节点元素

import java.util.Scanner;

public class TNote {
	public static void main(String[] args) {	
		//键盘数据导入
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入层数（正整数）：");		
		int n = scan.nextInt();
		scan.close();//关闭扫描器
		//判断输入数据必须大于零
		if(n <= 0){
			System.out.println("输入的数字必须为正整数");
			return;
		}
		
		System.out.print("树tree的第"+n+"层的所有节点值为；");
		//根据键盘路人数据判断元素
		switch(n){
		case 1:
			System.out.println("A");
			break;
		case 2:
			System.out.println("B-D");
			break;
		case 3:
			System.out.println("G-H-C-F");
			break;
		default:
			System.out.println("无对应的节点");
			break;
		}	
	}

}