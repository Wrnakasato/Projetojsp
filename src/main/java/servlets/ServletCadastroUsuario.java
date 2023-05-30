package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Usuario;

import java.io.IOException;

import banco.SimulaBanco;

@WebServlet("/CadastroUsuario")
public class ServletCadastroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ServletCadastroUsuario() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String sobreNome = request.getParameter("sobreNome");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		Usuario usuario = new Usuario(nome, sobreNome, email, senha, Integer.parseInt(telefone));

		SimulaBanco.incluir(usuario);

		request.getSession().setAttribute("usuario", usuario);
		request.setAttribute("email", usuario);
		RequestDispatcher rd = request.getRequestDispatcher("principal/menu.jsp");
		rd.forward(request, response);
		
	}

}
