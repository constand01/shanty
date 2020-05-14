package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.SecondHand_cart;
import bean.SecondHand_user;
import dao.basedao;

public class cartdao {
    
	 public static int insert(SecondHand_cart cart) {
		 String sql="insert into cart values(null,?,?,?,?,?,?,?,1)";
				 
        
	    Object[] params= {
	    	cart.getCart_p_filename(),
	    	cart.getCart_p_name(),
	    	cart.getCart_p_price(),
	    	cart.getCart_p_quantity(),
	    	cart.getCart_p_stock(),
	    	cart.getCart_p_id(),
	    	cart.getCart_u_id()
	    };
	    return basedao.exectuIUD(sql, params);
	    
	    
	 }
	 
	 public static ArrayList<SecondHand_cart> getcart(String id){
	    	ArrayList<SecondHand_cart> list=new ArrayList<SecondHand_cart>();
	    	//声明结果集
	    	ResultSet rs=null;
	    	//获取连接对象
	    	Connection con=basedao.getconn();
	 
	    	PreparedStatement ps=null;
	    	
	  
	    	try {
	    		String sql="select * from cart where cart_u_id=? and cart_vaild=1 order by cart_id desc";
	    		
	    		 ps=con.prepareStatement(sql);
	    		 ps.setString(1, id);
				rs=ps.executeQuery();
				while(rs.next()) {
					SecondHand_cart c=new SecondHand_cart(
							rs.getInt("cart_id"),
							rs.getString("cart_p_filename"),
							rs.getString("cart_p_name"),
							rs.getInt("cart_p_price"),
							rs.getInt("cart_quantity"),
							rs.getInt("cart_p_stock"),
							rs.getInt("cart_p_id"),
							rs.getString("cart_u_id"),
							rs.getInt("cart_vaild")
							);
					list.add(c);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				basedao.closeall(rs, ps, con);
			}
	    	
	    	return list;
	    }
	 
	 
	 public static SecondHand_cart getcartshop(String uid,String pid) {
		 
		 SecondHand_cart es=null;
	    	//声明结果集
	    	ResultSet rs=null;
	    	//获取连接对象
	    	Connection con=basedao.getconn();
	 
	    	PreparedStatement ps=null;
	    	
	  
	    	try {
	    		String sql="select * from cart where cart_u_id=? and cart_p_id=? and cart_vaild=1 order by cart_id desc";
	    		
	    		 ps=con.prepareStatement(sql);
	    		 ps.setString(1, uid);
	    		 ps.setInt(2, Integer.parseInt(pid));
				rs=ps.executeQuery();
				while(rs.next()) {
					es=new SecondHand_cart(
							rs.getInt("cart_id"),
							rs.getString("cart_p_filename"),
							rs.getString("cart_p_name"),
							rs.getInt("cart_p_price"),
							rs.getInt("cart_quantity"),
							rs.getInt("cart_p_stock"),
							rs.getInt("cart_p_id"),
							rs.getString("cart_u_id"),
							rs.getInt("cart_vaild")
							);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				basedao.closeall(rs, ps, con);
			}
	    	
	    	return es;
		 
		 
	 }
	 
	 
	 public static int updatenum(int esid,int count) {
		 
		String sql="update cart set cart_quantity=? where cart_id=?"; 
		
		Object[] params= {count,esid};
		return basedao.exectuIUD(sql, params);
		
	 }
	 
	 public static int getDeleteDD(int id) {
		 
		 String sql="delete from cart where cart_id=?";
		 Object[] params= {id};
		 
		 return basedao.exectuIUD(sql, params);
	 }
	 
 public static SecondHand_cart getcartshop(String id) {
		 
		 SecondHand_cart es=null;
	    	//声明结果集
	    	ResultSet rs=null;
	    	//获取连接对象
	    	Connection con=basedao.getconn();
	 
	    	PreparedStatement ps=null;
	    	
	  
	    	try {
	    		String sql="select * from cart where cart_id=?  and cart_vaild=1 order by cart_id desc";
	    		
	    		 ps=con.prepareStatement(sql);
	    		 ps.setString(1, id);
				rs=ps.executeQuery();
				while(rs.next()) {
					es=new SecondHand_cart(
							rs.getInt("cart_id"),
							rs.getString("cart_p_filename"),
							rs.getString("cart_p_name"),
							rs.getInt("cart_p_price"),
							rs.getInt("cart_quantity"),
							rs.getInt("cart_p_stock"),
							rs.getInt("cart_p_id"),
							rs.getString("cart_u_id"),
							rs.getInt("cart_vaild")
							);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				basedao.closeall(rs, ps, con);
			}
	    	
	    		return es;
	    
		 
		 
	 }
	 
	 
}
