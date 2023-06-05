package model.bean;

public class User {
	
	public User(String e, String n, String s, String c, String p, userRole r)
	{
		email = e;
		name = n;
		surname = s;
		country = c;
		password = p;
		role=r;
		
	}
	
	public userRole getRole() {
		return role;
	}
	
	
	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getSurname() 
	{
		return surname;
	}

	public void setSurname(String surname) 
	{
		this.surname = surname;
	}

	public String getCountry() 
	{
		return country;
	}

	public void setCountry(String country) 
	{
		this.country = country;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public static enum userRole{Admin,User};
	private String email, name, surname, country, password;
	private userRole role;
}
