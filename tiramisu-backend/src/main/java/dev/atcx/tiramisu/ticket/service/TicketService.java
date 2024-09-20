package dev.atcx.tiramisu.ticket.service;

import dev.atcx.tiramisu.ticket.Ticket;
import dev.atcx.tiramisu.ticket.repository.TicketRepository;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
@AllArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    public Optional<Ticket> findById(final Long id) {
        return ticketRepository.findById(id);
    }

    public Optional<Ticket> findByKey(final String key) {
        return ticketRepository.findByKey(key);
    }

    public List<Ticket> findAllByKeyPrefix(final String keyPrefix) {
        return ticketRepository.findByKeyStartsWith(keyPrefix);
    }

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public Ticket save(final Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public Ticket delete(final Ticket ticket) {
        ticketRepository.delete(ticket);
        return ticket;
    }

}
