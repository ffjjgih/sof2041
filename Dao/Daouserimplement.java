package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Model.User;
import Utils.Connectjpa;

public class Daouserimplement implements Daousers{

	private Connectjpa conn;
	private List<User> lst;
	public Daouserimplement() {
		this.conn=new Connectjpa();
		lst=new ArrayList<User>();
	}
	@Override
	public List<User> xuatlstuser() throws Exception {
		TypedQuery<User> query=conn.getEntityManager().createNamedQuery("User.findAll",User.class);
		lst = query.getResultList();
		return lst;
	}
	@Override
	public User findid(int id) throws Exception {
		EntityManager em=conn.getEntityManager();
		User us = em.find(User.class, id);
		return us;
	}
	@Override
	public void deleteuser(int id) throws Exception {
		try {
			SessionFactory factory=new Configuration().configure().buildSessionFactory();
			Session session=factory.openSession();
			String hql = "DELETE FROM users WHERE userid = :user_id";
		javax.persistence.Query query = session.createQuery(hql);
		query.setParameter("user_id", id);
		int result = query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
