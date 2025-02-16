package Interfaces;


import java.util.List;


import model.TblUsuariosusti;

public interface IUsuario {
	void RegistrarUsuario(TblUsuariosusti tblusuario);
	List<TblUsuariosusti> ListadoUsuario();
	TblUsuariosusti validarLogin(TblUsuariosusti tblusuario);
}
