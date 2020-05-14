package bean;

public class SecondHand_order {

	 private int order_id;
	 private String order_u_id;
	 private String order_u_status;
	 private int order_totprice;
	 private String order_a_id;
	public SecondHand_order(int order_id, String order_u_id, String order_u_status, int order_totprice,
			String order_a_id) {
		super();
		this.order_id = order_id;
		this.order_u_id = order_u_id;
		this.order_u_status = order_u_status;
		this.order_totprice = order_totprice;
		this.order_a_id = order_a_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getOrder_u_id() {
		return order_u_id;
	}
	public void setOrder_u_id(String order_u_id) {
		this.order_u_id = order_u_id;
	}
	public String getOrder_u_status() {
		return order_u_status;
	}
	public void setOrder_u_status(String order_u_status) {
		this.order_u_status = order_u_status;
	}
	public int getOrder_totprice() {
		return order_totprice;
	}
	public void setOrder_totprice(int order_totprice) {
		this.order_totprice = order_totprice;
	}
	public String getOrder_a_id() {
		return order_a_id;
	}
	public void setOrder_a_id(String order_a_id) {
		this.order_a_id = order_a_id;
	}
	
	
	
	
	
	
	
}
