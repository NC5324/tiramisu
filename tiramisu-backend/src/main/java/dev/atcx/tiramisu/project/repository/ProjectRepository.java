package dev.atcx.tiramisu.project.repository;

import dev.atcx.tiramisu.project.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    Optional<Project> findByKey(String key);

    List<Project> findAll();
}
