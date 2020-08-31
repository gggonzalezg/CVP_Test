package pruebas.cvp.managedb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pruebas.cvp.managedb.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
