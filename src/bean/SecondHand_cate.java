package bean;

public class SecondHand_cate {
   private int cate_id;
   private String cate_name;
   private int cate_parent_id;
public SecondHand_cate(int cate_id, String cate_name, int cate_parent_id) {
	super();
	this.cate_id = cate_id;
	this.cate_name = cate_name;
	this.cate_parent_id = cate_parent_id;
}
public int getCate_id() {
	return cate_id;
}
public void setCate_id(int cate_id) {
	this.cate_id = cate_id;
}
public String getCate_name() {
	return cate_name;
}
public void setCate_name(String cate_name) {
	this.cate_name = cate_name;
}
public int getCate_parent_id() {
	return cate_parent_id;
}
public void setCate_parent_id(int cate_parent_id) {
	this.cate_parent_id = cate_parent_id;
}
   
   
   
   
}
