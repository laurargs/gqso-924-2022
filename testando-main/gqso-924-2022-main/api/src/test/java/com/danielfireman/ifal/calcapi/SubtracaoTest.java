package com.danielfireman.ifal.calcapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import io.jooby.MockRouter;
import io.jooby.StatusCode;
import io.jooby.exception.BadRequestException;

public class SubtracaoTest {

    @Test
    public void subtracao1() {
        MockRouter router = new MockRouter(new App());
        router.get("/sub/4/2", rsp -> {
            assertEquals(2.0, rsp.value());
            assertEquals(StatusCode.OK, rsp.getStatusCode());
        });
    }

    @Test
    public void Adicao2() {
        MockRouter router = new MockRouter(new App());
        router.get("/sub/16/4", rsp -> {
            assertEquals(12.0, rsp.value());
            assertEquals(StatusCode.OK, rsp.getStatusCode());
        });
    }

    @Test
    public void Adicao3() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/sub/aa/2", rsp -> {});
        });
    }
    @Test
    public void Adicao4() {
        MockRouter router = new MockRouter(new App());
        assertThrows(BadRequestException.class, () ->{
            router.get("/sub/8,5/2", rsp -> {});
        });
    }

}
