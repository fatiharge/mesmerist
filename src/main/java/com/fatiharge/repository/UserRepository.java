package com.fatiharge.repository;


import com.fatiharge.domain.User;
import com.fatiharge.exception.UserNotFoundException;
import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;


@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {


    @Transactional
    public User createUser(User user) {
        persist(user);
        return user;
    }

    @Transactional
    public void deleteUser(Long id) {
        User user = getUserById(id);
        user.delete( );
    }

    public User findByEmail(String mail) {
        return find("mail", mail).firstResultOptional( ).orElseThrow(UserNotFoundException::new);
    }

    public User getUserById(Long id) {
        return findByIdOptional(id).orElseThrow(UserNotFoundException::new);
    }

    public User findByEmailAndPassword(
            String mail,
            String password
    ) {
        User user = findByEmail(mail);
        if (user != null && BcryptUtil.matches(password, user.password)) {
            return user;
        }
        return null;
    }

}