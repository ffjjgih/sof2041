package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import Utils.Connectjpa;

public interface Daobase<T> {
	default public T create(T t) throws Exception{
		Connectjpa conn=new Connectjpa();
		EntityManager manager=conn.getEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(t);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		return t;
	}
	default public void delete(T t)throws Exception{
		Connectjpa conn=new Connectjpa();	
		EntityManager manager=conn.getEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		try {
			transaction.begin();
			manager.remove	(t);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	default public void update(T t) throws Exception{
		Connectjpa conn=new Connectjpa();
		EntityManager manager=conn.getEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		try {
			transaction.begin();
			manager.merge(t);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
	}
}
