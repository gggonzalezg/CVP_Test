package pruebas.cvp.managedb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pruebas.cvp.managedb.model.TipoDocumento;

@Repository
public interface DocumentoRepository extends JpaRepository<TipoDocumento,Integer> {
}
