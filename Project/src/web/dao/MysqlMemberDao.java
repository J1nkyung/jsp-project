package web.dao;

import java.sql.*;

import javax.sql.DataSource;

import web.controls.Component;
import web.vo.Member;

@Component("MemberDao")
public class MysqlMemberDao{
	
	DataSource ds = null;
	
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	
	public Member exist(String id, String password) throws Exception{
		Connection connection = null;
		Member member = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		final String sqlExist = "SELECT mname,id FROM MEMBERS" + " WHERE id=? AND pwd=?";

		try {
			// 커넥션풀에서 Connection객체를 빌려온다
			connection = ds.getConnection();
			
			stmt = connection.prepareStatement(sqlExist);
			stmt.setString(1, id);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			if (rs.next()) {
				member = new Member().setMname(rs.getString("mname")).setId(rs.getString("id"));
			} else {
				return null;
			}
		} catch (Exception e) {
			throw e;

		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				if(connection != null)
					connection.close();// 다 썼으면 반납하자
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	return member;
	}
	
	
	
	public int memberJoin(Member member) throws Exception {
		Connection connection = null;
		int result = 0;
		PreparedStatement stmt = null;
		final String sqlInsert = "INSERT INTO members(id,email,pwd,mname, cre_date) VALUES(?,?,?,?,NOW())"; 
		
		try {
			connection = ds.getConnection();
			
			stmt = connection.prepareStatement(sqlInsert);
			stmt.setString(1, member.getId());
			stmt.setString(2, member.getEmail());
			stmt.setString(3, member.getPwd());
			stmt.setString(4, member.getMname());
			result = stmt.executeUpdate();
		}catch (Exception e) {
			throw e;
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if(connection != null)
					connection.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	

}

