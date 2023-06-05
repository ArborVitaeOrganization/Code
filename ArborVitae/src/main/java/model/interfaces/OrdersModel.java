package model.interfaces;

import java.sql.Date;
import java.util.ArrayList;

import model.bean.Orders;

public interface OrdersModel {

	public ArrayList<Orders> doRetrieveByKey(String email);/*, Date date, Date date2);*/
	public ArrayList<Orders> doRetrieveAll();
	public boolean doAdd(Orders o);
}
