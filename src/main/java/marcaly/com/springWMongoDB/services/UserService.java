package marcaly.com.springWMongoDB.services;

import marcaly.com.springWMongoDB.domain.User;
import marcaly.com.springWMongoDB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;
    public List<User> findAll() {
      return repo.findAll();
    }
}
