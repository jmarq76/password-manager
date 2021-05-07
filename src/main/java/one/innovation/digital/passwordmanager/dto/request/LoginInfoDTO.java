package one.innovation.digital.passwordmanager.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfoDTO {

    private Long id;

    @NotEmpty
    @Email
    private String email;

    private String loginUsername;

    @NotEmpty
    private String password;
}
