package service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.SecondHand_cart;
import bean.SecondHand_order;
import bean.SecondHand_user;
import dao.basedao;

public class orderdao {

	public static int insert(SecondHand_order order) throws SQLException {
		 String sql="insert into sorder values(null,?,'0',?,?)";
				 
       
	    Object[] params= {
	    		order.getOrder_u_id(),
	    		order.getOrder_totprice(),
	    		order.getOrder_u_id()
	    };
	   
	    
	    return  basedao.retid(sql, params);
	    
	 }
	
	
	 public static ArrayList<SecondHand_order> selectbyid(String id){
		 
		 
		 ArrayList<SecondHand_order> list=new ArrayList<SecondHand_order>();
	    	//���������
	    	ResultSet rs=null;
	    	//��ȡ���Ӷ���
	    	Connection con=basedao.getconn();
	 
	    	PreparedStatement ps=null;
	    	
	  
	    	try {
	    		String sql="select * from sorder where order_u_id =?";
	    		ps=con.prepareStatement(sql);
	    		ps.setString(1, id);
	       
				rs=ps.executeQuery();
				while(rs.next()) {
				SecondHand_order o=new SecondHand_order(
							rs.getInt("order_id"),
							rs.getString("order_u_id"),
							rs.getString("order_status"),
							rs.getInt("order_totprice"),
							rs.getString("order_a_id")
							);
				list.add(o);
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
