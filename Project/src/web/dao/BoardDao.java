package web.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import web.vo.Board;

public class BoardDao {
	DataSource ds = null;
	
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	public List<Board> selectList(int blno) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		final String sqlSelect = "SELECT blno, cno, title, id, reg_date, view_count FROM Board WHERE blno=? ORDER BY cno ASC"; 

		try {
			// 커넥션풀에서 Connection객체를 빌려온다
			connection = ds.getConnection();

			stmt = connection.prepareStatement(sqlSelect);
			stmt.setInt(1, blno);
			rs = stmt.executeQuery();
			
			ArrayList<Board> list = new ArrayList<Board>();

			while (rs.next()) {
				list.add(new Board().setCno(rs.getInt("cno"))
						.setTitle(rs.getString("title"))
						.setBlno(rs.getInt("blno"))
						.setId(rs.getString("id"))
						.setRegDate(rs.getDate("reg_date"))
						.setViewCount(rs.getInt("view_count")));
//				for(Board b : list) {
//					System.out.println(b.getTitle());
//				}
			}
			
			return list;

		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null)
					stmt.close();
			}	catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if(connection != null)
					connection.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
		
		}
	}
	
	public Board showContents(int cno) throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		Board board = null;
		final String sqlSelect = "SELECT cno, title, img,contents, id, reg_date, view_count FROM Board WHERE cno=" + cno; 
		
		try {
			connection = ds.getConnection();

			stmt = connection.createStatement();
			rs = stmt.executeQuery(sqlSelect);
			if(rs.next()) {
				board = new Board().setCno(rs.getInt("cno"))
						.setTitle(rs.getString("title"))
						.setImage(rs.getString("img"))
						.setContents(rs.getString("contents"))
						.setId(rs.getString("id"))
						.setRegDate(rs.getDate("reg_date"))
						.setViewCount(rs.getInt("view_count"));
			}
			
			return board;

		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
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
	}
	
	public void updateVC(int cno) throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		int result = 0;
		Board board = null;
		final String sqlUpdate = "UPDATE board SET view_count = view_count+1" + " WHERE cno=?";
		try {
			connection = ds.getConnection();

			pstmt = connection.prepareStatement(sqlUpdate);
			pstmt.setInt(1, cno);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
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

		
	}
	
	public void insertWrite(Board board) throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		final String sqlUpdate = "INSERT INTO board (blno, id, title, contents, img, view_count) VALUES (?,?,?,?,?,?)";
		try {

			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sqlUpdate);
			pstmt.setInt(1, board.getBlno());
			pstmt.setString(2, board.getId());
			pstmt.setString(3, board.getTitle());
			pstmt.setString(4, board.getContents());
			pstmt.setString(5, board.getImage());
			pstmt.setInt(6, 0);
			pstmt.executeUpdate();
					
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
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

	}
	
	
	public void deleteOne(int cno,int blno) throws Exception {
		Connection connection = null;
		Statement stmt = null;
		final String sqlDelete = "DELETE FROM board WHERE cno=" + cno;
		
		try {
			connection = ds.getConnection();
			stmt = connection.createStatement();
			stmt.executeUpdate(sqlDelete);
					
		} catch (Exception e) {
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
	}
		
		public  List<Board> selectPopularList() throws Exception {
			Connection connection = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			final String sqlSelect = "SELECT cno, title, blno, id, view_count, reg_date" + "\r\n" +
									 "FROM board\r\n" + "\r\n" + 
									 "WHERE blno = 2 OR blno = 3 OR blno = 4" + "\r\n" +
									 "ORDER BY view_count DESC limit 5"; //최상위 글 5개만 출력이 가능하게 설정해 놓음  

			try {
				// 커넥션풀에서 Connection객체를 빌려온다
				connection = ds.getConnection();

				stmt = connection.prepareStatement(sqlSelect);
				rs = stmt.executeQuery();
				
				ArrayList<Board> list = new ArrayList<Board>();

				while (rs.next()) {
					list.add(new Board().setCno(rs.getInt("cno"))
							.setTitle(rs.getString("title"))
							.setBlno(rs.getInt("blno"))
							.setId(rs.getString("id"))
							.setViewCount(rs.getInt("view_count"))
							.setRegDate(rs.getDate("reg_date")));

				}
				
				return list;
				
			} catch (Exception e) {
				throw e;
			} finally {
				try {
					if (rs != null)
						rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					if (stmt != null)
						stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					if (connection != null)
						connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		public  List<Board> selectNotice() throws Exception {
			Connection connection = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			final String sqlSelect = "SELECT cno, title, blno, id, view_count, reg_date" + "\r\n" +
									 "FROM board\r\n" + "\r\n" + 
									 "WHERE blno = 1" + "\r\n" +
									 "ORDER BY reg_date DESC limit 5"; //최상위 글 5개만 출력이 가능하게 설정해 놓음  

			try {
				connection = ds.getConnection();

				stmt = connection.prepareStatement(sqlSelect);
				rs = stmt.executeQuery();
				
				ArrayList<Board> list = new ArrayList<Board>();

				while (rs.next()) {
					list.add(new Board().setCno(rs.getInt("cno"))
							.setTitle(rs.getString("title"))
							.setBlno(rs.getInt("blno"))
							.setId(rs.getString("id"))
							.setViewCount(rs.getInt("view_count"))
							.setRegDate(rs.getDate("reg_date")));

				}
				
				return list;
				
			} catch (Exception e) {
				throw e;
			} finally {
				try {
					if (rs != null)
						rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					if (stmt != null)
						stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					if (connection != null)
						connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
		
		
		public void update(Board board) throws Exception {
			Connection connection = null;
			PreparedStatement stmt = null;
			int result = 0;
			final String sqlUpdate = "UPDATE BOARD SET title=?, contents=? WHERE id=? AND cno=?";

			try {

				connection = ds.getConnection();
				stmt = connection.prepareStatement(sqlUpdate);
				stmt.setString(1, board.getTitle());
				stmt.setString(2, board.getContents());
				stmt.setString(3, board.getId());
				stmt.setInt(4, board.getCno());
				result = stmt.executeUpdate();

			} catch (Exception e) {
				throw e;
			} finally {
				try {
					if (stmt != null)
						stmt.close();
				} catch (Exception e) {
				}

				try {
					if (connection != null)
						connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		
		
		public void insertComment(Board board) throws Exception {
			Connection connection = null;
			PreparedStatement stmt = null;
			int result = 0;
			final String sqlUpdate = "INSERT INTO comment (cno, id, comments) VALUES (?,?,?)";

			try {

				connection = ds.getConnection();
				stmt = connection.prepareStatement(sqlUpdate);
				stmt.setInt(1, board.getCno());
				stmt.setString(2, board.getId());
				stmt.setString(3, board.getComment());
				result = stmt.executeUpdate();

			} catch (Exception e) {
				throw e;
			} finally {
				try {
					if (stmt != null)
						stmt.close();
				} catch (Exception e) {
				}

				try {
					if (connection != null)
						connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		
	//댓글 입력 삭제 수정 시작 	
		public List<Board> selectComment(int cno) throws Exception {
			Connection connection = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			final String sqlSelect = "SELECT comno, cno, id, comments, comreg_date FROM comment WHERE cno=? ORDER BY comreg_date ASC;"; 

			try {
				connection = ds.getConnection();

				stmt = connection.prepareStatement(sqlSelect);
				stmt.setInt(1, cno);
				rs = stmt.executeQuery();
				
				ArrayList<Board> list = new ArrayList<Board>();

				while (rs.next()) {
					list.add(new Board().setComno(rs.getInt("comno"))
							.setCno(rs.getInt("cno"))
							.setId(rs.getString("id"))
							.setComment(rs.getString("comments"))
							.setComregDate(rs.getDate("comreg_date")));

				}
				
				return list;

			} catch (Exception e) {
				throw e;
			} finally {
				try {
					if (rs != null)
						rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					if (stmt != null)
						stmt.close();
				}	catch (Exception e) {
					e.printStackTrace();
				}
				try {
					if(connection != null)
						connection.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		
		public void deleteComment(int comno) throws Exception {
			Connection connection = null;
			Statement stmt = null;
			final String sqlDelete = "DELETE FROM comment WHERE comno=" + comno;
			
			try {
				connection = ds.getConnection();
				stmt = connection.createStatement();
				stmt.executeUpdate(sqlDelete);
						
			} catch (Exception e) {
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
		}
		
		
		public void updateComment(Board board) throws Exception {
			Connection connection = null;
			PreparedStatement stmt = null;
			int result = 0;
			final String sqlUpdate = "UPDATE comment SET comments=? WHERE comno=?";

			try {

				connection = ds.getConnection();
				stmt = connection.prepareStatement(sqlUpdate);
				stmt.setString(1, board.getComment());
				stmt.setInt(2, board.getComno());
				result = stmt.executeUpdate();

			} catch (Exception e) {
				throw e;
			} finally {
				try {
					if (stmt != null)
						stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					if (connection != null)
						connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		
		// 페이징 시작 번호, 끝번호, 게시판 번호 
		public List<Board> getList(int start, int end, int blno) throws Exception {
			Connection connection = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			final String sqlSelect = "SELECT * FROM Board WHERE blno=? ORDER BY reg_date DESC LIMIT "
										+ start + ", " + end; 
			
			try {
				connection = ds.getConnection();
				
				stmt = connection.prepareStatement(sqlSelect);
				stmt.setInt(1, blno);
				rs = stmt.executeQuery();
				
				ArrayList<Board> list = new ArrayList<Board>();
				
				while (rs.next()) {
					list.add(new Board().setCno(rs.getInt("cno"))
							.setTitle(rs.getString("title"))
							.setBlno(rs.getInt("blno"))
							.setId(rs.getString("id"))
							.setRegDate(rs.getDate("reg_date"))
							.setViewCount(rs.getInt("view_count")));
//					}
				}
				
				return list;
				
			} catch (Exception e) {
				throw e;
			} finally {
				try {
					if (rs != null)
						rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					if (stmt != null)
						stmt.close();
				}	catch (Exception e) {
					e.printStackTrace();
				}
				try {
					if (connection != null)
						connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		public int getTotalCount(int blno) throws Exception {
			Connection connection = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT count(*) FROM board WHERE blno=" + blno;
			    int total = 0;
			    
			    try {
			    	connection = ds.getConnection();
			    	pstmt = connection.prepareStatement(sql);
			    	rs = pstmt.executeQuery();
			      
			      if(rs.next()){
			        total = rs.getInt(1);
			      }
			      
			      
			    } catch (Exception e) {
					throw e;
				} finally {
					try {
						if (rs != null)
							rs.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
					try {
						if (pstmt != null)
							pstmt.close();
					} catch (Exception e) {
						e.printStackTrace();
					} 
					try {
						if (connection != null)
							connection.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				
				}
			    return total;
			  }
		
		public List<Board> searchList(int start, int end, String keyword) throws Exception {
			Connection connection = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			final String sqlSelect = "SELECT * FROM Board WHERE title LIKE ? OR contents LIKE ? ORDER BY reg_date DESC LIMIT " + start + ", " + end; 
			
			try {
				// 커넥션풀에서 Connection객체를 빌려온다
				connection = ds.getConnection();
				System.out.println(keyword);
				stmt = connection.prepareStatement(sqlSelect);
				stmt.setString(1, "%"+keyword+"%");
				stmt.setString(2, "%"+keyword+"%");
				rs = stmt.executeQuery();
				
				ArrayList<Board> list = new ArrayList<Board>();
				
				while (rs.next()) {
					list.add(new Board().setCno(rs.getInt("cno"))
							.setTitle(rs.getString("title"))
							.setBlno(rs.getInt("blno"))
							.setId(rs.getString("id"))
							.setRegDate(rs.getDate("reg_date"))
							.setViewCount(rs.getInt("view_count")));
					System.out.println(rs.getString("title"));
				}
				
				return list;
				
			} catch (Exception e) {
				throw e;
			} finally {
				try {
					if (rs != null)
						rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					if (stmt != null)
						stmt.close();
				}	catch (Exception e) {
					e.printStackTrace();
				}
				try {
					if (connection != null)
						connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		public int getCount(String keyword) throws Exception {
			Connection connection = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT count(*) FROM board WHERE title LIKE ? OR contents LIKE ?";
			    int total = 0;
			    
			    try {
			    	connection = ds.getConnection();
			    	pstmt = connection.prepareStatement(sql);
			    	pstmt.setString(1, "%"+keyword+"%");
			    	pstmt.setString(2, "%"+keyword+"%");
			    	rs = pstmt.executeQuery();
			      
			      if(rs.next()){
			        total = rs.getInt(1);
			      }
			      
			      
			    } catch (Exception e) {
					throw e;
				} finally {
					try {
						if (rs != null)
							rs.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
					try {
						if (pstmt != null)
							pstmt.close();
					} catch (Exception e) {
						e.printStackTrace();
					} 
					try {
						if (connection != null)
							connection.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				
				}
			    return total;
			  }
		
		public int getCommentCount(int cno) throws Exception {
	         Connection connection = null;
	         PreparedStatement pstmt = null;
	         ResultSet rs = null;
	         String sql = "SELECT COUNT(if(cno =" + cno + ", cno, null)) as count FROM comment";
	         int result = 0;
	             
	             try {
	                connection = ds.getConnection();
	                pstmt = connection.prepareStatement(sql);
	                rs = pstmt.executeQuery();
	               
	                  if(rs.next()){
	                     result = rs.getInt("count");
	                     }
	             } catch (Exception e) {
	               throw e;
	            } finally {
	               try {
	                  if (rs != null)
	                     rs.close();
	               } catch (Exception e) {
	                  e.printStackTrace();
	               }
	               try {
	                  if (pstmt != null)
	                     pstmt.close();
	               } catch (Exception e) {
	                  e.printStackTrace();
	               } 
	               try {
	                  if (connection != null)
	                     connection.close();
	               } catch (Exception e) {
	                  e.printStackTrace();
	               }
	            
	            }
	             return result;
	           }

	
	}
