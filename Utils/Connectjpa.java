package Utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class Connectjpa {
		private static EntityManagerFactory entity;
		public static EntityManager getEntityManager()throws Exception{
				entity=Persistence.createEntityManagerFactory("sof2041final");
			return entity.createEntityManager();
		}
	

}
