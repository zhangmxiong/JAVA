package training01;
//���������TREE������ȡ��Ӧ�Ľڵ�Ԫ��

import java.util.Scanner;

public class TNote {
	public static void main(String[] args) {	
		//�������ݵ���
		Scanner scan = new Scanner(System.in);
		System.out.println("���������������������");		
		int n = scan.nextInt();
		scan.close();//�ر�ɨ����
		//�ж��������ݱ��������
		if(n <= 0){
			System.out.println("��������ֱ���Ϊ������");
			return;
		}
		
		System.out.print("��tree�ĵ�"+n+"������нڵ�ֵΪ��");
		//���ݼ���·�������ж�Ԫ��
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
			System.out.println("�޶�Ӧ�Ľڵ�");
			break;
		}	
	}

}