package br.unitins.resource;
import br.unitins.dto.CoberturaDTO;
import br.unitins.dto.CoberturaResponseDTO;
import br.unitins.model.Cobertura;
import br.unitins.repository.CoberturaRepository;

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



@Path("/cobertura")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CoberturaResource{

    @Inject
    CoberturaRepository repository;

    @GET
    public List<Cobertura> getAll() {

        return repository.findAll().list();
    }

    @PUT
    @Path("/{id}") //precisa das chaves
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)//formato de retorno do dado
    @Transactional 
    public Cobertura update(@PathParam("id") Long id, Cobertura cobertura) {
        Cobertura entity = repository.findById(id);

        entity.setCoberturas(cobertura.getCoberturas());
        

        return entity;
    }

    @GET
    @Path("/quantidade")
    public long count(){
        return repository.count();
    }

    @GET
    @Path("/{id}")
    public Cobertura getCoberturaId (@PathParam("id") Long id){
        CoberturaRepository coberturaRepository = new CoberturaRepository();
        return coberturaRepository.findById(id);

    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Cobertura delete(@PathParam("id") Long id) {
        CoberturaRepository CoberturaRepository = new CoberturaRepository();
        Cobertura cobertura = CoberturaRepository.findById(id);
        CoberturaRepository.delete(cobertura);
        return cobertura;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public CoberturaResponseDTO insert(CoberturaDTO dto) {
       Cobertura entity = new Cobertura();
        entity.setCoberturas(dto.getCoberturas());

        repository.persist(entity);

        return new CoberturaResponseDTO(entity);
            
    }


    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Cobertura updateCobertura(@PathParam("id") Long id, Cobertura cobertura) {
        Cobertura entity = repository.findById(id);
        entity.setCoberturas(cobertura.getCoberturas());

        return entity;
    }
    
    @GET
    @Path("nomesabor/{cobertura}")
    public Response getbycobertura(@PathParam("cobertura") String cobertura) {
        CoberturaRepository Repository = new CoberturaRepository();
        Repository.list("LOWER(coberturas) like LOWER(?1)", cobertura.toLowerCase() + "%");
        return Response.ok(cobertura).build();
    }
  
}
