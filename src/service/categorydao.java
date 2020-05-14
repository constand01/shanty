package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.SecondHand_cate;
import bean.SecondHand_user;
import dao.basedao;

public class categorydao {

	 public static ArrayList<SecondHand_cate> selectall(){
	    	ArrayList<SecondHand_cate> list=new ArrayList<SecondHand_cate>();
	    	//声明结果集
	    	ResultSet rs=null;
	    	//获取连接对象
	    	Connection con=basedao.getconn();
	 
	    	PreparedStatement ps=null;
	    	
	  
	    	try {
	    		String sql="select * from cate";
	    			ps=con.prepareStatement(sql);
	    			rs=ps.executeQuery();
				while(rs.next()) {
					SecondHand_cate u=new SecondHand_cate(
							rs.getInt("cate_id"),
							rs.getString("cate_name"),
							rs.getInt("cate_parent_id")
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
	    
	 
	 //��ѯ���࣬�ӷ���͸�����
	 //flag==father  flag==child
	 
	 
	 public static ArrayList<SecondHand_cate> selectcat(String flag){
	    	ArrayList<SecondHand_cate> list=new ArrayList<SecondHand_cate>();
	    	//���������
	    	ResultSet rs=null;
	    	//��ȡ���Ӷ���
	    	Connection con=basedao.getconn();
	 
	    	PreparedStatement ps=null;
	    	
	  
	    	try {
	    		String sql=null;
	    		if(flag!=null&&flag.equals("father")) {
	    	    sql="select * from cate where cate_parent_id=0";
	    	    }else {
	    	    	sql="select * from cate where cate_parent_id!=0";
	    		}
	    			ps=con.prepareStatement(sql);
	    			rs=ps.executeQuery();
				while(rs.next()) {
					SecondHand_cate u=new SecondHand_cate(
							rs.getInt("cate_id"),
							rs.getString("cate_name"),
							rs.getInt("cate_parent_id")
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
	 
	 
	 
	 //��ӷ���
	 public static int insert(SecondHand_cate cate) {
	    	String sql="insert into cate values(null,?,?)"; 
	    	
	    	Object[] params= {cate.getCate_name(),
	    			cate.getCate_parent_id()
	    			};
	    	
	    	return basedao.exectuIUD(sql, params);
	    }
	
	 
	 public static SecondHand_cate selectbyid(int id){
	    	SecondHand_cate cate=null;
	    	//���������
	    	ResultSet rs=null;
	    	//��ȡ���Ӷ���
	    	Connection con=basedao.getconn();
	 
	    	PreparedStatement ps=null;
	    	
	  
	    	try {
	    		String sql="select * from cate m where cate_id =?";
	    		ps=con.prepareStatement(sql);
	    		ps.setInt(1, id);
	       
				rs=ps.executeQuery();
				while(rs.next()) {
				cate=new SecondHand_cate(
							rs.getInt("cate_id"),
							rs.getString("cate_name"),
							rs.getInt("cate_parent_id")
							
							);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				basedao.closeall(rs, ps, con);
			}
	    	 
	    	return cate;
	    }
	 
	 public static int update(SecondHand_cate cate) {
	    	String sql="update  cate set cate_name=?,"
	    			+ "cate_parent_id=? where cate_id=?"; 	
	    	Object[] params= {
	    			cate.getCate_name(),
	    			cate.getCate_parent_id(),
	    			cate.getCate_id()
	    			};
	    	
	    	return basedao.exectuIUD(sql, params);
	    }
	
	 
	 public static int del(int id) {
		 
		 String sql="delete from cate where cate_id=?";
		 Object[] params= {id};
		 return basedao.exectuIUD(sql, params);
		
	 }
}
