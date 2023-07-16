package marcaly.com.springWMongoDB.resources;

import marcaly.com.springWMongoDB.domain.User;
import marcaly.com.springWMongoDB.dto.UserDTO;
import marcaly.com.springWMongoDB.services.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity <List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity <UserDTO> findById(@PathVariable String id) {
        User objUser = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(objUser));
    }
}
