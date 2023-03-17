package br.unitins.resource;
import br.unitins.dto.CoberturaDTO;
import br.unitins.dto.CoberturaResponseDTO;
import br.unitins.model.Cobertura;
import br.unitins.repository.CoberturaRepository;
import br.unitins.repository.SorveteRepository;
import br.unitins.service.ServiceCobertura;

import java.util.List;
import java.util.stream.Collectors;


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
import javax.ws.rs.core.Response.Status;
import javax.inject.Inject;
import javax.validation.Valid;



@Path("/cobertura")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CoberturaResource{

    @Inject
    ServiceCobertura serviceCobertura;

    @GET
    public List<CoberturaResponseDTO> getAll() {
        return serviceCobertura.getAll();        
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, CoberturaDTO dto) {
      CoberturaResponseDTO entity = serviceCobertura.update(id, dto);
      return Response.ok(entity).build();
  }

    @GET
    @Path("/quantidade")
    public long count(){
        return serviceCobertura.count();
    }

    @GET
    @Path("/{id}")
    public CoberturaResponseDTO findById(@PathParam("id") Long id) {
        return serviceCobertura.findById(id);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        serviceCobertura.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @POST
    @Transactional
    public Response insert(CoberturaDTO dto) {
        CoberturaResponseDTO entity = serviceCobertura.insert(dto);
        return Response.status(Response.Status.CREATED).entity(entity).build();       
    }
    
    @GET
    @Path("nomesabor/{cobertura}")
    public Response getbycobertura(@PathParam("cobertura") String cobertura) {
        CoberturaRepository CRepository = new CoberturaRepository();
          List<Cobertura> coberturas = CRepository.list("LOWER(coberturas) like LOWER(?1)", cobertura.toLowerCase() + "%");
        return Response.ok(coberturas).build();
    }
  
}
