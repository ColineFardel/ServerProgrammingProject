package com.example.RoadTripManager;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.RoadTripManager.domain.User;
import com.example.RoadTripManager.domain.UserRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
    private UserRepository repository;

    @Test
    public void findByUsernameShouldReturnUser() {
        User user = repository.findByUsername("admin");
        
        assertThat(user).isNotNull();
        assertThat(user.getRole()).isEqualTo("ADMIN");
    }
    
    @Test
    public void createNewUser() {
    	User user = new User("Mickey", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
    	repository.save(user);
    	assertThat(user.getId()).isNotNull();
    }   
    
    @Test
    public void deleteUser() {
    	User user = repository.findByUsername("admin");
        assertThat(user).isNotNull();
        
        repository.deleteById(user.getId());
    	assertThat(repository.findByUsername("admin")).isNull();
    }
}
