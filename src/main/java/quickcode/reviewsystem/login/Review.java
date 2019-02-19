package quickcode.reviewsystem.login;

public class Review {

	private String cname;
	private String detail;
	private String rid;
	private String cid;
	private String uid;
	private String content;
	private String instructorPerformance;
	private String videoQuality;
	private String overallExperience;
	private String comments;
	
	
	public Review(String cname,String detail,String cid, String rid,String uid, String content, String instructorperformance, String videoquality,
			String overallexperience, String comments) {
		
		this.cname=cname;
		this.detail=detail;
		this.cid=cid;
		this.rid=rid;
		this.uid=uid;
		this.content=content;
		this.instructorPerformance = instructorperformance;
		this.videoQuality= videoquality;
		this.overallExperience = overallexperience;
		this.comments = comments;
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
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getInstructorPerformance() {
		return instructorPerformance;
	}
	public void setInstructorPerformance(String instructorPerformance) {
		this.instructorPerformance = instructorPerformance;
	}
	public String getVideoQuality() {
		return videoQuality;
	}
	public void setVideoQuality(String videoQuality) {
		this.videoQuality = videoQuality;
	}
	public String getOverallExperience() {
		return overallExperience;
	}
	public void setOverallExperience(String overallExperience) {
		this.overallExperience = overallExperience;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	

}
