package one.innovation.digital.passwordmanager.controllers;

import lombok.AllArgsConstructor;
import one.innovation.digital.passwordmanager.dto.request.LoginInfoDTO;
import one.innovation.digital.passwordmanager.dto.request.ServiceInfoDTO;
import one.innovation.digital.passwordmanager.dto.response.MessageResponseDTO;
import one.innovation.digital.passwordmanager.entities.ServiceInfo;
import one.innovation.digital.passwordmanager.exception.LoginDataNotFoundException;
import one.innovation.digital.passwordmanager.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/login")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody ServiceInfoDTO serviceInfoDTO){
        return loginService.create(serviceInfoDTO);
    }

    @GetMapping
    public List<ServiceInfoDTO> listAll(){
        return loginService.listAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ServiceInfoDTO findById(@PathVariable long id) throws LoginDataNotFoundException {
       return loginService.findById(id);
    }

}
