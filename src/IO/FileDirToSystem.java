package IO;
//文件目录及下面的子目录名输出到控制台
import java.io.*;
import java.util.*;
public class FileDirToSystem {

	public static void main(String[] args) {
		// 输入文件路径
		Scanner f = new Scanner(System.in);
		System.out.println("请输入一个文件路径，目录间用“\\”分隔符");
		String filepath = f.nextLine();
		f.close();
		//不能 通过路径名判断路径是否正确
		//String filepath = "D:\\ai";
		//File f = new File(filepath);
		//System.out.println(new File(filepath).getName());
		if(new File(filepath).listFiles()==null){
			System.out.println("文件路径错误，没有该文件");
		}
		FileDirToSystem file = new FileDirToSystem();
		file.fileList(filepath);
	}
	public void fileList(String fpath){
		File f = new File(fpath);    //路径构造文件
		File[] fnext = f.listFiles();//调用listFiles 获取当前目录下文件列表
		//递归浏览文件路径和名称
		for(int i =0;fnext !=null&&i<fnext.length;i++){
			System.out.println(fpath+"\\"+fnext[i].getName());//输出路径+文件名
			//判断是否有下级文件
			if(fnext[i].isDirectory()){
				fileList(fnext[i].getPath());
			}
		}		
	}
}
