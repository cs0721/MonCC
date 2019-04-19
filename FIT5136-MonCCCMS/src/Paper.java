import java.util.ArrayList;

public class Paper {
	
	private String title;
	private String content;
	private ArrayList<String> topic;
	private String status;
	private String conference;
	private String author;
	//private String[] submitDate;
	private ArrayList<String> reviewer;
	private ArrayList<Review> review ; 
	
	public Paper()
	{
		title = "";
		content = "";
		topic = new ArrayList<String>();
		status = "";
		author = "";
		//submitDate = new String[3];
		reviewer = new ArrayList<String>();
		review = new ArrayList<Review>();
	}


	public Paper(String title, String content, ArrayList<String> topic, String status, String conference, String author, ArrayList<String> reviewer, ArrayList<Review> review) 
	{
		this.title = title;
		this.content = content;
		this.topic = topic;
		this.status = status;
		this.conference = conference;
		this.author = author;
		this.reviewer = reviewer;
		this.review = review;
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


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}



	public ArrayList<String> getTopic() {
		return topic;
	}


	public void setTopic(ArrayList<String> topic) {
		this.topic = topic;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String getConference() {
		return conference;
	}

	public void setConference(String conference) {
		this.conference = conference;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}


	public ArrayList<String> getReviewer() {
		return reviewer;
	}


	public void setReviewer(ArrayList<String> reviewer) {
		this.reviewer = reviewer;
	}


	public ArrayList<Review> getReview() {
		return review;
	}


	public void setReview(ArrayList<Review> review) {
		this.review = review;
	}

}