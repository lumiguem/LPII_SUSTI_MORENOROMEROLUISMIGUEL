package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_usuariosusti database table.
 * 
 */
@Entity
@Table(name="tbl_usuariosusti")
@NamedQuery(name="TblUsuariosusti.findAll", query="SELECT t FROM TblUsuariosusti t")
public class TblUsuariosusti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idusuariosusti;

	private String passwordsusti;

	private String usuariosusti;

	public TblUsuariosusti() {
	}

	public int getIdusuariosusti() {
		return this.idusuariosusti;
	}

	public void setIdusuariosusti(int idusuariosusti) {
		this.idusuariosusti = idusuariosusti;
	}

	public String getPasswordsusti() {
		return this.passwordsusti;
	}

	public void setPasswordsusti(String passwordsusti) {
		this.passwordsusti = passwordsusti;
	}

	public String getUsuariosusti() {
		return this.usuariosusti;
	}

	public void setUsuariosusti(String usuariosusti) {
		this.usuariosusti = usuariosusti;
	}

}