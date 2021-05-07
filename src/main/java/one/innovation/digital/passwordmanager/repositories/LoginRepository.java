package one.innovation.digital.passwordmanager.repositories;

import one.innovation.digital.passwordmanager.entities.ServiceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<ServiceInfo, Long> {
}
