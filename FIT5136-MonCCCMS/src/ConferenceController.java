import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class ConferenceController 
{
	private ArrayList<Admin> adminList;
	private ArrayList<User> userList;
	private ArrayList<Chair> chairList;
	private ArrayList<Author> authorList;
	private ArrayList<Reviewer> reviewerList;
	private ArrayList<Keyword> keywordList;
	private ArrayList<Conference> conferenceList;
	private ArrayList<Paper> paperList;
	private View menu;
	private Validation validation;
	
	public ConferenceController()
	{
		adminList = new ArrayList<Admin>();
		userList = new ArrayList<User>();
		chairList = new ArrayList<Chair>();
		authorList = new ArrayList<Author>();
		reviewerList = new ArrayList<Reviewer>();
		keywordList = new ArrayList<Keyword>();
		paperList = new ArrayList<Paper>();
		validation = new Validation();
		conferenceList = new ArrayList<Conference>();
		menu = new View();
	}
	
	
	public int checkRole(User user)
	{
		int result = 0;
		
		String role = user.getRole();
		
		if(role.equals("Chair"))
			result = 1;
		else
			if(role.equals("Reviewer"))
				result = 2;
		else
			if(role.equals("Author"))
				result = 3;
		else
			if(role.equals("Admin"))
				result = 4;
		
		return result;
			
	}
	
	public User getUser(String username)
	{
		int index = 0;
		User human = new User();
		
		for (User person : userList)
		{
			if (person.getUserName().equals(username))
			{
				human = userList.get(index);
				break;
			}
			index = index + 1;
		}
		
		return human;
	}
	
	
	public Chair getChair(String username)
	{
		int index = 0;
		Chair human = new Chair();
		
		for (Chair person : chairList)
		{
			if (person.getUserName().equals(username))
			{
				human = chairList.get(index);
				break;
			}
			index = index + 1;
		}
		
		return human;
	}
	
	public Author getAuthor(String username)
	{
		int index = 0;
		Author human = new Author();
		
		for (Author person : authorList)
		{
			if (person.getUserName().equals(username))
			{
				human = authorList.get(index);
				break;
			}
			index = index + 1;
		}
		
		return human;
	}
	
	public Admin getAdmin(String username)
	{
		int index = 0;
		Admin human = new Admin();
		
		for (User person : adminList)
		{
			if (person.getUserName().equals(username))
			{
				human = adminList.get(index);
				break;
			}
			index = index + 1;
		}
		
		return human;
	}	
	

	public Reviewer getReviewer(String username)
	{
		int index = 0;
		Reviewer human = new Reviewer();
		
		for (Reviewer person : reviewerList)
		{
			if (person.getUserName().equals(username))
			{
				human = reviewerList.get(index);
				break;
			}
			index = index + 1;
		}
		
		return human;
	}		
	
	
	public Paper selectPaper()
	{
		boolean valid = false;
		String paperIndex = "";
		
		Scanner answer = new Scanner(System.in);
		
		while (!valid)
		{	
			menu.selectPaper();
			menu.displayAllPaperStatus(paperList, conferenceList);
			System.out.print("\t\t  Input the Paper's ID : ");
			paperIndex = answer.nextLine().trim();
			valid = validation.integerValidation(paperIndex, 1, paperList.size());
		}
		
		int number = Integer.parseInt(paperIndex);
		number = number - 1;
		Paper paper = paperList.get(number);
		
		return paper;
	}
	
	public Paper selectPaperFromList(ArrayList<Paper> list)
	{
		boolean valid = false;
		String paperIndex = "";
		
		Scanner answer = new Scanner(System.in);
		
		while (!valid)
		{	
			menu.selectPaper();
			menu.displayPaperForChair(list,conferenceList);
			System.out.print("\t\t  Input the Paper's ID : ");
			paperIndex = answer.nextLine().trim();
			valid = validation.integerValidation(paperIndex, 1, list.size());
		}
		
		int number = Integer.parseInt(paperIndex);
		number = number - 1;
		Paper paper = list.get(number);
		
		return paper;
	}
	
	public Reviewer selectReviewer(ArrayList<Reviewer> newList)
	{
		Scanner console = new Scanner(System.in);
		
		boolean valid = false;
		String choose = "";
				
		while (!valid)
		{
			choose = console.nextLine().trim();
			valid = validation.integerValidation(choose, 1, newList.size());
		}
		
		int indexReviewer = Integer.parseInt(choose);
		int number = indexReviewer -1 ;
		Reviewer reviewer = newList.get(number);
		
		return reviewer;
	}
	
	public void assignPaper(Chair chair)
	{
		Scanner console = new Scanner(System.in);
		boolean valid = false;
		Paper selectedPaper = new Paper();
		
		ArrayList<Paper> myPapers = paperInChairConference(chair);
		boolean check = validation.checkIfThereIsNoPaper(myPapers);
		if (check == false)
			return;
		
		
		String answer = "";
		
		while(!valid)
		{
			selectedPaper = selectPaperFromList(myPapers);
			valid = validation.checkTotalReviewers(selectedPaper);
			if (valid == false)
				return;
		}
		
		ArrayList<String> topic = selectedPaper.getTopic();
		
		ArrayList<Reviewer> reviewerFilterList = new ArrayList<Reviewer>();
		
		for (String keyword : topic)
		{
			for (Reviewer person : reviewerList)
			{
				ArrayList<String> expertises = person.getExpertise();
				for (String exp : expertises)
				{
					if (exp.equals(keyword))
					{
						reviewerFilterList.add(person);
						break;
					}
				}
				
			}
		}	
		
		ArrayList<Reviewer> List = reviewerFilterList;
		ArrayList<String> paperReviewers = selectedPaper.getReviewer();
		
		for(int order = 0; order < reviewerFilterList.size(); order++)
		{
			for(int sequence = 0; sequence < paperReviewers.size(); sequence++)
			{
				if (paperReviewers.get(sequence).equals(reviewerFilterList.get(order).getName()))
				{
					List.remove(order);
				}
			}
		}
		
		reviewerFilterList = List;
		
		if (reviewerFilterList.size() == 0)
			System.out.println("\n\t\t >>o Sorry there is no available reviewer at this time .. ");
		
		else
		{
			
			System.out.println("\n\t\t:::::::::::::::SELECT REVIEWER:::::::::::::::::");
			System.out.println("\t\t   >> Selected paper : " + selectedPaper.getTitle());
			System.out.println("\t\t   >> Author : " + selectedPaper.getAuthor());
			System.out.println("\t\t   >> Papers' Topics: ");
			for(String keyword : topic)
			{
				System.out.println("\t\t      .o.  " + keyword);
				
			}
			
			System.out.println("\t\t   >> Papers' Reviewers: " + selectedPaper.getReviewer().size() + " of 4");
			System.out.println("\t\t:::::::::::::::::::::::::::::::::::::::::::::");
			int index = 1;
			for (Reviewer person : reviewerFilterList)
			{
				System.out.println("\t\t   >> ID: [" + index + "]");
				System.out.println("\t\t   >> Name : " + person.getName());
				System.out.println("\t\t===========================================");
				index = index + 1;
			}
			boolean value = false;
			Reviewer reviewer = new Reviewer();
			while(!value)
			{
				System.out.print("\t\t    Insert the reviewer ID: ");
				reviewer = selectReviewer(reviewerFilterList);
				System.out.println("\n\t\t >o The reviewer you have chose is: " + reviewer.getName());
				value = validation.checkReviewers(selectedPaper, reviewer);
			}
			
						
			ArrayList<String> paperChecker = selectedPaper.getReviewer();
			paperChecker.add(reviewer.getName());
			selectedPaper.setReviewer(paperChecker);
			selectedPaper.setStatus("Reviewing");
			
			int paperIndex = 0;
			for (Paper journal : paperList)
			{
				String title = journal.getTitle();
				
				if (selectedPaper.getTitle().equals(title))
					break;
				
				paperIndex = paperIndex + 1;
			}
			
			paperList.set(paperIndex, selectedPaper);
			menu.displayPaper(selectedPaper);

		}
	}
	
	
	public String logIn()
	{
		Scanner answer = new Scanner(System.in);
		String username = "";
		String password = "";
		boolean valid = false;
		
		while (!valid)
		{
			System.out.println("\n\t\t**************LOG**IN******************");
			System.out.print("\t\t >> Please insert your username : ");
			username = answer.nextLine().trim();
			valid = validation.checkUserNameExistance(username, userList);
			if (valid == false)
				System.out.println("\n\t\t !!Username is not exist, please input the correct username");
		}
		
		valid = false;
		int attempt = 0;
		while (!valid)
		{
			System.out.print("\t\t >> Please insert your password : ");
			password = answer.nextLine().trim();
			valid = validation.checkUserPassword(username, password, userList);
			
			if (valid == false)
			{
				System.out.println("\n\t\t !! Password is not correct");
			    attempt = attempt + 1;
			}
			
			if (attempt == 3)
			{
				System.out.println("\n\t\t >> You already failed 3 times, please try to input your usename again ");
				home();
			}	
		}	
		
		return username;
	}
	
	public void logOut()
	{
		String decision = "";
		Scanner console = new Scanner(System.in);
		do
		{
			boolean valid = false;
			while (!valid)
			{
				System.out.print("\t\t >> Are you sure you want to log out?(y/n) ");
				decision = console.nextLine().trim().toLowerCase();
				valid = validation.checkNoBlank(decision);
			}
			
			decision = decision.substring(0, 1);
			
			if (decision.equals("y"))
            {
                home();
            }    
            else
                if (decision.equals("n"))
                    return; 
            else
                 System.out.print("\t\t >> Please enter your answer again (y/n) ");			
		}while (!decision.equals("n") && !decision.equals("y"));
	}
	
		
	public void createUser(String chosen)
	{
		String role = chosen;
		boolean valid = false;
		String name = "";
		String username = "";
		String email = "";
		String password = "";
		
		
		Scanner answer = new Scanner(System.in);
		while(!valid)
		{
			System.out.println();
			System.out.print("\t\t >> Please insert your name : ");
			name = answer.nextLine().trim();
			valid = validation.checkNoBlank(name);
		}
		valid = false;
		while(!valid)
		{
			System.out.print("\t\t >> Please insert your username : ");
			username = answer.nextLine().trim();
			valid = validation.checkNoBlank(username);
			boolean existance = validation.checkUserNameExistance(username, userList);
			if (existance == true)
			{
				valid = false;
				System.out.println();
				System.out.println("\t\t !! This username is already exist, please choose another one");
				System.out.println();
			}
		}
		
		System.out.print("\t\t >> Please insert your job title : ");
		String job = answer.nextLine().trim();
		valid  = false;
		while(!valid)
		{
			System.out.print("\t\t >> Please insert your email : ");
			email = answer.nextLine().trim();
			valid = validation.checkNoBlank(email);
		}
		
		valid  = false;
		while(!valid)
		{
			System.out.print("\t\t >> Please set your password : ");
			password = answer.nextLine().trim();
			valid = validation.checkNoBlank(password);
		}
		
		if(role.equals("1"))
		{
			createChair(name, username, job, email, password);
		}
		else
			if (role.equals("2"))
		{
				createReviewer(name, username, job, email, password);
		}
		else 
			if (role.equals("3"))
		{
				createAuthor(name, username, job, email, password);
		}
		else 
			if (role.equals("4"))
		{
				createAdmin(name, username, job, email, password);
		}	
		
	}
	
	public void createAdmin(String name, String username, String job, String email, String password)
	{
		Admin admin = new Admin();
		String adminName = name;
		String adminUsername = username;
		String role = "Admin";
		String adminJob = job;
		String adminEmail = email;
		String pass = password;
		
		admin.setName(adminName);
		admin.setUserName(adminUsername);
		admin.setRole(role);
		admin.setJobTitle(adminJob);
		admin.setEmail(adminEmail);
		admin.setPassword(pass);
		
		userList.add(admin);
	}
	
	
	public void createChair(String name, String username, String job, String email, String password)
	{
		Chair chair = new Chair();
		String chairName = name;
		String chairUsername = username;
		String role = "Chair";
		String chairJob = job;
		String chairEmail = email;
		String pass = password;
		
		chair.setName(chairName);
		chair.setUserName(chairUsername);
		chair.setRole(role);
		chair.setJobTitle(chairJob);
		chair.setEmail(chairEmail);
		chair.setPassword(pass);
		
		chairList.add(chair);
		userList.add(chair);
		menu.displayChair(chair);
	}
	
	public String insertKeyword()
	{
		boolean valid = false;
		String key = "";
		
		Scanner answer = new Scanner(System.in);
		
		while (!valid)
		{	
			menu.displayKeyword(keywordList);
			key = answer.nextLine().trim();
			valid = validation.integerValidation(key, 1, keywordList.size());
		}
		
		int number = Integer.parseInt(key);
		
		number = number - 1;
		String keyword = keywordList.get(number).getKeyword();
		
		
		return keyword;
		
	}
	
	public ArrayList<String> insertMoreThanOneKeyword()
	{
		ArrayList<String> choosenKeywords = new ArrayList<String>();
		Scanner console = new Scanner(System.in);
		boolean checktopic = false;
		
		String topic = insertKeyword();
		choosenKeywords.add(topic);	
		System.out.println("\t\t >>You choose: " + topic);
		
		if (topic.length() != 0)
		{
			for (int index = 2 ; index > 0 ; index++)
			{
				System.out.println();
				System.out.println("\t\t >> Select another keyword (" + index + ") - press enter to leave blank: ");
				menu.displayKeyword(keywordList);
				String topic2 = console.nextLine().trim();
				
				
				if (topic2.length() == 0)
					break;
				else
					if (topic2.length() != 0)
					{
						boolean valid = false;
						while(!valid)
						{
							valid = validation.integerValidation(topic2, 1, keywordList.size());
							if (valid == false)
							{
								menu.displayKeyword(keywordList);
								topic2 = console.nextLine().trim();
							}
						}
					
						int number = Integer.parseInt(topic2);
						number = number - 1;
						topic2 = keywordList.get(number).getKeyword();
						System.out.println("\t\t >>You choose: " + topic2);
						checktopic = false;
						
						for (String expertise : choosenKeywords)
						{
							if(topic2.equals(expertise))
							{
								System.out.println("\n\t\t !!You already choose that keyword, please choose another one");
								checktopic = true;
								break;
							}
						}
						
						if(checktopic == false)
							choosenKeywords.add(topic2);
					}
				}	
			}
		
		
		return choosenKeywords;
	}
	
	public void createReviewer(String name, String username, String job, String email, String password)
	{
		Reviewer reviewer = new Reviewer();
		Scanner console = new Scanner(System.in);
		ArrayList<String> choosenKeywords = new ArrayList<String>();
		System.out.println();
		System.out.println("\t\t >> Insert your expertise");
		String topic = insertKeyword();
		boolean checktopic = false;
		
		choosenKeywords.add(topic);	
		System.out.println("\t\t >>You choose: " + topic);
		if (topic.length() != 0)
		{
			for (int index = 2 ; index > 0 ; index++)
			{
				System.out.println();
				System.out.println("\t\t >> Select your another expertise (" + index + ") - press enter to leave blank: ");
				menu.displayKeyword(keywordList);
				String topic2 = console.nextLine().trim();
				
				
				if (topic2.length() == 0)
					break;
				else
					if (topic2.length() != 0)
					{
						boolean valid = false;
						while(!valid)
						{
							valid = validation.integerValidation(topic2, 1, keywordList.size());
							if (valid == false)
							{
								menu.displayKeyword(keywordList);
								topic2 = console.nextLine().trim();
							}
						}
					
						int number = Integer.parseInt(topic2);
						number = number - 1;
						topic2 = keywordList.get(number).getKeyword();
						System.out.println("\t\t >>You choose: " + topic2);
						checktopic = false;
						
						for (String expertise : choosenKeywords)
						{
							if(topic2.equals(expertise))
							{
								System.out.println("\n\t\t !!You already choose that expertise, please choose another one");
								checktopic = true;
								break;
							}
						}
						
						if(checktopic == false)
							choosenKeywords.add(topic2);
					}
				}	
			}
						
		String role = "Reviewer";
		String revName = name;
		String revUsername = username;
		String revJob = job;
		String revEmail = email;
		String pass = password;
		
		reviewer.setName(revName);
		reviewer.setUserName(revUsername);
		reviewer.setRole(role);
		reviewer.setJobTitle(revJob);
		reviewer.setEmail(revEmail);
		reviewer.setPassword(pass);
		reviewer.setExpertise(choosenKeywords);
		
		userList.add(reviewer);
		reviewerList.add(reviewer);
		menu.displayReviewer(reviewer);
	}
		
	public Conference selectConference()
	{
		boolean valid = false;
		Scanner console = new Scanner(System.in);
		String ans = "";
		
        
        while (!valid)
		{	
        	menu.displayAllConference(conferenceList);
    		System.out.println("\t\t===============================================");
            System.out.print("\t\t Please select the conference you want to submit : ");
			ans = console.nextLine().trim();
			valid = validation.integerValidation(ans, 1, conferenceList.size());
		}
        
		int number = Integer.parseInt(ans);
        int opt = number;
		opt = opt - 1;
		Conference conference = conferenceList.get(opt);
		
		return conference;
	}
	
	public void createAuthor(String name, String username, String job, String email, String password)
	{
		Author author = new Author();
		String autName = name;
		String autUsername = username;
		String role = "Author";
		String autJob = job;
		String autEmail = email;
		String pass = password;
		
		author.setName(autName);
		author.setUserName(autUsername);
		author.setRole(role);
		author.setJobTitle(autJob);
		author.setEmail(autEmail);
		author.setPassword(pass);
		
		userList.add(author);
		authorList.add(author);
		menu.displayAuthor(author);
	}
	
	private void storeKeywordsToKeywordList(String keywordDetails)
	{
		String[] allKeyword = keywordDetails.split(";");
		
		for (int line = 0; line < allKeyword.length ; line++)
		{
			String keyword = allKeyword[line];
			Keyword newKeyword = new Keyword(keyword);
			keywordList.add(newKeyword);
		}
	}
	
	private void storeAuthorsToUserList(String authorDetails)
	{
		String[] allAuthor = authorDetails.split(";");
		
		
		for (int line = 0; line < allAuthor.length ; line++)
		{
			String[] details = allAuthor[line].split(",");
			String autName = details[0];
			String autUsername = details[1];
			String role = details[2];
			String autJob = details[3];
			String autEmail = details[4];
			String pass = details[5];
			int totalUser = userList.size();
			int id = totalUser + 1; 
			
			Author author = new Author();
			author.setName(autName);
			author.setUserName(autUsername);
			author.setRole(role);
			author.setJobTitle(autJob);
			author.setEmail(autEmail);
			author.setPassword(pass);
			
			authorList.add(author);
			userList.add(author);
		}
	}
	
	private void storeChairstoUserList(String chairDetails)
	{
		String[] allChair = chairDetails.split(";");
		
		
		for (int line = 0; line < allChair.length ; line++)
		{
			String[] details = allChair[line].split(",");
			String chairName = details[0];
			String chairUsername = details[1];
			String role = details[2];
			String chairJob = details[3];
			String chairEmail = details[4];
			String pass = details[5];
		
			Chair chair = new Chair();
			chair.setName(chairName);
			chair.setUserName(chairUsername);
			chair.setRole(role);
			chair.setJobTitle(chairJob);
			chair.setEmail(chairEmail);
			chair.setPassword(pass);
			
			chairList.add(chair);
			userList.add(chair);
		}
	}
	
	private void storeAdmintoUserList(String adminDetails)
	{
		String[] allAdmin = adminDetails.split(";");
		
		
		for (int line = 0; line < allAdmin.length ; line++)
		{
			String[] details = allAdmin[line].split(",");
			String Name = details[0];
			String Username = details[1];
			String role = details[2];
			String Job = details[3];
			String Email = details[4];
			String pass = details[5];
 
			
			Admin admin = new Admin();
			admin.setName(Name);
			admin.setUserName(Username);
			admin.setRole(role);
			admin.setJobTitle(Job);
			admin.setEmail(Email);
			admin.setPassword(pass);
			
			userList.add(admin);
			adminList.add(admin);
		}
	}
	
	
	private void storeReviewerstoUserList(String reviewerDetails)
	{
		String[] allReviewer = reviewerDetails.split(";");
		
		
		for (int line = 0; line < allReviewer.length ; line++)
		{
			String[] details = allReviewer[line].split(",");
			String revName = details[0];
			String revUsername = details[1];
			String role = details[2];
			String revJob = details[3];
			String revEmail = details[4];
			String pass = details[5];
			ArrayList<String> topic = new ArrayList<String>();
			String exp = details[6];
			topic.add(exp);
			
			Reviewer reviewer = new Reviewer();
			reviewer.setName(revName);
			reviewer.setUserName(revUsername);
			reviewer.setRole(role);
			reviewer.setJobTitle(revJob);
			reviewer.setEmail(revEmail);
			reviewer.setPassword(pass);
			reviewer.setExpertise(topic);
			
			reviewerList.add(reviewer);
			userList.add(reviewer);
		}
	}
	
	
	public void storePaperToPaperList(String paperDetails)
	{
		String[] allPaper = paperDetails.split(";");
		
		
		for (int line = 0; line < allPaper.length ; line++)
		{
			String[] details = allPaper[line].split("///");
			String title = details[0];
			String content = details[1];
			ArrayList<String> topic = new ArrayList<String>();
			String keyword = details[2];
			topic.add(keyword);
			String status = details[3];
			String conf = details[4];
			String aut = details[5];
			
			ArrayList<String> reviewer = new ArrayList<String>();
			reviewer.add(details[6]);
			ArrayList<Review> review = new ArrayList<Review>();
						
			Paper paper = new Paper(title, content, topic, status, conf, aut, reviewer, review); 
			
			paperList.add(paper);
			addPaperToConference(paper);		
			
		}
	}
	
	public void storeReviewToReviewList(String reviewDetails)
	{
		String[] allReview = reviewDetails.split(";");
		
		
		for (int line = 0; line < allReview.length ; line++)
		{
			String[] details = allReview[line].split(",");
			
			String status = details[0];
			String rate = details[1];		
				int rating = Integer.parseInt(rate);
			 String comment = details[2];
			 String paper = details[3];
			 String reviewer = details[4];
			
			 Review review = new Review(status,rating,comment,paper,reviewer);
			 addReviewToPaper(review);
		
			
		}
	}
	
	public void addReviewToPaper(Review review)
	{
		String title = review.getPaper();
		String reviewer = review.getReviewer();
		Paper reviewedPaper = new Paper();
		ArrayList<Review> reviews = new ArrayList<Review>();
		ArrayList<String> reviewers = new ArrayList<String>();
		
		int index = 0;
		for(Paper journal : paperList)
		{
			if (title.equals(journal.getTitle()))
			{
				reviewedPaper = journal;
				reviews = reviewedPaper.getReview();
				reviewers = reviewedPaper.getReviewer();
				reviewers.add(reviewer);
				reviews.add(review);
				reviewedPaper.setReviewer(reviewers);
				reviewedPaper.setReview(reviews);
				paperList.set(index, reviewedPaper);
				break;
			}
			
			index = index + 1;
		}
	}
		

	public void storeConferenceToConferenceList(String conferenceDetails)
	{
		
		String[] allConference = conferenceDetails.split(";");
		
		
		for (int line = 0; line < allConference.length ; line++)
		{
			String[] details = allConference[line].split(",");
			String title = details[0];
			ArrayList<String> topic = new ArrayList<String>();
			String keyword = details[1];
			topic.add(keyword);
			String loc = details[2];
			String speaker = details[3];
			String creator = details[4];
			
			String[] deadPap = new String [3];
				deadPap[0] = details[5];
				deadPap[1] = details[6];
				deadPap[2] = details[7];
				
			String[] deadRev = new String [3];
				deadRev[0] = details[8];
				deadRev[1] = details[9];
				deadRev[2] = details[10];	
			
			Conference newConf = new Conference(title, topic, loc, speaker, creator, deadPap, deadRev);
			conferenceList.add(newConf);
			
		}
	}
	
	
	public void insertContent()
	{
		
		Scanner console = new Scanner(System.in);
		String finish = "--";
		StringBuilder b = new StringBuilder();
		String strLine;
		System.out.println("Please insert content of your paper");
		System.out.println("type only '--' at the final line and press enter to finish ");
		while (!(strLine = console.nextLine()).equals(finish))
		{
			b.append(strLine + ";");
		}
		
		String newString = b.toString();
		System.out.println(newString);
		
		String[] allWords = newString.split(";|\\.");
		
		for (int line = 0; line < allWords.length ; line++)
		{
			String test = allWords[line];
				System.out.println(test);
		}
	}
	
	public boolean checkPaperDeadline(Conference conference)
	{
		boolean valid = false;
		String[] paperDeadline = conference.getDeadlinePaper();		
		String[] today = dateNow();
		
		valid = checkingDate(paperDeadline, today);
		
		if(valid == false)
		{
			System.out.println("\n\t\t >> The conference you choose: " + conference.getTitle());
			System.out.println("\t\t >> Conferences' paper submission deadline: " + paperDeadline[0] +"-" + paperDeadline[1] + "-" + paperDeadline[2] );
			System.out.println("\t\t >> Todays' date : " + today[0] +"-" + today[1] + "-" + today[2] );
			System.out.println("\n\t\t   **Sorry, this conferences' paper submission session is already over**");
			System.out.println("\t\t                 **Please choose another conference**");
		}
		
		return valid;		
	}
	
	public boolean checkReviewDeadline(Paper paper)
	{
		boolean valid = false;
		String confName = paper.getConference();
		Conference conference = new Conference();
		
		for(Conference meeting : conferenceList)
		{
			if (confName.equals(meeting.getTitle()))
				conference = meeting;
		}
				
		String[] reviewDeadline = conference.getDeadlineReview();		
		String[] today = dateNow();
		
		valid = checkingDate(reviewDeadline, today);
		
		if(valid == false)
		{
			System.out.println("\n\t\t >> The paper you choose: " + paper.getTitle());
			System.out.println("\t\t >> Paper review deadline: " + reviewDeadline[0] +"-" + reviewDeadline[1] + "-" + reviewDeadline[2] );
			System.out.println("\t\t >> Todays' date : " + today[0] +"-" + today[1] + "-" + today[2] );
			System.out.println("\n\t\t   **Sorry, this paper review session is already over**");
			System.out.println("\t\t              **Please choose another paper**");
		}
		
		return valid;		
	}
	
	
	public boolean checkingDate(String[] deadline, String[] submission)
	{
		boolean valid = false;
		String deadlineDay = deadline[0];
		String deadlineMonth = deadline[1];
		String deadlineYear = deadline[2];
		String insertDay = submission[0];
		String insertMonth = submission[1];
		String insertYear = submission[2];
		
		int deadYear = Integer.parseInt(deadlineYear);
		int inYear = Integer.parseInt(insertYear);
		
		int deadMonth = Integer.parseInt(deadlineMonth);
		int inMonth = Integer.parseInt(insertMonth);
		
		int deadDay = Integer.parseInt(deadlineDay);
		int inDay = Integer.parseInt(insertDay);
		
		if (deadYear >= inYear)
		{
			if (deadMonth >= inMonth)
			{
				if (deadDay >= inDay)
					valid = true;
			}
		}	
		
		return valid;
	}
	
	
	public void submitPaper(Author author)
	{
		String title = "";
		String content= "";
		String topic = "";
		String status = "Submitted";
		String conf = "";
		String aut = "";
		
		boolean valid;
		boolean checkDeadline;
		
		boolean check = validation.checkIfThereIsNoConference(conferenceList);
		if (check == false)
			return;
		
		Scanner console = new Scanner(System.in);
		Conference conference = selectConference();
		checkDeadline = checkPaperDeadline(conference);
		
		if (checkDeadline == false)
			return;
					
		ArrayList<String> choosenKeywords = new ArrayList<String>();		
		choosenKeywords = conference.getTopic();
		
		conf = conference.getTitle();
		aut = author.getName();
		
		System.out.println("\n\t\t::::::::::::::CREATE NEW PAPER::::::::::::::::::");		
		valid = false;
		while (!valid)
		{
			System.out.print("\t\t >> Please insert the title: ");
			title = console.nextLine().trim();
			valid = validation.checkNoBlank(title);
		}
		String finish = "--";
		StringBuilder b = new StringBuilder();
		String strLine;
		System.out.println("\t\t >> Please insert content of your paper");
		System.out.println("\t\t  Type only '--' at the final line and press enter to finish ");
		while (!(strLine = console.nextLine()).equals(finish))
		{
			b.append(strLine + ";");
		}
		
		String newString = b.toString();
		content = newString;
		
		
		ArrayList<String> reviewer = new ArrayList<String>();
		ArrayList<Review> review = new ArrayList<Review>();
		
		Paper newPap = new Paper(title, content, choosenKeywords, status, conf, aut, reviewer, review);
		addPaperToConference(newPap);
		System.out.println("\t\t >>o Your Paper : " + newPap.getTitle() + " - successfully submitted!");
		paperList.add(newPap);
		menu.displayPaper(newPap);
		
	}
	
	public void addPaperToConference(Paper paper)
	{
		String conference = paper.getConference();
		ArrayList<Paper> list = new ArrayList<Paper>();
		
		int index = 0;
		for(Conference meeting : conferenceList)
		{
			if(meeting.getTitle().equals(conference))
			{
				list = meeting.getPaperList();
				list.add(paper);
				meeting.setPaperList(list);
				conferenceList.set(index, meeting);
				break;
			}
			
			index = index + 1;
		}
		
		
	}
		
	public void uploadDataFromFile()
	{
		String keywordFile = "keywords.txt";
		String authorFile = ("authors.txt");
		String chairFile = ("chairs.txt");
		String reviewerFile = ("reviewers.txt");
		String conferenceFile = ("conferences.txt");
		String paperFile = ("papers.txt");
		String reviewFile = ("reviews.txt");
		String adminFile = ("admin.txt");
		
		String keywordLines = readFile(keywordFile);
		String authorLines = readFile(authorFile);
		String chairLines = readFile(chairFile);
		String reviewerLines = readFile(reviewerFile);
		String conferenceLines = readFile(conferenceFile);
		String paperLines = readFile(paperFile);
		String reviewLines = readFile(reviewFile);
		String adminLines = readFile(adminFile);
		
		storeKeywordsToKeywordList(keywordLines);
		storeAuthorsToUserList(authorLines);
		storeChairstoUserList(chairLines);
		storeReviewerstoUserList(reviewerLines);
		storeConferenceToConferenceList(conferenceLines);
		storePaperToPaperList(paperLines);
		storeReviewToReviewList(reviewLines);
		storeAdmintoUserList(adminLines);
		
	}
	
	
	public void start()
	{
		uploadDataFromFile();
		menu.home();
		home();
	}
	
	
	public void home()
	{
		
		Scanner console = new Scanner(System.in);
		String answer = "";
		boolean valid = false;
		
		while(!valid)
		{
			menu.homeDisplay();
			answer = console.nextLine().trim();
			valid = validation.integerValidation(answer, 1, 3);
		}
		

		if (answer.equals("1"))
		{
			register();
			menu.welcomeNewUser();
			runCMS();
		}
		
		else
			if(answer.equals("2"))
				runCMS();
		
		else
			if(answer.equals("3"))
				exit();
	}
	
	public void runCMS()
	{
		String userName = logIn();
		
		User user = getUser(userName);
		int role = checkRole(user);
		
		if (role == 1)
		{
			Chair chair = getChair(userName);
			runCMSChair(chair);
		}
		
		else
			if(role == 2)
		{
				Reviewer reviewer = getReviewer(userName);
				runCMSReviewer(reviewer);
		}
		else
			if(role == 3)
		{
				Author author = getAuthor(userName);
				runCMSAuthor(author);
		}
		else
			if(role == 4)
		{
				Admin admin = getAdmin(userName);
				runCMSAdmin(admin);
		}
		
	}
	
	public void runCMSAdmin(Admin admin)
	{
		int option;
        String answer = "";
        
        
		while(true)
		{
			Scanner respon = new Scanner(System.in);
			boolean valid = false;
					
			while(!valid)
			{
				menu.adminDisplay(admin);
				answer = respon.nextLine().trim();
				valid = validation.integerMenuValidation(answer);
			}
			
			option = Integer.parseInt(answer);
			
			switch (option)
	        {
	            case 1:
	                menu.displayAllUser(userList);break;
	            
	            case 2:
	            	displayAllConferenceThenSpecificConference();break;
	            
	            case 3:
	            	displayAllPaperThenSpecificPaper(); break;
	                
	            case 4:
	            	displayAllKeyword();break;
	            	
	            case 5:
	            	createKeyword();break;
	                
	            case 6:
	                logOut(); break;  
	                
	            default:
	                System.out.println("\n\t\tERROR : Invalid Input. Please enter a valid number (1-6) \n ");
	        }
				
		}
	}
	
	
	public void runCMSChair(Chair chair)
	{
		int option;
        String answer = "";
        
        
		while(true)
		{
			Scanner respon = new Scanner(System.in);
			boolean valid = false;
					
			while(!valid)
			{
				menu.chairDisplay(chair);
				answer = respon.nextLine().trim();
				valid = validation.integerMenuValidation(answer);
			}
			
			option = Integer.parseInt(answer);
			
			switch (option)
	        {
	            case 1:
	                createConference(chair);break;
	            
	            case 2:
	            	displayConferenceDetail(chair);break;
	            
	            case 3:
	                assignPaper(chair); break;
	                
	            case 4:
	            	verifyReview(chair);break;
	            	
	            case 5:
	            	createNotification(chair);break;
	                
	            case 6:
	                logOut(); break;  
	                
	            default:
	                System.out.println("\n\t\tERROR : Invalid Input. Please enter a valid number (1-6) \n ");
	        }
				
		}
	}
	
	public void runCMSAuthor(Author author)
	{
		int option;
        String answer = "";
        
        while (true)
        {
            Scanner console = new Scanner(System.in);
            boolean valid = false;
            
            while (!valid)
            {
               menu.authorDisplay(author);
               answer = console.nextLine().trim();
               valid = validation.integerMenuValidation(answer);
            }
            
            option = Integer.parseInt(answer);
            
            switch (option)
            {
                case 1:
                    submitPaper(author);break;
                 
                case 2:
                	displayAllConferenceThenSpecificConference();break;
                
                case 3:
                	displayAuthorPaperDetail(author);break;
                	
                case 4:
                	menu.displayNotification(author);break;
                    
                case 5:
                	logOut();break;
             
                default:
                    System.out.println("\n\t\tERROR : Invalid Input. Please enter a valid number (1-7) \n ");
            }

        }
	}
	
	public void runCMSReviewer(Reviewer reviewer)
	{
		int option;
        String answer = "";
        
        while (true)
        {
            Scanner console = new Scanner(System.in);
            boolean valid = false;
            
            while (!valid)
            {
               menu.reviewerDisplay(reviewer);
               answer = console.nextLine().trim();
               valid = validation.integerMenuValidation(answer);
            }
            
            option = Integer.parseInt(answer);
            
            switch (option)
            {
                case 1:
                   reviewPaper(reviewer);break;
                
                case 2:
                	displayReviewedPaper(reviewer);break;
                   
                case 3:
                	logOut();break;
                default:
                    System.out.println("\n\t\tERROR : Invalid Input. Please enter a valid number (1-3) \n ");
            }

        }
	}
	
	
	public void displayAllConferenceThenSpecificConference()
	{
		Scanner console = new Scanner(System.in);
		boolean valid = false;
		String answer= "";
		
		boolean check = validation.checkIfThereIsNoConference(conferenceList);
		if (check == false)
			return;
		
		menu.displayAllConference(conferenceList);
		valid = false;
		while(!valid)
		{
			System.out.print("\t\t Please select the conference for more details : ");
			answer = console.nextLine().trim();
			valid = validation.integerValidation(answer, 1, conferenceList.size());
		}
		
		int num = Integer.parseInt(answer);
		num = num - 1;
		Conference conf = conferenceList.get(num);
		menu.displayConference(conf);
	}
		
	
	public ArrayList<Conference> myConferenceList(Chair chair)
	{
		String name = chair.getName();
		ArrayList<Conference> ownConf = new ArrayList<Conference>();
		
		for(Conference meeting : conferenceList)
		{
			if(name.equals(meeting.getCreator()))
				ownConf.add(meeting);
		}
		
		return ownConf;	
	}
	
	public void reviewPaper(Reviewer reviewer)
	{
		ArrayList<Paper> assignedPaper = new ArrayList<Paper>();
		ArrayList<String> reviewerList = new ArrayList<String>();
		String name = reviewer.getName();
		
		for(Paper journal : paperList)
		{
			 reviewerList = journal.getReviewer();
			 
			 for(String checker : reviewerList)
			 {
				if (checker.equals(name))
				{
					assignedPaper.add(journal);
				}
			 }
			
		}
		
		if (assignedPaper.size() == 0)
			System.out.println("\n\t\t  >>o Relax, you dont have any paper assigned");
		else
		{
			Paper paper = selectPaperToReview(assignedPaper);
			System.out.println("\t\t   >>o Selected Paper Details :");
			menu.displayPaper(paper);
			
			ArrayList<Review> paperReviews = paper.getReview();
			
			for (Review comment : paperReviews)
			{
				if (comment.getReviewer().equals(name))
				{
					System.out.println("\n\t\t   >>o You already reviewed this paper! ");
					return;
				}
			}
			
			createReview(reviewer, paper);
		}				
		
	}
	
	
	public void createReview(Reviewer reviewer, Paper paper)
	{
		String status;
		int rating;
		String rate = "" ;
		String comment;
		String paperTitle;
		String reviewerPaper;
			
		boolean valid;
		boolean checkDeadline = checkReviewDeadline(paper);
		
		if (checkDeadline == false)
			return;
		
		Scanner console = new Scanner(System.in);
		reviewerPaper = reviewer.getName();
		paperTitle = paper.getTitle();
		status = "Submitted";
		System.out.println("\n\t\t::::::::::::::::::::::::::::::::::::::");
		System.out.println("\t\t ::      CREATE NEW REVIEW          ::");
		System.out.println("\t\t::::::::::::::::::::::::::::::::::::::");
		valid = false;
		
		System.out.println("\t\t   >> Please insert your review ");
		String finish = "--";
		StringBuilder b = new StringBuilder();
		String strLine;
		System.out.println("\t\t    >>o To end you review : type only '--' at the final line and press enter");
		while (!(strLine = console.nextLine()).equals(finish))
		{
			b.append(strLine + ";");
		}
		
		String newString = b.toString();
		comment = newString;
		
		while(!valid)
		{
			System.out.print("\t\t >> Please insert papers' rating (1-10): ");
			rate = console.nextLine().trim();
			valid = validation.integerValidation(rate, 1, 10);
		}
		
		rating = Integer.parseInt(rate);
		
		Review review = new Review(status,rating,comment,paperTitle,reviewerPaper); 
		ArrayList<Review> reviews = paper.getReview();
		reviews.add(review);
		paper.setReview(reviews);
		addPaperToPaperList(paper);
		menu.displayPaper(paper);
		
		
	}
	
	public void addPaperToPaperList(Paper paper)
	{
		String title = paper.getTitle();
		
		int index = 0;
		for(Paper journal : paperList)
		{
			if(title.equals(journal.getTitle()))
			{
				paperList.set(index, paper);
				System.out.println("\t\t >>o Your Review has been successfully submitted!");
				break;
			}
			
			index = index + 1;
		}
			
	}
	
	public Paper selectPaperToReview(ArrayList<Paper> list)
	{
		Scanner console = new Scanner(System.in);
		String choose = "";
		menu.myPaperList();
		
		
		boolean valid = false;
		
		while (!valid)
		{
			menu.displayPaperForReviewer(list, conferenceList);
			choose = console.nextLine().trim();
			valid = validation.integerValidation(choose, 0, list.size());
		}
		
		int opt = Integer.parseInt(choose);
		opt = opt - 1;
		Paper paper = list.get(opt);
		
		return paper;
	}
	
	
	
	public void createConference(Chair chair)
	{	
		String title = "";
		String loc = "";
		String speak = "";
		Chair creator = chair;
		String[] deadPap = new String [3];
		String[] deadRev = new String [3];
		ArrayList<String> choosenKeywords = new ArrayList<String>();
		
		boolean valid;
		
		Scanner console = new Scanner(System.in);
		System.out.println("\n\t\t8888888888888888888888888888888888888888888888");
		System.out.println("\t\t888         Create New Conference          888");
		System.out.println("\t\t8888888888888888888888888888888888888888888888");
		valid = false;
		while (!valid)
		{
			System.out.print("\n\t\t >> Please insert the title : ");
			title = console.nextLine().trim();
			valid = validation.checkNoBlank(title);
		}
		
		System.out.println("\t\t >> Select the conference's topic");
		choosenKeywords = insertMoreThanOneKeyword();
		
				
		valid = false;
		while (!valid)
		{
			System.out.print("\n\t\t >> Please insert the location of the conference: ");
			loc = console.nextLine().trim();
			valid = validation.checkNoBlank(loc);
		}
		
		valid = false;
		while (!valid)
		{
			System.out.print("\n\t\t >> Please insert the speaker of conference: ");
			speak = console.nextLine().trim();
			valid = validation.checkNoBlank(speak);
		}
		
		System.out.println("\n\t\t >> Please insert the paper deadline submission date (dd-mm-yyyy)");
		deadPap = insertDate();
		
		System.out.println("\n\t\t >> Please insert the deadline for review (dd-mm-yyyy)");
		deadRev = insertDate();
		
		String chairName = creator.getName();
		Conference newConf = new Conference(title, choosenKeywords, loc, speak, chairName, deadPap, deadRev);
		conferenceList.add(newConf);
		menu.displayConference(newConf);
	}
	
	public void chooseRole()
	{
		Scanner answer = new Scanner(System.in);
		boolean valid = false;
		String role = "";
		
		while(!valid)
		{
			menu.displayRoles();
			role = answer.nextLine().trim();
			valid = validation.integerValidation(role, 1, 5);
		}
		
		if(role.equals("5"))
			home();
		else
			createUser(role);
	}
	
	
	public void register()
	{
		menu.registerdisplay();
		chooseRole();
	}
	
	public String[] insertDate()
	{
		Scanner console = new Scanner(System.in);
		String answer = "";
		boolean valid = false;
		String day = "";
		String month = "";
		String year = "";
		
		//System.out.println("Inserting date");
		while(!valid)
		{
			System.out.print("\t\t     >o Please insert day (1-31) : ");
			day = console.nextLine().trim();
			valid = validation.integerValidation(day, 1, 31);				
		}
		
		valid = false;
		while(!valid)
		{
			System.out.print("\t\t     >o Please insert month (1-12) : ");
			month = console.nextLine().trim();
			valid = validation.integerValidation(month, 1, 12);				
		}
		
		valid = false;
		while(!valid)
		{
			System.out.print("\t\t     >o Please insert year (yyyy) : ");
			year = console.nextLine().trim();
			valid = validation.yearValidation(year);				
		}
	
		
		System.out.println("\n\t\t ** Date: " + day +"-"+ month + "-" + year);
		String[] dateData = new String [3];
		dateData[0] = day;
		dateData[1] = month;
		dateData[2] = year;
		
		return dateData;
	}
	
	
	public String[] dateNow()
	{
		DateFormat day = new SimpleDateFormat("dd");
		DateFormat month = new SimpleDateFormat("MM");
		DateFormat year = new SimpleDateFormat("yyyy");
		
		java.util.Date today = Calendar.getInstance().getTime();
		String dayNow = day.format(today);
		String monthNow = month.format(today);
		String yearNow = year.format(today);

		String[] nowDate = new String[3];
		nowDate[0] = dayNow;
		nowDate[1] = monthNow;
		nowDate[2] = yearNow;
		
		return nowDate;

	}
	
	public void displayAuthorPaperDetail(Author author)
	{
		ArrayList<Paper> authorPapers = authorOwnPaper(author);
		
		boolean check = validation.checkIfThereIsNoPaper(authorPapers);
		if (check == false)
			return;
		
		menu.displayOwnPapers(authorPapers, conferenceList);
		
		boolean valid = false;
		String answer = "";
		Scanner console = new Scanner(System.in);
		
		while(!valid)
		{
			System.out.print("\t\t Please select the paper for more details : ");
			answer = console.nextLine().trim();
			valid = validation.integerValidation(answer, 1, authorPapers.size());
		}
		
		int num = Integer.parseInt(answer);
		num = num - 1;
		Paper paper = authorPapers.get(num);
		menu.displayPaper(paper);		
	}
	
	
	public ArrayList<Paper> authorOwnPaper(Author author)
	{
		String name = author.getName();
		ArrayList<Paper> ownPaper = new ArrayList<Paper>();
		
		for(Paper journal : paperList)
		{
			if(name.equals(journal.getAuthor()))
			{
				ownPaper.add(journal);
			}
		}
		
		return ownPaper;	
	}
	
	public ArrayList<Paper> reviewerPapers(Reviewer reviewer)
	{
		String name = reviewer.getName();
		ArrayList<Paper> reviewerPaper = new ArrayList<Paper>();
		ArrayList<String> reviewerList = new ArrayList<String>();
		
		for(Paper journal : paperList)
		{
			reviewerList = journal.getReviewer();
			
			for(String checker : reviewerList)
			{
				if(name.equals(checker))
				{
					reviewerPaper.add(journal);
					break;
				}
			}
			
		}
		
		return reviewerPaper;
	}
	
	
	public void displayReviewedPaper(Reviewer reviewer)
	{
		ArrayList<Paper> reviewerPaper = reviewerPapers(reviewer);
		menu.displayOwnPapers(reviewerPaper, conferenceList);
		boolean valid = false;
		String answer = "";
		Scanner console = new Scanner(System.in);
		
		if(reviewerPaper.size() == 0)
		{
			System.out.println("\n\t\t   >>o There is no reviewed paper yet " );
		}
		
		else
		{	
			while(!valid)
			{
				System.out.print("\t\t Please select the paper for more details : ");
				answer = console.nextLine().trim();
				valid = validation.integerValidation(answer, 1, reviewerPaper.size());
			}
			
			int num = Integer.parseInt(answer);
			num = num - 1;
			Paper paper = reviewerPaper.get(num);
			menu.displayPaper(paper);
		
		}
				
	}
	
	
	public void updateReviewStatus(Review review)
	{
		String title = review.getPaper();
		String reviewer = review.getReviewer();
		
		Paper reviewedPaper = new Paper();
		ArrayList<Review> reviews = new ArrayList<Review>();
		
		int index = 0;
		for(Paper journal : paperList)
		{
			if (title.equals(journal.getTitle()))
			{
				reviewedPaper = journal;
				reviews = reviewedPaper.getReview();
				
				int number = 0;
				for(Review comment : reviews)
				{
					if(reviewer.equals(comment.getReviewer()))
					{
						reviews.set(number,review);
						reviewedPaper.setReview(reviews);
						paperList.set(index, reviewedPaper);
						return;
					}
					number = number + 1;
				}
			}
			
			index = index + 1;
		}
	}
	
	
	public void acceptReview(Review review)
	{
		review.setStatus("Accepted");	
		Review newReview = review;
		updateReviewStatus(newReview);
	}
	
	public void rejectReview(Review review)
	{
		review.setStatus("Rejected");
		Review newReview = review;
		updateReviewStatus(newReview);
	}
	
	public ArrayList<Paper> paperInChairConference(Chair chair)
	{
		ArrayList<Paper> reviewedPaper = new ArrayList<Paper>();
		ArrayList<Conference> ownConf = myConferenceList(chair);
		for(Conference meeting : ownConf)
		{
			ArrayList<Paper> confPaper = meeting.getPaperList();
			for(Paper journal : confPaper)
			{
				reviewedPaper.add(journal);
			}
		}
		
		return reviewedPaper;
	}
	
	
	public Paper selectPaperToReviewExamine(ArrayList<Paper> list)
	{
		Scanner console = new Scanner(System.in);
		String choose = "";
		menu.myPaperList();
		
		
		boolean valid = false;
		
		while (!valid)
		{
			menu.displayPaperForChair(list, conferenceList);
			System.out.print("\t\t Insert Papers' ID you want to examine the review: ");
			choose = console.nextLine().trim();
			valid = validation.integerValidation(choose, 0, list.size());
		}
		
		int opt = Integer.parseInt(choose);
		opt = opt - 1;
		Paper paper = list.get(opt);
		
		return paper;
	}
	
	
	public void verifyReview(Chair chair)
	{
		ArrayList<Paper> paperInMyConference = paperInChairConference(chair);
		boolean check = validation.checkIfThereIsNoPaper(paperInMyConference);
		if (check == false)
			return;
		
		Paper selectedPaper = selectPaperToReviewExamine(paperInMyConference);
		
		ArrayList<Review> totalReviews = selectedPaper.getReview();	
		
		if (totalReviews.size() == 0)
		{
			System.out.println("\n\t\t >> This paper has no review ");
			return;
		}
		String answer = "";
		String reply = ""; 
		
	while(true)
		{
			Scanner console = new Scanner(System.in);
			boolean valid = false;
			
			while(!valid)
			{
				menu.displayPaper(selectedPaper);
				System.out.print("\t\t Insert reviews' number you want to examine: ");
				answer = console.nextLine().trim();
				valid = validation.integerValidation(answer, 1, totalReviews.size());
			}
			
			
			int option = Integer.parseInt(answer);
			option = option - 1;
			Review thisReview = totalReviews.get(option);
			menu.displayReview(selectedPaper, thisReview);
			examineReviewPaper(thisReview);
			
			valid = false;
			while (!valid)
            {
                System.out.print("\n\t\t >> Do you want to go through this papers' reviews again?(y/n) ");
                reply = console.nextLine().trim().toLowerCase();
                valid = validation.checkYNanswer(reply);
            }
					
			if (reply.equals("n"))
                break;
	
		}			
	}
	
	public void examineReviewPaper(Review review)
	{
		Scanner console = new Scanner(System.in);
		String answer = "";
		boolean valid = false;
		
		while(!valid)
		{
			menu.displayReviewDecision();
			answer = console.nextLine().trim();
			valid = validation.integerValidation(answer, 1, 3);
		}
		
		int opt = Integer.parseInt(answer);
		
		if(opt == 1)
		{
			acceptReview(review);
			System.out.println("\t\t >> This review has been accepted");
		}
		
		else
			if(opt == 2)
		{
				rejectReview(review);
				System.out.println("\t\t >> This review has been rejected");
		}
	}
	
	public void createNotification(Chair chair)
	{
		ArrayList<Paper> myPapers = paperInChairConference(chair);
		boolean check = validation.checkIfThereIsNoPaper(myPapers);
		if (check == false)
			return;
		
		boolean valid = false;
		String answer = "";
		Scanner console = new Scanner(System.in);
		
		while(!valid)
		{
			System.out.println("\n\t\t >> Select paper to send notification to the Author");
			menu.displayPaperForChair(myPapers, conferenceList);
			System.out.print("\t\t  Please input the papers' ID : ");
			answer = console.nextLine().trim();
			valid = validation.integerValidation(answer, 1, myPapers.size());
		}
		
		int opt = Integer.parseInt(answer);
		opt = opt - 1;
		
		Paper paper = myPapers.get(opt);
		String author = paper.getAuthor();
		Author theAuthor = getAuthorbyName(author);
		ArrayList<String> authorNotifs = theAuthor.getNotification();
		
		String message = "";
		
		valid = false;
		while(!valid)
		{
			System.out.print("\n\t\t >> Type the notification message for the Author: ");
			message = console.nextLine().trim();
			valid = validation.checkNoBlank(message);
		}
		
		authorNotifs.add(message);
		theAuthor.setNotification(authorNotifs);
		updateAuthorNotification(theAuthor);
		
		System.out.println("\n\t\t >> Notification is successfully sent to the Author " + theAuthor.getName());
		
	}
	
	
	public void updateAuthorNotification(Author author)
	{
		int index = 0;
		String name = author.getName();
		
		for (Author person : authorList)
		{
			if (person.getName().equals(name))
			{
				authorList.set(index, author);
				break;
			}
			index = index + 1;
		}
		
		int number = 0;
		for (User human : userList)
		{
			if(name.equals(human.getName()))
			{
				userList.set(number, author);
				break;
			}
			
			number = number + 1;
		}
		
	}
	
	
	public Author getAuthorbyName(String name)
	{
		int index = 0;
		Author human = new Author();
		
		for (Author person : authorList)
		{
			if (person.getName().equals(name))
			{
				human = authorList.get(index);
				break;
			}
			index = index + 1;
		}
		
		return human;
	}	
	
	public void displayAllPaperThenSpecificPaper()
	{
		boolean valid = false;
		String answer = "";
		Scanner console = new Scanner(System.in);
		
		boolean check = validation.checkIfThereIsNoPaper(paperList);
		if (check == false)
			return;

		menu.myPaperList();
		System.out.println ("\t\t>>Total Papers : " + paperList.size());
		while(!valid)
		{
			menu.displayAllPaperStatus(paperList, conferenceList);
			System.out.print("\t\t  Please input the papers' ID for see details : ");
			answer = console.nextLine().trim();
			valid = validation.integerValidation(answer, 1, paperList.size());
		}
		
		int opt = Integer.parseInt(answer);
		opt = opt - 1;
		
		Paper paper = paperList.get(opt);
		menu.displayPaper(paper);
		
	}
	
	public void displayAllKeyword()
	{
		boolean check = validation.checkIfThereIsNoKeyword(keywordList);
		if (check == false)
			return;
		
		int id = 1;
		System.out.println("\n\t\t:::::::::::::::KEYWORDS LIST:::::::::::::::");
		System.out.println("\t\t  >> Total keywords : " + keywordList.size());
		for (Keyword word : keywordList)
		{
			String keyword = word.getKeyword();
			
			System.out.println("\t\t[" + id + "] " + keyword);
			id = id + 1;
		}
		
		System.out.println("\t\t===================================");
	}
	
	public void createKeyword()
	{
		Scanner answer = new Scanner(System.in);
		boolean valid = false;
		String word = "";
		
		while(!valid)
		{
			System.out.print("\n\t\t >> Please insert the keyword: ");
			word = answer.nextLine().trim();
			valid = validation.checkKeywordExistance(word, keywordList);
		}
		
		Keyword newKeyword = new Keyword(word);
		keywordList.add(newKeyword);
		System.out.println("\n\t\t >> New keyword: " + word + " successfully add to the database" ); 
	}

	public void displayConferenceDetail(Chair chair)
	{
		Scanner console = new Scanner(System.in);
		boolean valid = false;
		String answer= "";
		
		boolean check = validation.checkIfThereIsNoConference(conferenceList);
		if (check == false)
			return;
		
		while(!valid)
		{
			menu.displayChairConferences();
			answer = console.nextLine().trim();
			valid = validation.integerValidation(answer, 1, 3);
		}
		
		int respon = Integer.parseInt(answer);
		
		if(respon == 1)
			displayAllConferenceThenSpecificConference();
		
		else
			if(respon == 2)
		{
			ArrayList<Conference> ownConf = myConferenceList(chair);
			
			check = validation.checkIfThereIsNoConference(ownConf);
			if (check == false)
				return;
			
			menu.displayOwnConf(ownConf);
			valid = false;
			while(!valid)
			{
				System.out.print("\t\t Please select the conference for more details : ");
				answer = console.nextLine().trim();
				valid = validation.integerValidation(answer, 1, ownConf.size());
			}
			
			int option = Integer.parseInt(answer);
			option = option - 1;
			Conference conf = ownConf.get(option);
			menu.displayConference(conf);
							
		}
		
		else
			if(respon == 3)
				return;	
	}
	
	public String readFile(String filename)
	{
		StringBuilder texts = new StringBuilder();
		
		try 
		{
			FileReader inputFile = new FileReader(filename);
			Scanner parser = new Scanner(inputFile);
			
			while (parser.hasNextLine())
            {
                String line = parser.nextLine();
                texts.append(line + ";");
            }
            
            inputFile.close();
            parser.close();
            return texts.toString();
			
		}
		
		catch(FileNotFoundException exception) 
		{
			String error = filename + " not found";
            System.out.println(error);
            return error;
		}
		
		catch(IOException exception) 
        {
            String error = "Unexpected I/O error occured";
            System.out.println(error); 
            return error;
        }    
	}

	private void exit()
    {
        String reply = "";
        Scanner console = new Scanner(System.in);
        
        do
        {
            boolean valid = false;
            while (!valid)
            {
                System.out.print("\n\t\t >> So, you want to exit from MonCC CMS?(y/n) ");
                reply = console.nextLine().trim().toLowerCase();
                valid = validation.checkNoBlank(reply);
            }
            reply = reply.substring(0, 1);
            if (reply.equals("y"))
                menu.exitRegards();
            else
                if (reply.equals("n"))
                    home(); 
            else
                 System.out.println("\t\tPlease enter your answer again (y/n) ");
        }while (!reply.equals("n") && !reply.equals("y"));       
    }
}
