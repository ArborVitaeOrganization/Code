package model.interfaces;

import java.util.ArrayList;

import model.bean.Orders;
import model.bean.Products;

public interface ProductModel {

	public ArrayList<Products> doRetrieveByKey(int codeOrder);
	public boolean doAdd(Products p, int codeOrder); 
}
