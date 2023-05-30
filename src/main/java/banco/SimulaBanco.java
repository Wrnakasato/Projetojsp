package banco;

import java.util.ArrayList;
import java.util.List;

import modelo.Usuario;

public class SimulaBanco {
	private static List<Usuario> usuarios = new ArrayList<>();

	static {
		Usuario usuario1 = new Usuario("Mario", "Silva", "mario@uninove.com", "123456", Integer.parseInt("22555"));
		SimulaBanco.incluir(usuario1);
	}
	public static void incluir(Usuario usuario) {

		SimulaBanco.usuarios.add(usuario);
	}

	public static List<Usuario> mostrar() {

		return SimulaBanco.usuarios;
	}	
	public Usuario buscarUsuario(String email) {
		
		Usuario user = new Usuario();
		usuarios = SimulaBanco.mostrar();
		
		for(Usuario usuario:usuarios) {
			
			if(usuario.getEmail().equalsIgnoreCase(email)) {
				
				user.setNome(usuario.getNome());
				user.setSobreNome(usuario.getSobreNome());
				user.setTelefone(usuario.getTelefone());
				user.setEmail(email);
				user.setSenha(usuario.getSenha());				
			}
		}	
		return user;
	}
}
