package br.unitins.resource;
import br.unitins.model.Sorvete;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import br.unitins.model.Sorvete;

@Path("/sorvete")
public class SorveteResource {

    @GET
    public List<Sorvete> getAll() {
        return Sorvete.findAll().list();
    }

    @PUT
    @Path("/{id}") //precisa das chaves
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)//formato de retorno do dado
    @Transactional 
    public Sorvete update(@PathParam("id") Long id, Sorvete sorvete) {
        Sorvete entity = Sorvete.findById(id);
        entity.setSabores(sorvete.getSabores());
        entity.setPrecosabor(sorvete.getPrecosabor());

        return entity;
    }

    @GET
    @Path("/{id}")
    public Sorvete getSorveteId (@PathParam("id") Long id){
      
        return Sorvete.findById(id);

    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Sorvete delete(@PathParam("id") Long id) {
        Sorvete entity = Sorvete.findById(id);
        entity.delete();
        return entity;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Sorvete create(Sorvete sorvete) {
        sorvete.persist();
        return sorvete;
    }

    @PUT
    @Path("/sabores/{sabores}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    //update de sabor e preço
    public Sorvete updateSabor(@PathParam("sabores") String sabores, Sorvete sorvete) {
        Sorvete entity = Sorvete.find("sabores", sabores).firstResult();
        entity.setSabores(sorvete.getSabores());
        entity.setPrecosabor(sorvete.getPrecosabor());

        return entity;
    }
    @PUT
    @Path("/sabores/{sabores}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    //update de preco
    public Sorvete updatePreco(@PathParam("precosabor") String precosabor, Sorvete sorvete) {
        Sorvete entity = Sorvete.find("precosabor", precosabor).firstResult();
        entity.setPrecosabor(sorvete.getPrecosabor());

        return entity;
    }



}
