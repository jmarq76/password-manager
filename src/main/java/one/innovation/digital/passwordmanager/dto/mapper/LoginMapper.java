package one.innovation.digital.passwordmanager.dto.mapper;

import one.innovation.digital.passwordmanager.dto.request.ServiceInfoDTO;
import one.innovation.digital.passwordmanager.entities.ServiceInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LoginMapper {

    LoginMapper INSTANCE = Mappers.getMapper(LoginMapper.class);

    @Mapping(target = "passwordDate", source = "passwordDate", dateFormat = "dd-MM-yyyy")
    ServiceInfo toModel(ServiceInfoDTO dto);

    ServiceInfoDTO toDTO(ServiceInfo dto);
}
