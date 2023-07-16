package marcaly.com.springWMongoDB.services;

import marcaly.com.springWMongoDB.domain.User;
import marcaly.com.springWMongoDB.dto.UserDTO;
import marcaly.com.springWMongoDB.repository.UserRepository;
import marcaly.com.springWMongoDB.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;
    public List<User> findAll() {
      return repo.findAll();
    }
    public User findById(String id) {
       Optional<User> obj = repo.findById(id);
       return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
    public User insert(User obj) {
        return repo.insert(obj);
    }
    public User FromDTO(UserDTO objDTO) {
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
}
