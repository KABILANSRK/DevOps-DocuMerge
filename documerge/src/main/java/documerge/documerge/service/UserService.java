package documerge.documerge.service;

import documerge.documerge.dto.UserDTO;
import documerge.documerge.model.User;
import documerge.documerge.repository.UserRepositoryJDBC;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepositoryJDBC userRepository;

    public UserService() {
        this.userRepository = new UserRepositoryJDBC();
    }

    // Signup logic
    public String signup(UserDTO userDTO) {
        // Check if user already exists
        Optional<User> existingUser = userRepository.findByEmail(userDTO.getEmail());
        if (existingUser.isPresent()) {
            return "User with this email already exists.";
        }

        // Save the new user
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword()); // Hash the password in production!
        userRepository.saveUser(user);
        return "User registered successfully!";
    }

    // Login logic
    public String login(String email, String password) {
        // Check if user exists
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return "Login successful!";
        }
        return "Invalid email or password.";
    }

    public boolean authenticateUser(String email, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'authenticateUser'");
    }

    public List<UserDTO> getAllUsers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllUsers'");
    }

    public UserDTO createUser(UserDTO userDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createUser'");
    }
}