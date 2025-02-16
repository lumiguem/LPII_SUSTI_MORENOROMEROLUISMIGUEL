package DaoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Interfaces.IProducto;
import model.TblProductosusti;


public class ClassProductoImp implements IProducto{
	
	public void RegistrarProducto(TblProductosusti tblproducto) {
		//establecemos conexion con la unidad de persistencia...
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPII_SUSTI_MORENOROMEROLUISMIGUEL");
		//permite gestionar entidades..
		EntityManager em=emf.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		//registramos
		em.persist(tblproducto);
		//emitimos mensaje por pantalla....
		System.out.println("Producto registrado en BD correctamente!!!!!!!!");
		//confirmamos
		em.getTransaction().commit();
		//cerramos la transaccion...
		em.close();
		
	}

	public void ActualizarProducto(TblProductosusti tblproducto) {
		// Nos conectamos con la unidad de persistencia 
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPII_SUSTI_MORENOROMEROLUISMIGUEL");
		//permite gestionar entidades..
		EntityManager em=emf.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		//actualizamos
		em.merge(tblproducto);
		//emitimos mensaje por consola
		System.out.println("Producto actualizado correctamente");
		//confirmamos
		em.getTransaction().commit();
		//cerramos la transaccion...
		em.close();
		
	}

	public void EliminarProducto(TblProductosusti tblproducto) {
		//establecemos conexion con la unidad de persistencia...
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPII_SUSTI_MORENOROMEROLUISMIGUEL");
		//gestionamos las entidades...
		EntityManager em=emf.createEntityManager();
		//iniciamos la transaccion...
		em.getTransaction().begin();
		//recuperar codigo a eliminar
		TblProductosusti tblprov =em.merge(tblproducto);
		//procedemos a eliminar
		em.remove(tblprov);
		System.out.println("producto eliminado");
		em.getTransaction().commit();
		em.close();
		
	}

	public List<TblProductosusti> ListadoProducto() {
		//establecemos conexion con la unidad de persistencia...
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPII_SUSTI_MORENOROMEROLUISMIGUEL");
		//gestionamos las entidades...
		EntityManager em=emf.createEntityManager();
		//iniciamos la transaccion...
		em.getTransaction().begin();
		//recuperamos el listado de la base de datos..
		List<TblProductosusti> listadoproductos=em.createQuery("select p from TblProductosusti p",TblProductosusti.class).getResultList();
		//confirmamos
		em.getTransaction().commit();
		//cerramos
		em.close();
		//retornamos el listado...
		return listadoproductos;
	}

	public TblProductosusti BuscarProducto(TblProductosusti tblproducto) {
		//establecemos conexion con la unidad de persistencia...
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPII_SUSTI_MORENOROMEROLUISMIGUEL");
		//para administrar las transacciones 
		EntityManager em=emf.createEntityManager();
		//iniciamos la transaccion...
		em.getTransaction().begin();
		//recuperamos el codigo a buscar
		TblProductosusti tblprod = em.find(TblProductosusti.class, tblproducto.getIdproductosusti());
		//confirmamos la transaccion
		em.getTransaction().commit();
		//cerramos la transaccion
		em.close();
		//retornamos el registro solicitado
		return tblprod;
	}



}
