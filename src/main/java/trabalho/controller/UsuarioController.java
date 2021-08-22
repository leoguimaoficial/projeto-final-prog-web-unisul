package trabalho.controller;

import java.util.List;
import trabalho.servico.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import trabalho.model.Usuario;
import trabalho.servico.Servico;

@RestController
@CrossOrigin(origins = "*")
public class UsuarioController {

	@Autowired
	private Servico servico;

	@GetMapping("/usuarioList")
	public ResponseEntity<List<Usuario>> getUsuarioList() {
		return new ResponseEntity<List<Usuario>>(servico.getUsuarioList(), HttpStatus.OK);
	}

	@GetMapping("/usuario/{id}")	
	public ResponseEntity<Usuario> getUsuario(@PathVariable(value="id") Long id) {
		return new ResponseEntity<Usuario>(servico.getUsuarioById(id), HttpStatus.OK);
	}

	@PostMapping("/usuario/save")
	public ResponseEntity<Void> saveOrUpdateUsuario(@RequestBody Usuario usuario) {
		servico.saveOrUpdateUsuario(usuario);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping("/usuario/delete/{id}")
	public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
		servico.deleteUsuario(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}

