import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;

public class Conference 
{
	private String title;
	private ArrayList<String> topic;
	private String location;
	private String speaker;
	private String creator;
	private String[] deadlinePaper;
	private String[] deadlineReview;
	private ArrayList<Paper> paperList;
	
	public Conference()
	{
		title = "";
		topic = new ArrayList<String>();
		location = "";
		speaker = "";
		creator = "";
		deadlinePaper = new String [3];
		deadlineReview = new String [3];
		paperList = new ArrayList<Paper>();		
	}
	
	public Conference(String head, ArrayList<String> top, String loc, String speak, String us,String[] pap, String[] rev)
	{
		title = head;
		topic = top;
		location = loc;
		speaker = speak;
		creator = us;
		deadlinePaper = pap;
		deadlineReview = rev;
		paperList = new ArrayList<Paper>();
		
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<String> getTopic() {
		return topic;
	}

	public void setTopic(ArrayList<String> topic) {
		this.topic = topic;
	}

	

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSpeaker() {
		return speaker;
	}

	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}


	public String[] getDeadlinePaper() {
		return deadlinePaper;
	}

	public void setDeadlinePaper(String[] deadlinePaper) {
		this.deadlinePaper = deadlinePaper;
	}

	public String[] getDeadlineReview() {
		return deadlineReview;
	}

	public void setDeadlineReview(String[] deadlineReview) {
		this.deadlineReview = deadlineReview;
	}

	public ArrayList<Paper> getPaperList() {
		return paperList;
	}

	public void setPaperList(ArrayList<Paper> paperList) {
		this.paperList = paperList;
	}


	
	
}
