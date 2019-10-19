package com.nowak.service;

import com.nowak.db_entities.Forms;
import com.nowak.db_entities.Messages;
import com.nowak.db_entities.User;
import com.nowak.validation.ValidationUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserDetailsService extends org.springframework.security.core.userdetails.UserDetailsService {

    User findUserByUsername(String username);
    List<User> getUsers();
    void addUser(ValidationUser validationUser);
    List<Forms> getForms();
    void addForm(Forms form);
    String currentlyLoggedUser();
    void addMessage(Messages messages);
     List<Messages> getMessages();
}
