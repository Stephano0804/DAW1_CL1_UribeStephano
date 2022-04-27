package com.cl1.dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.cl1.model.Libro;
import com.cl1.util.Util;

public class LibroDao {
	
	public void guardarLibro(Libro libro){
		Transaction transaction = null;
		try (Session session = Util.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(libro);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(transaction!=null){
				transaction.rollback();
			}
		}
	}
	
	public List<Libro> obtTodosLosLibros(){
		Transaction transaction = null;
		List<Libro> libros = null;
		try(Session session = Util.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			libros = session.createQuery("from Libro").list();
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(transaction!=null){
				transaction.rollback();
			}
		}
		return libros;
	}
	
	public Libro obtLibroPorId(int id){
		Transaction transaction = null;
		Libro libro = null;
		try(Session session = Util.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			libro = session.get(Libro.class, id);
			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if(transaction!=null){
				transaction.rollback();
			}
		}
		return libro;
	}

}
