package com.cl1.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity

@Table(name="libro")
public class Libro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="tit")
	private String tit;
	@Column(name="precio")
	private String precio;
	@Column(name="cant")
	private String cant;
	@Column(name="origen")
	private String origen;
	@ManyToOne
	private Tema tema;

	public Libro() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Libro(String tit, String precio, String cant, String origen) {
		super();
		this.tit = tit;
		this.precio = precio;
		this.cant = cant;
		this.origen = origen;
	}
	
	

	public Libro(String tit, String precio, String cant, String origen, Tema tema) {
		super();
		this.tit = tit;
		this.precio = precio;
		this.cant = cant;
		this.origen = origen;
		this.tema = tema;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getTit() {
		return tit;
	}


	public void setTit(String tit) {
		this.tit = tit;
	}


	public String getPrecio() {
		return precio;
	}


	public void setPrecio(String precio) {
		this.precio = precio;
	}


	public String getCant() {
		return cant;
	}


	public void setCant(String cant) {
		this.cant = cant;
	}


	public String getOrigen() {
		return origen;
	}


	public void setOrigen(String origen) {
		this.origen = origen;
	}
	
	public String toString(){
		return tit+" - "+ precio + " - " + cant+" - "+origen;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	

}






