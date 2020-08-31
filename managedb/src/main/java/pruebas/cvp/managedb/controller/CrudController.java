package pruebas.cvp.managedb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pruebas.cvp.managedb.application.CrudApplication;
import pruebas.cvp.managedb.model.Pais;
import pruebas.cvp.managedb.model.Persona;
import pruebas.cvp.managedb.model.TipoDocumento;

import java.util.logging.Logger;


@RestController
@RequestMapping(value="/crud")
public class CrudController {
    private static Logger logger = Logger.getLogger(CrudController.class.getName());

    @Autowired private CrudApplication crudApplication;

    // ------------------------------------------------ CRUD DOCUMENTOS ------------------------------------------------
    @RequestMapping (value = "/documentos/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public TipoDocumento createTipoDocumento(@RequestBody TipoDocumento documento){
        return crudApplication.createTipoDocumento(documento);
    }

    @RequestMapping (value = "/documentos/update/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public TipoDocumento updateTipoDocumento(@RequestBody TipoDocumento documento, @PathVariable Integer id){
        return crudApplication.updateTipoDocumento(documento,id);
    }

    @RequestMapping(value = "/documentos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getTiposDocumentos(){
        return crudApplication.getDocumentos(null);
    }

    @RequestMapping(value = "/documentos/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getTiposDocumentos(@PathVariable Integer id){
        return crudApplication.getDocumentos(id);
    }

    @RequestMapping(value = "/documentos/delete/{id}", method = RequestMethod.GET)
    public String deleteTipoDocumento(@PathVariable Integer id){
        return crudApplication.deleteDocumento(id);
    }
    // -----------------------------------------------------------------------------------------------------------------

    // ---------------------------------------------------CRUD PAISES---------------------------------------------------
    @RequestMapping (value = "/pais/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Pais createPais(@RequestBody Pais pais){
        return crudApplication.createPais(pais);
    }

    @RequestMapping (value = "/pais/update/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Pais updatePais(@RequestBody Pais pais, @PathVariable Integer id){
        return crudApplication.updatePais(pais,id);
    }

    @RequestMapping(value = "/pais", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getPaises(){
        return crudApplication.getPais(null);
    }

    @RequestMapping(value = "/pais/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getPais(@PathVariable Integer id){
        return crudApplication.getPais(id);
    }

    @RequestMapping(value = "/pais/delete/{id}", method = RequestMethod.GET)
    public String deletePais(@PathVariable Integer id){
        return crudApplication.deletePais(id);
    }
    // -----------------------------------------------------------------------------------------------------------------

    // ------------------------------------------------ CRUD PERSONAS --------------------------------------------------
    @RequestMapping (value = "/persona/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Persona createPersona(@RequestBody Persona persona){
        return crudApplication.createPersona(persona);
    }

    @RequestMapping (value = "/persona/update/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Persona updatePersona(@RequestBody Persona persona, @PathVariable Integer id){
        return crudApplication.updatePersona(persona,id);
    }

    @RequestMapping(value = "/persona", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getPersonas(){
        return crudApplication.getPersona(null);
    }

    @RequestMapping(value = "/persona/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getPersona(@PathVariable Integer id){
        logger.info(id.toString());
        return crudApplication.getPersona(id);
    }

    @RequestMapping(value = "/persona/delete/{id}", method = RequestMethod.GET)
    public String deletePersona(@PathVariable Integer id){
        return crudApplication.deletePersona(id);
    }
    // -----------------------------------------------------------------------------------------------------------------
}
