package br.com.lavajato.DoisIrmoes.services;

import br.com.lavajato.DoisIrmoes.repositories.UserRepository;
import br.com.lavajato.DoisIrmoes.controllers.request.UserRequest;
import br.com.lavajato.DoisIrmoes.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserRequest request) {

        User user = User.builder()
                .cpf(request.getCpf())
                .name(request.getName())
                .street(request.getStreet())
                .houseNumber(request.getHouseNumber())
                .phone(request.getPhone())
                .email(request.getEmail())
                .build();

        return userRepository.saveAndFlush(user);
    }

    public User updateUser(Integer userId, UserRequest request) {

        User user = userRepository.findById(userId).orElse(new User());

        user.setCpf(request.getCpf());
        user.setName(request.getName());
        user.setStreet(request.getStreet());
        user.setHouseNumber(request.getHouseNumber());
        user.setPhone(request.getPhone());
        user.setEmail(request.getEmail());

        return userRepository.save(user);

    }

    public User getUser(Integer userId) {
        return userRepository.findById(userId).orElse(new User());
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void deleteUser(Integer userId) {
        User user = userRepository.findById(userId).orElse(new User());
        userRepository.delete(user);
    }

}
