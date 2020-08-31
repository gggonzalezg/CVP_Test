package pruebas.cvp.managedb.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "tipo_documento")
public class TipoDocumento {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tipo_documento")
    private String tipo_documento;

    @Column(name = "descripcion")
    private String descripcion;
}
