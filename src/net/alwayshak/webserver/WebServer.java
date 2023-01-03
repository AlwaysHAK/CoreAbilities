package net.alwayshak.webserver;

import net.alwayshak.abilities.Ability;
import net.alwayshak.abilities.AbilityHandler;
import net.alwayshak.enchantments.CustomEnchant;
import net.alwayshak.enchantments.EnchantHandler;
import org.bukkit.Bukkit;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;

public class WebServer {

    private boolean running;
    private Thread thr;
    private ServerSocket serverSocket;
    public void start() {
        running = true;
        try {
            thr = new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                    serverSocket = new ServerSocket(49501);

                    while (running) {
                        Socket clientSocket = serverSocket.accept();

                        InputStream input = clientSocket.getInputStream();
                        OutputStream output = clientSocket.getOutputStream();

                        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                        String request = reader.readLine();

                        servePage(output);

                        clientSocket.close();
                    }
                    serverSocket.close();
                } catch (Exception e) {
                    Bukkit.getLogger().log(Level.SEVERE, "Failed to load webserver: " + e.getMessage());
                }
                }
            });
            thr.start();
        } catch (Exception e) {
            Bukkit.getLogger().log(Level.SEVERE, "Failed to load webserver: " + e.getMessage());
        }
    }

    public void stop() {
        running = false;
        try {
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        thr.stop();
    }

    public WebServer() {

    }

    public void servePage(OutputStream output) throws IOException {
        StringBuilder enchants = new StringBuilder();
        for(CustomEnchant enchant : EnchantHandler.getEnchantments()) {
                    enchants.append(
                            "      <li>\n" +
                            "        <h2>" + enchant.getDisplayName() + "</h2>\n" +
                            "        <p>" + enchant.getDescription() + "</p>\n" +
                            "      </li>\n");
        }

        StringBuilder abilities = new StringBuilder();
        for(Ability ability : AbilityHandler.getHandler().getAbilities()) {
            abilities.append(
                    "      <li>\n" +
                    "        <h2>" + ability.getName() + "</h2>\n" +
                    "        <p>" + ability.getDescription() + "</p>\n" +
                    "      </li>\n");
        }

        String fileContents = readFile("index.html").replaceAll("%enchantments", enchants.toString()).replaceAll("%abilities", abilities.toString());

        // Write the HTTP response header to the client
        output.write("HTTP/1.1 200 OK\n\n".getBytes());

        // Write the contents of the file to the client
        output.write(fileContents.getBytes());
    }

    public String readFile(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();

        // Open the file and read its contents
        BufferedReader reader = new BufferedReader(new InputStreamReader(getResource("index.html")));
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();

        return sb.toString();
    }

    public InputStream getResource(String filename) {
        try {
            URL url = getClass().getClassLoader().getResource(filename);
            if (url == null) {
                return null;
            } else {
                URLConnection connection = url.openConnection();
                connection.setUseCaches(false);
                return connection.getInputStream();
            }
        } catch (IOException var4) {
            return null;
        }
    }

}
