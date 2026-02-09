package com.Ycoy.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // This allows us to find a user by their email automatically
    Optional<User> findByEmail(String email);

    // This allows us to find a user by their username (since your FRS requires it)
    Optional<User> findByUsername(String username);
}
