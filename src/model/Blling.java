package model;

public class Blling {
	private String b_id;
	private String u_name;
	private String p_id;
	private String p_type;
	private String no_of_boxes;
	private String no_of_days;
	
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
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
	public Blling(String b_id, String u_name, String p_id, String p_type, String no_of_boxes, String no_of_days) {
		this.b_id = b_id;
		this.u_name = u_name;
		this.p_id = p_id;
		this.p_type = p_type;
		this.no_of_boxes = no_of_boxes;
		this.no_of_days = no_of_days;
	}
	
	
}
