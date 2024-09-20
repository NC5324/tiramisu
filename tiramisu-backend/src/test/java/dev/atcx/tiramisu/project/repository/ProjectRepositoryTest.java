package dev.atcx.tiramisu.project.repository;

import dev.atcx.tiramisu.project.Project;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.AdditionalMatchers.not;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@QuarkusTest
class ProjectRepositoryTest {

    private static final String PROJECT_KEY = "ABC";
    private static final String NOT_EXISTENT_PROJECT_KEY = "EFG";

    @Inject
    ProjectRepository projectRepository;

    @BeforeAll
    static void setup() {
        // Arrange
        Project mockProject = new Project();
        mockProject.setKey(PROJECT_KEY);
        ProjectRepository projectRepositoryMock = mock(ProjectRepository.class);
        when(projectRepositoryMock.findByKey(PROJECT_KEY)).thenReturn(Optional.of(mockProject));
        when(projectRepositoryMock.findByKey(not(eq(PROJECT_KEY)))).thenReturn(Optional.empty());
    }

    @Test
    void testFindByKey() {
        // Act
        Optional<Project> project = projectRepository.findByKey(PROJECT_KEY);

        // Assert
        assertTrue(project.isPresent());
        assertEquals(PROJECT_KEY, project.get().getKey());
    }

    @Test
    void testFindByNonExistentKey() {
        // Act
        Optional<Project> project = projectRepository.findByKey(NOT_EXISTENT_PROJECT_KEY);

        // Assert
        assertTrue(project.isEmpty());
        assertThrows(NoSuchElementException.class, project::get);
    }

    @Test
    void testFindById() {

    }

    @Test
    void testFindByNotExistentId() {

    }

    @Test
    void testFindAll() {

    }

    @Test
    void testFindAllEmpty() {

    }

    @Test
    void testFindAllById() {

    }

    @Test
    void testFindAllByNonExistentId() {

    }

    @Test
    void testCount() {

    }

    @Test
    void existsById() {

    }

    @Test
    void testSave() {

    }

    @Test
    void testSaveAll() {

    }

    @Test
    void testDeleteById() {

    }

    @Test
    void testDeleteByNonExistentId() {

    }

    @Test
    void testDelete() {

    }

    @Test
    void testDeleteAll() {

    }

}
