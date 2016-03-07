package training01;

//将文件内容转换成byte数组返回,如果文件不存在或者读入错误返回null

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileIO {
    void readFile(String filepath)throws IOException
    {
        File f = new File(filepath);
        if(!f.exists())
        {	
            System.out.println("文件"+f.getAbsolutePath()+"不存在！");
            return;
        }
        else
        {
            FileInputStream fis=new FileInputStream(f);//创建对应f的文件输入流
			//创建一个长度等于文件f长度的byte数组，用于存放从文件中读出的数据
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