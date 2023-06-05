package model.interfaces;

import model.bean.User;

public interface UserModel {
	public boolean doRetrieveByKey(String email,String p);
	public boolean doUpdate(User user,User.userRole u);
	public boolean doDelete(String user);
}
