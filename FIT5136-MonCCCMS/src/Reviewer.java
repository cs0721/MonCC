import java.util.ArrayList;

public class Reviewer extends User 
{
	private ArrayList<String> expertise;
	
	public Reviewer()
	{
		expertise = new ArrayList<String>();
	}
	
	public Reviewer(ArrayList<String> exp)
	{
		expertise = exp;
	}

	public ArrayList<String> getExpertise() {
		return expertise;
	}

	public void setExpertise(ArrayList<String> expertise) {
		this.expertise = expertise;
	}


	
}
