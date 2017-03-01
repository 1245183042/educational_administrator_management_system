package com.edu.client.view.student;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.edu.bean.Message;
import com.edu.bean.Score;

public class StudentScoreView {
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
	
	Color bgColor = new Color(245,245,245);
	//课程表
	JPanel scorePanel = new JPanel();
	scorePanel.setLayout(null);
	scorePanel.setBackground(bgColor);
	scorePanel.setSize(800,600);
	
	Font font = new Font("宋体", Font.BOLD, 16);
	
	//专业
	JLabel studentMIdLabel222= new JLabel("专业:"+message.getMajor().getMajorName());
	studentMIdLabel222.setBounds(500, 60, 220, 30);
	studentMIdLabel222.setFont(font);
	scorePanel.add(studentMIdLabel222);
	//姓名
	JLabel studentNameLabel222 = new JLabel("姓名:"+message.getStudent().getStudentName());
	studentNameLabel222.setBounds(300, 60, 200, 30);
	studentNameLabel222.setFont(font);
	scorePanel.add(studentNameLabel222);
	//学号
	JLabel studentIdLabel222 = new JLabel("学号:"+message.getStudent().getStudentId());
	studentIdLabel222.setBounds(50, 60, 200, 30);
	studentIdLabel222.setFont(font);
	scorePanel.add(studentIdLabel222);
	
	JLabel courseLabel = new JLabel("    序号"+"                  "+"课程"+"                       "+"老师"+"                 "+"成绩");
	courseLabel.setBounds(10, 100, 750, 30);
	courseLabel.setFont(font);
	courseLabel.setBackground(bgColor);
	scorePanel.add(courseLabel);
	List<String> scoreData = new ArrayList<String>();
	for(Score s : message.getScores())
	{
		scoreData.add(s.getScoScore()+":"+s.getScoTime().split(":")[0]+":"+s.getScoTime().split(":")[1]);
	}
	String[] scores = new String[scoreData.size()];
	for(int i = 0;i < scoreData.size();i++)
	{ 
		scores[i] = "  "+(i+1)+"                 "+scoreData.get(i).split(":")[1]+"               "+scoreData.get(i).split(":")[2]+"              "+scoreData.get(i).split(":")[0];
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JList courseList = new JList(scores);
	courseList.setFont(new Font("宋体",Font.BOLD,20));
	JScrollPane courseScrollPane = new JScrollPane(courseList);
	courseScrollPane.setBounds(10, 130, 800, 400);
	scorePanel.add(courseScrollPane);
	
	frame.add(scorePanel);
	frame.setVisible(true);
	}
	public static void main(String[] args) {
		new StudentScoreView().InitUI(null);
	}
}
