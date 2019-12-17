package regenaration.team4;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Team4Application implements CommandLineRunner {


    public static void main(String[] args) {SpringApplication.run(Team4Application.class, args);}

    @Override
    public void run(String... args) {


    }

}
