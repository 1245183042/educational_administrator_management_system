package com.edu.client.view.teacher;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
   JComboBox teacherCourseGradeJCBox,teacherCourseMajorJCBox;
   JTextArea[][] teacherCourseTabels=new JTextArea[5][9];
   
//   TextField teacherNumberText,teacherNameText,
//               teacherPhoneText,teacherAddressText,teacherPositionText,teacherCollegeText;
   /*
    * 教师公布考试成绩表的组件
    */
   JTextField teacherTestResultTeacherName;//教师名称文本框
   JComboBox teacherTestResultYearJC,teacherTestResultTermJC,teacherTestResultCourseNameJC,
                teacherTestResultCourseCharacterJC;//依次是学年、学期、课程名称、课程性质JComboBox;
   DefaultTableModel teacherTestResultDefaultTable; //教师View中的学生成绩表 
   JButton teacherTestResultSubmitButton;//提交按钮
   
   /*
    * 添加教师评价的各个组件
    */
   JComboBox teacherCommentYearJCBox,teacherCommentTermJCBox,teacherCommentCourseNameJCBox;
   JTextField teacherCommentStatisticsText,teacherCommentLevelText,
                  teacherCommentForTeacherText,teacherCommentGradeTermText;
   DefaultTableModel teacherCommentItmizeStatisticsDefaultTable,teacherCommentInformationDefaultTable;
   /*
    * 添加修改密码的各个组件(modifyPasswordPanel)
    */
   JTextField modifyPasswordUserNameText,modifyPasswordUserIdText,
   modifyPasswordOldPasswordText,modifyPasswordNewPasswordText,modifyPasswordEnsureNewPasswordText;
   JButton modifyPasswordEnsureButton;
   public void init(Teacher teacher,Vector<String> teacherCourseVeGradeJCBox,
		   Vector<String> teacherCourseVeMajorJCBox,Vector<String>teacherVeYearJCBox,Vector<String>teacherVeTermJCBox,
		   Vector<String>teacherVeCourseNameJCBox,Vector<String>teacherTestResultVeCourseCharacterJCBox){
	   
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
//	   teacherInformationPanel.add(teacherReviseButton);
//	   teacherInformationPanel.add(teacherSureButton);
	   
	   
	   /*
	    * 设置教师课程表，其中有添加表格，下拉框等组件。其中有三个Panel（包括teacherCoursePanel），
	    * 其中两个是添加到teacherCoursePanel中，teacherCoursePanel用的是边界布局。
	    */
	   JLabel teacherGradeLabel=new JLabel("学年学期:");
	   teacherGradeLabel.setBounds(100, 25,60, 20);
	   teacherGradeLabel.setFont(font);
	   
	   final JTextArea teacherCourseGradeJCBTextArea=new JTextArea();
	   teacherCourseGradeJCBox=new JComboBox(teacherCourseVeGradeJCBox);//教师课程表的年级下拉款
	   teacherCourseGradeJCBox.setBounds(155, 20, 200, 30);
	   teacherCourseGradeJCBox.setFont(font);
	   teacherCourseGradeJCBox.addItemListener(new ItemListener(){

		@Override
		public void itemStateChanged(ItemEvent e) {
			Object book=teacherCourseGradeJCBox.getSelectedItem();
			teacherCourseGradeJCBTextArea.setText(book.toString());
			
		}
		   
	   });
	   
	   JLabel teacherMajorLabel=new JLabel("专业:");
	   teacherMajorLabel.setBounds(450, 25,60, 20);
	   teacherMajorLabel.setFont(font);
	   
	   final JTextArea teacherCourseMajorJCBTextArea=new JTextArea();
	   teacherCourseMajorJCBox=new JComboBox(teacherCourseVeMajorJCBox);//教室课程表专业下拉款
	   teacherCourseMajorJCBox.setBounds(505, 20, 200, 30);
	   teacherCourseMajorJCBox.setFont(font);
	   teacherCourseMajorJCBox.addItemListener(new ItemListener(){

		@Override
		public void itemStateChanged(ItemEvent e) {
			Object book=teacherCourseMajorJCBox.getSelectedItem();
			teacherCourseMajorJCBTextArea.setText(book.toString());
			
		}
		   
	   });
	   
	   
	   JPanel northCoursePanel=new JPanel();//教室课程表北Panel，其中加入了年级、专业下拉框的Panel
	   northCoursePanel.setBounds(0, 0, 800, 70);
	   northCoursePanel.setBackground(new Color(201,162,240));
	   northCoursePanel.setLayout(null);
	   northCoursePanel.add(teacherCourseGradeJCBox);
	   northCoursePanel.add(teacherGradeLabel);
	   northCoursePanel.add(teacherMajorLabel);
	   northCoursePanel.add(teacherCourseMajorJCBox);
	   
	   
	   
	   
	   JPanel centreCoursePanel=new JPanel();//课程表中心Panel
	   centreCoursePanel.setBounds(0, 73, 800, 566);
	   centreCoursePanel.setLayout(new GridLayout(5,9,5,4));
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
			   centreCoursePanel.add(teacherCourseTabels[i][j]);
		   }
	   }
	   
	   teacherCoursePanel=new JPanel();//教师课程表Panel
	   teacherCoursePanel.setLayout(null);
	   teacherCoursePanel.setSize(800, 666);
	   teacherCoursePanel.add(northCoursePanel);
	   teacherCoursePanel.add(centreCoursePanel);
	   
	   /*
	    * 建立教师公布考试成绩的Panel，其中该pannel添加有三个pannel，
	    *   分为北(northTestResultsPanel,其中添加文本、下拉框等)、中(centerTestResultsPanel)、南(southTestResultsPanel)
	    *   
	    */
	   //添加北Panel的各组件
	   Font font2=new Font("宋体",Font.BOLD,18);
	   JLabel teacherTestResultTeacherNameLabel=new JLabel("教师名称:");//教师名称Label
	   teacherTestResultTeacherNameLabel.setBounds(20, 5, 120, 20);
	   teacherTestResultTeacherNameLabel.setFont(font);
	   
	   
	   JLabel teacherTestResultTermLabel=new JLabel("学期:");//教师学期Label
	   teacherTestResultTermLabel.setBounds(530, 5, 90, 20);
	   teacherTestResultTermLabel.setFont(font);
	   
	   JLabel teacherTestResultYearLabel=new JLabel("学年:");//教师学年Label
	   teacherTestResultYearLabel.setBounds(285, 5, 90, 20);
	   teacherTestResultYearLabel.setFont(font);
	   
	   JLabel teacherTestResultCourseNameLabel=new JLabel("课程名称:");//教师课程名称Label
	   teacherTestResultCourseNameLabel.setBounds(20, 40, 90, 20);
	   teacherTestResultCourseNameLabel.setFont(font);
	   
	   JLabel teacherTestResultCourseTermLabel=new JLabel("课程性质:");//教师课程性质Label
	   teacherTestResultCourseTermLabel.setBounds(450, 40, 90, 20);
	   teacherTestResultCourseTermLabel.setFont(font);
	   
	   teacherTestResultTeacherName=new JTextField();//教师名称文本框
	   teacherTestResultTeacherName.setBounds(120, 5, 130, 20);
	   teacherTestResultTeacherName.setFont(font);
	   
	   final JTextArea teacherTestResultYearTextArea=new JTextArea();
	   teacherTestResultYearJC=new JComboBox();//教师成绩学年下拉框
	   teacherTestResultYearJC.setBounds(345, 5, 170, 25);
	   teacherTestResultYearJC.setFont(font);
	   teacherTestResultYearJC.addItemListener(new ItemListener(){

		@Override
		public void itemStateChanged(ItemEvent e) {
			Object book=teacherTestResultYearJC.getItemListeners();
			teacherTestResultYearTextArea.setText(book.toString());
			
			
		}
		   
	   });
	   
	   final JTextArea teacherTestResultTermJCBTextArea=new JTextArea();
	   teacherTestResultTermJC=new JComboBox(teacherVeTermJCBox);//教师成绩学期下拉框
	   teacherTestResultTermJC.setBounds(590, 5, 150, 25);
	   teacherTestResultTermJC.setFont(font);
	   teacherTestResultTermJC.addItemListener(new ItemListener(){

		@Override
		public void itemStateChanged(ItemEvent e) {
			Object book=teacherTestResultTermJC.getItemListeners();
			teacherTestResultTermJCBTextArea.setText(book.toString());
			
			
		}
		   
	   });
	   final JTextArea teacherTestResultCourseNameJCBTextArea=new JTextArea();
	   teacherTestResultCourseNameJC=new JComboBox(teacherVeCourseNameJCBox);//教师成绩课程名称下拉框
	   teacherTestResultCourseNameJC.setBounds(120, 40, 200, 20);
	   teacherTestResultCourseNameJC.setFont(font);
	   teacherTestResultCourseNameJC.addItemListener(new ItemListener(){

		@Override
		public void itemStateChanged(ItemEvent e) {
			Object book=teacherTestResultCourseNameJC.getItemListeners();
			teacherTestResultCourseNameJCBTextArea.setText(book.toString());
			
		}
		   
	   });
	   
	   final JTextArea teacherTestResultCourseCharacterJCBTextArea=new JTextArea();
	   teacherTestResultCourseCharacterJC=new JComboBox(teacherVeCourseNameJCBox);//课程性质JComboBox
	   teacherTestResultCourseCharacterJC.setBounds(540, 40, 200, 20);
	   teacherTestResultCourseCharacterJC.setFont(font);
	   teacherTestResultCourseCharacterJC.addItemListener(new ItemListener(){

		@Override
		public void itemStateChanged(ItemEvent e) {
			Object book=teacherTestResultCourseCharacterJC.getItemListeners();
			teacherTestResultCourseCharacterJCBTextArea.setText(book.toString());
			
		}
		   
	   });
	   
	   JPanel northTestResultsPanel=new JPanel();//北(northTestResultsPanel,其中添加文本、下拉框等)
	   northTestResultsPanel.setLayout(null);
	   northTestResultsPanel.setBounds(0,3,800,70);
	   northTestResultsPanel.setBackground(new Color(7,9,67));
	   northTestResultsPanel.add(teacherTestResultTeacherNameLabel);
	   northTestResultsPanel.add(teacherTestResultTermLabel);
	   northTestResultsPanel.add(teacherTestResultCourseNameLabel);
	   northTestResultsPanel.add(teacherTestResultCourseTermLabel);
	   northTestResultsPanel.add(teacherTestResultTeacherName);
	   northTestResultsPanel.add(teacherTestResultTermJC);
	   northTestResultsPanel.add(teacherTestResultCourseNameJC);
	   northTestResultsPanel.add(teacherTestResultCourseCharacterJC);
	   northTestResultsPanel.add(teacherTestResultYearLabel);
	   northTestResultsPanel.add(teacherTestResultYearJC);
	   
	  //添加中Panel的各组件
	   JLabel classNameLabel=new JLabel("班级名称");
	   classNameLabel.setFont(font);
	   classNameLabel.setBackground(new Color(242,242,245));
	   JLabel studentIdLabel=new JLabel("学号");
	   studentIdLabel.setFont(font);
	   studentIdLabel.setBackground(new Color(242,242,245));
	   JLabel studentNameLabel=new JLabel("学生姓名");
	   studentNameLabel.setFont(font);
	   studentNameLabel.setBackground(new Color(242,242,245));
	   JLabel peacetimeGradeLabel=new JLabel("平时成绩");
	   peacetimeGradeLabel.setFont(font);
	   peacetimeGradeLabel.setBackground(new Color(242,242,245));
	   JLabel endGradeLabel=new JLabel("期末成绩");
	   endGradeLabel.setFont(font);
	   endGradeLabel.setBackground(new Color(242,242,245));
	   JLabel allGradeLabel=new JLabel("总成绩");
	   allGradeLabel.setFont(font);
	   allGradeLabel.setBackground(new Color(242,242,245));
	   
	   JPanel centerTestResultsPanel=new JPanel();//中(centerTestResultsPanel,其中用网格布局，添加标签)
	   centerTestResultsPanel.setLayout(new GridLayout(1,6,5,4));
	   centerTestResultsPanel.setBackground(new Color(185,185,219));
	   centerTestResultsPanel.setBounds(0,72,800,70);
	   centerTestResultsPanel.add(classNameLabel);
	   centerTestResultsPanel.add(studentIdLabel);
	   centerTestResultsPanel.add(studentNameLabel);
	   centerTestResultsPanel.add(peacetimeGradeLabel);
	   centerTestResultsPanel.add(endGradeLabel);
	   centerTestResultsPanel.add(allGradeLabel);
	   
	   //南(southTestResultsPanel)的各个组件
	   teacherTestResultDefaultTable=new DefaultTableModel(100,6);
	   JTable teacherTestResultTable=new JTable(teacherTestResultDefaultTable);
	   teacherTestResultTable.setRowHeight(20);
	   teacherTestResultTable.setSize(800, 600);
	   //jt.setSize(800, 600);
//	   JPanel jp=new JPanel();
//	   jp.add(jt);
	   JScrollPane jScrollPanel=new JScrollPane();
	   jScrollPanel.setPreferredSize(new Dimension(800,472));
	   jScrollPanel.setBounds(0, 0, 800, 472);
	   
	   jScrollPanel.setViewportView(teacherTestResultTable);
	   
	   teacherTestResultSubmitButton=new JButton("发布");
	   teacherTestResultSubmitButton.setBounds(700,490,60,20);
	   JPanel southTestResultsPanel=new JPanel();//南(southTestResultsPanel)
	   southTestResultsPanel.setBounds(0, 142, 800, 522);
	   southTestResultsPanel.add(jScrollPanel);
	   southTestResultsPanel.setLayout(null);
	   southTestResultsPanel.add(teacherTestResultSubmitButton);
	      
	 //教师考试成绩Panel
	   teacherTestResultsPanel=new JPanel();
	   teacherTestResultsPanel.setLayout(null);
	   teacherTestResultsPanel.setSize(800, 666);
	   teacherTestResultsPanel.add(northTestResultsPanel);
	   teacherTestResultsPanel.add(centerTestResultsPanel);
	   teacherTestResultsPanel.add(southTestResultsPanel);
	   
	   /*
	    * 实现查看评价Panel,其中添加各种的文本框，下拉框，表格
	    */
	   //添加各种 标签
	   
	   JLabel teacherCommentYearLabel=new JLabel("学年:");
	   teacherCommentYearLabel.setBounds(25, 15, 60, 20);
	   teacherCommentYearLabel.setFont(font);
	   
	   final JTextArea teacherCommentYearTextArea=new JTextArea();
	   teacherCommentYearJCBox=new JComboBox(teacherVeYearJCBox);
	   teacherCommentYearJCBox.setBounds(85, 15, 150, 20);
	   teacherCommentYearJCBox.setFont(font);
	   teacherCommentYearJCBox.addItemListener(new ItemListener(){

		@Override
		public void itemStateChanged(ItemEvent e) {
			Object book=teacherCommentYearJCBox.getItemListeners();
			teacherCommentYearTextArea.setText(book.toString());
			
		}
		   
	   });
	   
	   JLabel teacherCommentTermLabel=new JLabel("学期:");
	   teacherCommentTermLabel.setBounds(255, 15, 60, 20);
	   teacherCommentTermLabel.setFont(font);
	   
	   final JTextArea teacherCommentTermTextArea=new JTextArea();
	   teacherCommentTermJCBox=new JComboBox(teacherVeTermJCBox);
	   teacherCommentTermJCBox.setBounds(315, 15, 150, 20);
	   teacherCommentTermJCBox.setFont(font);
	   teacherCommentTermJCBox.addItemListener(new ItemListener(){

		@Override
		public void itemStateChanged(ItemEvent e) {
			Object book=teacherCommentTermJCBox.getItemListeners();
			teacherCommentTermTextArea.setText(book.toString());
			
		}
		   
	   });
	   
	   JLabel teacherCommentCourseNameLabel=new JLabel("课程名称:");
	   teacherCommentCourseNameLabel.setBounds(505, 15, 100, 20);
	   teacherCommentCourseNameLabel.setFont(font);
	   
	   final JTextArea teacherCommentCourseNameTextArea=new JTextArea();
	   teacherCommentCourseNameJCBox=new JComboBox(teacherVeCourseNameJCBox);
	   teacherCommentCourseNameJCBox.setBounds(605, 15, 150, 20);
	   teacherCommentCourseNameJCBox.setFont(font);
	   teacherCommentCourseNameJCBox.addItemListener(new ItemListener(){

		@Override
		public void itemStateChanged(ItemEvent e) {
			Object book=teacherCommentCourseNameJCBox.getItemListeners();
			teacherCommentCourseNameTextArea.setText(book.toString());
		}

		teacherCoursePanel = new JPanel();// 教师课程表Panel
		teacherCoursePanel.setLayout(null);
		teacherCoursePanel.setSize(800, 666);
		teacherCoursePanel.add(northCoursePanel);
		teacherCoursePanel.add(centreCoursePanel);

		/*
		 * 建立教师公布考试成绩的Panel，其中该pannel添加有三个pannel，
		 * 分为北(northTestResultsPanel,其中添加文本
		 * 、下拉框等)、中(centerTestResultsPanel)、南(southTestResultsPanel)
		 */
		// 添加北Panel的各组件
		Font font2 = new Font("宋体", Font.BOLD, 18);
		JLabel teacherTestResultTeacherNameLabel = new JLabel("教师名称:");// 教师名称Label
		teacherTestResultTeacherNameLabel.setBounds(20, 5, 120, 20);
		teacherTestResultTeacherNameLabel.setFont(font);

		JLabel teacherTestResultTermLabel = new JLabel("学期:");// 教师学期Label
		teacherTestResultTermLabel.setBounds(530, 5, 90, 20);
		teacherTestResultTermLabel.setFont(font);

		JLabel teacherTestResultYearLabel = new JLabel("学年:");// 教师学年Label
		teacherTestResultYearLabel.setBounds(285, 5, 90, 20);
		teacherTestResultYearLabel.setFont(font);

		JLabel teacherTestResultCourseNameLabel = new JLabel("课程名称:");// 教师课程名称Label
		teacherTestResultCourseNameLabel.setBounds(20, 40, 90, 20);
		teacherTestResultCourseNameLabel.setFont(font);

		JLabel teacherTestResultCourseTermLabel = new JLabel("课程性质:");// 教师课程性质Label
		teacherTestResultCourseTermLabel.setBounds(450, 40, 90, 20);
		teacherTestResultCourseTermLabel.setFont(font);

		teacherTestResultTeacherName = new JTextField();// 教师名称文本框
		teacherTestResultTeacherName.setBounds(120, 5, 130, 20);
		teacherTestResultTeacherName.setFont(font);

		final JTextArea teacherTestResultYearTextArea = new JTextArea();
		teacherTestResultYearJC = new JComboBox();// 教师成绩学年下拉框
		teacherTestResultYearJC.setBounds(345, 5, 170, 25);
		teacherTestResultYearJC.setFont(font);
		teacherTestResultYearJC.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				Object book = teacherTestResultYearJC.getItemListeners();
				teacherTestResultYearTextArea.setText(book.toString());

			}

		});

		final JTextArea teacherTestResultTermJCBTextArea = new JTextArea();
		teacherTestResultTermJC = new JComboBox(teacherVeTermJCBox);// 教师成绩学期下拉框
		teacherTestResultTermJC.setBounds(590, 5, 150, 25);
		teacherTestResultTermJC.setFont(font);
		teacherTestResultTermJC.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				Object book = teacherTestResultTermJC.getItemListeners();
				teacherTestResultTermJCBTextArea.setText(book.toString());

			}

		});
		final JTextArea teacherTestResultCourseNameJCBTextArea = new JTextArea();
		teacherTestResultCourseNameJC = new JComboBox(teacherVeCourseNameJCBox);// 教师成绩课程名称下拉框
		teacherTestResultCourseNameJC.setBounds(120, 40, 200, 20);
		teacherTestResultCourseNameJC.setFont(font);
		teacherTestResultCourseNameJC.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				Object book = teacherTestResultCourseNameJC.getItemListeners();
				teacherTestResultCourseNameJCBTextArea.setText(book.toString());

			}

		});

		final JTextArea teacherTestResultCourseCharacterJCBTextArea = new JTextArea();
		teacherTestResultCourseCharacterJC = new JComboBox(
				teacherVeCourseNameJCBox);// 课程性质JComboBox
		teacherTestResultCourseCharacterJC.setBounds(540, 40, 200, 20);
		teacherTestResultCourseCharacterJC.setFont(font);
		teacherTestResultCourseCharacterJC.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				Object book = teacherTestResultCourseCharacterJC
						.getItemListeners();
				teacherTestResultCourseCharacterJCBTextArea.setText(book
						.toString());

			}

		});

		JPanel northTestResultsPanel = new JPanel();// 北(northTestResultsPanel,其中添加文本、下拉框等)
		northTestResultsPanel.setLayout(null);
		northTestResultsPanel.setBounds(0, 3, 800, 70);
		northTestResultsPanel.setBackground(new Color(7, 9, 67));
		northTestResultsPanel.add(teacherTestResultTeacherNameLabel);
		northTestResultsPanel.add(teacherTestResultTermLabel);
		northTestResultsPanel.add(teacherTestResultCourseNameLabel);
		northTestResultsPanel.add(teacherTestResultCourseTermLabel);
		northTestResultsPanel.add(teacherTestResultTeacherName);
		northTestResultsPanel.add(teacherTestResultTermJC);
		northTestResultsPanel.add(teacherTestResultCourseNameJC);
		northTestResultsPanel.add(teacherTestResultCourseCharacterJC);
		northTestResultsPanel.add(teacherTestResultYearLabel);
		northTestResultsPanel.add(teacherTestResultYearJC);

		// 添加中Panel的各组件
		JLabel classNameLabel = new JLabel("班级名称");
		classNameLabel.setFont(font);
		classNameLabel.setBackground(new Color(242, 242, 245));
		JLabel studentIdLabel = new JLabel("学号");
		studentIdLabel.setFont(font);
		studentIdLabel.setBackground(new Color(242, 242, 245));
		JLabel studentNameLabel = new JLabel("学生姓名");
		studentNameLabel.setFont(font);
		studentNameLabel.setBackground(new Color(242, 242, 245));
		JLabel peacetimeGradeLabel = new JLabel("平时成绩");
		peacetimeGradeLabel.setFont(font);
		peacetimeGradeLabel.setBackground(new Color(242, 242, 245));
		JLabel endGradeLabel = new JLabel("期末成绩");
		endGradeLabel.setFont(font);
		endGradeLabel.setBackground(new Color(242, 242, 245));
		JLabel allGradeLabel = new JLabel("总成绩");
		allGradeLabel.setFont(font);
		allGradeLabel.setBackground(new Color(242, 242, 245));

		JPanel centerTestResultsPanel = new JPanel();// 中(centerTestResultsPanel,其中用网格布局，添加标签)
		centerTestResultsPanel.setLayout(new GridLayout(1, 6, 5, 4));
		centerTestResultsPanel.setBackground(new Color(185, 185, 219));
		centerTestResultsPanel.setBounds(0, 72, 800, 70);
		centerTestResultsPanel.add(classNameLabel);
		centerTestResultsPanel.add(studentIdLabel);
		centerTestResultsPanel.add(studentNameLabel);
		centerTestResultsPanel.add(peacetimeGradeLabel);
		centerTestResultsPanel.add(endGradeLabel);
		centerTestResultsPanel.add(allGradeLabel);

		// 南(southTestResultsPanel)的各个组件
		teacherTestResultDefaultTable = new DefaultTableModel(100, 6);
		JTable teacherTestResultTable = new JTable(
				teacherTestResultDefaultTable);
		teacherTestResultTable.setRowHeight(20);
		teacherTestResultTable.setSize(800, 600);
		// jt.setSize(800, 600);
		// JPanel jp=new JPanel();
		// jp.add(jt);
		JScrollPane jScrollPanel = new JScrollPane();
		jScrollPanel.setPreferredSize(new Dimension(800, 472));
		jScrollPanel.setBounds(0, 0, 800, 472);

		jScrollPanel.setViewportView(teacherTestResultTable);

		teacherTestResultSubmitButton = new JButton("发布");
		teacherTestResultSubmitButton.setBounds(700, 490, 60, 20);
		JPanel southTestResultsPanel = new JPanel();// 南(southTestResultsPanel)
		southTestResultsPanel.setBounds(0, 142, 800, 522);
		southTestResultsPanel.add(jScrollPanel);
		southTestResultsPanel.setLayout(null);
		southTestResultsPanel.add(teacherTestResultSubmitButton);

		// 教师考试成绩Panel
		teacherTestResultsPanel = new JPanel();
		teacherTestResultsPanel.setLayout(null);
		teacherTestResultsPanel.setSize(800, 666);
		teacherTestResultsPanel.add(northTestResultsPanel);
		teacherTestResultsPanel.add(centerTestResultsPanel);
		teacherTestResultsPanel.add(southTestResultsPanel);

		/*
		 * 实现查看评价Panel,其中添加各种的文本框，下拉框，表格
		 */
		// 添加各种 标签

		JLabel teacherCommentYearLabel = new JLabel("学年:");
		teacherCommentYearLabel.setBounds(25, 15, 60, 20);
		teacherCommentYearLabel.setFont(font);

		final JTextArea teacherCommentYearTextArea = new JTextArea();
		teacherCommentYearJCBox = new JComboBox(teacherVeYearJCBox);
		teacherCommentYearJCBox.setBounds(85, 15, 150, 20);
		teacherCommentYearJCBox.setFont(font);
		teacherCommentYearJCBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				Object book = teacherCommentYearJCBox.getItemListeners();
				teacherCommentYearTextArea.setText(book.toString());

			}

		});

		JLabel teacherCommentTermLabel = new JLabel("学期:");
		teacherCommentTermLabel.setBounds(255, 15, 60, 20);
		teacherCommentTermLabel.setFont(font);

		final JTextArea teacherCommentTermTextArea = new JTextArea();
		teacherCommentTermJCBox = new JComboBox(teacherVeTermJCBox);
		teacherCommentTermJCBox.setBounds(315, 15, 150, 20);
		teacherCommentTermJCBox.setFont(font);
		teacherCommentTermJCBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				Object book = teacherCommentTermJCBox.getItemListeners();
				teacherCommentTermTextArea.setText(book.toString());

			}

		});

		JLabel teacherCommentCourseNameLabel = new JLabel("课程名称:");
		teacherCommentCourseNameLabel.setBounds(505, 15, 100, 20);
		teacherCommentCourseNameLabel.setFont(font);

		final JTextArea teacherCommentCourseNameTextArea = new JTextArea();
		teacherCommentCourseNameJCBox = new JComboBox(teacherVeCourseNameJCBox);
		teacherCommentCourseNameJCBox.setBounds(605, 15, 150, 20);
		teacherCommentCourseNameJCBox.setFont(font);
		teacherCommentCourseNameJCBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				Object book = teacherCommentCourseNameJCBox.getItemListeners();
				teacherCommentCourseNameTextArea.setText(book.toString());

			}

		});

		JLabel teacherCommentStatisticsLabel = new JLabel("评价总汇统计:");
		teacherCommentStatisticsLabel.setBounds(25, 60, 130, 20);
		teacherCommentStatisticsLabel.setFont(font);

		teacherCommentStatisticsText = new JTextField();
		teacherCommentStatisticsText.setBounds(155, 60, 200, 20);
		teacherCommentStatisticsText.setEditable(false);
		teacherCommentStatisticsText.setFont(font);

		JLabel teacherCommentLevelLabel = new JLabel("等级:");
		teacherCommentLevelLabel.setBounds(425, 60, 60, 20);
		teacherCommentLevelLabel.setFont(font);

		teacherCommentLevelText = new JTextField();
		teacherCommentLevelText.setEditable(false);
		teacherCommentLevelText.setBounds(495, 60, 60, 20);
		teacherCommentLevelText.setFont(font);

		JLabel teacherCommentForTeacherLabel = new JLabel("对教师的评价分:");
		teacherCommentForTeacherLabel.setBounds(25, 100, 150, 20);
		teacherCommentForTeacherLabel.setFont(font);

		teacherCommentForTeacherText = new JTextField();
		teacherCommentForTeacherText.setEditable(false);
		teacherCommentForTeacherText.setBounds(185, 100, 180, 20);
		teacherCommentForTeacherText.setFont(font);

		JLabel teacherCommentGradeTermLabel = new JLabel("评价学年学期:");
		teacherCommentGradeTermLabel.setBounds(425, 100, 150, 20);
		teacherCommentGradeTermLabel.setFont(font);

		teacherCommentGradeTermText = new JTextField();
		teacherCommentGradeTermText.setEditable(false);
		teacherCommentGradeTermText.setBounds(575, 100, 200, 20);
		teacherCommentGradeTermText.setFont(font);

		JLabel teacherCommentItmizeStatisticsLabel = new JLabel("评价分项统计:");
		teacherCommentItmizeStatisticsLabel.setBounds(15, 150, 150, 20);
		teacherCommentItmizeStatisticsLabel.setFont(font);

		Vector<String> commentColumnIdentifiers = new Vector<String>();
		commentColumnIdentifiers.add("评价号");
		commentColumnIdentifiers.add("评价者");
		commentColumnIdentifiers.add("评价内容");
		commentColumnIdentifiers.add("评分");

		// {"评价号","评价者","评价内容","评分"};
		teacherCommentItmizeStatisticsDefaultTable = new DefaultTableModel(100,
				4);
		teacherCommentItmizeStatisticsDefaultTable
				.setColumnIdentifiers(commentColumnIdentifiers);
		JTable teacherCommentItmizeStatisticsTable = new JTable(
				teacherCommentItmizeStatisticsDefaultTable);
		// teacherCommentItmizeStatisticsTable.isCellEditable(100, column)
		JScrollPane teacherCommentItmizeStatisticsJSP = new JScrollPane();
		teacherCommentItmizeStatisticsJSP.setBounds(5, 190, 780, 300);
		teacherCommentItmizeStatisticsJSP
				.setViewportView(teacherCommentItmizeStatisticsTable);

		// 评价信息
		// JLabel teacherCommentInformationLabel=new JLabel("评价信息:");
		// teacherCommentInformationLabel.setBounds(15,500,100, 20);
		// teacherCommentInformationLabel.setFont(font);

		Vector<String> informationColumnIdentifiers = new Vector<String>();
		informationColumnIdentifiers.add("评价信息");
		teacherCommentInformationDefaultTable = new DefaultTableModel(100, 1);
		teacherCommentInformationDefaultTable
				.setColumnIdentifiers(informationColumnIdentifiers);
		JTable teacherCommentInformationTable = new JTable(
				teacherCommentInformationDefaultTable);
		teacherCommentInformationTable.setRowHeight(20);
		JScrollPane teacherCommentInformationJSP = new JScrollPane();
		teacherCommentInformationJSP.setBounds(5, 505, 780, 150);
		teacherCommentInformationJSP
				.setViewportView(teacherCommentInformationTable);

		// 实例化评论的Panel
		teacherCommentPanel = new JPanel();
		teacherCommentPanel.setLayout(null);
		teacherCommentPanel.setSize(800, 666);
		teacherCommentPanel.add(teacherCommentYearLabel);
		teacherCommentPanel.add(teacherCommentTermLabel);
		teacherCommentPanel.add(teacherCommentCourseNameLabel);
		teacherCommentPanel.add(teacherCommentStatisticsLabel);
		teacherCommentPanel.add(teacherCommentLevelLabel);
		teacherCommentPanel.add(teacherCommentForTeacherLabel);
		teacherCommentPanel.add(teacherCommentGradeTermLabel);
		teacherCommentPanel.add(teacherCommentYearJCBox);
		teacherCommentPanel.add(teacherCommentTermJCBox);
		teacherCommentPanel.add(teacherCommentCourseNameJCBox);
		teacherCommentPanel.add(teacherCommentStatisticsText);
		teacherCommentPanel.add(teacherCommentLevelText);
		teacherCommentPanel.add(teacherCommentForTeacherText);
		teacherCommentPanel.add(teacherCommentGradeTermText);
		teacherCommentPanel.add(teacherCommentItmizeStatisticsLabel);
		teacherCommentPanel.add(teacherCommentItmizeStatisticsJSP);
		// teacherCommentPanel.add(teacherCommentInformationLabel);
		teacherCommentPanel.add(teacherCommentInformationJSP);

		/*
		 * 添加修改密码Panel 的各个组件
		 */
		JLabel modifyPasswordUserNameLabel = new JLabel("用户名:");
		modifyPasswordUserNameLabel.setBounds(xWieht / 2 - 250, hight + 20 + 2
				* hightAdd, 100, 20);
		modifyPasswordUserNameLabel.setFont(font);
		modifyPasswordUserNameText = new JTextField();
		modifyPasswordUserNameText.setBounds(xWieht / 2 - 140, hight + 20 + 2
				* hightAdd, 200, 20);
		modifyPasswordUserNameText.setFont(font);
		JLabel modifyPasswordUserIdLabel = new JLabel("账户:");
		modifyPasswordUserIdLabel.setBounds(xWieht / 2 - 250, hight + 60 + 3
				* hightAdd, 100, 20);
		modifyPasswordUserIdLabel.setFont(font);
		modifyPasswordUserIdText = new JTextField();
		modifyPasswordUserIdText.setBounds(xWieht / 2 - 140, hight + 60 + 3
				* hightAdd, 200, 20);
		modifyPasswordUserIdText.setFont(font);
		JLabel modifyPasswordOldPasswordLabel = new JLabel("旧密码:");
		modifyPasswordOldPasswordLabel.setBounds(xWieht / 2 - 250, hight + 100
				+ 4 * hightAdd, 100, 20);
		modifyPasswordOldPasswordLabel.setFont(font);
		modifyPasswordOldPasswordText = new JTextField();
		modifyPasswordOldPasswordText.setBounds(xWieht / 2 - 140, hight + 100
				+ 4 * hightAdd, 200, 20);
		modifyPasswordOldPasswordText.setFont(font);
		JLabel modifyPasswordNewPasswordLabel = new JLabel("新密码:");
		modifyPasswordNewPasswordLabel.setBounds(xWieht / 2 - 250, hight + 140
				+ 5 * hightAdd, 100, 20);
		modifyPasswordNewPasswordLabel.setFont(font);
		modifyPasswordNewPasswordText = new JTextField();
		modifyPasswordNewPasswordText.setBounds(xWieht / 2 - 140, hight + 140
				+ 5 * hightAdd, 200, 20);
		modifyPasswordNewPasswordText.setFont(font);
		JLabel modifyPasswordEnsureNewPasswordLabel = new JLabel("确认新密码:");
		modifyPasswordEnsureNewPasswordLabel.setBounds(xWieht / 2 - 250, hight
				+ 180 + 6 * hightAdd, 130, 20);
		modifyPasswordEnsureNewPasswordLabel.setFont(font);
		modifyPasswordEnsureNewPasswordText = new JTextField();
		modifyPasswordEnsureNewPasswordText.setBounds(xWieht / 2 - 140, hight
				+ 180 + 6 * hightAdd, 200, 20);
		modifyPasswordEnsureNewPasswordText.setFont(font);

		modifyPasswordEnsureButton = new JButton("确认");
		modifyPasswordEnsureButton.setBounds(xWieht / 2 + 100, hight + 180 + 13
				* hightAdd, 60, 20);
		// 实例化modifyPasswordPanel
		modifyPasswordPanel = new JPanel();
		modifyPasswordPanel.setLayout(null);
		modifyPasswordPanel.setSize(800, 666);
		modifyPasswordPanel.add(modifyPasswordUserNameLabel);
		modifyPasswordPanel.add(modifyPasswordUserIdLabel);
		modifyPasswordPanel.add(modifyPasswordOldPasswordLabel);
		modifyPasswordPanel.add(modifyPasswordNewPasswordLabel);
		modifyPasswordPanel.add(modifyPasswordEnsureNewPasswordLabel);
		modifyPasswordPanel.add(modifyPasswordUserNameText);
		modifyPasswordPanel.add(modifyPasswordUserIdText);
		modifyPasswordPanel.add(modifyPasswordOldPasswordText);
		modifyPasswordPanel.add(modifyPasswordNewPasswordText);
		modifyPasswordPanel.add(modifyPasswordEnsureNewPasswordText);
		modifyPasswordPanel.add(modifyPasswordEnsureButton);
		/*
		 * 将Panel添加到TabbedPane中
		 */
		teacherTabbedPane.add("个人信息", teacherInformationPanel);
		teacherTabbedPane.add("教师课程表", teacherCoursePanel);
		teacherTabbedPane.add("考试成绩", teacherTestResultsPanel);
		teacherTabbedPane.add("查看评价", teacherCommentPanel);
		teacherTabbedPane.add("修改密码", modifyPasswordPanel);
		/**
		 * 将TabbedPane添加到Frame中
		 */
		teacherFrame.add(teacherTabbedPane);
		teacherFrame.setVisible(true);
		teacherFrame.setDefaultCloseOperation(teacherFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		TeacherView te = new TeacherView();
		int num = 20140020;
		String name = "彭飞荣";
		String phone = "13512345678";
		String address = "异界大陆";
		String position = "马云的老板";
		int college = 12345;
		Teacher teacher = new Teacher();
		teacher.setTeacherId(num);
		teacher.setTeacherAddress(address);
		teacher.setTeacherPhone(phone);
		teacher.setTeaColId(college);
		teacher.setTeacherTitle(position);
		teacher.setTeacherName(name);
		Vector<String> vector = new Vector<String>();
		vector.add("feifei");
		vector.add("feifei");
		vector.add("feifei");
		vector.add("feifei");
		Vector<String> vector2 = new Vector<String>();
		te.init(teacher, vector, vector, vector, vector, vector, vector);
	}
}