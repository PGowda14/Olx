package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Dto.Customerdto;

public class Customerdao {
EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
EntityManager em=emf.createEntityManager();
EntityTransaction t=em.getTransaction();

public void save(Customerdto dto){
	t.begin();
	em.persist(dto);
	t.commit();
}
public List<Customerdto> find(long mobile){
	return em.createQuery("select x from Customerdto x where mobile=?1").setParameter(1, mobile).getResultList();
}
public List<Customerdto> find(String email){
	return em.createQuery("select x from Customerdto x where email=?1").setParameter(1, email).getResultList();
}
public Customerdto find(int customerid){
	return em.find(Customerdto.class,customerid);
}
}
