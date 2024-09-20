package dev.atcx.tiramisu.base.user.controller;

import dev.atcx.tiramisu.base.user.User;
import dev.atcx.tiramisu.base.user.service.UserService;
import dev.atcx.tiramisu.base.utils.NumberUtils;
import dev.atcx.tiramisu.base.utils.ResponseUtils;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;

@Path("/v1/user")
@ApplicationScoped
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GET
    @Path("{idOrLogin}")
    public Response findByIdOrKey(@PathParam("idOrLogin") final String idOrLogin) {
        return userService.findByLogin(idOrLogin)
                .or(() -> userService.findById(NumberUtils.parseLong(idOrLogin))).map(ResponseUtils::ok)
                .orElseThrow(() -> new NotFoundException(STR."User with id or login \{idOrLogin} does not exist."));
    }

    @POST
    public Response save(final User user) {
        return ResponseUtils.ok(userService.save(user));
    }

    @DELETE
    public Response delete(final User user) {
        return ResponseUtils.ok(userService.delete(user));
    }

}
