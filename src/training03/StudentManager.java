package training03;

import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import java.io.*; 
import java.util.*; 
 
class Student implements java.io.Serializable{ 
    String number,name,specialty,grade,borth,sex; 
    public Student(){}; 
    public void setNumber(String number){ this.number=number;} 
    public String getNumber(){ return number;} 
    public void setName(String name){ this.name=name;} 
    public String getName(){ return name;} 
    public void setSex(String sex){ this.sex=sex;} 
    public String getSex(){ return sex;} 
    public void setSpecialty(String specialty){ this.specialty=specialty;} 
    public String getSpecialty(){ return specialty;} 
    public void setGrade(String grade){ this.grade=grade;} 
    public String getGrade(){ return grade;} 
    public void setBorth(String borth){ this.borth=borth;} 
    public String getBorth(){ return borth;} 
} 
public class StudentManager extends JFrame{ 
    JLabel lb=new JLabel("录入请先输入记录，查询、删除请先输入学号，修改是对查询" + 
            "内容改后的保存！"); 
    static JTextField Jnumber,Jname,Jspecialty,Jgrade,Jborth; 
    static JRadioButton boy,girl; 
    static ButtonGroup group=null; 
    static JButton Login,select,delete,update,show; 
    static JPanel p1,p2,p3,p4,p5,p6,pv,ph; 
    static Student student=null; 
    static Hashtable Shashtable=null; 
    static File file=null; 
    static FileInputStream inOne=null; 
    static ObjectInputStream inTwo=null; 
    static FileOutputStream outOne=null; 
    static ObjectOutputStream outTwo=null; 
    public StudentManager(){ 
      super("学生基本信息管理系统"); 
      Jnumber=new JTextField(10); 
      Jname =new JTextField(10); 
      Jspecialty=new JTextField(10); 
      Jgrade=new JTextField(10); 
      Jborth=new JTextField(10); 
      group=new ButtonGroup(); 
      boy=new JRadioButton("男",true); 
      girl=new JRadioButton("女",false); 
      group.add(boy); 
      group.add(girl); 
      Login=new JButton("录入"); 
      select=new JButton("查询"); 
      delete=new JButton("删除"); 
      update=new JButton("修改"); 
      show=new JButton("显示"); 
      Login.addActionListener(new InputAct()); 
      select.addActionListener(new InquestAct()); 
      update.addActionListener(new ModifyAct()); 
      delete.addActionListener(new DeleteAct()); 
      show.addActionListener(new ShowAct()); 
      update.setEnabled(false); 
      p1=new JPanel(); 
      p1.add(new JLabel("学号:",JLabel.CENTER)); 
      p1.add(Jnumber); 
      p2=new JPanel(); 
      p2.add(new JLabel("姓名:",JLabel.CENTER)); 
      p2.add(Jname); 
      p3=new JPanel(); 
      p3.add(new JLabel("性别:",JLabel.CENTER)); 
      p3.add(boy); 
      p3.add(girl); 
      p4=new JPanel(); 
      p4.add(new JLabel("专业:",JLabel.CENTER)); 
      p4.add(Jspecialty); 
      p5=new JPanel(); 
      p5.add(new JLabel("年级:",JLabel.CENTER)); 
      p5.add(Jgrade); 
      p6=new JPanel(); 
      p6.add(new JLabel("出生:",JLabel.CENTER)); 
      p6.add(Jborth); 
      pv=new JPanel(); 
      pv.setLayout(new GridLayout(6,1)); 
      pv.add(p1); 
      pv.add(p2); 
      pv.add(p3); 
      pv.add(p4); 
      pv.add(p5); 
      pv.add(p6); 
      ph=new JPanel(); 
      ph.add(Login); 
      ph.add(select); 
      ph.add(update); 
      ph.add(delete); 
      ph.add(show); 
      file=new File("学生信息.txt"); 
      Shashtable=new Hashtable(); 
        if(!file.exists()){ 
            try{ 
                FileOutputStream out=new FileOutputStream(file); 
                ObjectOutputStream objectOut=new ObjectOutputStream(out); 
                objectOut.writeObject(Shashtable); 
                objectOut.close(); 
                out.close(); 
            } 
            catch(IOException e){} 
        } 
        Container con=getContentPane(); 
        con.setLayout(new BorderLayout()); 
        con.add(lb, BorderLayout.NORTH); 
        con.add(pv, BorderLayout.CENTER); 
        con.add(ph, BorderLayout.SOUTH); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setBounds(100,100,600,300); 
        setVisible(true); 
 
    } 
    public static void main(String[] args) {new StudentManager();} 
    class InputAct implements ActionListener{ 
        public void actionPerformed(ActionEvent e){ 
           update.setEnabled(false); 
           String number=""; 
           number=Jnumber.getText(); 
          if(number.length()>0){ 
              try{ 
                  inOne=new FileInputStream(file); 
                  inTwo=new ObjectInputStream(inOne); 
                  Shashtable=(Hashtable)inTwo.readObject(); 
                  inOne.close(); 
                  inTwo.close(); 
              } 
              catch(Exception ee){System.out.println("创建散列表出现问题！");} 
              if(Shashtable.containsKey(number)){ 
                  String warning="该生信息已存在，请到修改页面修改！"; 
                  JOptionPane.showMessageDialog(null,warning,"警告", 
                          JOptionPane.WARNING_MESSAGE); 
              }//end if1 
              else{ 
                  String m="该生信息将被录入！"; 
                  int ok=JOptionPane.showConfirmDialog(null,m,"确认", 
                          JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE); 
                  if(ok==JOptionPane.YES_OPTION){ 
                      String name=Jname.getText(); 
                      String specialty=Jspecialty.getText(); 
                      String grade=Jgrade.getText(); 
                      String borth=Jborth.getText(); 
                      String sex=null; 
                      if(boy.isSelected()){sex=boy.getText();} 
                      else{sex=girl.getText();} 
                      student=new Student(); 
                      student.setNumber(number); 
                      student.setName(name); 
                      student.setSpecialty(specialty); 
                      student.setGrade(grade); 
                      student.setBorth(borth); 
                      student.setSex(sex); 
                      try{ 
                          outOne=new FileOutputStream(file); 
                          outTwo=new ObjectOutputStream(outOne); 
                          Shashtable.put(number,student); 
                          outTwo.writeObject(Shashtable); 
                          outTwo.close(); 
                          outOne.close(); 
                      } 
                      catch(Exception ee){System.out.println("输出散列表出现问题！");} 
                      Jnumber.setText(null); 
                      Jname.setText(null); 
                      Jspecialty.setText(null); 
                      Jgrade.setText(null); 
                      Jborth.setText(null); 
                  } 
              }//end else1 
          }//end if0 
          else{ 
              String warning="必须输入学号！"; 
              JOptionPane.showMessageDialog(null,warning, 
                      "警告",JOptionPane.WARNING_MESSAGE); 
          }//end else0 
      }//end actionPerformed 
  }//end class 
    class InquestAct implements ActionListener{ 
        public void actionPerformed(ActionEvent e){ 
           String number=""; 
           number=Jnumber.getText(); 
          if(number.length()>0){ 
              try{ 
                  inOne=new FileInputStream(file); 
                  inTwo=new ObjectInputStream(inOne); 
                  Shashtable=(Hashtable)inTwo.readObject(); 
                  inOne.close(); 
                  inTwo.close(); 
              } 
              catch(Exception ee){System.out.println("散列表有问题！");} 
              if(Shashtable.containsKey(number)){ 
                update.setEnabled(true); 
                Student stu=(Student)Shashtable.get(number); 
                Jname.setText(stu.getName()); 
                Jspecialty.setText(stu.getSpecialty()); 
                Jgrade.setText(stu.getGrade()); 
                Jborth.setText(stu.getBorth()); 
                if(stu.getSex().equals("男")){boy.setSelected(true);} 
                else{girl.setSelected(true);} 
              } 
              else{ 
                  update.setEnabled(false); 
                  String warning="该学号不存在！"; 
              JOptionPane.showMessageDialog(null,warning, 
                      "警告",JOptionPane.WARNING_MESSAGE); 
              } 
          } 
          else{ 
          update.setEnabled(false); 
          String warning="必须输入学号！"; 
              JOptionPane.showMessageDialog(null,warning, 
                      "警告",JOptionPane.WARNING_MESSAGE); 
          } 
        } 
    } 
    class ModifyAct implements ActionListener{ 
        public void actionPerformed(ActionEvent e){ 
           String number=Jnumber.getText(); 
           String name=Jname.getText(); 
           String specialty=Jspecialty.getText(); 
           String grade=Jgrade.getText(); 
           String borth=Jborth.getText(); 
           String sex=null; 
           if(boy.isSelected()){sex=boy.getText();} 
           else{sex=girl.getText();} 
           Student 学生=new Student(); 
           学生.setNumber(number); 
           学生.setName(name); 
           学生.setSpecialty(specialty); 
           学生.setGrade(grade); 
           学生.setBorth(borth); 
           学生.setSex(sex); 
           try{ 
               outOne=new FileOutputStream(file); 
               outTwo=new ObjectOutputStream(outOne); 
               Shashtable.put(number, 学生); 
               outTwo.writeObject(Shashtable); 
               outTwo.close(); 
               outOne.close(); 
               Jnumber.setText(null); 
               Jname.setText(null); 
               Jspecialty.setText(null); 
               Jgrade.setText(null); 
               Jborth.setText(null); 
           } 
           catch(Exception ee){ 
               System.out.println("录入修改出现异常!"); 
               update.setEnabled(false); 
           } 
       } 
   } 
   class DeleteAct implements ActionListener{ 
       public void actionPerformed(ActionEvent e){ 
           update.setEnabled(false); 
           String number=Jnumber.getText(); 
          if(number.length()>0){ 
              try{ 
                  inOne=new FileInputStream(file); 
                  inTwo=new ObjectInputStream(inOne); 
                  Shashtable=(Hashtable)inTwo.readObject(); 
                  inOne.close(); 
                  inTwo.close(); 
              } 
              catch(Exception ee){} 
              if(Shashtable.containsKey(number)){ 
                Student stu=(Student)Shashtable.get(number); 
                Jname.setText(stu.getName()); 
                Jspecialty.setText(stu.getSpecialty()); 
                Jgrade.setText(stu.getGrade()); 
                Jborth.setText(stu.getBorth()); 
                if(stu.getSex().equals("男")){boy.setSelected(true);} 
                else{girl.setSelected(true);} 
              } 
              String m="确定要删除该学生的记录吗？"; 
              int ok=JOptionPane.showConfirmDialog(null,m,"确认", 
                 JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE); 
              if(ok==JOptionPane.YES_OPTION){ 
                  Shashtable.remove(number); 
                  try{ 
                      outOne=new FileOutputStream(file); 
                      outTwo=new ObjectOutputStream(outOne); 
                      outTwo.writeObject(Shashtable); 
                      outTwo.close(); 
                      outOne.close(); 
                      Jnumber.setText(null); 
                      Jname.setText(null); 
                      Jspecialty.setText(null); 
                      Jgrade.setText(null); 
                      Jborth.setText(null); 
                  } 
                  catch(Exception ee){System.out.println(ee);} 
 
              } 
              else if(ok==JOptionPane.NO_OPTION){ 
                  Jnumber.setText(null); 
                  Jname.setText(null); 
                  Jspecialty.setText(null); 
                  Jgrade.setText(null); 
                  Jborth.setText(null); 
              } 
              else{ 
                  String warning="该学号不存在！"; 
                  JOptionPane.showMessageDialog(null,warning, 
                          "警告",JOptionPane.WARNING_MESSAGE); 
              } 
          } 
          else{ 
               String warning="必须输入学号！"; 
               JOptionPane.showMessageDialog(null,warning, 
                      "警告",JOptionPane.WARNING_MESSAGE); 
          } 
       } 
   } 
   class ShowAct implements ActionListener{ 
       public void actionPerformed(ActionEvent e){ 
           new StudentShow(file); 
       } 
   } 
   class StudentShow extends JDialog{ 
       Hashtable 学生散列表= null; 
       JTextArea 显示=null; 
       FileInputStream inOne=null; 
       ObjectInputStream inTwo=null; 
       File file=null; 
       public StudentShow(File file){ 
           super(new JFrame(),"显示对话框"); 
           this.file=file; 
           显示=new JTextArea(16,30); 
           try{ 
               inOne=new FileInputStream(file); 
               inTwo=new ObjectInputStream(inOne); 
               学生散列表=(Hashtable)inTwo.readObject(); 
               inOne.close(); 
               inTwo.close(); 
           } 
           catch(Exception ee){} 
           if(学生散列表.isEmpty())显示.append("目前还没有学生的信息记录！\n"); 
           else{ 
               显示.setText("学号 姓名 性别 专业 年级 出生\n"); 
               for(Enumeration enm=学生散列表.elements();enm.hasMoreElements();){ 
                   Student stu=(Student)enm.nextElement(); 
                   String sex=""; 
                   if(stu.getSex().equals("男"))sex="男"; 
                   else sex="女"; 
                   String str=stu.getNumber()+","+stu.getName()+","+sex+"," 
                           +stu.getSpecialty()+","+stu.getGrade()+","+stu.getBorth()+"\n"; 
                   显示.append(str); 
               } 
           } 
           JScrollPane scroll=new JScrollPane(显示); 
           Container con=getContentPane(); 
           con.add("Center",scroll); 
           con.validate(); 
           setVisible(true); 
           setBounds(200,200,400,300); 
           addWindowListener(new WindowAdapter(){ 
               public void windowClosing(WindowEvent e){setVisible(false);} 
           } 
           ); 
       } 
   } 
}