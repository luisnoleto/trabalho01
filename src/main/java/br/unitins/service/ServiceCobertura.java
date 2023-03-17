package br.unitins.service;

import br.unitins.dto.CoberturaDTO;
import br.unitins.dto.CoberturaResponseDTO;
import br.unitins.model.Cobertura;
import java.util.List;

public interface ServiceCobertura {

    //recursos basicos
    List<CoberturaResponseDTO> getAll();

    CoberturaResponseDTO findById(Long id);

    CoberturaResponseDTO insert(CoberturaDTO dto);

    CoberturaResponseDTO update(Long id, CoberturaDTO dto);

    void delete(Long id);

    //extra

    List<CoberturaResponseDTO> findByCoberturas (String coberturas);

    long count();


    
}
