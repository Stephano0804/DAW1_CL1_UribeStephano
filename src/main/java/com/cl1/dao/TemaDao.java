package com.cl1.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cl1.model.Tema;
import com.cl1.util.Util;

public class TemaDao {
	
	@SuppressWarnings("unchecked")
	public List<Tema> traerTodosTemas(){
		Transaction transaction = null;
		List<Tema> temas = null;
		try(Session session = Util.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			temas = session.createQuery("from Tema").list();
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null){transaction.rollback();}
		}
		return temas;
	}
	//guardar 
	public void guardarTema(Tema tema){
		Transaction transaction = null;
		try(Session session = Util.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(tema);
			transaction.commit();
		} catch (Exception e) {
			if(transaction != null){transaction.rollback();}
		}
	}

}
