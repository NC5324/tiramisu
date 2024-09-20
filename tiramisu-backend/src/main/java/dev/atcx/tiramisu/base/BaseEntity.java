package dev.atcx.tiramisu.base;

import dev.atcx.tiramisu.base.audit.Auditable;
import dev.atcx.tiramisu.base.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.Date;

@Data
@MappedSuperclass
public class BaseEntity implements Auditable {

    @OneToOne
    @JoinColumn(name = "creator")
    private User creator;

    @OneToOne
    @JoinColumn(name = "editor")
    private User editor;

    @Column(name = "created")
    private Date created;

    @Column(name = "edited")
    private Date edited;

    @Column(name = "deleted")
    private boolean deleted;

}
