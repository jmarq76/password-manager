package one.innovation.digital.passwordmanager.services;

import lombok.AllArgsConstructor;
import one.innovation.digital.passwordmanager.dto.mapper.LoginMapper;
import one.innovation.digital.passwordmanager.dto.request.ServiceInfoDTO;
import one.innovation.digital.passwordmanager.dto.response.MessageResponseDTO;
import one.innovation.digital.passwordmanager.entities.ServiceInfo;
import one.innovation.digital.passwordmanager.exception.LoginDataNotFoundException;
import one.innovation.digital.passwordmanager.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LoginService {

    private final LoginRepository loginRepository;

    private final LoginMapper loginMapper;

    public MessageResponseDTO create(ServiceInfoDTO serviceInfoDTO){

        ServiceInfo serviceInfo = loginMapper.toModel(serviceInfoDTO);

        serviceInfo.setPasswordDate(LocalDate.now());
        serviceInfo.setDaysToChange(180L);
        serviceInfo.setStatus("OK");

        String loginUser = serviceInfo.getLogins().get(0).getLoginUsername();

        if (loginUser == null){
            serviceInfo.getLogins().get(0).setLoginUsername(serviceInfo.getLogins().get(0).getEmail());
        }

        ServiceInfo savedService = (ServiceInfo) loginRepository.save(serviceInfo);

        MessageResponseDTO messageResponseDTO = createMessageResponse("Login data successfully created with ID: ", savedService.getId());

        return  messageResponseDTO;

    }

    public List<ServiceInfoDTO> listAll(){
        List<ServiceInfo> services = loginRepository.findAll();

        return services.stream()
                .map(loginMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ServiceInfoDTO findById(Long id) throws LoginDataNotFoundException {
        ServiceInfo serviceInfo = loginRepository.findById(id)
                .orElseThrow(() -> new LoginDataNotFoundException(id));

        return loginMapper.toDTO(serviceInfo);
    }

    public void deleteById(Long id) throws LoginDataNotFoundException {
        loginRepository.findById(id)
        .orElseThrow(() -> new LoginDataNotFoundException(id));

        loginRepository.deleteById(id);
    }

    private MessageResponseDTO createMessageResponse(String s, Long id) {

        return MessageResponseDTO
                .builder()
                .message(s + id)
                .build();

    }
}
