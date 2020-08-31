package pruebas.cvp.managedb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "pais")
public class Pais {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private int id;

    @Column(name = "pais")
    @Getter @Setter
    private String pais;
}
