package dev.atcx.tiramisu.ticket;

import dev.atcx.tiramisu.base.BaseEntity;
import dev.atcx.tiramisu.base.LongIdentifiable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import static dev.atcx.tiramisu.ticket.Ticket.TABLE_NAME;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = TABLE_NAME)
public class Ticket extends BaseEntity implements LongIdentifiable {

    public static final String TABLE_NAME = "t_ticket";
    public static final String SEQUENCE_NAME = "seq_ticket_id";

    @Id
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1, initialValue = 5000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @Column(name = "id")
    private long id;

    @Column(name = "key")
    private String key;

    @Column(name = "summary")
    private String summary;

    @Column(name = "description")
    private String description;

}
