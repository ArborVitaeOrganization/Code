package model.interfaces;

import java.util.ArrayList;

import model.bean.Tree;

public interface TreeModel {

	public ArrayList<Tree> doRetrieveByInformations(String name,String species,String country,String co2); //Ricerca Albero attraverso informazioni varie
	
	public ArrayList<Tree> doRetrieveByPrice(double min,double max); //Ricerca Albero mediante range di prezzi
	
	public boolean doUpdate(String name,String country,double price);
	
	public boolean doDelete(String name);
	
	public boolean doAdd(String name,String species,String country,String co2,String description,double price);
}
