package com.danielfireman.ifal.calcapi;

import io.jooby.Jooby;

public class App extends Jooby {

  {
    get("/", ctx -> "Chupa Javascript!");
    mvc(new Raiz());
    get("/div", ctx -> "Divisão!");
    mvc(new Divisao());
  }

  public static void main(final String[] args) {
    runApp(args, App::new);
  }

}
