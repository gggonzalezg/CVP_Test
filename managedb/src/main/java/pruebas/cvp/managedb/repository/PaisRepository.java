package pruebas.cvp.managedb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pruebas.cvp.managedb.model.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais,Integer> {
}
