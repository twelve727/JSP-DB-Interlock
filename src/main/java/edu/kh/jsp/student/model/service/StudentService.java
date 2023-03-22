package edu.kh.jsp.student.model.service;

import java.sql.Connection;
import java.util.List;

import static edu.kh.jsp.common.JDBCTemplate.*;

import edu.kh.jsp.student.model.dao.StudentDAO;
import edu.kh.jsp.student.model.vo.Student;

public class StudentService {

	private StudentDAO dao = new StudentDAO();
	
	public List<Student> selectAll() throws Exception {
	
//		Connection 생성
//		static .* 붙여주면 더 이상 JDBC 필요  XX
		Connection conn = getConnection();
		
		List<Student> stdList = dao.selectAll(conn);
		
//		트잭 처리
//		connection 반환
		close(conn);
		
		return stdList;
	}
}
