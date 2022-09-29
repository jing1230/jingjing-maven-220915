package jingjing.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {

    @Test
    public void testHelloWorldReview() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("mybatis.config.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory factory = builder.build(inputStream);

        SqlSession session = factory.openSession();

        String statement = "jingjing.mybatis.dao.EmployeeMapper.selectEmpById";

        Long empId = 1L;

        Object o = session.selectOne(statement, empId);

        System.out.println("o = " + o);

        session.commit();

        session.close();




    }



















  @Test
    public void testHelloWorld() throws IOException {
        //1.使用Mybatis的Resources类读取Mybatis全局配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis.config.xml");

        //2.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        //3.调用builder对象的build方法创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = builder.build(inputStream);

        //4.通过SqlSessionFactory对象开启一个从Java程序到数据库的会话
        SqlSession session = sessionFactory.openSession();

        //5.通过SqlSession对象找到Mapper配置文件中可以执行的SQL语句
        Object o = session.selectOne("jingjing.mybatis.dao.EmployeeMapper.selectEmpById", "1");
        //6.直接打印查询结果
        System.out.println("o = "+o);

        //7.提交事务
        session.commit();

        //8.关闭SqlSession
        session.close();
    }
}
