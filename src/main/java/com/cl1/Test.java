package com.cl1;

import java.util.List;

import com.cl1.dao.LibroDao;
import com.cl1.dao.TemaDao;
import com.cl1.model.Libro;
import com.cl1.model.Tema;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Tema t1 = null;
		Tema t2 = null;
		Tema t3 = null;
		//Crear las carreras
		TemaDao carreraDao = new TemaDao();
			t1 = new Tema("Informatica");
			t2 = new Tema("Diseño");
			t3 = new Tema("Tecnologia");
			carreraDao.guardarTema(t1);
			carreraDao.guardarTema(t2);
			carreraDao.guardarTema(t3);
		
		LibroDao dao = new LibroDao();
		Libro libro = new Libro("Libro1", "Precio", "cantidad", "Origen", t1);
		dao.guardarLibro(libro);
		System.out.println(libro);
		Libro libro2 = new Libro("Harry potter", "150", "20", "Usa", t2);
		dao.guardarLibro(libro2);
		System.out.println(libro2);
		Libro libro3 = new Libro("SQL", "100", "60", "Peru", t3);
		dao.guardarLibro(libro3);
		System.out.println(libro3);
		
		
		List<Libro> libros = dao.obtTodosLosLibros();
		libros.forEach(lib->System.out.println(lib));

	}

}
