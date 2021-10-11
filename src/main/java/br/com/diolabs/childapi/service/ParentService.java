package br.com.diolabs.childapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.diolabs.childapi.repository.ParentRepository;
import br.com.diolabs.childapi.model.Parent;
import br.com.diolabs.childapi.dto.ParentDTO;
import br.com.diolabs.childapi.mapper.ParentMapper;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParentService {

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private ParentMapper parentMapper;

    public List<Parent> getParents(List<ParentDTO> listParentDTO) {        
        return listParentDTO.stream().map(this::findByCPF).collect(Collectors.toList());    
    }

    private Parent findByCPF(ParentDTO parentDTO) {
        Optional<Parent> optParent = parentRepository.findByCPF(parentDTO.getCpf());
        if (optParent.isPresent()) {
            return optParent.get();
        }
        return parentMapper.toModel(parentDTO);
    }

}
