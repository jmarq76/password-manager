package one.innovation.digital.passwordmanager.services;

import lombok.AllArgsConstructor;
import one.innovation.digital.passwordmanager.dto.mapper.LoginMapper;
import one.innovation.digital.passwordmanager.dto.request.ServiceInfoDTO;
import one.innovation.digital.passwordmanager.dto.response.MessageResponseDTO;
import one.innovation.digital.passwordmanager.entities.ServiceInfo;
import one.innovation.digital.passwordmanager.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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

        MessageResponseDTO messageResponseDTO = createMessageResponse("Login data successful created with ID: ", savedService.getId());

        return  messageResponseDTO;

    }

    private MessageResponseDTO createMessageResponse(String s, Long id) {

        return MessageResponseDTO
                .builder()
                .message(s + id)
                .build();

    }
}
