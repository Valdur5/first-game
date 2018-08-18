package de.pandigo.games.first;

import de.pandigo.games.first.domain.client.PlayerClient;
import de.pandigo.games.first.domain.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    @Autowired
    private PlayerClient playerClient;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            Player player = playerClient.createPlayer();
            playerClient.getPlayer(player.getPlayerId());
            player = playerClient.addExpToPlayer(player.getPlayerId(), 1000);
            System.out.println(player.getLevel());
            player = playerClient.addExpToPlayer(player.getPlayerId(), 1000);
            player = playerClient.addExpToPlayer(player.getPlayerId(), 1000);
            System.out.println(player.getLevel());
        };
    }
}
