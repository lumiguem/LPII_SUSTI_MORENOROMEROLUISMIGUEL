package Controlador;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImp.ClassProductoImp;
import model.TblProductosusti;


/**
 * Servlet implementation class ControladorProducto
 */
public class ControladorProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//instanciamos la respectiva clase 
		ClassProductoImp crudimp=new ClassProductoImp();
		//recuperamos el listado de productos de la BD
		List<TblProductosusti> listadoproductos=crudimp.ListadoProducto();
		TblProductosusti tblprod=new TblProductosusti();
		//enviamos hacia la vista
		//almacenamos en el respectivo metodo...
		request.setAttribute("listado",listadoproductos);
		
		//declaramos una variable tipo string
		//recibimos el valor segun la accion
		String accion=request.getParameter("accion");
		//aplicamos una condicion
		if(accion != null){
			//aplicamos un switch
			switch(accion){
			case "Modificar":
				//obtenemos el codigo	
				int cod = Integer.parseInt(request.getParameter("cod"));
				//asignamos valores
				tblprod.setIdproductosusti(cod);
				//buscamos el codigo a actualizar
				TblProductosusti prod=crudimp.BuscarProducto(tblprod);
				//asignamos los valores
				//para enviarlos hacia la vista (formulario actualizar)
				request.setAttribute("codigo", prod.getIdproductosusti());
				request.setAttribute("nombre", prod.getNombresusti());
				request.setAttribute("preVenta", prod.getPrecioventasusti());
				request.setAttribute("preCompra", prod.getPreciocompsusti());
				request.setAttribute("estado", prod.getEstadosusti());
				request.setAttribute("descripcion", prod.getDescripsusti());
				
				//redireccionamos
				request.getRequestDispatcher("/FrmActualizarProducto.jsp").forward(request, response);				
				
				//salimos 
				break;
			case "Registrar":
				//redireccionamos hacia la vista(.jsp)
				request.getRequestDispatcher("/FrmRegistrarProducto.jsp").forward(request, response);
				//salimos
				break;
			case "Eliminar":
				//obtenemos el codigo	
				int codelim = Integer.parseInt(request.getParameter("cod"));
				//asignamos el codigo
				tblprod.setIdproductosusti(codelim);
				//invocamos al metodo eliminar
				crudimp.EliminarProducto(tblprod);
				List<TblProductosusti> listado=crudimp.ListadoProducto();
				//enviamos hacia la vista
				request.setAttribute("listado",listado);
				//redireccionamos
				request.getRequestDispatcher("/FrmRegistrarProducto.jsp").forward(request, response);				
				//salimos
				break;
			case "Listar": 	
			    List<TblProductosusti> listadoProductos = crudimp.ListadoProducto();
			    request.setAttribute("listado", listadoProductos);
				//redireccionamos hacia la vista (.jsp)
				request.getRequestDispatcher("/Main.jsp").forward(request,response);
			}//fin del switch
		}
	} //fin del metodo doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		//recuperamos los datos del formulario
		String codigo = request.getParameter("codigo");
		String nombre = request.getParameter("nombre");
		double preVenta = Double.parseDouble(request.getParameter("preVenta"));
		double preCompra = Double.parseDouble(request.getParameter("preCompra"));
		String estado = request.getParameter("estado");
		String descripcion = request.getParameter("descripcion");
		

		//hacer respectivas instancias...
		TblProductosusti tblprod=new TblProductosusti();
		ClassProductoImp climp=new ClassProductoImp();
		//asignamos los valores	
		
		tblprod.setNombresusti(nombre);
		tblprod.setPrecioventasusti(preVenta);
		tblprod.setPreciocompsusti(preCompra);
		tblprod.setEstadosusti(estado);
		tblprod.setDescripsusti(descripcion);
		//aplicamos una condicion 
		if(codigo!=null){
			int cod=Integer.parseInt(codigo);
			//luego asignamos el codigo a actualizar
			tblprod.setIdproductosusti(cod);
			//invocamos el metodo actualizar
			climp.ActualizarProducto(tblprod);
			//invocamos el metodo registrar	
		}else {
			climp.RegistrarProducto(tblprod);
		}

		
	    // Actualizamos la lista de proveedores
	    List<TblProductosusti> listado = climp.ListadoProducto();
	    request.setAttribute("listado", listado);
	    request.setAttribute("mensaje", "Dato registrado en la BD");
	    // Redirigir a FrmRegistrarProveedor.jsp para mantener la vista
	    request.getRequestDispatcher("/FrmRegistrarProducto.jsp").forward(request, response);
	}

}
