import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;


public class User 
{
	private String name;
	private String userName;
	private String role;
	private String jobTitle;
	private String email;
	private String password;
	private ArrayList<String> roleList;

	public User()
	{
		name = "";
		userName = "";
		role = "";
		jobTitle = "";
		email = "";
		password ="";
		roleList = new ArrayList<String>(Arrays.asList("Chair","Author","Reviewer","Admin"));
	}
	
	public User(String nam, String user, String job, String mail, String pass)
	{
		name = nam;
		userName = user;
		role = "";
		jobTitle = job;
		email = mail;
		password = pass;
		
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getUserName() 
	{
		return userName;
	}

	public void setUserName(String userName) 
	{
		this.userName = userName;
	}

	public String getRole() 
	{
		return role;
	}

	public void setRole(String role) 
	{
		this.role = role;
	}

	public String getJobTitle() 
	{
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) 
	{
		this.jobTitle = jobTitle;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public ArrayList<String> getRoleList() 
	{
		return roleList;
	}

	public void setRoleList(ArrayList<String> roleList) 
	{
		this.roleList = roleList;
	}
	
	public void displayUser()
	{
		System.out.println("Name: " + name + "\n User Name: " + userName);
		System.out.println("Role: " + role+ "\n Job Title: " + jobTitle);
		System.out.println("Email: " + email);
	}
	
	public void displayRoleList()
	{
		System.out.println("Available roles in CMS are : ");
		
		for (String role : roleList)
		{
			System.out.println(role);
		}
		
	}

}
