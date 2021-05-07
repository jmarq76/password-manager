package one.innovation.digital.passwordmanager.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.innovation.digital.passwordmanager.entities.LoginInfo;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceInfoDTO {

    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String website;

    @Valid
    @NotEmpty
    private List<LoginInfo> logins;

    private String passwordDate;

    private Long daysToChange;

    private String status;
}
