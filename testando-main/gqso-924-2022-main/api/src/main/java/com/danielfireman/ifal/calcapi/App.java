package com.danielfireman.ifal.calcapi;

import io.jooby.Jooby;

public class App extends Jooby {

  {
    get("/", ctx -> "Bem-vindo a API Calculadora!");
    mvc(new Multiplicacao());
    mvc(new Subtracao());

  }

  public static void main(final String[] args) {
    runApp(args, App::new);
  }

}
