package bean;

public class SecondHand_cart {
        private int cart_id;
        private String cart_p_filename;
        private String cart_p_name;
        private int cart_p_price;
        private int cart_p_quantity;
        private int cart_p_stock;
        private int cart_p_id;
        private String cart_u_id;
        private int cart_p_vaild;
		public SecondHand_cart(int cart_id, String care_p_filename, String care_p_name, int cart_p_price,
				int cart_p_quantity, int cart_p_stock, int cart_p_id, String care_u_id, int cart_p_vaild) {
			super();
			this.cart_id = cart_id;
			this.cart_p_filename = care_p_filename;
			this.cart_p_name = care_p_name;
			this.cart_p_price = cart_p_price;
			this.cart_p_quantity = cart_p_quantity;
			this.cart_p_stock = cart_p_stock;
			this.cart_p_id = cart_p_id;
			this.cart_u_id = care_u_id;
			this.cart_p_vaild = cart_p_vaild;
		}
		public int getCart_id() {
			return cart_id;
		}
		public void setCart_id(int cart_id) {
			this.cart_id = cart_id;
		}
		public String getCart_p_filename() {
			return cart_p_filename;
		}
		public void setCart_p_filename(String care_p_filename) {
			this.cart_p_filename = care_p_filename;
		}
		public String getCart_p_name() {
			return cart_p_name;
		}
		public void setCart_p_name(String care_p_name) {
			this.cart_p_name = care_p_name;
		}
		public int getCart_p_price() {
			return cart_p_price;
		}
		public void setCart_p_price(int cart_p_price) {
			this.cart_p_price = cart_p_price;
		}
		public int getCart_p_quantity() {
			return cart_p_quantity;
		}
		public void setCart_p_quantity(int cart_p_quantity) {
			this.cart_p_quantity = cart_p_quantity;
		}
		public int getCart_p_stock() {
			return cart_p_stock;
		}
		public void setCart_p_stock(int cart_p_stock) {
			this.cart_p_stock = cart_p_stock;
		}
		public int getCart_p_id() {
			return cart_p_id;
		}
		public void setCart_p_id(int cart_p_id) {
			this.cart_p_id = cart_p_id;
		}
		public String getCart_u_id() {
			return cart_u_id;
		}
		public void setCart_u_id(String care_u_id) {
			this.cart_u_id = care_u_id;
		}
		public int getCart_p_vaild() {
			return cart_p_vaild;
		}
		public void setCart_p_vaild(int cart_p_vaild) {
			this.cart_p_vaild = cart_p_vaild;
		}
	
	
	
	
	
}
