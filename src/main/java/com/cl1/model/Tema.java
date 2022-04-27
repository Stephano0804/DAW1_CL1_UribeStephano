package com.cl1.model;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Tema")
public class Tema {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idtema;
	private String nombre;
	@OneToMany(mappedBy="tema", cascade=CascadeType.PERSIST)
	private List<Libro> libros = new ArrayList<Libro>();
	public Tema() {
		super();
	}
	
	public Tema(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public int getIdtema() {
		return idtema;
	}
	public void setIdtema(int idtema) {
		this.idtema = idtema;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Libro> getLibros() {
		return libros;
	}
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	public String toString(){return nombre;}

}
