package Interfaces;

import java.util.List;

import model.TblProductosusti;

public interface IProducto {
	//declaramos los m�todos
	void RegistrarProducto(TblProductosusti tblproducto);
	void ActualizarProducto(TblProductosusti tblproducto);
	void EliminarProducto(TblProductosusti tblproducto);
	List<TblProductosusti> ListadoProducto();
	TblProductosusti BuscarProducto(TblProductosusti tblproducto);

}
