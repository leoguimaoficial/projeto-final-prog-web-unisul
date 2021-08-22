package trabalho.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import trabalho.model.*;

import trabalho.model.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Long> {

}
