package bean;

public class SecondHand_sale {
	private int sale_id;
	private String sale_u_id;
	private String sale_p_filename;
	private int sale_p_number;
	private int sale_p_price;
	private String sale_p_desc;
	public SecondHand_sale(int sale_id, String sale_u_id, String sale_p_filename, int sale_p_number, int sale_p_price,
			String sale_p_desc, String sale_p_name) {
		super();
		this.sale_id = sale_id;
		this.sale_u_id = sale_u_id;
		this.sale_p_filename = sale_p_filename;
		this.sale_p_number = sale_p_number;
		this.sale_p_price = sale_p_price;
		this.sale_p_desc = sale_p_desc;
		this.sale_p_name = sale_p_name;
	}
	private String sale_p_name;
	public int getSale_id() {
		return sale_id;
	}
	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}
	public String getSale_u_id() {
		return sale_u_id;
	}
	public void setSale_u_id(String sale_u_id) {
		this.sale_u_id = sale_u_id;
	}
	public String getSale_p_filename() {
		return sale_p_filename;
	}
	public void setSale_p_filename(String sale_p_filename) {
		this.sale_p_filename = sale_p_filename;
	}
	public int getSale_p_number() {
		return sale_p_number;
	}
	public void setSale_p_number(int sale_p_number) {
		this.sale_p_number = sale_p_number;
	}
	public int getSale_p_price() {
		return sale_p_price;
	}
	public void setSale_p_price(int sale_p_price) {
		this.sale_p_price = sale_p_price;
	}
	public String getSale_p_desc() {
		return sale_p_desc;
	}
	public void setSale_p_desc(String sale_p_desc) {
		this.sale_p_desc = sale_p_desc;
	}
	public String getSale_p_name() {
		return sale_p_name;
	}
	public void setSale_p_name(String sale_p_name) {
		this.sale_p_name = sale_p_name;
	}
	

}
