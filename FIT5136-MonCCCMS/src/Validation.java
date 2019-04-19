import java.util.ArrayList;
import java.util.Scanner;

public class Validation 
{
	public boolean checkNoBlank(String word)
    {
        boolean value = true;

        if (word.length() > 0)
            value = true;
        else 
            if (word.length() == 0)
        {
               System.out.println();
               System.out.println("\t\t!!ERROR : Invalid Input. Please do not enter a blank space");
               System.out.println();
               value = false;
        }
        
        return value;
    }
	
	public boolean integerMenuValidation(String input)
    {
		Scanner parser = new Scanner(input);
        boolean value = false;
        
        if (parser.hasNextInt())
            value = true;
        else
        {
            System.out.println();
            System.out.println("\t\t!!ERROR : Invalid Input.Please enter a valid number");
            System.out.println();
            value = false;
        }    
        
        return value;
    }
	
	public boolean checkIfThereIsNoConference(ArrayList<Conference> conferenceList)
	{
		boolean valid = true;
		
		if (conferenceList.size() == 0)
		{
			System.out.println("\n\t\t::::::::::::::::::::::::::::::::::::::::::::::");
			System.out.println("\t\t   ** THERE IS NO CONFERENCE IN DATABASE **");
			System.out.println("\t\t::::::::::::::::::::::::::::::::::::::::::::::::");
			valid = false;
		}
		
		return valid;
	}
	
	public boolean checkIfThereIsNoPaper(ArrayList<Paper> paperList)
	{
		boolean valid = true;
		
		if (paperList.size() == 0)
		{
			System.out.println("\n\t\t::::::::::::::::::::::::::::::::::::::::::::::");
			System.out.println("\t\t   ** THERE IS NO PAPER IN DATABASE **");
			System.out.println("\t\t::::::::::::::::::::::::::::::::::::::::::::::::");
			valid = false;
		}
		
		return valid;
	}
	
	
	public boolean checkIfThereIsNoKeyword(ArrayList<Keyword> keywordList)
	{
		boolean valid = true;
		
		if (keywordList.size() == 0)
		{
			System.out.println("\n\t\t::::::::::::::::::::::::::::::::::::::::::::::");
			System.out.println("\t\t   ** THERE IS NO KEYWORD IN DATABASE **");
			System.out.println("\t\t::::::::::::::::::::::::::::::::::::::::::::::::");
			valid = false;
		}
		
		return valid;
	}
	
	 public boolean integerValidation(String input, int min, int max)
	 {
	        Scanner console = new Scanner(input);
	        boolean value = false;
	        int numberToCheck;
	        
	        if (console.hasNextInt())
	        {
	            numberToCheck = Integer.parseInt(input);
	            if (numberToCheck <= max && numberToCheck > 0)
	                value = true;
	            else
	            {
	                System.out.println();
	                System.out.println("\t\t!!ERROR : Invalid Input.Please enter a valid number (" + min + "-" + max +")");
	                System.out.println();
	                value = false;
	            }
	        }        
	        else
	        {
	            System.out.println();
	            System.out.println("\t\t!!ERROR : Invalid Input.Please enter a valid number (" + min + "-" + max +")");
	            System.out.println();
	            value = false;
	        }   
	        
	        return value;
	    }
	 
	 
	 public boolean yearValidation(String input)
	 {
		 	Scanner console = new Scanner(input);
	        boolean value = false;
	        
	        if(input.length() == 4)
	        	value = true;
	        
	        else
	        {
	            System.out.println();
	            System.out.println("\t\t!!ERROR : Invalid Input.Please enter a valid year (format: yyyy, ex: 2017)");
	            System.out.println();
	            value = false;
	        }   
	        
	       return value;
	        	
	 }
	 
	 
	 public boolean checkYNanswer(String input)
	 {
		 Scanner console = new Scanner(input);
	     boolean value = false;
	     
	     if(input.equals("y"))
	    	 value = true;
	     
	     else
	    	 if(input.equals("n"))
	    		 value = true;
	     
	     else
		 {
		    System.out.println();
		    System.out.println("\t\t!!ERROR : Invalid Input.Please enter a right answer (y/n)");
		    System.out.println();
		    value = false;
		  }   
	     
	     return value;
	 }
	 
	 
	public boolean checkTotalReviewers(Paper paper)
	{
		boolean valid = false;
		
		if(paper.getReviewer().size() >= 4)
		{
			System.out.println("\n\t\t >>o ** This paper already has 4 reviewers **");
			valid = false;
		}
		
		else
			if(paper.getReviewer().size() < 4)
				valid = true;
		
		return valid;
	}
		
		
	public boolean checkReviewers(Paper paper, Reviewer reviewer)
	{
		boolean valid = true;
		String name = reviewer.getName();
		ArrayList<String> checkers = paper.getReviewer();
				
		for(String person : checkers)
		{
			if (name.equals(person))
			{
				System.out.println("\t\t >>o The person you have chose is already reviewer of the paper");
				System.out.println("\t\t              Please choose another reviewer");
				valid = false;
				break;
			}
		}
		
		return valid;
	}
	
	public boolean checkUserNameExistance(String username, ArrayList<User> userList)
	{
		boolean result = false;
		for (User person : userList)
		{
			String personUserName = person.getUserName();
			
			if(username.equals(personUserName))
			{
				result = true;
				break;
			}	
		}
		return result;
	}
	
	public boolean checkUserPassword(String username, String password, ArrayList<User> userList)
	{
		boolean result = false;
		for (User person : userList)
		{
			if (person.getUserName().equals(username))
			{
				String personUserPassword = person.getPassword();
			
				if(password.equals(personUserPassword))
				{
					result = true;
					break;
				}
			}
		}
		return result;
	}
	
	public boolean checkKeywordExistance(String keyword, ArrayList<Keyword> keywordList)
	{
		boolean valid = true;
			
		for(Keyword word : keywordList)
		{
			if (keyword.equals(word.getKeyword()))
			{
				valid = false;
				  System.out.println("\n\t\t!!ERROR : " + keyword + " is already exis in database");
				  System.out.println("\t\t  >o Please insert another keyword ");
				break;
			}

		}
		return valid;
	}
	
}
