import java.util.ArrayList;

public class Author extends User 
{
	private ArrayList<String> notification;
	
	public Author()
	{
		notification = new ArrayList<String>();
		
	}
	
	public Author(ArrayList<String> notif)
	{
		notification = notif;
	}

	public ArrayList<String> getNotification() {
		return notification;
	}

	public void setNotification(ArrayList<String> notification) {
		this.notification = notification;
	}

	
	
}
