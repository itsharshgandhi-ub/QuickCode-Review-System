package quickcode.reviewsystem.login;

public class Course {
	private String cid;
	private String cname;
	private String detail;
	
	
	
	public Course(String cid, String cname, String detail) {
		super();
		this.cid = cid;
		this.cname= cname;
		this.detail = detail;
		
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	

}
