package model;

public class Warehouse {
	private String p_id;
	private String u_name;
	private String p_type;
	private String no_of_boxes;
	private String no_of_days;
	
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getP_type() {
		return p_type;
	}
	public void setP_type(String p_type) {
		this.p_type = p_type;
	}
	public String getNo_of_boxes() {
		return no_of_boxes;
	}
	public void setNo_of_boxes(String no_of_boxes) {
		this.no_of_boxes = no_of_boxes;
	}
	public String getNo_of_days() {
		return no_of_days;
	}
	public void setNo_of_days(String no_of_days) {
		this.no_of_days = no_of_days;
	}
	public Warehouse(String p_id, String u_name, String p_type, String no_of_boxes, String no_of_days) {
		this.p_id = p_id;
		this.u_name = u_name;
		this.p_type = p_type;
		this.no_of_boxes = no_of_boxes;
		this.no_of_days = no_of_days;
	}
	public Warehouse(String u_name, String p_type, String no_of_boxes, String no_of_days) {
		this.u_name = u_name;
		this.p_type = p_type;
		this.no_of_boxes = no_of_boxes;
		this.no_of_days = no_of_days;
	}
	
	
	
	
}
