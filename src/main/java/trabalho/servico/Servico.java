package trabalho.servico;


import java.util.List;
import trabalho.servico.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import trabalho.model.Usuario;
import trabalho.repo.UsuarioRepo;

@Service
public class Servico {

	@Autowired
	private UsuarioRepo usuariorepo;

	public List<Usuario> getUsuarioList() {
		return usuariorepo.findAll();
	}

	public Usuario getUsuarioById(Long id) {
		return usuariorepo.findById(id).get();
	}

	public void saveOrUpdateUsuario(Usuario usuario) {
		usuariorepo.save(usuario);
	}
	
	public void deleteUsuario(Long id) {
		usuariorepo.deleteById(id);
	}

}
