package training03;

import java.util.*;

public class TestIterator 
{ 
    public static void main(String[] args) 
    { 
        //����һ������ 
        Collection books = new HashSet(); 

        books.add("������J2EE��ҵӦ��ʵս"); 
        books.add("Struts2Ȩ��ָ��"); 
        books.add("����J2EE��Ajax����"); 

        //��ȡbooks���϶�Ӧ�ĵ����� 
        Iterator it = books.iterator(); 

        while(it.hasNext()) 
        { 
            //δʹ�÷��ͣ���Ҫǿ��ת��
            String book = (String)it.next(); 

            System.out.println(book); 

            if (book.equals("Struts2Ȩ��ָ��")) 
            { 
                it.remove();
                //ʹ��Iterator���������У������޸ļ���Ԫ��,������������쳣
                //books.remove(book); 

            } 

            //��book������ֵ������ı伯��Ԫ�ر��� 
             book = "�����ַ���"; 

        } 
        System.out.println(books); 
    } 
}