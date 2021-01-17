package com.kovbel.agency.service;

import com.kovbel.agency.entity.User;
import com.kovbel.agency.repository.UserRepository;
import org.hibernate.query.internal.NativeQueryImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private EntityManager entityManager;

    @Mock
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    public UserService userService;


    @Test
    public void saveUserAndCheckIfUserNameIsBusyTest() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        BCryptPasswordEncoder bCryptPasswordEncoder = Mockito.mock(BCryptPasswordEncoder.class);
        User userFirst = new User();
        userFirst.setUsername("Andrij");
        UserService userService = new UserService(userRepository, null, bCryptPasswordEncoder, null);
        User userSecond = new User();
        when(userRepository.findByUsername("Andrij")).thenReturn(null);
        Assert.assertTrue(userService.saveUser(userFirst));
    }

    @Test
    public void allUsersTest() {
        List<User> userList = new ArrayList<>();
        userList.add(new User());
        userList.add(new User());
        userList.add(new User());
        when(userRepository.findAll()).thenReturn(userList);
        Assert.assertEquals(userList, userRepository.findAll());
    }

    @Test
    public void findUserByIdTest() {
        UserService userService = Mockito.mock(UserService.class);
        User user = new User();
        user.setId(12l);
        userService.findUserById(12l);
        when(userService.findUserById(12l)).thenReturn(user);
        Assert.assertEquals(user, userService.findUserById(12L));
    }

    @Test(expected = NullPointerException.class)
    public void deleteUserByIdAndFindTest() {
        User userFirst = new User();
        userFirst.setId(12L);
        when(userService.deleteUser(12l)).thenReturn(null);
        verify(userService.deleteUser(12l));
        Assert.assertTrue(userService.deleteUser(12L));
    }

    @Test(expected = NullPointerException.class)
    public void deleteUserByIdTest() {
        User userFirst = new User();
        userFirst.setId(12L);
        when(userService.deleteUser(12l)).thenReturn(null);
        Assert.assertTrue(userService.deleteUser(12L));
    }

    @Test
    public void usergtListTest() {
        NativeQueryImpl nativeQuery1 = Mockito.mock(NativeQueryImpl.class, RETURNS_DEEP_STUBS);
        when(nativeQuery1.getResultList()).thenReturn(Collections.emptyList());
        when(entityManager.createQuery(any(String.class), eq(User.class))).thenReturn(nativeQuery1);
        userService.usergtList(14l);
        verify(entityManager).createQuery("SELECT u FROM User u WHERE u.id > :paramId", User.class);
    }

    @Test
    public void saveUserTest() {
        User userFirst = new User();
        userFirst.setUsername("Andrij");
        User userSecond = new User();
        when(userRepository.findByUsername("Andrij")).thenReturn(userSecond);
        Assert.assertFalse(userService.saveUser(userFirst));
    }

    @Test
    public void loadUserByUsernameTest() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        User userFirst = new User();
        userRepository.findByUsername(userFirst.getUsername());
        UserService userService = new UserService(userRepository, null, null, null);
        User userSecond = new User();
        when(userRepository.findByUsername(userSecond.getUsername())).thenReturn(null);
    }
}

