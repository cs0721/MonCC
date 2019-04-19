
public class Review 
{
	private String status;
	private int rating;
	private String comment;
	private String paper;
	private String reviewer;
	//private String[] submitDate;
	
	public Review()
	{
		this.status = "";
		this.rating = 0;
		this.comment = "";
		this.paper = "";
		this.reviewer = "";
		//submitDate = new String[3];
	}
	
	
	public Review(String status, int rating, String comment, String paper, String reviewer) 
	{

		this.status = status;
		this.rating = rating;
		this.comment = comment;
		this.paper = paper;
		this.reviewer = reviewer;
		//submitDate = new String[3];
	}


//	public String[] getSubmitDate() {
//		return submitDate;
//	}
//
//
//	public void setSubmitDate(String[] submitDate) {
//		this.submitDate = submitDate;
//	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}
	

	public String getComment() {
		return comment;
	}




	public void setComment(String comment) {
		this.comment = comment;
	}


	public String getPaper() {
		return paper;
	}


	public void setPaper(String paper) {
		this.paper = paper;
	}


	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}
	
}
