package model.bean;

import java.sql.Date;
import java.util.ArrayList;

public class Orders {
	public Orders(String e,int co, Date d) 
	{
		email=e;
		codeOrder=co;
		data = d;
	}
	
	public Date getDate() {
		return data;
	}

	public void setDate(Date d) {
		data=d;
	}
	
	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	public int getCodeOrder() 
	{
		return codeOrder;
	}
	
	public void setCodeOrder(int codeOrder) 
	{
		this.codeOrder = codeOrder;
	}
	

	private String email;
	private Date data;
	private int codeOrder;
}
