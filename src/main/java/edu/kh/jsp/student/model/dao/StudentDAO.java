package edu.kh.jsp.student.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static edu.kh.jsp.common.JDBCTemplate.*;

import edu.kh.jsp.student.model.vo.Student;

public class StudentDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public StudentDAO() {
		try {
			String filePath 
			= StudentDAO.class.getResource("/edu/kh/jsp/sql/student-sql.xml").getPath();
			
			prop = new Properties();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param conn
	 * @return
	 */
	public List<Student> selectAll(Connection conn) throws Exception {
		
//		결과 저장용 변수 선언
		List<Student> stdList = new ArrayList<>();
		
//		try 에서 SQL 작성하기
//	    studen-sql의 <entry> 태그 안에 있는걸 가져오는 개념
		try {
		
			String sql = prop.getProperty("selectAll");
		
//		Statement 객체 생성
			stmt = conn.createStatement();
//	    Statement 버스태워 보냄, Query인 이유? 조회여서
			
//		SQL 수행 했으니 결과(resultset) 반환 받기
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				String studentNo = rs.getString("STUDENT_NO");
				String studentName = rs.getString("STUDENT_NAME");
				String studentAddress = rs.getString("STUDENT_ADDRESS");
				String departmentName = rs.getString("DEPARTMENT_NAME");
				
				stdList.add(
						new Student(studentNo, studentName, studentAddress, departmentName)
						);
			}
			
			
		} finally {
//		finally 이유 ? 사용한 JDBC 객체 자원 반환
			
			close(rs);
			close(stmt);
		}
		
//		return 이유 ? 결과값 반환
		return stdList;
	
	}
}
