package pruebas.cvp.managedb.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import pruebas.cvp.managedb.model.TipoDocumento;
import pruebas.cvp.managedb.repository.DocumentoRepository;
import pruebas.cvp.managedb.repository.PersonaRepository;
import pruebas.cvp.managedb.model.Pais;
import pruebas.cvp.managedb.model.Persona;
import pruebas.cvp.managedb.repository.PaisRepository;

import java.util.logging.Logger;

@Component
public class CrudApplication {
    private static Logger logger = Logger.getLogger(CrudApplication.class.getName());

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    DocumentoRepository documentoRepository;

    @Autowired
    PaisRepository paisRepository;

    // ------------------------------------------------ CRUD DOCUMENTOS ------------------------------------------------
    public TipoDocumento createTipoDocumento(TipoDocumento documento) {
        return documentoRepository.save(documento);
    }

    public TipoDocumento updateTipoDocumento(TipoDocumento documentoUpdate, Integer id) {
        TipoDocumento documento = documentoRepository.findById(id).isPresent()?
                documentoRepository.findById(id).get() : new TipoDocumento();
        documento.setTipo_documento(documentoUpdate.getTipo_documento());
        documento.setDescripcion(documentoUpdate.getDescripcion());
        return documentoRepository.save(documento);
    }

    public Object getDocumentos(@Nullable Integer id){
        if (id==null)
            return documentoRepository.findAll();
        else
            return documentoRepository.findById(id);
    }

    public String deleteDocumento(Integer id){
        documentoRepository.deleteById(id);
        return "Eliminado el tipo de documento " + id;
    }
    // -----------------------------------------------------------------------------------------------------------------

    // ---------------------------------------------------CRUD PAISES---------------------------------------------------
    public Pais createPais(Pais pais) {
        return paisRepository.save(pais);
    }

    public Pais updatePais(Pais pais, Integer id) {
        Pais oldPais = paisRepository.findById(id).isPresent()?
                paisRepository.findById(id).get() : new Pais();
        oldPais.setPais(pais.getPais());
        return paisRepository.save(oldPais);
    }

    public Object getPais(@Nullable Integer id) {
        if (id==null)
            return paisRepository.findAll();
        else
            return paisRepository.findById(id);
    }

    public String deletePais(Integer id) {
        paisRepository.deleteById(id);
        return "Eliminado el pais " + id;
    }
    // -----------------------------------------------------------------------------------------------------------------

    // ------------------------------------------------ CRUD PERSONAS --------------------------------------------------
    public Persona createPersona(Persona persona) {

        logger.info(persona.getTipoDocumento().toString());
        return personaRepository.save(persona);
    }

    public Persona updatePersona(Persona persona, Integer id) {
        Persona oldPersona = personaRepository.findById(id).isPresent()?
                personaRepository.findById(id).get() : new Persona();
        oldPersona.setNombres(persona.getNombres());
        oldPersona.setApellidos(persona.getApellidos());
        oldPersona.setNumeroDocumento(persona.getNumeroDocumento());
        oldPersona.setGenero(persona.getGenero());
        oldPersona.setEdad(persona.getEdad());
        oldPersona.setTipoDocumento(persona.getTipoDocumento());
        oldPersona.setPais(persona.getPais());
        return personaRepository.save(oldPersona);
    }

    public Object getPersona(Integer id) {
        if (id==null)
            return personaRepository.findAll();
        else{
            Persona p = personaRepository.findById(id).isPresent()?
                    personaRepository.findById(id).get() : new Persona();
            logger.info(p.getTipoDocumento().toString());
            return personaRepository.findById(id);
        }
    }

    public String deletePersona(Integer id) {
        personaRepository.deleteById(id);
        return "Eliminada la persona  " + id;
    }
    // -----------------------------------------------------------------------------------------------------------------
}
