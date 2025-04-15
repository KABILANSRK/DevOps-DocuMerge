package documerge.documerge.repository;

import documerge.documerge.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Add custom database queries if required
}
