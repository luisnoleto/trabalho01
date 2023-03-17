package br.unitins.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.ws.rs.NotFoundException;

import br.unitins.dto.CoberturaDTO;
import br.unitins.dto.CoberturaResponseDTO;
import br.unitins.model.Cobertura;
import br.unitins.repository.CoberturaRepository;
import br.unitins.repository.SorveteRepository;


@ApplicationScoped
public class ServiceCoberturaImpl implements ServiceCobertura {

    @Inject
    CoberturaRepository repository;

    @Inject
    SorveteRepository sorveteRepository;

    @Inject
    Validator validator;

    @Override
    public List<CoberturaResponseDTO> getAll() {
        return repository.findAll()
        .stream()
        .map(cobertura -> new CoberturaResponseDTO(cobertura))
        .collect(Collectors.toList());
    }

    @Override
    public CoberturaResponseDTO findById(Long id) {

        Cobertura cobertura = repository.findById(id);
        if(cobertura == null)
            throw new NotFoundException("Cobertura não encontrada");
            return new CoberturaResponseDTO(cobertura);
    
    }

    @Override
    @Transactional
    public CoberturaResponseDTO insert(CoberturaDTO dto) {
       Set<ConstraintViolation<CoberturaDTO>> violations = validator.validate(dto);
       if(!violations.isEmpty())
            throw new ConstraintViolationException(violations);
       
         Cobertura cobertura = new Cobertura();
            cobertura.setCoberturas(dto.getCoberturas());
            cobertura.setSorvete(sorveteRepository.findById(dto.getIdSorvete()));
            repository.persist(cobertura);

            return new CoberturaResponseDTO(cobertura);
    }

    @Override
    @Transactional
    public CoberturaResponseDTO update(Long id, CoberturaDTO dto) {
        Cobertura cobertura = repository.findById(id);

        if(cobertura == null)
            throw new NotFoundException("Cobertura não encontrada");

        cobertura.setCoberturas(dto.getCoberturas());
        cobertura.setSorvete(sorveteRepository.findById(dto.getIdSorvete()));

        return new CoberturaResponseDTO(cobertura);

    }

    @Override
    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }

    @Override
    public List<CoberturaResponseDTO> findByCoberturas(String coberturas) {
        List<Cobertura> cobertura = repository.findByNome(coberturas);
       
        return cobertura.stream().map(CoberturaResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return repository.count();
    }
}
