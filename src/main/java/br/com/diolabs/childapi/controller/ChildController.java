package br.com.diolabs.childapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.diolabs.childapi.dto.MessageResponseDTO;
import br.com.diolabs.childapi.dto.ChildDTO;
import br.com.diolabs.childapi.service.ChildService;

@RestController
@RequestMapping("/api/v1/child")
public class ChildController {

    @Autowired
    private ChildService childService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createChild(@Valid @RequestBody ChildDTO childDTO){        
         return childService.saveChild(childDTO);     
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ChildDTO> findAllChild(){
        return childService.findAllChild();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ChildDTO findChildById(@Valid @PathVariable Long id){
       return  childService.findChildById(id);        
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO deleteChild(@Valid @PathVariable Long id){
       return  childService.deleteChild(id);        
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO updateChild(@Valid @PathVariable Long id, @Valid @RequestBody ChildDTO childDTO){        
         return childService.updateChild(id,childDTO);     
    }
    
}
