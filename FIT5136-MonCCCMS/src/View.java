import java.util.ArrayList;

public class View 
{
	public void displayRoles()
	{
		System.out.println("\n\t\t:::::::::::::::::::::::::::::::::::");
		System.out.println("\t\t|      Choose your role below :   |");
		System.out.println("\t\t:::::::::::::::::::::::::::::::::::");
		System.out.println("\t\t|       [1] Chair                 |");
        System.out.println("\t\t|       [2] Reviewer         	  |");
        System.out.println("\t\t|       [3] Author                |");
        System.out.println("\t\t|       [4] Admin                 |");
        System.out.println("\t\t|       [5] Cancel                |");
        System.out.println("\t\t===================================");
        System.out.print("\t\t      Please type your answer : ");
	}
	
	
	public void welcomeNewUser()
	{
		System.out.println();
		System.out.println("\t\t######################################################################################");
		System.out.println("\t\t::                     Thankyou for register to MonCC CMS,                          ::");
		System.out.println("\t\t::                   Your data has been saved to our database                       ::");
		System.out.println("\t\t:: Please remember your USERNAME and PASSWORD from now on to access your account    ::");
		System.out.println("\t\t:: Just input your registered username and password for log in to your new account  ::");
		System.out.println("\t\t######################################################################################");
		System.out.println();
	}
	
	public void home()
	{
		System.out.println();
		System.out.println("\t** ==**==**==*==*oo*==*oo*==*oo*==*oo*==*oo*==*oo*==*oo*==*oo*==*oo*==*oo*==*oo*==*oo*==*oo*==*==*==*==");
		System.out.println("\t**==**==**==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==*==");
		System.out.println("\t::       Welcome abroad to Monash Conference Centre (MonCC) Conference Management System (CMS)      ::");                       
		System.out.println("\t::  MonCC will organise the conference for our users which are Chair, Author, Reviewer, and Admin.  ::");
		System.out.println("\t::    As a Chair, you can create conference and wait until Author submit paper for your conference. ::");
		System.out.println("\t::                  After that, Chair can assign the paper to available Reviewer.                   ::");
		System.out.println("\t::          Reviewer will review the paper and submit the review to be examine by Chair.            ::");
		System.out.println("\t::                     Chair can choose to accept or reject the review.                             ::");
		System.out.println("\t:: Don't forget that Chair will set the deadline for submitting paper and review, so don't be late! ::");
		System.out.println("\t::                                                                    (`\\_/`)                       ::");
		System.out.println("\t::                                  At last, please enjoy MonCC CMS! *( 0.0 )*                      ::");
	    System.out.println("\t::                                                                     (___)                        ::");
		System.out.println("\t######################################################################################################");
		System.out.println();
	}
	
	
	public void exitRegards()
    {
        System.out.println("\n\t\tSystem exit...");
        System.out.println("\t\t================Thankyou, have a wonderful day! ===============");
        System.exit(0);
    }
	
	public void homeDisplay()
	{
		System.out.println("\n\t\t:::::::::::::::::::::::::::::::::::");
		System.out.println("\t\t|     Welcome to MonCC CMS        |");
		System.out.println("\t\t:::::::::::::::::::::::::::::::::::");
		System.out.println("\t\t|Please choose the options below :|");
		System.out.println("\t\t===================================");
        System.out.println("\t\t|       [1] Register         	  |");
        System.out.println("\t\t|       [2] LogIn                 |");
        System.out.println("\t\t|       [3] Exit                  |");
        System.out.println("\t\t===================================");
        System.out.print("\t\t  Please input the option number : ");
	}
	
	public void authorDisplay(Author author)
	{
		welcome();
		System.out.println("\t\t      Welcome Again Author " + author.getUserName().toUpperCase()+"!"  );
		System.out.println("\t\t::::::::::::::::::::::::::::::::::::::::");
		System.out.println("\t\t||  Please choose the options below : ||");
		System.out.println("\t\t::::::::::::::::::::::::::::::::::::::::");
        System.out.println("\t\t|  [1] Submit Paper For Conference     |");
        System.out.println("\t\t|  [2] Display Conferences             |");
        System.out.println("\t\t|  [3] Display Paper Detail            |");
        System.out.println("\t\t|  [4] Check Notification              |");
        System.out.println("\t\t|  [5] Log Out                         |");
        System.out.println("\t\t========================================");
        System.out.print("\t\t  Please input the option number : ");
		
	}
	
	public void chairDisplay(Chair chair)
	{
		welcome();
		System.out.println("\t\t      Welcome Again Chair " + chair.getUserName().toUpperCase()+"!"  );
		System.out.println("\t\t::::::::::::::::::::::::::::::::::::::");
		System.out.println("\t\t|| Please choose the options below :||");
		System.out.println("\t\t::::::::::::::::::::::::::::::::::::::");
        System.out.println("\t\t|   [1] Create Conference            |");
        System.out.println("\t\t|   [2] Display Conferences          |");
        System.out.println("\t\t|   [3] Assign Paper To Reviewer     |");
        System.out.println("\t\t|   [4] Examine Paper's Review       |");
        System.out.println("\t\t|   [5] Send Notification To Author  |");
        System.out.println("\t\t|   [6] Log Out                      |");
        System.out.println("\t\t======================================");
        System.out.print("\t\t  Please input the option number : ");
	}
	
	public void reviewerDisplay(Reviewer reviewer)
	{
		welcome();
		System.out.println("\t\t   Welcome Again Reviewer " + reviewer.getUserName().toUpperCase()+"!"  );
		System.out.println("\t\t::::::::::::::::::::::::::::::::::::::");
		System.out.println("\t\t|| Please choose the options below :||");
		System.out.println("\t\t::::::::::::::::::::::::::::::::::::::");
        System.out.println("\t\t|   [1] Review Paper                 |");
        System.out.println("\t\t|   [2] Display Reviewed Paper       |");
        System.out.println("\t\t|   [3] Log Out                      |");
        System.out.println("\t\t======================================");
        System.out.print("\t\t  Please input the option number : ");		
	}
	
	public void displayChairConferences()
	{
		System.out.println("\n\t\t::::::::::::::::::::::::::::::::::::::");
		System.out.println("\t\t|| Please choose the options below :||");
		System.out.println("\t\t::::::::::::::::::::::::::::::::::::::");
        System.out.println("\t\t|   [1] Display all conferences      |");
        System.out.println("\t\t|   [2] Display my conferences       |");
        System.out.println("\t\t|   [3] Back                         |");
        System.out.println("\t\t======================================");
        System.out.print("\t\t  Please input the option number : ");
	}
	
	
	public void adminDisplay(Admin admin)
	{
		welcome();
		System.out.println("\t\t   Welcome Again Admin " + admin.getUserName().toUpperCase()+"!"  );
		System.out.println("\t\t::::::::::::::::::::::::::::::::::::::");
		System.out.println("\t\t|| Please choose the options below :||");
		System.out.println("\t\t::::::::::::::::::::::::::::::::::::::");
        System.out.println("\t\t|   [1] Display All Users            |");
        System.out.println("\t\t|   [2] Display All Conferences      |");
        System.out.println("\t\t|   [3] Display All Papers           |");
        System.out.println("\t\t|   [4] Display All Keywords         |");
        System.out.println("\t\t|   [5] Add Keywords                 |");
        System.out.println("\t\t|   [6] Log Out                      |");
        System.out.println("\t\t======================================");
        System.out.print("\t\t  Please input the option number : ");		
	}
	
	public void registerdisplay()
	{
		System.out.println("\n\t||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("\t\t         You choose to register as a new user");
		System.out.println("\t   Please read the following instructions for registration process");
	}
	
	public void welcome()
	{
		System.out.println(" \n\n\t/////////////////////////////////////////////////////// ");
		System.out.println("\t                    **MonCC CMS**                   ");
	}
	
	public void myPaperList()
	{
		System.out.println("\n\t\t::::::::::::::::::::::::::::::::::::::");
		System.out.println("\t\t::       **MY PAPERS LIST**         ::");
		System.out.println("\t\t::::::::::::::::::::::::::::::::::::::");
	}
	
	public void reviewDetails()
	{
		System.out.println("\n\t\t::::::::::::::::::::::::::::::::::::::");
		System.out.println("\t\t::       **REVIEW DETAILS**         ::");
		System.out.println("\t\t::::::::::::::::::::::::::::::::::::::");
	}
	
	public void displayReviewDecision()
	{
		System.out.println("\n\t\t::o::o::o::o::o::o::o::o::o::o::o::o::o::o::o::o::o");
		System.out.println("\t\t  Please choose the options below for the review ");
		System.out.println("\t\t::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("\t\t   		[1] Approve");
        System.out.println("\t\t  		[2] Reject");
        System.out.println("\t\t    ===================================== ");
        System.out.print("\t\t  Please input the option number : ");
	}
	
	
	public void notification()
	{
		
			System.out.println("\n\t\t::::::::::::::::::::::::::::::::::::::");
			System.out.println("\t\t::       **NOTIFICATIONS**          ::");
			System.out.println("\t\t::::::::::::::::::::::::::::::::::::::");

	}
	
	
	public void selectPaper()
	{
		System.out.println("\n\t\t***************SELECT THE PAPER BELOW*******************");
		System.out.println("\t\t::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
	}
	
	
	public void displayAllConference(ArrayList<Conference> conferenceList)
	{
		int id = 1;
		System.out.println("\n\t\t:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o");
		System.out.println("\t\t::               CONFERENCES LIST             ::");
		System.out.println("\t\t================================================");
		for (Conference conf : conferenceList)
		{
			String meeting = conf.getTitle();
			
			System.out.println("\t\t  [" + id + "] " + meeting);
			id = id + 1;
		}
		
		System.out.println("\n\t\t:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o");
	}
	
	
	public void displayAllPaperStatus(ArrayList<Paper> paperList, ArrayList<Conference> conferenceList)
	{
		int index = 1;
		for (Paper journal : paperList)
		{
			String title = journal.getTitle();
			String author = journal.getAuthor();
			String conf = journal.getConference();
			Conference con = new Conference();
			
			for(Conference meeting : conferenceList)
			{
				if(conf.equals(meeting.getTitle()))
					con = meeting;
			}
			
			int numbOfReviews = journal.getReview().size();
			int numbOfReviewers = journal.getReviewer().size();
			
			System.out.println("\n\t\t ID [" + index + "] " + title);
			System.out.println("\n\t\t >> Author : " + author);
			System.out.println("\n\t\t >> Topic : ");
			ArrayList<String> topicList = journal.getTopic();
			int ind = 1;
			for(String keyword : topicList)
			{
				System.out.println("\t\t       .o. " + keyword);
				ind = ind + 1;
			}
			System.out.println("\n\t\t >> Conference : " + conf );
			String[] deadPap = con.getDeadlinePaper();
			System.out.println("\t\t >> Submission deadline: " + deadPap[0] + "-" + deadPap[1] + "-" + deadPap[2]);
			String[] deadRev = con.getDeadlineReview();
			System.out.println("\t\t >> Review deadline : " + deadRev[0] + "-" + deadRev[1] + "-" + deadRev[2] );
			System.out.println("\n\t\t >> Total Reviewers : " + numbOfReviewers + " of 4");
			System.out.println("\t\t >> Total Reviews : " + numbOfReviews); 
			System.out.println("\t\t =======================================");
			index = index + 1;
						
		}
	}
	
	public void displayUser(User user)
	{
		String name = user.getName();
		String userName = user.getUserName();
		String role = user.getRole();
		String jobTitle = user.getJobTitle();
		String email = user.getEmail();
		String pass = user.getPassword();
		
		System.out.println("\t\t	>> Name     : " + name  ); 
		System.out.println("\t\t	>> User Name: " + userName  );
		System.out.println("\t\t	>> Role     : " + role  ); 
		System.out.println("\t\t	>> Job Title: " + jobTitle );
		System.out.println("\t\t	>> Email    : " + email  );
		System.out.println("\t\t	>> Password : " + pass  );
	}
	
	
	public void displayChair(User user)
	{
		System.out.println();
		System.out.println("\t\t:::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("\t\t     Hi Chair " + user.getUserName().toUpperCase() +"! Welcome to MonCC CMS  ");
		System.out.println("\t\t::     Please read your details below          ::");
		System.out.println("\t\t=================================================");
		displayUser(user);
		System.out.println("\t\t=================================================");	
	}
	
	public void displayAuthor(User user)
	{
		System.out.println();
		System.out.println("\t\t:::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("\t\t     Hi Author " + user.getUserName().toUpperCase() +"! Welcome to MonCC CMS  ");
		System.out.println("\t\t::     Please read your details below          ::");
		System.out.println("\t\t=================================================");
		displayUser(user);
		System.out.println("\t\t=================================================");	
	}
	
	public void displayReviewer(Reviewer user)
	{
		System.out.println();
		System.out.println("\t\t:::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("\t\t     Hi Reviewer " + user.getUserName().toUpperCase() +"! Welcome to MonCC CMS  ");
		System.out.println("\t\t::     Please read your details below          ::");
		System.out.println("\t\t=================================================");
		displayUser(user);
		ArrayList<String> topicList = user.getExpertise();
		int index = 1;
		System.out.println("\t\t	>> Expertises: ");
		for(String keyword : topicList)
		{
			System.out.println("\t\t	    [" + index + "]" + keyword);
			index = index + 1;
		}
		System.out.println("\t\t=================================================");	
		
	}
	
	public void displayAllUser(ArrayList<User> userList)
	{
		int totalUser = userList.size();
		System.out.println("\n\t\t::::::::::::::::**USERS::LIST**::::::::::::::::");
		System.out.println("\n\t\t >> Total Users: " + totalUser);
		
		
		int index = 1;
		for (User person : userList)
		{
			System.out.println("\t\t ID ["+ index +"]" );
			displayUser(person);
			System.out.println("\t\t======================================");
			index = index + 1;
		}
		
		System.out.println("\t\t:::::::::::::::::::::::::::::::::::::::::");
	}
	
	public void displayKeyword(ArrayList<Keyword> keywordList)
	{
		int id = 1;
		
		System.out.println("\t\t Keywords List :");
		for (Keyword word : keywordList)
		{
			String keyword = word.getKeyword();
			
			System.out.println("\t\t[" + id + "] " + keyword);
			id = id + 1;
		}
		
		System.out.println("\t\t===================================");
        System.out.print("\t\t  Please input the keyword number : ");
	}
	
	public void displayConference(Conference conf)
	{
		System.out.println("\n\n\t\t***************************************************");
		System.out.println("\t\t**               CONFERENCE DETAILS              **");
		System.out.println("\t\t***************************************************");
		
		System.out.println("\t\t >> Title : " + conf.getTitle());
		System.out.println("\t\t >> Topic : ");
		ArrayList<String> topicList = conf.getTopic();
		int index = 1;
		for(String keyword : topicList)
		{
			System.out.println("\t\t    [" + index + "]" + keyword);
			index = index + 1;
		}
		System.out.println("\n\t\t >> Location : " + conf.getLocation());
		System.out.println("\t\t >> Speaker : " + conf.getSpeaker());
		System.out.println("\t\t >> Chair : " + conf.getCreator());
		int totalPapers = conf.getPaperList().size();
		System.out.println("\t\t >> Total Papers : " + totalPapers);
		String[] deadPap = conf.getDeadlinePaper();
		System.out.println("\t\t >> Paper submission deadline : " + deadPap[0] + "-" + deadPap[1] + "-" + deadPap[2]);
		String[] deadRev = conf.getDeadlineReview();
		System.out.println("\t\t >> Review deadline : " + deadRev[0] + "-" + deadRev[1] + "-" + deadRev[2] );
		System.out.println("\t\t:::::::::::::::::::::::::::::::::::::::::::::::::::");
	}
	
	public void displayOwnConf(ArrayList<Conference> ownConf)
	{
		int id = 1;
		System.out.println("\n\t\t:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o");
		System.out.println("\t\t:o:o            CONFERENCES LIST            :o:o");
		System.out.println("\t\t::::::::::::::::::::::::::::::::::::::::::::::::");
		for (Conference conf : ownConf)
		{
			String meeting = conf.getTitle();
			
			System.out.println("\t\t  [" + id + "] " + meeting);
			id = id + 1;
		}
		
		System.out.println("\n\t\t:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o");
	}
	
	public void displayPaper(Paper paper)
	{
		System.out.println("\n\t\t:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o");
		System.out.println("\t\t:o:o               PAPER DETAILS                  :o:o");
		System.out.println("\t\t:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o");
		System.out.println("\t\t   >> Author : " + paper.getAuthor());
		System.out.println("\t\t   >> Title : " + paper.getTitle());
		System.out.println("\t\t   >> Conference : " + paper.getConference());
		
		System.out.println("\t\t   >> Topic : ");
		ArrayList<String> topicList = paper.getTopic();
		int index = 1;
		for(String keyword : topicList)
		{
			System.out.println("\t\t       [" + index + "]" + keyword);
			index = index + 1;
		}
		
		System.out.println("");
		System.out.println("\t\t   >> Content : " );
		
		String[] allWords = paper.getContent().split(";|\\.");
		
		for (int line = 0; line < allWords.length ; line++)
		{
			String text = allWords[line];
				System.out.println("\t\t     >o " + text);
		}
		
		System.out.println("");
		System.out.println("\t\t   >> Status : " + paper.getStatus());
		System.out.println("\t\t   >> Total Reviews : " + paper.getReview().size());
		System.out.println("\t\t   >> Total Reviewers : " + paper.getReviewer().size());
		
		System.out.println("\n\t\t   >> Reviewer : ");
		int num = 1;
		for(String checker : paper.getReviewer())
		{
			System.out.println("\t\t      [" + num + "] " + checker);
			num = num + 1;
		}
		
		int number = 1;
		
		System.out.println("\n\t\t   >> Review : ");
		for(Review comment : paper.getReview())
		{
			System.out.println("\n\t\t     [" + number + "] Reviewer : " + comment.getReviewer());
			System.out.println("\t\t        >o Papers' Rating : " + comment.getRating());
			System.out.println("\t\t        >o Reviews' Status : " + comment.getStatus());
			System.out.println("\t\t        >o Comment: " + comment.getComment());
			number = number + 1;
		}
		
		System.out.println("\t\t:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o:o");
		
	}
	
	public void displayPaperForReviewer(ArrayList<Paper> list, ArrayList<Conference> conferenceList)
	{
			int index = 1;
			for (Paper journal : list)
			{
				String title = journal.getTitle();
				String conf = journal.getConference();

				System.out.println("\t\t   ID : [" + index +"] " + title );
				System.out.println("\t\t   >> Topic : ");
				ArrayList<String> topicList = journal.getTopic();
				int ind = 1;
				for(String keyword : topicList)
				{
					System.out.println("\t\t    .o. " + keyword);
					ind = ind + 1;
				}
				System.out.println("\n\t\t   >> Conference : " + conf );
				
				int number = 0;
				String[] reviewDeadline = new String[3];
				for(Conference meeting : conferenceList)
				{
					if(meeting.getTitle().equals(conf))
					{
						reviewDeadline = meeting.getDeadlineReview();
					}
					
					number = number + 1;
				}
				
				System.out.println("\t\t   >> Deadline Review : " + reviewDeadline[0] +"-" + reviewDeadline[1] + "-" + reviewDeadline[2] );
				System.out.println("\t\t============================================");
				index = index + 1;
							
			}
			System.out.print("\t\t    Insert Papers' ID you want to review: ");
		
	}
		
	public void displayOwnPapers(ArrayList<Paper> ownPaper, ArrayList<Conference> conferenceList)
	{

		int index = 1;
		myPaperList();
		
		for (Paper journal : ownPaper)
		{
			String title = journal.getTitle();
			String author = journal.getAuthor();
			String conf = journal.getConference();
			Conference con = new Conference();
			
			for(Conference meeting : conferenceList)
			{
				if(conf.equals(meeting.getTitle()))
					con = meeting;
			}
			
			int numbOfReviews = journal.getReview().size();
			int numbOfReviewers = journal.getReviewer().size();
			
			System.out.println("\n\t\t ID [" + index + "] " + title);
			System.out.println("\t\t         Status : " + journal.getStatus());
			System.out.println("\n\t\t   >> Author : " + author);
			System.out.println("\n\t\t   >> Topic : ");
			ArrayList<String> topicList = journal.getTopic();
			int ind = 1;
			for(String keyword : topicList)
			{
				System.out.println("\t\t       .o. " + keyword);
				ind = ind + 1;
			}
			System.out.println("\n\t\t   >> Conference : " + conf );
			String[] deadPap = con.getDeadlinePaper();
			System.out.println("\t\t   >> Submission deadline: " + deadPap[0] + "-" + deadPap[1] + "-" + deadPap[2]);
			String[] deadRev = con.getDeadlineReview();
			System.out.println("\t\t   >> Review deadline : " + deadRev[0] + "-" + deadRev[1] + "-" + deadRev[2] );
			System.out.println("\n\t\t   >> Total Reviewers : " + numbOfReviewers + " of 4");
			System.out.println("\t\t   >> Total Reviews : " + numbOfReviews); 
			System.out.println("\t\t =======================================");
			index = index + 1;
						
		}		
		
	}
	
	public void displayPaperForChair(ArrayList<Paper> list, ArrayList<Conference> conferenceList)
	{
			//menu.myPaperList();
			int index = 1;
			for (Paper journal : list)
			{
				String title = journal.getTitle();
				String conf = journal.getConference();

				System.out.println("\t\t   ID : [" + index +"] " + title );
				System.out.println("\t\t   >> Author : " + journal.getAuthor());
				System.out.println("\n\t\t   >> Topic : ");
				ArrayList<String> topicList = journal.getTopic();
				int ind = 1;
				for(String keyword : topicList)
				{
					System.out.println("\t\t    .o. " + keyword);
					ind = ind + 1;
				}
				System.out.println("\n\t\t   >> Conference : " + conf );
				
				int number = 0;
				String[] reviewDeadline = new String[3];
				for(Conference meeting : conferenceList)
				{
					if(meeting.getTitle().equals(conf))
					{
						reviewDeadline = meeting.getDeadlineReview();
					}
					
					number = number + 1;
				}
				
				System.out.println("\t\t   >> Deadline Review : " + reviewDeadline[0] +"-" + reviewDeadline[1] + "-" + reviewDeadline[2] );
				System.out.println("\t\t   >> Total Reviews : " + journal.getReview().size());
				System.out.println("\t\t   >> Total Reviewers : " + journal.getReviewer().size() + " of 4");
				System.out.println("\t\t============================================");
				index = index + 1;
							
			}
			
		
	}
	
	public void displayNotification(Author author)
	{
		ArrayList<String> notif = author.getNotification();
		int totalNotif = notif.size();
		notification();
		
		if (totalNotif == 0)
		{
			System.out.println("\n\t::o::o::o::o: ** YOU HAVE 0 NOTIFICATION **   :o::o::o::o::");
		}
		
		else
		{
			System.out.println("\n\t::o::o::o::o::o::o::o::o::o::o::o::o::o::o::o::o::o");
			System.out.println("\t >> You have : " + totalNotif + " notifications");
			int index = 1;
			for (String msg : notif)
			{
				
				System.out.println("\n\t [" + index + "] " + msg);
				index = index + 1;
			}
			
			System.out.println("\t::o::o::o::o::o::o::o::o::o::o::o::o::o::o::o::o::o");
		}
		
	}
	
	
	public void displayReview(Paper paper, Review review)
	{
		String[] allWords = paper.getContent().split(";|\\.");
		String paperTitle = paper.getTitle();
		String author = paper.getAuthor();
		String conf = paper.getConference();
		
		reviewDetails();
		
		System.out.println("\t\t Papers' Title: " + paperTitle);
		System.out.println("\t\t  >> Author: " + author);
		System.out.println("\t\t  >> Conference: " + conf);
		
		System.out.println("\n\t\t >> Content: ");
		for (int line = 0; line < allWords.length ; line++)
		{
			String text = allWords[line];
				System.out.println("\t\t >o " + text);
		}
		
		System.out.println("\n\t\t >> Review: ");
		System.out.println("\t\t  Reviewer: " + review.getReviewer());
		System.out.println("\t\t  Rating: " + review.getRating());
		System.out.println("\n\t\t  Comment: ");
		System.out.println("\t\t     >o " + review.getComment());
	
		
	}
	
	
	
	
}
