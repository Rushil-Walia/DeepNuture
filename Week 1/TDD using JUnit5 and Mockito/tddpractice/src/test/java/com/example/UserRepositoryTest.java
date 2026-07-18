package com.example;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByName() {
        User user = new User();
        user.setId(1L); 
        user.setName("Alice");
        userRepository.save(user);

        List<User> results = userRepository.findByName("Alice");

        assertEquals(1, results.size());
        assertEquals("Alice", results.get(0).getName());
    }
}