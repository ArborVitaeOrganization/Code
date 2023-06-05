package model.bean;

import java.io.Serializable;

public class Tree implements Serializable{

 public Tree(String n, String s, String c, String co, String d, double p,int cod)
 {
  name = n;
  species = s;
  country = c;
  co2 = co;
  description = d;
  price = p;
  codeTree=cod;
 }

 public String getName() 
 {
  return name;
 }
 
 public void setName(String name) 
 {
  this.name = name;
 }
 
 public String getSpecies() 
 {
  return species;
 }
 
 public void setSpecies(String species) 
 {
  this.species = species;
 }
 
 public String getCountry() 
 {
  return country;
 }
 
 public void setCountry(String country) 
 {
  this.country = country;
 }
 
 public String getCo2() 
 {
  return co2;
 }
 
 public void setCo2(String co2) 
 {
  this.co2 = co2;
 }
 
 public String getDescription() 
 {
  return description;
 }
 
 public void setDescription(String description) 
 {
  this.description = description;
 }
 
 public double getPrice() 
 {
  return price;
 }
 
 public void setPrice(double price) 
 {
  this.price = price;
 }

 public int getCodeTree() 
 {
  return codeTree;
 }
 
 private String name, species, country, co2, description;
 private double price;
 private int codeTree;
}