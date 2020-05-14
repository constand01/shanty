package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.SecondHand_cate;
import bean.SecondHand_product;
import dao.basedao;

public class productdao {

	
	 public static int insert(SecondHand_product p) {
	    	String sql="insert into product values(null,?,?,?,?,?,?,?)"; 
	    	
	    	Object[] params= {
                    p.getProduct_name(),
                    p.getProduct_description(),
                    p.getProduct_price(),
                    p.getProduct_stock(),
                    p.getProduct_fid(),
                    p.getProduct_cid(),
                    p.getProduct_filename()
	    			
	    			};
	    	
	    	return basedao.exectuIUD(sql, params);
	    }
	
	 
	 public static int update(SecondHand_product p) {
	    	String sql="update  product set product_name=?,"
	    			+ "product_description=?,"
	    			+ "product_price=?,"
	    			+ "product_stock=?,"
	    			+ "product_filename=? where product_id=?"; 	
	    	Object[] params= {
	    			p.getProduct_name(),
	    			p.getProduct_description(),
	    			p.getProduct_price(),
	    			p.getProduct_stock(),
	    			p.getProduct_filename(),
	    			p.getProduct_id()
	    			};
	    	
	    	return basedao.exectuIUD(sql, params);

	    	
	    	
	    }

	 
	 
	 
	 
	 public static ArrayList<SecondHand_product> selectall(){
	    	ArrayList<SecondHand_product> list=new ArrayList<SecondHand_product>();
	    	//声明结果集
	    	ResultSet rs=null;
	    	//获取连接对象
	    	Connection con=basedao.getconn();
	 
	    	PreparedStatement ps=null;
	    	
	  
	    	try {
	    		String sql="select * from product";
	    			ps=con.prepareStatement(sql);
	    			rs=ps.executeQuery();
				while(rs.next()) {
					SecondHand_product p=new SecondHand_product(
							rs.getInt("product_id"),
							rs.getString("product_name"),
							rs.getString("product_description"),
							rs.getInt("product_price"),
							rs.getInt("product_stock"),
							rs.getInt("product_fid"),
							rs.getInt("product_cid"),
							rs.getString("product_filename")
							);
					list.add(p);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				basedao.closeall(rs, ps, con);
			}
	    	
	    	return list;
	    }
	 
	 
	 public static int del(String id) {
	    	String sql="delete from product where product_id=?";
	    	Object[] params= {id};
	    	return basedao.exectuIUD(sql, params);
	    }

	 
	 
	 
	    
	 
	 public static ArrayList<SecondHand_product> selectallbyfid(int fid){
	    	ArrayList<SecondHand_product> list=new ArrayList<SecondHand_product>();
	    	//声明结果集
	    	ResultSet rs=null;
	    	//获取连接对象
	    	Connection con=basedao.getconn();
	 
	    	PreparedStatement ps=null;
	    	
	  
	    	try {
	    		String sql="select * from product where product_fid=?";
	    
	    			ps=con.prepareStatement(sql);
	    			ps.setInt(1, fid);
	    			rs=ps.executeQuery();
				while(rs.next()) {
					SecondHand_product p=new SecondHand_product(
							rs.getInt("product_id"),
							rs.getString("product_name"),
							rs.getString("product_description"),
							rs.getInt("product_price"),
							rs.getInt("product_stock"),
							rs.getInt("product_fid"),
							rs.getInt("product_cid"),
							rs.getString("product_filename")
							);
					list.add(p);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				basedao.closeall(rs, ps, con);
			}
	    	
	    	return list;
	    }
	    
	 
	 public static ArrayList<SecondHand_product> selectallbycid(int cid){
	    	ArrayList<SecondHand_product> list=new ArrayList<SecondHand_product>();
	    	//声明结果集
	    	ResultSet rs=null;
	    	//获取连接对象
	    	Connection con=basedao.getconn();
	 
	    	PreparedStatement ps=null;
	    	
	  
	    	try {
	    		String sql="select * from product where product_cid=?";
	    
	    			ps=con.prepareStatement(sql);
	    			ps.setInt(1, cid);
	    			rs=ps.executeQuery();
				while(rs.next()) {
					SecondHand_product p=new SecondHand_product(
							rs.getInt("product_id"),
							rs.getString("product_name"),
							rs.getString("product_description"),
							rs.getInt("product_price"),
							rs.getInt("product_stock"),
							rs.getInt("product_fid"),
							rs.getInt("product_cid"),
							rs.getString("product_filename")
							);
					list.add(p);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				basedao.closeall(rs, ps, con);
			}
	    	
	    	return list;
	    }
	    
	 
	 public static ArrayList<SecondHand_product> selectallbyid(ArrayList<Integer> ids){
	    	ArrayList<SecondHand_product> lastlylist=new ArrayList<SecondHand_product>();
	    	//声明结果集
	    	
	    	
	    	SecondHand_product p=null;
	    	ResultSet rs=null;
	    	//获取连接对象
	    	Connection con=basedao.getconn();
	 
	    	PreparedStatement ps=null;
	    	
	  
	    	try {
	    		for(int i=0;i<ids.size();i++) {
	    		String sql="select * from product where product_id=?";
	    
	    			ps=con.prepareStatement(sql);
	    			ps.setInt(1, ids.get(i));
	    			rs=ps.executeQuery();
				while(rs.next()) {
					 p=new SecondHand_product(
							rs.getInt("product_id"),
							rs.getString("product_name"),
							rs.getString("product_description"),
							rs.getInt("product_price"),
							rs.getInt("product_stock"),
							rs.getInt("product_fid"),
							rs.getInt("product_cid"),
							rs.getString("product_filename")
							);
					lastlylist.add(p);
				  }
	    		}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				basedao.closeall(rs, ps, con);
			}
	    	
	    	return lastlylist;
	    }
	 
	 
	 public static SecondHand_product selectbyid(int id){
	    	SecondHand_product p=null;
	    	//声明结果集
	    	ResultSet rs=null;
	    	//获取连接对象
	    	Connection con=basedao.getconn();
	 
	    	PreparedStatement ps=null;
	    	
	  
	    	try {
	    		String sql="select * from product where product_id=?";
	    			ps=con.prepareStatement(sql);
	    			ps.setInt(1, id);
	    			rs=ps.executeQuery();
				while(rs.next()) {
					 p=new SecondHand_product(
							rs.getInt("product_id"),
							rs.getString("product_name"),
							rs.getString("product_description"),
							rs.getInt("product_price"),
							rs.getInt("product_stock"),
							rs.getInt("product_fid"),
							rs.getInt("product_cid"),
							rs.getString("product_filename")
							);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				basedao.closeall(rs, ps, con);
			}
	    	
	    	return p;
	    }
	    
	 
	 public static ArrayList<SecondHand_product> selectbykey(String str){
	    	ArrayList<SecondHand_product> list=new ArrayList<SecondHand_product>();
	    	//声明结果集
	    	ResultSet rs=null;
	    	//获取连接对象
	    	Connection con=basedao.getconn();
	 
	    	PreparedStatement ps=null;
	    	
	  
	    	try {
	    		String sql="select * from product where product_name like ?";
	    			ps=con.prepareStatement(sql);
	    			str="%"+str+"%";
	    			ps.setString(1, str);
	    			rs=ps.executeQuery();
				while(rs.next()) {
					SecondHand_product p=new SecondHand_product(
							rs.getInt("product_id"),
							rs.getString("product_name"),
							rs.getString("product_description"),
							rs.getInt("product_price"),
							rs.getInt("product_stock"),
							rs.getInt("product_fid"),
							rs.getInt("product_cid"),
							rs.getString("product_filename")
							);
					list.add(p);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				basedao.closeall(rs, ps, con);
			}
	    	
	    	return list;
	    }
	 
	 
}
