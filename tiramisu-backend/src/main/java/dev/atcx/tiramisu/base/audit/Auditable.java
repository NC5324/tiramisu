package dev.atcx.tiramisu.base.audit;

import dev.atcx.tiramisu.base.user.User;

import java.util.Date;

public interface Auditable {

    User getCreator();

    User getEditor();

    Date getCreated();

    Date getEdited();

    boolean isDeleted();

    void setDeleted(boolean deleted);
}
