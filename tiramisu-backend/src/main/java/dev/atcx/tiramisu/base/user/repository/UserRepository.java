package dev.atcx.tiramisu.base.user.repository;

import dev.atcx.tiramisu.base.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByLogin(String login);
}
