package com.edu.bean;

import java.io.Serializable;
import java.util.List;

public class Message implements Serializable {

	private static final long serialVersionUID = -7152824057168642835L;

	private String identify;	//用户标志
	private String operationCode;	//业务代码
	private Administrator admin;
	private Student student;
	private Teacher teacher;
	private Collage collage;
	private Comment comment;
	private Course course;
	private CoursePosition coursePosition;
	private Elective elective;
	private Grade grade;
	private Major major;
	private Notice notice;
	private Score score;
	private Subject subject;
	private List<Notice> notices;

	public List<Notice> getNotices() {
		return notices;
	}

	public void setNotices(List<Notice> notices) {
		this.notices = notices;
	}

	public Message() {
	}

	public Message(String identify, String operationCode, Administrator admin) {
		super();
		this.identify = identify;
		this.operationCode = operationCode;
		this.admin = admin;
	}

	public Message(String identify, String operationCode, Student student) {
		super();
		this.identify = identify;
		this.operationCode = operationCode;
		this.student = student;
	}
	
	public Message(String identify, String operationCode, Teacher teacher) {
		super();
		this.identify = identify;
		this.operationCode = operationCode;
		this.teacher = teacher;
	}

	public String getIdentify() {
		return identify;
	}

	public void setIdentify(String identify) {
		this.identify = identify;
	}

	public String getOperationCode() {
		return operationCode;
	}

	public void setOperationCode(String operationCode) {
		this.operationCode = operationCode;
	}

	public Administrator getAdmin() {
		return admin;
	}

	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Collage getCollage() {
		return collage;
	}

	public void setCollage(Collage collage) {
		this.collage = collage;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public CoursePosition getCoursePosition() {
		return coursePosition;
	}

	public void setCoursePosition(CoursePosition coursePosition) {
		this.coursePosition = coursePosition;
	}

	public Elective getElective() {
		return elective;
	}

	public void setElective(Elective elective) {
		this.elective = elective;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

}
