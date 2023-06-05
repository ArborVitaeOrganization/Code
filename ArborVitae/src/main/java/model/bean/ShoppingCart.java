package model.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class ShoppingCart implements Serializable{
 public ShoppingCart(String e,int n,int c)
 {
  email=e;
  numItems=n;
  codeCart=c;
 }
 
 public int getcodeCart() 
 {
  return codeCart;
 }
 
 public String getEmail() 
 {
  return email;
 }
 
 public void setEmail(String email) 
 {
  this.email = email;
 }
 
 public int getNumItems() 
 {
  return numItems;
 }
 
 public void setNumItems(int numItems) 
 {
  this.numItems = numItems;
 }
 
 
 private String email;
 private int numItems,codeCart;

}