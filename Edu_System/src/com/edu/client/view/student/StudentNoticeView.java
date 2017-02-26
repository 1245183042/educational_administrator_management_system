package com.edu.client.view.student;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.edu.bean.Notice;

public class StudentNoticeView implements ActionListener{
	private JFrame frame;
	private int noticeNum;
	private Notice notice;
	private JTextArea  textArea;
	public void InitUI(){
		
	}
	public StudentNoticeView(int noticeNum, Notice n) {
		this.noticeNum = noticeNum;
		this.notice = n;
	}
	public StudentNoticeView() {
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		frame = new JFrame("公告详细内容");
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE );
		//窗口用户是否调整
		frame.setResizable(false);
		frame.setSize( 800, 600);
		//对控件施行绝对定位，必须让它不要使用任何布局方式（关键步骤）
		frame.setLayout(null);
		//设置窗口相对于指定组件的位置。 如果组件当前未显示，或者 c 为 null，则此窗口将置于屏幕的中央。
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		textArea = new JTextArea("发布时间:"+notice.getNoticeReleaseTime()+"\n\t\t"
		+notice.getNoticeTitle()+"\n\t"+notice.getNoticeContent()+"\n"+"作者:"+notice.getNoticeAuthor()
		+"\n公告编号:<"+noticeNum+">");
		textArea.setBounds(10, 10, 780, 580);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("宋体", Font.BOLD, 26));
		frame.add(textArea);
		
	}
	
}
