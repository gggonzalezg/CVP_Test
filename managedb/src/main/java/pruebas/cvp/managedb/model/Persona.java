package pruebas.cvp.managedb.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "numero_documento")
    private String numeroDocumento;

    @Column(name = "genero")
    private String genero;

    @Column(name = "edad")
    private int edad;

    @ManyToOne
    @JoinColumn(name = "id_Tipo_Documento", nullable = false)
    private TipoDocumento tipoDocumento;

    @ManyToOne
    @JoinColumn(name = "id_pais", nullable = false)
    private Pais pais;

}
