package com.edu.client.view.teacher;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import com.edu.bean.Teacher;

public class TeacherView {
JFrame teacherFrame;
   JTabbedPane teacherTabbedPane;
   
   JPanel teacherInformationPanel,teacherCoursePanel,
            teacherTestResultsPanel,teacherCommentPanel,
            modifyPasswordPanel;
   
   /*
    * 个人信息组件
    */
   JButton teacherReviseButton,teacherSureButton;
   
   /*
    * 教师课程表组件
    */
   JComboBox teacherGradeJCBox,teacherMajorJCBox;
   JTextArea[][] teacherCourseTabels=new JTextArea[5][9];
   
//   TextField teacherNumberText,teacherNameText,
//               teacherPhoneText,teacherAddressText,teacherPositionText,teacherCollegeText;
   
   public void init(Teacher teacher,Vector<String> teacherVeGradeJCbox,Vector<String> teacherVeMajorJCBox){
	   
	   int xWieht=888,jHight=666,hight=60,hightAdd=20;
	   /**
	    * 设置JFrame
	    */
	   teacherFrame=new JFrame();
	   teacherFrame.setSize(xWieht+20, jHight+50);
	   teacherFrame.setResizable(false);
	   teacherFrame.setLocationRelativeTo(null);
	   teacherFrame.setLayout(null);
	   /**
	    * 实例化JTabbedPane,设置绝对位置
	    */
	   teacherTabbedPane=new JTabbedPane(JTabbedPane.LEFT,JTabbedPane.WRAP_TAB_LAYOUT);
	   teacherTabbedPane.setBounds(0, 10, xWieht, jHight);
	   /**
	    * 设置字体以及添加背景图片标签
	    */
	   Font font=new Font("宋体",Font.BOLD,18);
	   //Icon icon=new ImageIcon("");
	   
	   /**
	    * 设置个人信息的标签,以及修改、确定按钮
	    */
	   JLabel teacherNumLabel=new JLabel("编号："+teacher.getUserId());
	   teacherNumLabel.setFont(font);
	   teacherNumLabel.setBounds(xWieht/2-100, hight+20, 500, 20);
	   
	   
	   JLabel teacherNameLabel=new JLabel("姓名:"+teacher.getUserName());
	   teacherNameLabel.setFont(font);
	   teacherNameLabel.setBounds(xWieht/2-100, hight+60+hightAdd, 500, 20);
	   
	   JLabel teacherPhoneLabel=new JLabel("电话号码:"+teacher.getTeacherPhone());
	   teacherPhoneLabel.setFont(font);
	   teacherPhoneLabel.setBounds(xWieht/2-100, hight+100+2*hightAdd, 500, 20);
	   
	   JLabel teacherAddressLabel=new JLabel("家庭地址:"+teacher.getTeacherAddress());
	   teacherAddressLabel.setFont(font);
	   teacherAddressLabel.setBounds(xWieht/2-100, hight+140+3*hightAdd, 500, 20);
	   
	   JLabel teacherPositionLabel=new JLabel("职称:"+teacher.getTeacherTitle());
	   teacherPositionLabel.setFont(font);
	   teacherPositionLabel.setBounds(xWieht/2-100, hight+180+4*hightAdd, 500, 20);
	   
	   JLabel teacherCollegeLabel=new JLabel("学院:"+teacher.getTeaColId());
	   teacherCollegeLabel.setFont(font);
	   teacherCollegeLabel.setBounds(xWieht/2-100, hight+220+5*hightAdd, 500, 20);
	   
	   teacherReviseButton=new JButton("修改");
	   teacherReviseButton.setBounds(xWieht/2+80, hight+220+10*hightAdd, 60, 20);
	   teacherSureButton=new JButton("确定");
	   teacherSureButton.setBounds(xWieht/2+180, hight+220+10*hightAdd, 60, 20);
	   
	   /**
	    * 个人信息Panel，以及将标签、按钮添加到Panel;
	    */
	   teacherInformationPanel=new JPanel();
	   teacherInformationPanel.setLayout(null);
	   teacherInformationPanel.setSize(800,666);
	   teacherInformationPanel.add(teacherNumLabel);
	   teacherInformationPanel.add(teacherNameLabel);
	   teacherInformationPanel.add(teacherPhoneLabel);
	   teacherInformationPanel.add(teacherAddressLabel);
	   teacherInformationPanel.add(teacherPositionLabel);
	   teacherInformationPanel.add(teacherCollegeLabel);
	   teacherInformationPanel.add(teacherReviseButton);
	   teacherInformationPanel.add(teacherSureButton);
	   
	   
	   /*
	    * 设置教师课程表，其中有添加表格，下拉框等组件。其中有三个Panel（包括teacherCoursePanel），
	    * 其中两个是添加到teacherCoursePanel中，teacherCoursePanel用的是边界布局。
	    */
	   JLabel teacherGradeLabel=new JLabel("年级:");
	   teacherGradeLabel.setBounds(100, 25,60, 20);
	   teacherGradeLabel.setFont(font);
	   
	   final JTextArea teacherGradeJCBTextArea=new JTextArea();
	   teacherGradeJCBox=new JComboBox(teacherVeGradeJCbox);//年级下拉款
	   teacherGradeJCBox.setBounds(155, 20, 200, 30);
	   teacherGradeJCBox.setFont(font);
	   teacherGradeJCBox.addItemListener(new ItemListener(){

		@Override
		public void itemStateChanged(ItemEvent e) {
			Object book=teacherGradeJCBox.getSelectedItem();
			teacherGradeJCBTextArea.setText(book.toString());
			
		}
		   
	   });
	   
	   JLabel teacherMajorLabel=new JLabel("专业:");
	   teacherMajorLabel.setBounds(450, 25,60, 20);
	   teacherMajorLabel.setFont(font);
	   
	   final JTextArea teacherMajorJCBTextArea=new JTextArea();
	   teacherMajorJCBox=new JComboBox(teacherVeMajorJCBox);//专业下拉款
	   teacherMajorJCBox.setBounds(505, 20, 200, 30);
	   teacherMajorJCBox.setFont(font);
	   teacherMajorJCBox.addItemListener(new ItemListener(){

		@Override
		public void itemStateChanged(ItemEvent e) {
			Object book=teacherMajorJCBox.getSelectedItem();
			teacherMajorJCBTextArea.setText(book.toString());
			
		}
		   
	   });
	   
	   
	   JPanel northPanel=new JPanel();//年级、专业下拉框的Panel
	   northPanel.setBounds(0, 0, 800, 70);
	   northPanel.setBackground(new Color(201,162,240));
	   northPanel.setLayout(null);
	   northPanel.add(teacherGradeJCBox);
	   northPanel.add(teacherGradeLabel);
	   northPanel.add(teacherMajorLabel);
	   northPanel.add(teacherMajorJCBox);
	   
	   
	   
	   
	   JPanel centrePanel=new JPanel();//课程表Panel
	   centrePanel.setBounds(0, 73, 800, 566);
	   centrePanel.setLayout(new GridLayout(5,9,5,4));
	   String[] weekStrs={"星期一","星期二","星期三","星期四","星期五","星期六","星期日"};
	   String[] strMoOnes={"上午","1~2节"};
	   String[] strMoTwos={"上午","3~4节"};
	   String[] strAfs={"下午","5~6节"};
	   String[] strEvs={"晚上","7~8节"};
	   
	   for(int i=0;i<5;i++){
		   for(int j=0;j<9;j++){
			   teacherCourseTabels[i][j]=new JTextArea();
			   teacherCourseTabels[i][j].setSize(3, 4);
			   teacherCourseTabels[i][j].setFont(font);
			   teacherCourseTabels[i][j].setEditable(false);
			   if(i==0&&(j>=0&&j<=1)){
				   teacherCourseTabels[i][j].setText(" ");
			   }else if(i==0&&(j>=2&&j<9)){
				   teacherCourseTabels[i][j].setText(weekStrs[j-2]); 
			   }else if(i==1&&(j>=0&&j<=1)){
				   teacherCourseTabels[i][j].setText(strMoOnes[j]);
			   }else if(i==2&&(j>=0&&j<=1)){
				   teacherCourseTabels[i][j].setText(strMoTwos[j]);
			   }else if(i==3&&(j>=0&&j<=1)){
				   teacherCourseTabels[i][j].setText(strAfs[j]);
			   }else if(i==4&&(j>=0&&j<=1)){
				   teacherCourseTabels[i][j].setText(strEvs[j]);
			   }else{
				 teacherCourseTabels[i][j].setText(" ");
			   }
			  
			   teacherCourseTabels[i][j].setBackground(new Color(208,216,232));
			   centrePanel.add(teacherCourseTabels[i][j]);
		   }
	   }
	   
	   teacherCoursePanel=new JPanel();
	   teacherCoursePanel.setLayout(null);
	   teacherCoursePanel.setSize(800, 666);
	   teacherCoursePanel.add(northPanel);
	   teacherCoursePanel.add(centrePanel);
	   
	   
	   
	   
	   
	   
	   
	   /**
	    * 将Panel添加到TabbedPane中
	    */
	   teacherTabbedPane.add("个人信息",teacherInformationPanel);
	   teacherTabbedPane.add("教师课程表",teacherCoursePanel);
	   /**
	    * 将TabbedPane添加到Frame中
	    */
	   teacherFrame.add(teacherTabbedPane);
	   teacherFrame.setVisible(true);
	   teacherFrame.setDefaultCloseOperation(teacherFrame.EXIT_ON_CLOSE);
	   
	   
	  
	   
   }
   
   public static void main(String[] args){
	   TeacherView te=new TeacherView();
	   int num=20140020;
	   String name="彭飞荣";
	   String phone="13512345678";
	   String address="异界大陆";
	   String position="马云的老板";
	   int college=12345;
	   Teacher teacher =new Teacher();
	   teacher.setUserId(num);
	   teacher.setTeacherAddress(address);
	   teacher.setTeacherPhone(phone);
	   teacher.setTeaColId(college);
	   teacher.setTeacherTitle(position);
	   teacher.setUserName(name);
	   Vector<String> vector=new Vector<String>();
	   vector.add("feifei");
	   vector.add("feifei");
	   vector.add("feifei");
	   vector.add("feifei");
	   Vector<String> vector2=new Vector<String>();
	   te.init(teacher,vector,vector2);
   }
}