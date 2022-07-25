package com.danielfireman.ifal.calcapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.jooby.MockRouter;
import io.jooby.StatusCode;
import io.jooby.exception.BadRequestException;

public class DivisaoTest {

    @Test
    public void Divisao() {
        MockRouter router = new MockRouter(new App());
        router.get("/div/16/4", rsp -> {
            assertEquals(4.0, rsp.value());
            assertEquals(StatusCode.OK, rsp.getStatusCode());
        });
    }

    @Test
    public void div_operadorString() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/div/aa/2", rsp -> {});
        });
    }
    @Test
    public void div_virgula() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/div/8,5/2", rsp -> {});
        });
    }
    
}

