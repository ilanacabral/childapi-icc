package br.com.diolabs.childapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diolabs.childapi.dto.MessageResponseDTO;
import br.com.diolabs.childapi.dto.ChildDTO;
import br.com.diolabs.childapi.exception.ChildNotFoundException;
import br.com.diolabs.childapi.mapper.ChildMapper;
import br.com.diolabs.childapi.mapper.ParentMapper;
import br.com.diolabs.childapi.model.Child;
import br.com.diolabs.childapi.repository.ChildRepository;
import br.com.diolabs.childapi.repository.ParentRepository;
import br.com.diolabs.childapi.model.Parent;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChildService {

    @Autowired
    private ChildRepository childRepository;

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private ChildMapper childMapper;

    @Autowired
    private ParentMapper parentMapper;

    public MessageResponseDTO saveChild(ChildDTO childDTO) {       
        Child child =  childRepository.save(childMapper.toModel(childDTO));
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
        this.findChildById(id);
        childRepository.deleteById(id);
        return messageResponseDTO("Child with ID " + id + " deleted with success.");
    }

    public MessageResponseDTO updateChild(Long id, ChildDTO childDTO) {
        this.findChildById(id);
        childRepository.save(childMapper.toModel(childDTO));
        return messageResponseDTO("Child with ID " + id + " updated with success.");
    }

    private MessageResponseDTO messageResponseDTO(String mensagem) {
        return MessageResponseDTO.builder().message(mensagem).build();
    }

}
