package model.interfaces; 
 
import java.util.ArrayList; 
 
import model.bean.ShoppingCart; 
import model.bean.Tree; 
 
public interface ShoppingCartModel { 
 
 public boolean doAdd(String email); 
 public ShoppingCart doRetrieveByKey(String email); 
 public boolean doAddTree(int codeCart,int codeTree); 
 public boolean doRemoveTree(int codeCart,int codeTree); 
 public boolean doRemove(int codeCart); 
 public ArrayList<Tree> doRetrieveTrees(int codeCart); 
}