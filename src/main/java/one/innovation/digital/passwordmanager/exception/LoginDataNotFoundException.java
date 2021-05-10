package one.innovation.digital.passwordmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LoginDataNotFoundException extends Exception {
    public LoginDataNotFoundException(Long id) {
        super(String.format("Login data with %s not found!", id));
    }

    public LoginDataNotFoundException(String name) {
        super(String.format("Login data with %s not found!", name));
    }
}
