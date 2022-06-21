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


