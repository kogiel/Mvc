package sda.spring.mvc.Mvc.service;

import org.modelmapper.ModelMapper;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import sda.spring.mvc.Mvc.model.dto.UserDto;
import sda.spring.mvc.Mvc.model.entity.User;
import sda.spring.mvc.Mvc.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private ModelMapper mapper;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(ModelMapper mapper, UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.mapper = mapper;
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }
@Transactional
    public void addUser(UserDto userDto) {
        User user = mapper.map(userDto, User.class);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole("ROLE_USER");
        user = userRepository.save(user);
        System.out.println(user);
    }
    @Secured("ROLE_USER")
    public List<UserDto> getAllUsers() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        auth.getAuthorities()
                .forEach(u -> System.out.println(u.getAuthority()));
      return userRepository.findAll()
               .stream()
               .map(u -> mapper.map(u, UserDto.class))
               .collect(Collectors.toList());
    }
    @Transactional
    public void delete(String login) {
        userRepository.deleteByLogin(login);
    }

}
