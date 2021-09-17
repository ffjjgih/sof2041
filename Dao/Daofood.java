package Dao;

import java.util.List;

import Model.Food;

public interface Daofood extends Daobase<Food>{
	public Food findfood(int id)throws Exception;
	public List<Food> getall()throws Exception;
}
