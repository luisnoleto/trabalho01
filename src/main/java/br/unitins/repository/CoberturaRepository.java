package br.unitins.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import br.unitins.model.Cobertura;
import io.quarkus.hibernate.orm.panache.PanacheRepository;   

@ApplicationScoped
public class CoberturaRepository implements PanacheRepository<Cobertura> {
    
            public List<Cobertura> findByNome(String sabores){
                return find("sabores", sabores).firstResult();
            }
        public Cobertura findByID(Long id){
            return find("id", id).firstResult();
        }

}
    
