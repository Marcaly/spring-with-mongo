package marcaly.com.springWMongoDB.config;

import marcaly.com.springWMongoDB.domain.Post;
import marcaly.com.springWMongoDB.domain.User;
import marcaly.com.springWMongoDB.dto.AuthorDTO;
import marcaly.com.springWMongoDB.repository.PostRepository;
import marcaly.com.springWMongoDB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria", "Maria@gmail.com");
        User alex = new User(null, "Alex", "alex@gmail.com");
        User nala = new User(null, "Nala", "Nala@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, nala));              

        Post post1 = new Post(null, "Partiu viagem", sdf.parse("21/03/2019"), "Vou viajar para SP", new AuthorDTO(maria));
        Post post2 = new Post(null, "Bom dia", sdf.parse("22/04/2019"), "Acordei feliz", new AuthorDTO(maria));


        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
