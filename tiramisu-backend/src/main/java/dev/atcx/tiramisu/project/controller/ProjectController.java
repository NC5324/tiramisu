package dev.atcx.tiramisu.project.controller;

import dev.atcx.tiramisu.base.utils.NumberUtils;
import dev.atcx.tiramisu.base.utils.ResponseUtils;
import dev.atcx.tiramisu.project.Project;
import dev.atcx.tiramisu.project.service.ProjectService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;

@Path("/v1/project")
@ApplicationScoped
@AllArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GET
    @Path("{idOrKey}")
    public Response findByIdOrKey(@PathParam("idOrKey") final String idOrKey) {
        return projectService.findByKey(idOrKey)
                .or(() -> projectService.findById(NumberUtils.parseLong(idOrKey))).map(ResponseUtils::ok)
                .orElseThrow(() -> new NotFoundException(STR."Project with key \{idOrKey} does not exist."));
    }

    @POST
    public Response save(final Project project) {
        return ResponseUtils.ok(projectService.save(project));
    }

    @DELETE
    public Response delete(final Project project) {
        return ResponseUtils.ok(projectService.delete(project));
    }

}
