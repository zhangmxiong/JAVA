package training01;

//���ļ�����ת����byte���鷵��,����ļ������ڻ��߶�����󷵻�null

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileIO {
    void readFile(String filepath)throws IOException
    {
        File f = new File(filepath);
        if(!f.exists())
        {	
            System.out.println("�ļ�"+f.getAbsolutePath()+"�����ڣ�");
            return;
        }
        else
        {
            FileInputStream fis=new FileInputStream(f);//������Ӧf���ļ�������
			//����һ�����ȵ����ļ�f���ȵ�byte���飬���ڴ�Ŵ��ļ��ж���������
            byte[] b=new byte[(int)f.length()];
            fis.read(b);
            System.out.println(b.length);
            for(int i = 0;i<b.length;i++){
            	System.out.print(b[i]+";");
            }
            fis.close();   
        }
    }
     
    public static void main(String args[])throws IOException{
        FileIO fio=new FileIO();
        fio.readFile("E:\\FileDemo.txt");  
    }
}