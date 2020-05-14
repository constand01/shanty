package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.SecondHand_cart;
import bean.SecondHand_sale;
import bean.SecondHand_user;
import dao.basedao;

public class saledao {
	 public static int insert(SecondHand_sale sale) {
		 String sql="insert into sale values(null,?,?,?,?,?,?)";
				 
        
	    Object[] params= {
	    		sale.getSale_u_id(),
	    		sale.getSale_p_filename(),
	    		  sale.getSale_p_number(),
	            sale.getSale_p_price(),
	            sale.getSale_p_desc(),
	            sale.getSale_p_name()
	    };
	    return basedao.exectuIUD(sql, params);
	    
	    
	 }
	
	
	 public static ArrayList<SecondHand_sale> selectall(){
	    	ArrayList<SecondHand_sale> list=new ArrayList<SecondHand_sale>();
	    	//声明结果集
	    	ResultSet rs=null;
	    	//获取连接对象
	    	Connection con=basedao.getconn();
	 
	    	PreparedStatement ps=null;
	    	
	  
	    	try {
	    		String sql="select * from sale";
	    			ps=con.prepareStatement(sql);
				rs=ps.executeQuery();
				while(rs.next()) {
					SecondHand_sale s=new SecondHand_sale(
							rs.getInt("sale_id"),
							rs.getString("sale_u_id"),
							rs.getString("sale_p_filename"),
							rs.getInt("sale_p_number"),
							rs.getInt("sale_p_price"),
							rs.getString("sale_p_desc"),
							rs.getString("sale_p_name")
							);
					list.add(s);
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
