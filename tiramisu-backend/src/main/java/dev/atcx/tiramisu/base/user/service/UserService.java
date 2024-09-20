package dev.atcx.tiramisu.base.user.service;

import dev.atcx.tiramisu.base.user.User;
import dev.atcx.tiramisu.base.user.repository.UserRepository;
import dev.atcx.tiramisu.base.utils.CollectionUtils;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;

    public Optional<User> findById(final Long id) {
        return repository.findById(id);
    }

    public Optional<User> findByLogin(final String login) {
        return repository.findByLogin(login);
    }

    public List<User> findAll() {
        return CollectionUtils.toList(repository.findAll());
    }

    public User save(final User user) {
        return repository.save(user);
    }

    public User delete(final User user) {
        repository.delete(user);
        return user;
    }

}
