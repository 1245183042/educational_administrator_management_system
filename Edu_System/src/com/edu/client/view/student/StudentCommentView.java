package com.edu.client.view.student;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.edu.bean.Course;
import com.edu.bean.Message;

public class StudentCommentView {
	private JFrame frame;
	private int num;
	String[] courseNameString;
	JComboBox<String> courseNameBox;
	JTextField teacherNameField;
	String[] teacherNameString;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void InitUI(Message message){
		// TODO Auto-generated method stub
	frame = new JFrame("课表详细内容");
	frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE );
	//窗口用户是否调整
	frame.setResizable(false);
	frame.setSize( 800, 600);
	//对控件施行绝对定位，必须让它不要使用任何布局方式（关键步骤）
	frame.setLayout(null);
	//设置窗口相对于指定组件的位置。 如果组件当前未显示，或者 c 为 null，则此窗口将置于屏幕的中央。
	frame.setLocationRelativeTo(null);
	
	Color bgColor = new Color(245,245,245);
	Font font = new Font("宋体", Font.BOLD, 18);
	//评价老师
	JPanel commentPanel = new JPanel();
	commentPanel.setLayout(null);
	commentPanel.setBackground(bgColor);
	commentPanel.setSize(800,600);
	
	//课程名
	JLabel courseName = new JLabel("  课程名:");
	courseName.setBounds(400, 10, 100, 30);
	courseName.setFont(font);
	commentPanel.add(courseName);
	//课程名下拉菜单
	List<String> teacherSubject = new ArrayList<String>();
	for(Course c : message.getCourses()){
		String[] course = c.getCouClassroom().split("teacher:");
		teacherSubject.add(course[1]+"/"+c.getCouYearTerm());
	}
	courseNameString = new String[teacherSubject.size()];
	teacherNameString = new String[teacherSubject.size()];
	this.num = teacherSubject.size();
	for(int i = 0;i < teacherSubject.size();i++)
	{
		String[] ctName = teacherSubject.get(i).split("/");
		courseNameString[i] = ctName[1];
		teacherNameString[i] = ctName[0];
		System.out.println(courseNameString[i]+"   "+teacherNameString[i]);
	}
	courseNameBox = new JComboBox(courseNameString);
	courseNameBox.setBounds(500, 10, 200, 30);
	courseNameBox.setFont(font);
	commentPanel.add(courseNameBox);
	
	//课程名
	JLabel teacherName = new JLabel("授课教师:");
	teacherName.setBounds(50, 10, 100, 30);
	teacherName.setFont(font);
	commentPanel.add(teacherName);
	
	teacherNameField = new JTextField(teacherNameString[0]);
	teacherNameField.setBounds(150, 10, 200, 30);
	teacherNameField.setFont(font);
	teacherNameField.setEditable(false);
	teacherNameField.setBackground(bgColor);
	commentPanel.add(teacherNameField);
	//评价号
	JLabel commentNum = new JLabel("评价号");
	commentNum.setBounds(75, 50, 100, 30);
	commentNum.setFont(font);
	commentPanel.add(commentNum);
	//评价内容
	JLabel commentReason = new JLabel("评价内容");
	commentReason.setBounds(325, 50, 100, 30);
	commentReason.setFont(font);
	commentPanel.add(commentReason);
	//评价等级
	JLabel commentLevel = new JLabel("评价等级");
	commentLevel.setBounds(575, 50, 100, 30);
	commentLevel.setFont(font);
	commentPanel.add(commentLevel);
	
	JLabel[] commentNums = new JLabel[8];
	JTextField[] commentReasons = new JTextField[8];
	//课程名下拉菜单
	String[] commentLevelString = new String[]{"优秀","良好","及格","不及格","很差"};
	for(int i = 0;i<8;i++)
	{	
		commentNums[i] = new JLabel(String.valueOf(i+1));
		commentNums[i].setBounds(100, 100+40*i, 20, 30);
		commentNums[i].setFont(font);
		commentPanel.add(commentNums[i]);
		
		commentReasons[i] = new JTextField();
		commentReasons[i].setBounds(140, 100+40*i, 350, 30);
		commentReasons[i].setFont(font);
		commentPanel.add(commentReasons[i]);
		
		@SuppressWarnings({ })
		JComboBox commentLevelBox = new JComboBox(commentLevelString);
		commentLevelBox.setBounds(500, 100+40*i, 200, 30);
		commentLevelBox.setFont(font);
		commentPanel.add(commentLevelBox);
	}
	JButton commentButton = new JButton("提交");
	commentButton.setBounds(500, 450, 200, 30);
	commentButton.setBackground(bgColor);
	commentPanel.add(commentButton);
	
	frame.add(commentPanel);
	frame.setVisible(true);
	
	courseNameBox.addItemListener(new ItemListener(){

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if(e.getStateChange() == ItemEvent.SELECTED){
				for(int i = 0;i < num;i++)
				{
					if (courseNameBox.getSelectedItem().equals(courseNameString[i])) 
					{
						teacherNameField.setText(teacherNameString[i]);
					}
				}
			}
		}
		
	});
	}
	public static void main(String[] args) {
		new StudentCommentView().InitUI(null);
	}
}
