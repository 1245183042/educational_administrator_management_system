package com.edu.server.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.edu.bean.Administrator;
import com.edu.bean.Collage;
import com.edu.bean.Grade;
import com.edu.bean.Major;
import com.edu.bean.Message;
import com.edu.bean.Notice;
import com.edu.bean.Student;
import com.edu.bean.Subject;
import com.edu.bean.Teacher;
import com.edu.db.DBServer;
import com.edu.util.DateUtil;

public class EduDao {

	// 数据库连接池的别名
	private static final String POOLNAME = "proxool.edu_manage";

	public void method() {
		DBServer dbServer = new DBServer(POOLNAME);
		try {

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbServer.close();
		}
	}

	/**
	 * 根据接受者查询公告
	 * 
	 * @param target
	 * @return
	 */
	public Message getNotice(int target) {
		DBServer dbServer = new DBServer(POOLNAME);
		Message message = new Message();
		List<Notice> notices = new ArrayList<Notice>();
		try {
			HashMap<Integer, Object> params = new HashMap<Integer, Object>();
			params.put(1, target);
			ResultSet rs = dbServer.select("notice", "*",
					"where notice_target = ?", params);
			while (rs.next()) {
				Notice notice = new Notice();
				notice.setNoticeId(rs.getInt("notice_id"));
				notice.setNoticeTitle(rs.getString("notice_title"));
				notice.setNoticeContent(rs.getString("notice_content"));
				notice.setNoticeReleaseTime(rs.getString("notice_release_time"));
				notice.setNoticeAuthor(rs.getString("notice_author"));
				notice.setNoticeTarget(rs.getInt("notice_target"));
				notices.add(notice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbServer.close();
		}
		message.setNotices(notices);
		return message;
	}

	/**
	 * 根据科目名称获取科目信息
	 * 
	 * @param subjectName
	 * @return
	 */
	public Message getSubject(String subjectName) {
		DBServer dbServer = new DBServer(POOLNAME);
		Message message = new Message();
		Subject subject = new Subject();
		try {
			HashMap<Integer, Object> params = new HashMap<Integer, Object>();
			params.put(1, subjectName);
			ResultSet rs = dbServer.select("subject", "*",
					"where subject_name = ?", params);
			while (rs.next()) {
				subject.setSubjectId(rs.getInt("subject_id"));
				subject.setSubjectName(rs.getString("subject_name"));
				subject.setSubjectTime(rs.getInt("subject_time"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbServer.close();
		}
		message.setSubject(subject);
		return message;
	}

	/**
	 * 根据学号和密码获取学生信息
	 * 
	 * @param studentId
	 * @param studentPassword
	 * @return
	 */
	public Message getStudent(int studentId, String studentPassword) {
		DBServer dbServer = new DBServer(POOLNAME);
		Message message = new Message();
		Student student = new Student();
		Collage collage = new Collage();
		Major major = new Major();
		Grade grade = new Grade();
		try {
			HashMap<Integer, Object> params = new HashMap<Integer, Object>();
			int n = 1;
			params.put(n++, studentId);
			params.put(n++, studentPassword);
			ResultSet rs = dbServer
					.select("student,major,collage,grade",
							"*,major_name,collage_name,grade_year",
							"where student.stu_maj_id = major.major_id and major.maj_col_id = collage.collage_id and student.stu_gra_id = grade.grade_id and student_id = ? and student_password = ?",
							params);
			while (rs.next()) {
				student.setStudentId(rs.getInt("student_id"));
				student.setStudentName(rs.getString("student_name"));
				student.setStudentPassword(rs.getString("student_password"));
				student.setStudentAddress(rs.getString("student_address"));
				student.setStudentDormitory(rs.getString("student_dormitory"));
				student.setStudentPhone(rs.getString("student_phone"));
				student.setStudentGender(rs.getString("student_sex"));
				student.setStudentRace(rs.getString("student_race"));
				collage.setCollageName(rs.getString("collage_name"));
				major.setMajorName(rs.getString("major_name"));
				grade.setGradeYear(rs.getString("grade_year"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbServer.close();
		}
		message.setStudent(student);
		message.setCollage(collage);
		message.setGrade(grade);
		message.setMajor(major);
		return message;
	}

	/**
	 * 根据学号获取学生信息
	 * 
	 * @param studentId
	 * @return
	 */
	public Message getStudent(int studentId) {
		DBServer dbServer = new DBServer(POOLNAME);
		Message message = new Message();
		Student student = new Student();
		Collage collage = new Collage();
		Major major = new Major();
		Grade grade = new Grade();
		try {
			HashMap<Integer, Object> params = new HashMap<Integer, Object>();
			int n = 1;
			params.put(n++, studentId);
			ResultSet rs = dbServer
					.select("student,major,collage,grade",
							"*,major_name,collage_name,grade_year",
							"where student.stu_maj_id = major.major_id and major.maj_col_id = collage.collage_id and student.stu_gra_id = grade.grade_id and student_id = ?",
							params);
			while (rs.next()) {
				student.setStudentId(rs.getInt("student_id"));
				student.setStudentName(rs.getString("student_name"));
				student.setStudentPassword(rs.getString("student_password"));
				student.setStudentAddress(rs.getString("student_address"));
				student.setStudentDormitory(rs.getString("student_dormitory"));
				student.setStudentPhone(rs.getString("student_phone"));
				student.setStudentGender(rs.getString("student_sex"));
				student.setStudentRace(rs.getString("student_race"));
				collage.setCollageName(rs.getString("collage_name"));
				major.setMajorName(rs.getString("major_name"));
				grade.setGradeYear(rs.getString("grade_year"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbServer.close();
		}
		message.setStudent(student);
		message.setCollage(collage);
		message.setGrade(grade);
		message.setMajor(major);
		return message;
	}

	/**
	 * 根据学院、专业、年级、班级查询一个班的学生
	 */
	public List<Message> getStudents(Message message) {
		DBServer dbServer = new DBServer(POOLNAME);
		List<Message> messages = new ArrayList<Message>();
		try {
			HashMap<Integer, Object> params = new HashMap<Integer, Object>();
			int n = 1;
			params.put(n++, message.getCollage().getCollageName());// 院系
			params.put(n++, message.getMajor().getMajorName());// 专业
			params.put(n++, message.getGrade().getGradeYear());// 年级
			params.put(n++, message.getStudent().getStuClass());// 班级
			ResultSet rs = dbServer
					.select("student,major,collage,grade",
							"*,major_name,collage_name,grade_year",
							"where student.stu_maj_id = major.major_id and major.maj_col_id = collage.collage_id and student.stu_gra_id = grade.grade_id and collage_name = ? and major_name = ? and grade_year = ? and stu_class = ?",
							params);
			while (rs.next()) {
				Message getMes = new Message();
				Student student = new Student();
				Collage collage = new Collage();
				Major major = new Major();
				Grade grade = new Grade();
				student.setStudentId(rs.getInt("student_id"));
				student.setStudentName(rs.getString("student_name"));
				student.setStudentPassword(rs.getString("student_password"));
				student.setStudentAddress(rs.getString("student_address"));
				student.setStudentDormitory(rs.getString("student_dormitory"));
				student.setStudentPhone(rs.getString("student_phone"));
				student.setStudentGender(rs.getString("student_sex"));
				student.setStudentRace(rs.getString("student_race"));
				collage.setCollageName(rs.getString("collage_name"));
				major.setMajorName(rs.getString("major_name"));
				grade.setGradeYear(rs.getString("grade_year"));
				getMes.setStudent(student);
				getMes.setCollage(collage);
				getMes.setGrade(grade);
				getMes.setMajor(major);
				messages.add(getMes);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbServer.close();
		}
		return messages;
	}

	/**
	 * 根据学院名称获取教师信息
	 * 
	 * @param collage
	 * @return
	 */
	public List<Message> getTeachers(String collageName) {
		DBServer dbServer = new DBServer(POOLNAME);
		List<Message> messages = new ArrayList<Message>();
		try {
			HashMap<Integer, Object> params = new HashMap<Integer, Object>();
			int n = 1;
			params.put(n++, collageName);// 院系
			ResultSet rs = dbServer
					.select("teacher,collage",
							"*,collage_name",
							"where teacher.tea_col_id = collage.collage_id and collage_name = ?",
							params);
			while (rs.next()) {
				Message getMes = new Message();
				Teacher teacher = new Teacher();
				Collage getCol = new Collage();
				teacher.setTeacherId(rs.getInt("teacher_id"));
				teacher.setTeacherName(rs.getString("teacher_name"));
				teacher.setTeacherPassword(rs.getString("teacher_password"));
				teacher.setTeacherTitle(rs.getString("teacher_title"));
				teacher.setTeacherAddress(rs.getString("teacher_address"));
				teacher.setTeacherGender(rs.getString("teacher_gender"));
				teacher.setTeacherPhone(rs.getString("teacher_phone"));
				teacher.setTeacherRace(rs.getString("teacher_race"));
				getCol.setCollageName(rs.getString("collage_name"));
				getMes.setTeacher(teacher);
				getMes.setCollage(getCol);
				messages.add(getMes);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbServer.close();
		}
		return messages;
	}

	/**
	 * 根据账号和密码获取教师信息
	 * 
	 * @param teacherId
	 * @param teacherPassword
	 * @return
	 */
	public Message getTeacher(int teacherId, String teacherPassword) {
		DBServer dbServer = new DBServer(POOLNAME);
		Message message = new Message();
		Teacher teacher = new Teacher();
		Collage collage = new Collage();
		try {
			HashMap<Integer, Object> params = new HashMap<Integer, Object>();
			int n = 1;
			params.put(n++, teacherId);
			params.put(n++, teacherPassword);
			ResultSet rs = dbServer
					.select("teacher,collage",
							"*,collage_name",
							"where teacher.tea_col_id = collage.collage_id and teacher_id = ? and teacher_password = ?",
							params);
			while (rs.next()) {
				teacher.setTeacherId(rs.getInt("teacher_id"));
				teacher.setTeacherName(rs.getString("teacher_name"));
				teacher.setTeacherPassword(rs.getString("teacher_password"));
				teacher.setTeacherTitle(rs.getString("teacher_title"));
				teacher.setTeacherAddress(rs.getString("teacher_address"));
				teacher.setTeacherGender(rs.getString("teacher_gender"));
				teacher.setTeacherPhone(rs.getString("teacher_phone"));
				teacher.setTeacherRace(rs.getString("teacher_race"));
				collage.setCollageName(rs.getString("collage_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbServer.close();
		}
		message.setTeacher(teacher);
		message.setCollage(collage);
		return message;
	}

	/**
	 * 添加一个教师
	 * 
	 * @param teacher
	 */
	public void addTeacher(Teacher teacher) {
		DBServer dbServer = new DBServer(POOLNAME);
		try {
			HashMap<Integer, Object> params = new HashMap<Integer, Object>();
			int n = 1;
			params.put(n++, teacher.getTeacherName());
			params.put(n++, teacher.getTeacherPassword());
			params.put(n++, teacher.getTeacherAddress());
			params.put(n++, teacher.getTeacherGender());
			params.put(n++, teacher.getTeacherPhone());
			params.put(n++, teacher.getTeacherRace());
			params.put(n++, teacher.getTeacherTitle());
			params.put(n++, teacher.getTeaColId());
			int record = dbServer
					.insert("teacher",
							"teacher_name,teacher_password,teacher_address,teacher_gender,teacher_phone,teacher_race,teacher_title,tea_col_id",
							params);
			System.out.println(record);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbServer.close();
		}
	}

	/**
	 * 添加一门课
	 * 
	 * @param teacher
	 */
	public void addSubject(Subject subject) {
		DBServer dbServer = new DBServer(POOLNAME);
		try {
			HashMap<Integer, Object> params = new HashMap<Integer, Object>();
			int n = 1;
			params.put(n++, subject.getSubjectName());
			params.put(n++, subject.getSubjectTime());
			int record = dbServer.insert("subject",
					"subject_name,subject_time", params);
			System.out.println(record);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbServer.close();
		}
	}

	/**
	 * 根据账号获取教师信息
	 * 
	 * @param teacherId
	 * @return
	 */
	public Message getTeacher(int teacherId) {
		DBServer dbServer = new DBServer(POOLNAME);
		Message message = new Message();
		Teacher teacher = new Teacher();
		Collage collage = new Collage();
		try {
			HashMap<Integer, Object> params = new HashMap<Integer, Object>();
			int n = 1;
			params.put(n++, teacherId);
			ResultSet rs = dbServer
					.select("teacher,collage",
							"*,collage_name",
							"where teacher.tea_col_id = collage.collage_id and teacher_id = ?",
							params);
			while (rs.next()) {
				teacher.setTeacherId(rs.getInt("teacher_id"));
				teacher.setTeacherName(rs.getString("teacher_name"));
				teacher.setTeacherPassword(rs.getString("teacher_password"));
				teacher.setTeacherTitle(rs.getString("teacher_title"));
				teacher.setTeacherAddress(rs.getString("teacher_address"));
				teacher.setTeacherGender(rs.getString("teacher_gender"));
				teacher.setTeacherPhone(rs.getString("teacher_phone"));
				teacher.setTeacherRace(rs.getString("teacher_race"));
				collage.setCollageName(rs.getString("collage_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbServer.close();
		}
		message.setTeacher(teacher);
		message.setCollage(collage);
		return message;
	}

	/**
	 * 根据工号和密码获取管理员信息
	 * 
	 * @param adminName
	 * @param adminPassword
	 * @return
	 */
	public Message getAdmin(int adminName, String adminPassword) {
		DBServer dbServer = new DBServer(POOLNAME);
		Message message = new Message();
		Administrator admin = new Administrator();
		try {
			HashMap<Integer, Object> params = new HashMap<Integer, Object>();
			int n = 1;
			params.put(n++, adminName);
			params.put(n++, adminPassword);
			ResultSet rs = dbServer.select("administrator", "*",
					"where admin_name = ? and admin_password = ?", params);
			while (rs.next()) {
				admin.setAdminId(rs.getInt("admin_id"));
				admin.setAdminName(rs.getInt("admin_name") + "");
				admin.setAdminPassword(rs.getString("admin_password"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbServer.close();
		}
		message.setAdmin(admin);
		return message;
	}

	/**
	 * 删除一条公告
	 * 
	 * @param noticeId
	 */
	public void deleteNotice(int noticeId) {
		DBServer dbServer = new DBServer(POOLNAME);
		try {
			HashMap<Integer, Object> params = new HashMap<>();
			params.put(1, noticeId);
			int record = dbServer.delete("notice", "where notice_id = ?",
					params);
			System.out.println(record);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbServer.close();
		}
	}

	/**
	 * 删除一个学生
	 * 
	 * @param teacherId
	 */
	public void deleteStudent(int studentId) {
		DBServer dbServer = new DBServer(POOLNAME);
		try {
			HashMap<Integer, Object> params = new HashMap<>();
			params.put(1, studentId);
			int record = dbServer.delete("student", "where student_id = ?",
					params);
			System.out.println(record);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbServer.close();
		}
	}

	/**
	 * 删除学生
	 * 
	 * @param teacherId
	 */
	public void deleteTeacher(int teacherId) {
		DBServer dbServer = new DBServer(POOLNAME);
		try {
			HashMap<Integer, Object> params = new HashMap<>();
			params.put(1, teacherId);
			int record = dbServer.delete("teacher", "where teacher_id = ?",
					params);
			System.out.println(record);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbServer.close();
		}
	}

	/**
	 * 删除一门科目
	 * 
	 * @param subjectId
	 */
	public void deleteSubject(int subjectId) {
		DBServer dbServer = new DBServer(POOLNAME);
		try {
			HashMap<Integer, Object> params = new HashMap<>();
			params.put(1, subjectId);
			int record = dbServer.delete("subject", "where subject_id = ?",
					params);
			System.out.println(record);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbServer.close();
		}
	}

	/**
	 * 添加一条公告
	 * 
	 * @param notice
	 */
	public void addNotice(Notice notice) {
		DBServer dbServer = new DBServer(POOLNAME);
		try {
			HashMap<Integer, Object> params = new HashMap<Integer, Object>();
			int n = 1;
			params.put(n++, notice.getNoticeTitle());
			params.put(n++, notice.getNoticeContent());
			params.put(n++, notice.getNoticeReleaseTime());
			params.put(n++, notice.getNoticeTarget());
			params.put(n++, notice.getNoticeAuthor());
			int record = dbServer
					.insert("notice",
							"notice_title,notice_content,notice_release_time,notice_target,notice_author",
							params);
			System.out.println(record);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbServer.close();
		}
	}

	/**
	 * 添加加一个学生
	 * 
	 * @param student
	 */
	public void addStudent(Student student) {
		DBServer dbServer = new DBServer(POOLNAME);
		try {
			HashMap<Integer, Object> params = new HashMap<Integer, Object>();
			int n = 1;
			params.put(n++, student.getStudentName());
			params.put(n++, student.getStudentPassword());
			params.put(n++, student.getStudentAddress());
			params.put(n++, student.getStudentDormitory());
			params.put(n++, student.getStudentGender());
			params.put(n++, student.getStudentRace());
			params.put(n++, student.getStudentPhone());
			params.put(n++, student.getStuClass());
			params.put(n++, student.getStuMajId());
			params.put(n++, student.getStuGraId());
			int record = dbServer
					.insert("student",
							"student_name,student_password,student_address,student_dormitory,student_sex,student_race,student_phone,stu_class,stu_maj_id,stu_gra_id",
							params);
			System.out.println(record);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbServer.close();
		}
	}

	/**
	 * 修改一条公告
	 * 
	 * @param notice
	 */
	public void alterNotice(Notice notice) {
		DBServer dbServer = new DBServer(POOLNAME);
		try {
			HashMap<Integer, Object> params = new HashMap<>();
			int n = 1;
			params.put(n++, notice.getNoticeTitle());
			params.put(n++, notice.getNoticeContent());
			params.put(n++, notice.getNoticeReleaseTime());
			params.put(n++, notice.getNoticeTarget());
			params.put(n++, notice.getNoticeAuthor());
			params.put(n++, notice.getNoticeId());
			int record = dbServer
					.update("notice",
							"notice_title,notice_content,notice_release_time,notice_target,notice_author",
							"where notice_id = ?", params);
			System.out.println(record);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbServer.close();
		}
	}

	/**
	 * 修改一门课
	 * 
	 * @param notice
	 */
	public void alterSubject(Subject subject) {
		DBServer dbServer = new DBServer(POOLNAME);
		try {
			HashMap<Integer, Object> params = new HashMap<>();
			int n = 1;
			params.put(n++, subject.getSubjectName());
			params.put(n++, subject.getSubjectTime());
			params.put(n++, subject.getSubjectId());
			int record = dbServer
					.update("subject", "subject_name,subject_time",
							"where subject_id = ?", params);
			System.out.println(record);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbServer.close();
		}
	}

	/**
	 * 修改学生信息
	 * 
	 * @param student
	 */
	public void alterStudent(Student student) {
		DBServer dbServer = new DBServer(POOLNAME);
		try {
			HashMap<Integer, Object> params = new HashMap<>();
			int n = 1;
			params.put(n++, student.getStudentName());
			params.put(n++, student.getStudentPassword());
			params.put(n++, student.getStudentAddress());
			params.put(n++, student.getStudentDormitory());
			params.put(n++, student.getStudentGender());
			params.put(n++, student.getStudentRace());
			params.put(n++, student.getStudentPhone());
			params.put(n++, student.getStuClass());
			params.put(n++, student.getStuMajId());
			params.put(n++, student.getStuGraId());
			params.put(n++, student.getStudentId());
			int record = dbServer
					.update("student",
							"student_name,student_password,student_address,student_dormitory,student_sex,student_race,student_phone,stu_class,stu_maj_id,stu_gra_id",
							"where student_id = ?", params);
			System.out.println(record);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbServer.close();
		}
	}

	/**
	 * 修改教师信息
	 * 
	 * @param teacher
	 */
	public void alterTeacher(Teacher teacher) {
		DBServer dbServer = new DBServer(POOLNAME);
		try {
			HashMap<Integer, Object> params = new HashMap<Integer, Object>();
			int n = 1;
			params.put(n++, teacher.getTeacherName());
			params.put(n++, teacher.getTeacherPassword());
			params.put(n++, teacher.getTeacherAddress());
			params.put(n++, teacher.getTeacherGender());
			params.put(n++, teacher.getTeacherPhone());
			params.put(n++, teacher.getTeacherRace());
			params.put(n++, teacher.getTeacherTitle());
			params.put(n++, teacher.getTeaColId());
			params.put(n++, teacher.getTeacherId());
			int record = dbServer
					.update("teacher",
							"teacher_name,teacher_password,teacher_address,teacher_gender,teacher_phone,teacher_race,teacher_title,tea_col_id",
							"where teacher_id = ?", params);
			System.out.println(record);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbServer.close();
		}
	}
	
	

	public static void main(String[] args) {
		EduDao dao = new EduDao();
		Message message = null;
		// message = dao.getTeacher(1, "1");
		message = dao.getStudent(1);
		// System.out.println(message.getStudent().getStudentName());
		// System.out.println(message.getCollage().getCollageName());
		Notice notice = new Notice(0, "2", "2", DateUtil.getTime(), 0, "1");
		// dao.alterNotice(notice);
		dao.addNotice(notice);
		message = new Message();
		Collage collage = new Collage();
		collage.setCollageName("信息科学技术学院");
		message.setCollage(collage);
		Major major = new Major();
		major.setMajorName("计算机科学与技术");
		message.setMajor(major);
		Grade grade = new Grade();
		grade.setGradeYear("2014");
		Student student = new Student(1316, "6", "1", "", "", "", 1, 1, 2, "1",
				"1");
		dao.alterStudent(student);
		// student.setStuClass(2);
		// message.setGrade(grade);
		// message.setStudent(student);
		// List<Message> messages = dao.getStudents(message);
		// for (Message m : messages) {
		// System.out.println(m.getStudent().getStudentName());
		// }
		// dao.deleteStudent(1317);
		Teacher teacher = new Teacher(4, "11", "1", "1", "1", "1", 1, "1", "1");
		dao.deleteTeacher(4);
		// teacher.setTeacherId(1);
		// System.out.println(dao.getTeacher(1).getTeacher().getTeacherName());
		// List<Message> messages = dao.getTeachers("信息科学技术学院");
		// for (Message m : messages) {
		// System.out.println(m.getTeacher().getTeacherName());
		// }
		message = dao.getSubject("离散数学");
		System.out.println(message.getSubject().getSubjectTime());
		Subject subject = new Subject(14, "sdkjkjkjlfdf", 48);
		//dao.addSubject(subject);
		//dao.deleteSubject(13);
		dao.alterSubject(subject);
	}

}
