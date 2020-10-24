package dao;

import domain.User;

import java.util.List;

public interface IUserDao {




    List<User> findAll();

    void savaUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

    User findById(int id);

}
