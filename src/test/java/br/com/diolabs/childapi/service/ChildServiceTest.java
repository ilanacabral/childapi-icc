package br.com.diolabs.childapi.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import br.com.diolabs.childapi.mapper.ChildMapper;
import br.com.diolabs.childapi.dto.ChildDTO;
import br.com.diolabs.childapi.dto.MessageResponseDTO;
import br.com.diolabs.childapi.exception.ChildAgeException;
import br.com.diolabs.childapi.model.Child;
import br.com.diolabs.childapi.repository.ChildRepository;
import static br.com.diolabs.childapi.utils.ChildUtils.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ChildServiceTest {

    @Mock
    private ChildRepository childRepository;   
  
    @Mock
    private ChildMapper childMapper;

    @Mock
    private ParentService parentService; 

    @InjectMocks
    private ChildService childService;

    @Test
    public void testGivenValidChildDTOThenReturnSaveMessage() throws ChildAgeException {
        ChildDTO childDTO = createValidFakeDTO();
        Child expectedSavedChild = createValidFakeEntity();
       
        Mockito.when(childMapper.toModel(childDTO)).thenReturn(expectedSavedChild);
        Mockito.when(childRepository.save(any(Child.class))).thenReturn(expectedSavedChild);
     
        MessageResponseDTO expectedSuccessMessage = messageResponseDTO(
                "Child created with ID " + expectedSavedChild.getId());

        MessageResponseDTO successMessage = childService.saveChild(childDTO);

        Assertions.assertEquals(expectedSuccessMessage.getMessage(), successMessage.getMessage());
    }

    @Test
    public void testGivenInvalidChildDTOhrowException() throws ChildAgeException {
        ChildDTO childDTO = createInvalidFakeDTO();
        Child invalidChild = createInvalidFakeEntity();

        Mockito.when(childMapper.toModel(childDTO)).thenReturn(invalidChild);
        assertThrows(ChildAgeException.class, () -> childService.saveChild(childDTO));
    }

    private MessageResponseDTO messageResponseDTO(String mensagem) {
        return MessageResponseDTO.builder().message(mensagem).build();
    }

}
