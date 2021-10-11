package br.com.diolabs.childapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.diolabs.childapi.dto.MessageResponseDTO;
import br.com.diolabs.childapi.dto.ChildDTO;
import br.com.diolabs.childapi.exception.ChildAgeException;
import br.com.diolabs.childapi.exception.ChildNotFoundException;
import br.com.diolabs.childapi.mapper.ChildMapper;
import java.time.LocalDate;
import br.com.diolabs.childapi.model.Child;
import br.com.diolabs.childapi.model.Parent;
import br.com.diolabs.childapi.repository.ChildRepository;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChildService {

    @Autowired
    private ChildRepository childRepository;

    @Autowired
    private ChildMapper childMapper;

    @Autowired
    private ParentService parentService;

    public MessageResponseDTO saveChild(ChildDTO childDTO) {
        Child child =  childMapper.toModel(childDTO);
        
        //Valida idade da criança, máximo permitido 10 anos
        this.ageValidate(child.getBirthDate());
       
        //Obtém PARENTS que já existem no banco             
        List<Parent> parents = parentService.getParents(childDTO.getParents());       
        child.setParents(parents);

        //Persiste CHILD
        child = childRepository.save(child);
        return messageResponseDTO("Child created with ID " + child.getId());
    }   

    public List<ChildDTO> findAllChild() {
        List<Child> allChild = childRepository.findAll();
        return allChild.stream().map(childMapper::toDTO).collect(Collectors.toList());
    }

    public ChildDTO findChildById(Long id) {
        Child child = childRepository.findById(id).orElseThrow(() -> new ChildNotFoundException(id));
        return childMapper.toDTO(child);
    }

    public MessageResponseDTO deleteChild(Long id) {
        ChildDTO childDTO = this.findChildById(id);  
        //Exclui relacionamentos filhos      
        childDTO.setParents(null);
        childRepository.delete(childMapper.toModel(childDTO));
        return messageResponseDTO("Child with ID " + id + " deleted with success.");
    }

    public MessageResponseDTO updateChild(Long id, ChildDTO childDTO) {
        this.findChildById(id);
        

        Child child =  childMapper.toModel(childDTO);

        //Valida idade da criança, máximo permitido 10 anos
        this.ageValidate(child.getBirthDate());        
     
        childRepository.save(child);
        return messageResponseDTO("Child with ID " + id + " updated with success.");
    }

    private MessageResponseDTO messageResponseDTO(String mensagem) {
        return MessageResponseDTO.builder().message(mensagem).build();
    }

    private void ageValidate(LocalDate birthDate) {
        int ageChild = Calendar.getInstance().get(Calendar.YEAR) - birthDate.getYear();
        if (ageChild>10) throw new ChildAgeException(ageChild);
    }

}
