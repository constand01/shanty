 package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.SecondHand_user;
import dao.basedao;

public class userdao {
    public static int insert(SecondHand_user u) {
    	String sql="insert into user values(?,?,?,DATE_FORMAT(?,'%Y-%m-%d'),?,?,?,?,?)"; 
    	
    	Object[] params= {u.getUser_id(),
    			u.getUser_name(),
    			u.getUser_password(),
    			u.getUser_birthday(),
    			u.getUser_sex(),
    			u.getUser_email(),
    			u.getUser_phone(),  
    			u.getUser_address(),
    			u.getUser_status()
    			};
    	
    	return basedao.exectuIUD(sql, params);
    }
    
    public static int del(String id) {
    	String sql="delete from user where user_id=? and user_status!=2";
    	Object[] params= {id};
    	return basedao.exectuIUD(sql, params);
    }
    
    
    
    public static int update(SecondHand_user u) {
    	String sql="update  user set user_name=?,"
    			+ "user_password=?,"
    			+ "user_sex=?,"
    			+ "user_birthday=DATE_FORMAT(?,'%y-%m-%d'),"
    			+ "user_email=?,"
    			+ "user_phone=?,"
    			+ "user_address=?,"
    			+ "user_status=? where user_id=?"; 	
    	Object[] params= {
    			u.getUser_name(),
    			u.getUser_password(),
    			u.getUser_sex(),
    			u.getUser_birthday(),
    			u.getUser_email(),
    			u.getUser_phone(),  
    			u.getUser_address(),
    			u.getUser_status(),
    			u.getUser_id()
    			};
    	
    	return basedao.exectuIUD(sql, params);
    }
    
    
    
    
    public static int[] totalPage(int count,String keyword) {
    	//0�ܼ�¼��  1��ҳ��
    	int arr[]= {0,1};
    	
    	Connection con=basedao.getconn();
    	 
    	PreparedStatement ps=null;
    	ResultSet rs=null;
    	
 
    	try {
    		String sql="";
    		
    		
    		if(keyword!=null) {
    			sql="select count(*) from user where user_name like ?";
    			ps=con.prepareStatement(sql);
    			ps.setString(1, "%"+keyword+"%");
    		}else {
    			sql="select count(*) from user";
    			ps=con.prepareStatement(sql);
    		}
			rs=ps.executeQuery();
			
			
			while(rs.next()) {
				arr[0]=rs.getInt(1);
				if(arr[0]%count==0) {
				arr[1]=arr[0]/count;
				}
				else {
					arr[1]=arr[0]/count+1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			basedao.closeall(rs, ps, con);
		}
    	return arr;
    }
    
    
    public static int selectbyname(String id) {
    	//0�ܼ�¼��  1��ҳ��
    	int count=0;
    	Connection con=basedao.getconn();
    	 
    	PreparedStatement ps=null;
    	ResultSet rs=null;
    	
 
    	try {
    		String sql="select count(*) from user where user_id=?";
    		ps=con.prepareStatement(sql);
			ps.setString(1,id);
    		
    		
			rs=ps.executeQuery();
			
			
			while(rs.next()) {
				count=rs.getInt(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			basedao.closeall(rs, ps, con);
		}
    	return count;
    }
    
    
    
    
    public static ArrayList<SecondHand_user> selectall(int cpage,int count,String keyword){
    	ArrayList<SecondHand_user> list=new ArrayList<SecondHand_user>();
    	//声明结果集
    	ResultSet rs=null;
    	//获取连接对象
    	Connection con=basedao.getconn();
 
    	PreparedStatement ps=null;
    	
  
    	try {
    		String sql="";
    		if(keyword!=null) {
    			sql="select * from user where user_name like ? limit ?,?";
    			ps=con.prepareStatement(sql);
    			ps.setString(1, "%"+keyword+"%");
    			ps.setInt(2, (cpage-1)*count);
    			ps.setInt(3, count);
    		}
    		else {
    		 sql="select * from user  limit ?,?";
    		 ps=con.prepareStatement(sql);
    		 ps.setInt(1, (cpage-1)*count);
 			ps.setInt(2, count);
    		}
			rs=ps.executeQuery();
			while(rs.next()) {
				SecondHand_user u=new SecondHand_user(
						rs.getString("user_id"),
						rs.getString("user_name"),
						rs.getString("user_password"),
						rs.getString("user_sex"),
						rs.getString("user_birthday"),
						rs.getString("user_email"),
						rs.getString("user_phone"),
						rs.getString("user_address"),
						rs.getInt("user_status")
						);
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			basedao.closeall(rs, ps, con);
		}
    	
    	return list;
    }
    
    
    //ͨ���û�id��ѯ
    public static SecondHand_user selectbyid(String id){
    	SecondHand_user u=null;
    	//���������
    	ResultSet rs=null;
    	//��ȡ���Ӷ���
    	Connection con=basedao.getconn();
 
    	PreparedStatement ps=null;
    	
  
    	try {
    		String sql="select m.*, DATE_FORMAT(m.user_birthday,'%Y-%m-%d')birthday from user m where user_id =?";
    		ps=con.prepareStatement(sql);
    		ps.setString(1, id);
       
			rs=ps.executeQuery();
			while(rs.next()) {
			 u=new SecondHand_user(
						rs.getString("user_id"),
						rs.getString("user_name"),
						rs.getString("user_password"),
						rs.getString("user_sex"),
						rs.getString("birthday"),
						rs.getString("user_email"),
						rs.getString("user_phone"),
						rs.getString("user_address"),
						rs.getInt("user_status")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			basedao.closeall(rs, ps, con);
		}
    	 
    	return u;
    }
    
    public static int selectbyna(String username,String psw) {
    	int count=0;
    	Connection con=basedao.getconn();
    	 
    	PreparedStatement ps=null;
    	ResultSet rs=null;
    	
 
    	try {
    		String sql="select count(*) from user where user_id=? and user_password=?";
    		ps=con.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2,psw);
    		
			rs=ps.executeQuery();
			
			
			while(rs.next()) {
				count=rs.getInt(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			basedao.closeall(rs, ps, con);
		}
    	return count;
    }
    
    public static SecondHand_user selectadmin(String username,String psw) {
    	SecondHand_user u=null;
    	//���������
    	ResultSet rs=null;
    	//��ȡ���Ӷ���
    	Connection con=basedao.getconn();
 
    	PreparedStatement ps=null;
    	
  
    	try {
    		String sql="select m.*, DATE_FORMAT(m.user_birthday,'%Y-%m-%d')birthday from user m where user_id =? and user_password=?";
    		ps=con.prepareStatement(sql);
    		ps.setString(1, username);
    		ps.setString(2, psw);
       
			rs=ps.executeQuery();
			while(rs.next()) {
			 u=new SecondHand_user(
						rs.getString("user_id"),
						rs.getString("user_name"),
						rs.getString("user_password"),
						rs.getString("user_sex"),
						rs.getString("birthday"),
						rs.getString("user_email"),
						rs.getString("user_phone"),
						rs.getString("user_address"),
						rs.getInt("user_status")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			basedao.closeall(rs, ps, con);
		}
    	 
    	return u;
    }
    
}
