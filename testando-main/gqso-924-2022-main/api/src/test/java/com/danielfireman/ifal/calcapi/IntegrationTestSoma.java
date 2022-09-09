package com.danielfireman.ifal.calcapi;

import io.jooby.JoobyTest;
import io.jooby.StatusCode;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@JoobyTest(App.class)
public class IntegrationTestSoma {

  static OkHttpClient client = new OkHttpClient();

  @Test
  public void checaErro1(int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort + "/soma/aa/2")
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals(StatusCode.BAD_REQUEST_CODE, rsp.code());
    }
  }

  @Test
  public void checaErro2(int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort + "/soma/8,5/2")
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals(StatusCode.BAD_REQUEST_CODE, rsp.code());
    }
  }

  @Test
  public void checaSucesso1(int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort + "/soma/25/5")
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals(StatusCode.OK_CODE, rsp.code());
      assertEquals("30.0", rsp.body().string());
    }
  }

  @Test
  public void checaSucesso2(int serverPort) throws IOException {
    Request req = new Request.Builder()
        .url("http://localhost:" + serverPort + "/soma/16/4")
        .build();

    try (Response rsp = client.newCall(req).execute()) {
      assertEquals(StatusCode.OK_CODE, rsp.code());
      assertEquals("20.0", rsp.body().string());
    }
  }
  
}