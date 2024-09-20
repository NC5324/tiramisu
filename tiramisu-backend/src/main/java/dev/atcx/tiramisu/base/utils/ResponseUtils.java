package dev.atcx.tiramisu.base.utils;

import jakarta.ws.rs.core.Response;

public class ResponseUtils {

    private ResponseUtils() {
        super();
    }

    public static Response ok(final Object entity) {
        return Response.ok(entity).build();
    }

}
