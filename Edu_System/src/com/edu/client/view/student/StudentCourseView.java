package com.edu.client.view.student;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.edu.bean.Course;
import com.edu.bean.Message;

public class StudentCourseView{
	private JFrame frame;
	
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
	
	
	//课程表
	JPanel coursePanel = new JPanel();
	coursePanel.setLayout(null);
	coursePanel.setSize(800,600);
	
	Font font = new Font("宋体", Font.BOLD, 18);
	Font font2 = new Font("宋体",Font.BOLD,11);

	
	JLabel morning = new JLabel("上午");
	morning.setBounds(10, 150, 50, 30);
	morning.setFont(font);
	coursePanel.add(morning);
	JLabel afternone = new JLabel("下午");
	afternone.setBounds(10, 250, 50, 30);
	afternone.setFont(font);
	coursePanel.add(afternone);
	JLabel late = new JLabel("晚上");
	late.setBounds(10, 350, 50, 30);
	late.setFont(font);
	coursePanel.add(late);
	JLabel morning1 = new JLabel("1、2节");
	morning1.setBounds(50, 125, 60, 30);
	morning1.setFont(font);
	coursePanel.add(morning1);
	JLabel afternone1 = new JLabel("5、6节");
	afternone1.setBounds(50, 225, 60, 30);
	afternone1.setFont(font);
	coursePanel.add(afternone1);
	JLabel late1 = new JLabel("9、10节");
	late1.setBounds(40, 325, 70, 30);
	late1.setFont(font);
	coursePanel.add(late1);
	JLabel morning2 = new JLabel("3、4节");
	morning2.setBounds(50, 175, 60, 30);
	morning2.setFont(font);
	coursePanel.add(morning2);
	JLabel afternone2 = new JLabel("7、8节");
	afternone2.setBounds(50, 275, 60, 30);
	afternone2.setFont(font);
	coursePanel.add(afternone2);
	JLabel late2 = new JLabel("11、12节");
	late2.setBounds(30, 375, 80, 30);
	late2.setFont(font);
	coursePanel.add(late2);
	JLabel day1 = new JLabel("星期一");
	day1.setBounds(150, 80, 80, 30);
	day1.setFont(font);
	coursePanel.add(day1);
	JLabel day2 = new JLabel("星期二");
	day2.setBounds(230, 80, 80, 30);
	day2.setFont(font);
	coursePanel.add(day2);
	JLabel day3 = new JLabel("星期三");
	day3.setBounds(310, 80, 80, 30);
	day3.setFont(font);
	coursePanel.add(day3);
	JLabel day4 = new JLabel("星期四");
	day4.setBounds(390, 80, 80, 30);
	day4.setFont(font);
	coursePanel.add(day4);
	JLabel day5 = new JLabel("星期五");
	day5.setBounds(480, 80, 80, 30);
	day5.setFont(font);
	coursePanel.add(day5);
	JLabel day6 = new JLabel("星期六");
	day6.setBounds(560, 80, 80, 30);
	day6.setFont(font);
	coursePanel.add(day6);
	JLabel day7 = new JLabel("星期日");
	day7.setBounds(640, 80, 80, 30);
	day7.setFont(font);
	coursePanel.add(day7);
	JTextArea[] courseTextArea = new JTextArea[42];
	for(int i = 0;i < 7;i++)
	{
		for(int j = 0;j < 6;j++)
		{
			//课程文本
			if(message.getCourses() != null)
			{
				for(Course c : message.getCourses())
				{	
					if(c.getCouCpId() == (6*i+j+1))
					{
					String[] course = c.getCouClassroom().split("teacher:");
					courseTextArea[6*i+j] = new JTextArea(course[0]+" "+course[1]+" "+c.getCouWeek()+" "+c.getCouYearTerm());
					courseTextArea[6*i+j].setBounds(150+82*i, 115+52*j, 70, 40);
					courseTextArea[6*i+j].setFont(font2);
					courseTextArea[6*i+j].setBackground(new Color(238,238,238));
					courseTextArea[6*i+j].setEditable(false);
					courseTextArea[6*i+j].setLineWrap(true);
					coursePanel.add(courseTextArea[6*i+j]);
					}
				}
			}
		}
	}
	frame.add(coursePanel);
	frame.setVisible(true);
	}
	
}
