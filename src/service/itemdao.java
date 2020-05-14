package service;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.SecondHand_item;
import bean.SecondHand_order;
import dao.basedao;

public class itemdao {
	
	
	
	public static int insert(int oid,int pid,int pn,String profilename,String proname,int proprice) {
		
		
		String 	sql = "insert into item values(null,?,?,?,?,?,?)";
		 Object[] params= {
				 oid,pid,pn,profilename,proname,proprice
		 };
	    
	    return basedao.exectuIUD(sql, params);
	    
	    
	 }

	
 public static ArrayList<SecondHand_item> selectbyid(String id){
		 
		 
		 ArrayList<SecondHand_item> list=new ArrayList<SecondHand_item>();
	    	//���������
	    	ResultSet rs=null;
	    	//��ȡ���Ӷ���
	    	Connection con=basedao.getconn();
	 
	    	PreparedStatement ps=null;
	    	
	  
	    	try {
	    		String sql="select * from item where item_o_id =?";
	    		ps=con.prepareStatement(sql);
	    		ps.setString(1, id);
	       
				rs=ps.executeQuery();
				while(rs.next()) {
				SecondHand_item i=new SecondHand_item(
							rs.getInt("item_id"),
							rs.getInt("item_o_id"),
							rs.getInt("item_p_id"),
							rs.getInt("item_p_number"),
							rs.getString("item_p_filename"),
							rs.getString("item_p_name"),
							rs.getString("item_p_price")
						
							);
				list.add(i);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				basedao.closeall(rs, ps, con);
			}
	    	 
	    	return list;
	    }
	
 
 
 
 public static ArrayList<SecondHand_item> selectall(){
	 
	 
	 ArrayList<SecondHand_item> list=new ArrayList<SecondHand_item>();
    	//���������
    	ResultSet rs=null;
    	//��ȡ���Ӷ���
    	Connection con=basedao.getconn();
 
    	PreparedStatement ps=null;
    	
  
    	try {
    		String sql="select * from item ";
    		ps=con.prepareStatement(sql);
       
			rs=ps.executeQuery();
			while(rs.next()) {
			SecondHand_item i=new SecondHand_item(
						rs.getInt("item_id"),
						rs.getInt("item_o_id"),
						rs.getInt("item_p_id"),
						rs.getInt("item_p_number"),
						rs.getString("item_p_filename"),
						rs.getString("item_p_name"),
						rs.getString("item_p_price")
					
						);
			list.add(i);
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
