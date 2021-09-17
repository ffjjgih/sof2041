package Dao;

import java.util.List;

import Model.User;

public interface Daousers extends Daobase<User>{
	public List<User> xuatlstuser() throws Exception;
	public User findid(int id) throws Exception;
	public void deleteuser(int id) throws Exception;
}
