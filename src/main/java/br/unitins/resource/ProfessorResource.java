package br.unitins.resource;

import br.unitins.model.Professor;


import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("/professor")
public class ProfessorResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Professor test(){
        Professor p = new Professor();
        p.setNome("Pereira");
        p.setIdade(49);
        p.setDisciplina("Matematica");
        p.setMatricula(123);
        p.setAnoinicio(2000);
       
        return p;

    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List <Professor> getALL(){

        return Professor.findAll().list();

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Professor insert(Professor prof){
        prof.persist();
        return prof;
    }
    
}
