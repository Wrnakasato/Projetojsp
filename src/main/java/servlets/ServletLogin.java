package servlets;

import java.io.IOException;
import java.util.List;

import banco.SimulaBanco;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Usuario;

@WebServlet("/Login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String page = "";

		List<Usuario> usuarios = SimulaBanco.mostrar();

		for (Usuario usuario : usuarios) {

			if (usuario.getEmail().equalsIgnoreCase(email) && usuario.getSenha().equalsIgnoreCase(senha)) {

				System.out.print(usuario.getNome());

				request.setAttribute("email", usuario);
				request.getSession().setAttribute("usuario", usuario);
				page = "principal/menu.jsp";
				break;
			} else {

				page = "login.jsp";
			}

		}

		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
		// response.sendRedirect(page);
	}

}
