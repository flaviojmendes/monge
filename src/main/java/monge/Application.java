package monge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("es.flaviojmend.monge.persistence.repo")
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public void run() {
    }
}