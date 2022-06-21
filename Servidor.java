import static java.net.HttpURLConnection.HTTP_OK;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.io.OutputStream;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import com.sun.net.httpserver.HttpServer;

public class Servidor {
   
    public static final int TAMANHO_BACKLOG = 100;

    public static void main(String[] args) throws IOException {
       
        InetSocketAddress bindAddr = new InetSocketAddress(46317);
        HttpServer server = HttpServer.create(bindAddr, TAMANHO_BACKLOG);
        server.setExecutor(Executors.newSingleThreadExecutor());

        server.createContext(IndexHandler.PATH, new IndexHandler());
   
        server.start();
        System.out.printf("Servidor ouvindo requisições na porta %s\n\n", server.getAddress().getPort());
    }
}


public class IndexHandler implements HttpHandler {

    public static final String PATH = "/";

    @Override
    public void handle(HttpExchange conn) throws IOException {
        byte[] mensagem = "Seja bem-vindo(a) a API Calculadora! Temos o seguinte endpoint: /div".getBytes();

        try {
            
            conn.sendResponseHeaders(HTTP_OK, mensagem.length);

            Headers headers = conn.getResponseHeaders();
            headers.add("Content-Type", "text/html; charset=UTF-8");
            
            try (OutputStream out = conn.getResponseBody()) {
                out.write(mensagem);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }
}
