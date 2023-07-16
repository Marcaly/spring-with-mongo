package marcaly.com.springWMongoDB.config;

import marcaly.com.springWMongoDB.domain.User;
import marcaly.com.springWMongoDB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        User maria = new User(null, "Maria", "Maria@gmail.com");
        User alex = new User(null, "Alex", "alex@gmail.com");
        User nala = new User(null, "Nala", "Nala@gmail.com");
        userRepository.saveAll(Arrays.asList(maria,alex,nala));
    }
}
