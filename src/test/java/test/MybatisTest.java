package test;

import dao.IUserDao;
import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class MybatisTest {
    private InputStream in;
    private SqlSession session;
    private IUserDao userDao;

    public static void main(String[] args)  {





    }
    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);


    }
    @After
    public void destroy() throws Exception {
        session.commit();
        session.close();
        in.close();
    }




    @Test
    public void testFindAll(){

        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }




    }
    @Test
    public void testSave() throws Exception {
        User user = new User();
        user.setUsername("王");
        user.setAddress("日本");
        user.setSex("男");
        user.setBirthday(new Date());

        userDao.savaUser(user);

    }


    @Test
    public void updateUser(){
        User user = new User();
        user.setUsername("王");
        user.setAddress("日本");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setId(41);
        userDao.updateUser(user);

    }

    @Test
    public void deleteUser(){

        userDao.deleteUser(48);
    }
    @Test
    public void findById(){

        User byId = userDao.findById(55);
        System.out.println(byId);
    }
}
