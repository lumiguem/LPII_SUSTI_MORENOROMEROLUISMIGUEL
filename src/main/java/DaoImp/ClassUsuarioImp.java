package DaoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Interfaces.IUsuario;
import model.TblUsuariosusti;

public class ClassUsuarioImp implements IUsuario{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPII_SUSTI_MORENOROMEROLUISMIGUEL");

	public TblUsuariosusti validarLogin(TblUsuariosusti tblusuario) {
	
	EntityManager em = emf.createEntityManager();
    TblUsuariosusti usuarioValidado = null;
    try {
        TypedQuery<TblUsuariosusti> query = em.createQuery("SELECT u FROM TblUsuariosusti u WHERE u.usuariosusti = :usuario AND u.passwordsusti = :password",TblUsuariosusti.class
        );
        query.setParameter("usuario", tblusuario.getUsuariosusti());
        query.setParameter("password", tblusuario.getPasswordsusti());

        usuarioValidado = query.getSingleResult(); // Obtiene el usuario si existe

    } catch (Exception e) {
        System.out.println("Error en validación de login: " + e.getMessage());
    } finally {
        em.close();
    }

    return usuarioValidado;
	}

	public void RegistrarUsuario(TblUsuariosusti tblusuario) {
		//establecemos conexion con la unidad de persistencia...
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPII_SUSTI_MORENOROMEROLUISMIGUEL");
		//permite gestionar entidades..
		EntityManager em=emf.createEntityManager();
		//iniciamos la transaccion
		em.getTransaction().begin();
		//registramos
		em.persist(tblusuario);
		//emitimos mensaje por pantalla....
		System.out.println("Usuario registrado en BD correctamente!!!!!!!!");
		//confirmamos
		em.getTransaction().commit();
		//cerramos la transaccion...
		em.close();
		
	}

	public List<TblUsuariosusti> ListadoUsuario() {
		//establecemos conexion con la unidad de persistencia...
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPII_SUSTI_MORENOROMEROLUISMIGUEL");
		//gestionamos las entidades...
		EntityManager em=emf.createEntityManager();
		//iniciamos la transaccion...
		em.getTransaction().begin();
		//recuperamos el listado de la base de datos..
		List<TblUsuariosusti> listadousuarios=em.createQuery("select u from TblUsuariosusti u",TblUsuariosusti.class).getResultList();
		//confirmamos
		em.getTransaction().commit();
		//cerramos
		em.close();
		//retornamos el listado...
		return listadousuarios;
	}



}
