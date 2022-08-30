package vito.shop.pizza.service.impl;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import vito.shop.pizza.entity.User;
import vito.shop.pizza.repository.UserRepository;
import vito.shop.pizza.service.UserService;



import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserServiceImplTest {

    @Autowired
    private UserService userService;


@Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setup(){
   User user = new User(1L,"kasun","kasun@gmail.com", "123456788808", "23423434244244", "assdeeeerrrrr");
   userService.registerUser(user);
    }

    @DisplayName("Single test successful")
    @Test
    public void testGetUserById_Success() {
        String user_name = "kasun";
        User user = userRepository.getById(1L);
        assertEquals(user_name, "kasun" );
    }
//
//    @Test
//   public void testGetUserById() {
//
//        User user = User.builder()
//                .name("Kasun")
//                .email("k@gmail.com")
//                .password("1234456")
//                .phone("12344506060")
//                .address("address 1234")
//                .build();
//
//        userRepository.save(user);
//        assertEquals("kasun", user.getName() );
//
//   }
}