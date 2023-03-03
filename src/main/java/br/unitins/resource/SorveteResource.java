package br.unitins.resource;
import br.unitins.model.Sorvete;
import br.unitins.repository.SorveteRepository;

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
import javax.ws.rs.core.Response;
import javax.inject.Inject;



@Path("/sorvete")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SorveteResource{

    @Inject
    SorveteRepository repository;

    @GET
    public List<Sorvete> getAll() {
        return repository.findAll().list();
    }

    @PUT
    @Path("/{id}") //precisa das chaves
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)//formato de retorno do dado
    @Transactional 
    public Sorvete update(@PathParam("id") Long id, Sorvete sorvete) {
        Sorvete entity = repository.findById(id);

        entity.setSabores(sorvete.getSabores());
        entity.setPrecosabor(sorvete.getPrecosabor());

        return entity;
    }

    @GET
    @Path("/quantidade")
    public long count(){
        return repository.count();
    }

    @GET
    @Path("/{id}")
    public Sorvete getSorveteId (@PathParam("id") Long id){
      SorveteRepository SorveteRepository = new SorveteRepository();
        return SorveteRepository.findById(id);

    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Sorvete delete(@PathParam("id") Long id) {
       SorveteRepository sorveteRepository = new SorveteRepository();
        Sorvete sorvete = sorveteRepository.findById(id);
        sorveteRepository.delete(sorvete);
        return sorvete;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Sorvete insert(Sorvete sorvete) {
        if (sorvete.getId() != null) {
            repository.persist(sorvete);
        }
        else {
            repository.persistAndFlush(sorvete);
        }
        return sorvete;
            
            
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Sorvete updateSabor(@PathParam("id") Long id, Sorvete sorvete) {
        Sorvete entity = repository.findById(id);
        entity.setSabores(sorvete.getSabores());
        entity.setPrecosabor(sorvete.getPrecosabor());

        return entity;
    }
    
    //@GET
    //@Path("nomesabor/{sabor}")
    //public Response getbysabor(@PathParam("sabor") String sabor) {
      //  SorveteRepository SorveteRepository = new SorveteRepository();
      //  List<Sorvete> sorvetes = SorveteRepository.list("LOWER(sabores) like LOWER(?1)" + sabor.toLowerCase() + "%");
       // return Response.ok(sorvetes).build();
   // }
   @GET
    @Path("nomesabor/{sabor}")
    public Response getbysabor(@PathParam("sabor") String sabor) {
    SorveteRepository sorveteRepository = new SorveteRepository();
    List<Sorvete> sorvetes = sorveteRepository.list("LOWER(sabores) like LOWER(?1) and LOWER(sabores) like LOWER(?2)", sabor.substring(0, 1) + "%", "%" + sabor.toLowerCase() + "%");
    
    return Response.ok(sorvetes).build();
}

    

    



}
