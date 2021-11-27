package usa.ciclo4.reto1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.ciclo4.reto1.model.User;
import usa.ciclo4.reto1.repository.crud.UserCrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> getAll() {
        return (List<User>)userCrudRepository.findAll();
    }
    
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }

    public User save(User user) {
        return userCrudRepository.save(user);
    }
    
    public boolean existEmail(String email) {
        Optional<User> user = userCrudRepository.findByEmail(email);
        return !user.isEmpty();
    }

    public Optional <User> userAutentication(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
}
