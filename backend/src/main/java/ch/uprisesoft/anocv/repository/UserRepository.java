package ch.uprisesoft.anocv.repository;

import ch.uprisesoft.anocv.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
