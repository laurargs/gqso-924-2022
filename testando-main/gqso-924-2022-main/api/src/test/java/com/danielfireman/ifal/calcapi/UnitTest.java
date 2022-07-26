package com.danielfireman.ifal.calcapi;

import io.jooby.MockRouter;
import io.jooby.StatusCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTest {
  @Test
  public void welcome() {
    MockRouter router = new MockRouter(new App());
    router.get("/", rsp -> {
      assertEquals("Chupa Javascript!", rsp.value());
      assertEquals(StatusCode.OK, rsp.getStatusCode());
    });
  }
}
