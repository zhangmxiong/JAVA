package training03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TestCollection
{
    public static void main(String[] args) 
    {
        Collection c = new ArrayList();
        //���Ԫ��
        c.add("�����");
        //��Ȼ�����ﲻ�ܷŻ������͵�ֵ����Java֧���Զ�װ��
        c.add(6);

        System.out.println("c���ϵ�Ԫ�ظ���Ϊ:" + c.size());
       
        //ɾ��ָ��Ԫ��
        c.remove(6);
       
        System.out.println("c���ϵ�Ԫ�ظ���Ϊ:" + c.size());
        //�ж��Ƿ����ָ���ַ���
        System.out.println("c���ϵ��Ƿ����������ַ���:" + c.contains("�����"));

        c.add("������J2EE��ҵӦ��ʵս");

        System.out.println("c���ϵ�Ԫ�أ�" + c);        

        Collection books = new HashSet();

        books.add("������J2EE��ҵӦ��ʵս");
        books.add("Struts2Ȩ��ָ��");

        System.out.println("c�����Ƿ���ȫ����books���ϣ�" + c.containsAll(books));

        //��c���ϼ�ȥbooks�������Ԫ��
        c.removeAll(books);

        System.out.println("c���ϵ�Ԫ�أ�" + c);
        System.out.println("books���ϵ�Ԫ��:" + books);
        //ɾ��c����������Ԫ��
        c.clear();

        System.out.println("c���ϵ�Ԫ�أ�" + c);

        //books������ֻʣ��c������Ҳͬʱ������Ԫ��
        books.retainAll(c);

        System.out.println("books���ϵ�Ԫ��:" + books);
    }
}