package dev.atcx.tiramisu.ticket.controller;

import dev.atcx.tiramisu.base.utils.NumberUtils;
import dev.atcx.tiramisu.base.utils.ResponseUtils;
import dev.atcx.tiramisu.ticket.Ticket;
import dev.atcx.tiramisu.ticket.service.TicketService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;

@Path("/v1/ticket")
@ApplicationScoped
@AllArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @GET
    @Path("{idOrKey}")
    public Response findByIdOrKey(@PathParam("idOrKey") final String idOrKey) {
        return ticketService.findByKey(idOrKey)
                .or(() -> ticketService.findById(NumberUtils.parseLong(idOrKey))).map(ResponseUtils::ok)
                .orElseThrow(() -> new NotFoundException(STR."Ticket with key \{idOrKey} does not exist."));
    }

    @POST
    public Response save(final Ticket ticket) {
        return ResponseUtils.ok(ticketService.save(ticket));
    }

    @DELETE
    public Response delete(final Ticket ticket) {
        return ResponseUtils.ok(ticketService.delete(ticket));
    }

}
