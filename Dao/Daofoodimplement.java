package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Model.Food;
import Model.User;
import Utils.Connectjpa;

public class Daofoodimplement implements Daofood{

	private Connectjpa conn;
	private List<Food> lst;
	private EntityManager manager;
	private Food f;
	public Daofoodimplement() {
		this.conn=new Connectjpa();
		this.lst=new ArrayList<Food>();
		try {
			this.manager=conn.getEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.f=new Food();
	}
	@Override
	public Food findfood(int id) throws Exception {
		EntityManager em=conn.getEntityManager();
		f = em.find(Food.class, id);
		return f;
	}
	@Override
	public List<Food> getall() throws Exception {
		TypedQuery<Food> query=conn.getEntityManager().createNamedQuery("Food.findAll",Food.class);
		lst = query.getResultList();
		return lst;
	}
}