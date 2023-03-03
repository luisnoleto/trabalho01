package br.unitins.repository;
import javax.enterprise.context.ApplicationScoped;

import br.unitins.model.Sorvete;
import io.quarkus.hibernate.orm.panache.PanacheRepository;   


@ApplicationScoped
public class SorveteRepository implements PanacheRepository<Sorvete> {
        
            public Sorvete findByNome(String sabores){
                return find("sabores", sabores).firstResult();
            }
        public Sorvete findByID(Long id){
            return find("id", id).firstResult();
        }

}
    
