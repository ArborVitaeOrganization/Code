package model.bean;

import java.sql.Date;

public class Certificate {
	public Certificate(int c,String n,String d,Date da)
	{
		codeCertificate=c;
		name=n;
		description=d;
		date=da;
	}
	
	public int getCodeCertificate() 
	{
		return codeCertificate;
	}
	
	public void setCodeCertificate(int codeCertificate) 
	{
		this.codeCertificate = codeCertificate;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getDescription() 
	{
		return description;
	}
	
	public void setDescription(String description) 
	{
		this.description = description;
	}
	
	public Date getDate() 
	{
		return date;
	}
	
	public void setDate(Date date) 
	{
		this.date = date;
	}

	private int codeCertificate;
	private String name, description;
	private Date date;
}
