package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_productosusti database table.
 * 
 */
@Entity
@Table(name="tbl_productosusti")
@NamedQuery(name="TblProductosusti.findAll", query="SELECT t FROM TblProductosusti t")
public class TblProductosusti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idproductosusti;

	private String descripsusti;

	private String estadosusti;

	private String nombresusti;

	private double preciocompsusti;

	private double precioventasusti;

	public TblProductosusti() {
	}

	public int getIdproductosusti() {
		return this.idproductosusti;
	}

	public void setIdproductosusti(int idproductosusti) {
		this.idproductosusti = idproductosusti;
	}

	public String getDescripsusti() {
		return this.descripsusti;
	}

	public void setDescripsusti(String descripsusti) {
		this.descripsusti = descripsusti;
	}

	public String getEstadosusti() {
		return this.estadosusti;
	}

	public void setEstadosusti(String estadosusti) {
		this.estadosusti = estadosusti;
	}

	public String getNombresusti() {
		return this.nombresusti;
	}

	public void setNombresusti(String nombresusti) {
		this.nombresusti = nombresusti;
	}

	public double getPreciocompsusti() {
		return this.preciocompsusti;
	}

	public void setPreciocompsusti(double preciocompsusti) {
		this.preciocompsusti = preciocompsusti;
	}

	public double getPrecioventasusti() {
		return this.precioventasusti;
	}

	public void setPrecioventasusti(double precioventasusti) {
		this.precioventasusti = precioventasusti;
	}

}