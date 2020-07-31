package model;

public class Storage {
	private String total;
	private String occupied;
	private String free;
	
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getOccupied() {
		return occupied;
	}
	public void setOccupied(String occupied) {
		this.occupied = occupied;
	}
	public String getFree() {
		return free;
	}
	public void setFree(String free) {
		this.free = free;
	}
	public Storage(String total, String occupied, String free) {
		this.total = total;
		this.occupied = occupied;
		this.free = free;
	}
	
}
