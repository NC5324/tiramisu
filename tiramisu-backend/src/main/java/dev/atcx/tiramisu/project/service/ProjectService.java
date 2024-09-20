package dev.atcx.tiramisu.project.service;

import dev.atcx.tiramisu.project.Project;
import dev.atcx.tiramisu.project.repository.ProjectRepository;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
@AllArgsConstructor
public class ProjectService {

    private final ProjectRepository repository;

    public Optional<Project> findById(final Long id) {
        return repository.findById(id);
    }

    public Optional<Project> findByKey(final String key) {
        return repository.findByKey(key);
    }

    public List<Project> findAll() {
        return repository.findAll();
    }

    public Project save(final Project ticket) {
        return repository.save(ticket);
    }

    public Project delete(final Project ticket) {
        repository.delete(ticket);
        return ticket;
    }

}
