package IO;
//�ļ�Ŀ¼���������Ŀ¼�����������̨
import java.io.*;
import java.util.*;
public class FileDirToSystem {

	public static void main(String[] args) {
		// �����ļ�·��
		Scanner f = new Scanner(System.in);
		System.out.println("������һ���ļ�·����Ŀ¼���á�\\���ָ���");
		String filepath = f.nextLine();
		f.close();
		//���� ͨ��·�����ж�·���Ƿ���ȷ
		//String filepath = "D:\\ai";
		//File f = new File(filepath);
		//System.out.println(new File(filepath).getName());
		if(new File(filepath).listFiles()==null){
			System.out.println("�ļ�·������û�и��ļ�");
		}
		FileDirToSystem file = new FileDirToSystem();
		file.fileList(filepath);
	}
	public void fileList(String fpath){
		File f = new File(fpath);    //·�������ļ�
		File[] fnext = f.listFiles();//����listFiles ��ȡ��ǰĿ¼���ļ��б�
		//�ݹ�����ļ�·��������
		for(int i =0;fnext !=null&&i<fnext.length;i++){
			System.out.println(fpath+"\\"+fnext[i].getName());//���·��+�ļ���
			//�ж��Ƿ����¼��ļ�
			if(fnext[i].isDirectory()){
				fileList(fnext[i].getPath());
			}
		}		
	}
}
