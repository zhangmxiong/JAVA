package training01;
//根据输入的TREE层数获取对应的节点元素

import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;

public class TNote {
	//定义字符组
	private char[] array = {'A','B','D','G','H','C','F'};
	private static List<Node> nodeList = null;
	//定义节点类属性
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
		//将字符队列导入节点
		for (int i = 0; i < array.length; i++){
			nodeList.add(new Node(array[i]));
		}
		//根据父节点和孩子节点在队列所占位置的数组关系建立二叉树
		for (int i = 0;i <= array.length / 2 - 1;i++){
			//第i个节点对应的左分支
			nodeList.get(i).leftChild = nodeList.get(i * 2 + 1);
			//第i个节点对应的右分支
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
			System.out.println("没有该层节点");
		}
	}
	public static void main(String[] args) {
		TNote binTree = new TNote();
		//调用方法将二叉树与数组位置关系确认
		binTree.createBinTree();
		// nodeList中第0个索引处的值即为根节点 
		Node root = nodeList.get(0);
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
		//调用方法获取节点值
		TreeLevel(root,n);
	}
}