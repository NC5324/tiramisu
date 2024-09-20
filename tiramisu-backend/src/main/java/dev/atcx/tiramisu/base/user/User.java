package dev.atcx.tiramisu.base.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = User.TABLE_NAME)
public class User extends BaseEntity implements LongIdentifiable {

    public static final String TABLE_NAME = "t_user";
    public static final String SEQUENCE_NAME = "seq_user_id";

    @Id
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1, initialValue = 5000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @Column(name = "id")
    private long id;

    @Column(name = "login")
    private String login;

    @JsonIgnore
    private String password;

}
