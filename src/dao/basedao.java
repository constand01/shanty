package dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import java.sql.PreparedStatement;

public class basedao {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}       //
	}
	
	
	public static Connection getconn() {
		//创建连接对象
		Connection con=null;
		try
		{
		   String uri="jdbc:mysql://127.0.0.1/secondhand?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull";
		   String user="root";
		   String password="123";  
		   con=DriverManager.getConnection(uri,user,password);
		}
		catch(Exception e)
		{
			System.out.print(e);
			}
		return con;
	}
	
	public static int exectuIUD(String sql,Object[] params) {
		int count=0;
		Connection con=basedao.getconn();
		//准备sql
		PreparedStatement ps=null;
		//insert into user(''''''',') 
		try {
			
			ps=con.prepareStatement(sql);
			
		for(int i=0;i<params.length;i++){
			ps.setObject(i+1, params[i]);
			}
		count=ps.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			basedao.closeall(null,ps,con);
		}
		return count;
	
	}
	
	//返回自动生成的主键
	public static int retid(String sql,Object[] params) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int r=0;
		try{
			conn = basedao.getconn();
			ps=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			for(int i=0;i<params.length;i++){
				ps.setObject(i+1, params[i]);
				}
			ps.executeUpdate();
			
			rs = ps.getGeneratedKeys();
			if(rs.next()){
			r=rs.getInt(1);
			}
	
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			basedao.closeall(null,ps,conn);
			if(r==0) {
				return 0;
			}
				return r;
			}
		}



	
	
	public static void closeall(ResultSet rs,PreparedStatement ps,Connection con) {
		
		try {
			if(rs!=null) {
				rs.close();
		}
		if(ps!=null)
		{
				ps.close();
		}
		if(con!=null) {
				con.close();
		}
	 } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
   }
}
