package bean;

public class SecondHand_item {

	private int item_id;
	private int item_o_id;
	private int item_p_id;
	private int item_p_number;
	private String item_p_filename;
	private String item_p_name;
	private String item_p_price;
	public SecondHand_item(int item_id, int item_o_id, int item_p_id, int item_p_number, String item_p_filename,
			String item_p_name, String item_p_price) {
		super();
		this.item_id = item_id;
		this.item_o_id = item_o_id;
		this.item_p_id = item_p_id;
		this.item_p_number = item_p_number;
		this.item_p_filename = item_p_filename;
		this.item_p_name = item_p_name;
		this.item_p_price = item_p_price;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getItem_o_id() {
		return item_o_id;
	}
	public void setItem_o_id(int item_o_id) {
		this.item_o_id = item_o_id;
	}
	public int getItem_p_id() {
		return item_p_id;
	}
	public void setItem_p_id(int item_p_id) {
		this.item_p_id = item_p_id;
	}
	public int getItem_p_number() {
		return item_p_number;
	}
	public void setItem_p_number(int item_p_number) {
		this.item_p_number = item_p_number;
	}
	public String getItem_p_filename() {
		return item_p_filename;
	}
	public void setItem_p_filename(String item_p_filename) {
		this.item_p_filename = item_p_filename;
	}
	public String getItem_p_name() {
		return item_p_name;
	}
	public void setItem_p_name(String item_p_name) {
		this.item_p_name = item_p_name;
	}
	public String getItem_p_price() {
		return item_p_price;
	}
	public void setItem_p_price(String item_p_price) {
		this.item_p_price = item_p_price;
	}
	
	
	
}
