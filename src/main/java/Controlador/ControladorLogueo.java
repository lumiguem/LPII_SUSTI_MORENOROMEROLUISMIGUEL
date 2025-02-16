package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DaoImp.ClassUsuarioImp;
import model.TblUsuariosusti;

/**
 * Servlet implementation class ControladorLogueo
 */
public class ControladorLogueo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorLogueo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		// Obtener datos del formulario
				String usuario = request.getParameter("usuario");
				String password = request.getParameter("password");
				
				TblUsuariosusti tblUsuario = new TblUsuariosusti();
				
				tblUsuario.setUsuariosusti(usuario);
				tblUsuario.setPasswordsusti(password);;
				
				// Instanciar DAO e intentar validar el usuario
				ClassUsuarioImp usuarioDao = new ClassUsuarioImp();
				TblUsuariosusti usuarioValidado = usuarioDao.validarLogin(tblUsuario);
				
				if (usuarioValidado != null) {
					// Usuario autenticado: iniciar sesión
					HttpSession session = request.getSession();
					session.setAttribute("usuario", usuarioValidado);
					response.sendRedirect("Main.jsp"); // Redirigir a la página principal
				} else {
					// Credenciales incorrectas: volver a login con mensaje de error
					request.setAttribute("error", "Usuario o contraseña incorrectos");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
	} //fin del método doPost

}
