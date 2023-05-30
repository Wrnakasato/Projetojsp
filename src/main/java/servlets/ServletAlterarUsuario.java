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

@WebServlet("/alterar")
public class ServletAlterarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServletAlterarUsuario() {
        super();
       
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		SimulaBanco simulaBanco = new SimulaBanco();
		
		Usuario usuario;
		
		usuario = simulaBanco.buscarUsuario(email);


		request.setAttribute("usuario", usuario);
		RequestDispatcher rd = request.getRequestDispatcher("principal/alterarDados.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String sobreNome = request.getParameter("sobreNome");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		Usuario usuario = new Usuario(nome,sobreNome,email,senha,Integer.parseInt(telefone));

		SimulaBanco.incluir(usuario);

		request.getSession().setAttribute("usuario", usuario);
		request.setAttribute("usuario", usuario);
		RequestDispatcher rd = request.getRequestDispatcher("principal/menu.jsp");
		rd.forward(request, response);

	}

}
