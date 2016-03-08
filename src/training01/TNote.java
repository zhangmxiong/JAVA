package training01;
//���������TREE������ȡ��Ӧ�Ľڵ�Ԫ��

import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;

public class TNote {
	//�����ַ���
	private char[] array = {'A','B','D','G','H','C','F'};
	private static List<Node> nodeList = null;
	//����ڵ�������
	private static class Node{
		Node leftChild;
		Node rightChild;
		char data;	
		Node(char newData){
			leftChild = null;
			rightChild =null;
			data = newData;
		}		
	}
	
	public void createBinTree(){
		nodeList = new LinkedList<Node>();
		//���ַ����е���ڵ�
		for (int i = 0; i < array.length; i++){
			nodeList.add(new Node(array[i]));
		}
		//���ݸ��ڵ�ͺ��ӽڵ��ڶ�����ռλ�õ������ϵ����������
		for (int i = 0;i <= array.length / 2 - 1;i++){
			//��i���ڵ��Ӧ�����֧
			nodeList.get(i).leftChild = nodeList.get(i * 2 + 1);
			//��i���ڵ��Ӧ���ҷ�֧
			nodeList.get(i).rightChild = nodeList.get(i * 2 + 2);
		}
	}
	public static void TreeLevel(Node node,int n){
		if (node == null)
		return;
		if (n == 1){
			System.out.print(node.data);
		}else if (n == 2){
			TreeLevel(node.leftChild,1);
			System.out.print("-");
			TreeLevel(node.rightChild,1);
		}else if (n == 3){
			TreeLevel(node.leftChild.leftChild,1);
			System.out.print("-");
			TreeLevel(node.leftChild.rightChild,1);
			System.out.print("-");
			TreeLevel(node.rightChild.leftChild,1);
			System.out.print("-");
			TreeLevel(node.rightChild.rightChild,1);
		}else{
			System.out.println("û�иò�ڵ�");
		}
	}
	public static void main(String[] args) {
		TNote binTree = new TNote();
		//���÷�����������������λ�ù�ϵȷ��
		binTree.createBinTree();
		// nodeList�е�0����������ֵ��Ϊ���ڵ� 
		Node root = nodeList.get(0);
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
		//���÷�����ȡ�ڵ�ֵ
		TreeLevel(root,n);
	}
}