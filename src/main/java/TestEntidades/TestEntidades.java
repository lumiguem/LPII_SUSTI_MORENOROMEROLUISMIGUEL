package TestEntidades;


import java.util.List;

import DaoImp.ClassProductoImp;
import DaoImp.ClassUsuarioImp;
import model.TblProductosusti;
import model.TblUsuariosusti;

public class TestEntidades {

	public static void main(String[] args) {
		//instanciamos la respectivas clases
		TblProductosusti tbl=new TblProductosusti();
		ClassProductoImp crudimp=new ClassProductoImp();
		TblUsuariosusti tblu=new TblUsuariosusti();
		ClassUsuarioImp  crudimpu= new ClassUsuarioImp();
		
		//asignamos valores de usuario
//		tblu.setUsuariosusti("Miguel");
//		tblu.setPasswordsusti("123456");
//		//incovamos el metodo registrar
//		crudimpu.RegistrarUsuario(tblu);
		
		List<TblUsuariosusti> listadousuarios=crudimpu.ListadoUsuario();
		
		//aplicamos un bucle for...
		for(TblUsuariosusti usu:listadousuarios){
			
			//imprimir por pantalla
			System.out.println(" codigo " + usu.getIdusuariosusti() + " usuario " 
			+usu.getUsuariosusti()+ " password " + usu.getPasswordsusti());		
		} //fin del bucle for
		
		//asignamos valores de producto
		tbl.setNombresusti("galletas");
		tbl.setPrecioventasusti(2.5);
		tbl.setPreciocompsusti(1.50);
		tbl.setEstadosusti("nuevo");
		tbl.setDescripsusti("paquete x 6 un");
		//invocamos el metodo registrar producto
		crudimp.RegistrarProducto(tbl);
		
		//***********************TESTEANDO EL METODO LISTADO ...
		
		List<TblProductosusti> listadoproductos = crudimp.ListadoProducto();
		//aplicamos bucle for...
		for(TblProductosusti prod:listadoproductos){
			//imprimimos por pantalla
			System.out.println(" codigo: " + prod.getIdproductosusti() + " nombre: " +prod.getNombresusti() 
			+ " precioVenta: " + prod.getPrecioventasusti() + " precioComrpa: " + prod.getPreciocompsusti()
			+ " estado: " + prod.getEstadosusti() + " descripcion: " + prod.getDescripsusti());
		} //fin del bucle for 

	}

}
