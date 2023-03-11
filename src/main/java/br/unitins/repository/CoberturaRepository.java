package br.unitins.repository;

import javax.enterprise.context.ApplicationScoped;
import br.unitins.model.Cobertura;
import io.quarkus.hibernate.orm.panache.PanacheRepository;   

@ApplicationScoped
public class CoberturaRepository implements PanacheRepository<Cobertura> {
    
            public Cobertura findByNome(String sabores){
                return find("sabores", sabores).firstResult();
            }
        public Cobertura findByID(Long id){
            return find("id", id).firstResult();
        }

}
    
