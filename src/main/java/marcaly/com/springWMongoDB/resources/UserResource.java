package marcaly.com.springWMongoDB.resources;

import marcaly.com.springWMongoDB.domain.User;
import marcaly.com.springWMongoDB.dto.UserDTO;
import marcaly.com.springWMongoDB.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User objUser = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(objUser));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO) {
        User obj = service.FromDTO(objDTO);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody UserDTO objDTO, @PathVariable String id) {
        User obj = service.FromDTO(objDTO);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }
}
