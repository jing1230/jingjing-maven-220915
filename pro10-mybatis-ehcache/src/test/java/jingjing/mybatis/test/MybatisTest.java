package jingjing.mybatis.test;

import com.sun.tools.corba.se.idl.constExpr.Or;
import jingjing.mybatis.dao.EmployeeMapper;
import jingjing.mybatis.entity.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MybatisTest {

    private SqlSessionFactory factory;

    @Test
    public void testSecondLevelCacheWork(){
        //测试二级缓存存在：使用两个不同的SqlSession执行查询

        //第一次查询
        SqlSession session = factory.openSession();

        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

        Integer empId = 1;

        Emp emp01 = mapper.selectEmpById(empId);

        System.out.println("emp01 = " + emp01);

        session.commit();
        session.close();

        //第二次查询
        session = factory.openSession();

        mapper = session.getMapper(EmployeeMapper.class);

        Emp emp02 = mapper.selectEmpById(empId);

        System.out.println("emp02 = " + emp02);
        session.commit();
        session.close();

        //第二次查询
        session = factory.openSession();

        mapper = session.getMapper(EmployeeMapper.class);

        Emp emp03 = mapper.selectEmpById(empId);

        System.out.println("emp03 = " + emp03);
        session.commit();
        session.close();

        //第四次查询
        session = factory.openSession();

        mapper = session.getMapper(EmployeeMapper.class);

        Emp emp04 = mapper.selectEmpById(empId);

        System.out.println("emp04 = " + emp04);
        session.commit();
        session.close();


    }

    @Test
    public void testSecondLevelCache(){
        //测试二级缓存存在：使用两个不同的SqlSession执行查询
        SqlSession session01 = factory.openSession();
        SqlSession session02 = factory.openSession();

        EmployeeMapper mapper01 = session01.getMapper(EmployeeMapper.class);
        EmployeeMapper mapper02 = session01.getMapper(EmployeeMapper.class);

        Integer empId = 1;

        Emp emp01 = mapper01.selectEmpById(empId);
        Emp emp02 = mapper01.selectEmpById(empId);

        System.out.println("emp01 = " + emp01);
        System.out.println("emp02 = " + emp02);

        session01.commit();
        session01.close();
        session02.commit();
        session02.close();


    }
    @Test
    public void testFirstLevelCacheNotWork05(){

        //一级缓存失效五：两次查询之间提交事务
        SqlSession session = factory.openSession();
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Integer empId = 1;

        //第一次查询:需要查询数据库
        Emp emp01 = employeeMapper.selectEmpById(empId);
        System.out.println("emp01 = " + emp01);

        //提交事务
        session.commit();

        //第二次查询：没有发生SQL语句到数据库，证明数据是从缓存中获取到的
        Emp emp02 = employeeMapper.selectEmpById(empId);
        System.out.println("emp02 = " + emp02);

        session.commit();
        session.close();
    }


    @Test
    public void testFirstLevelCacheNotWork04(){

        //一级缓存失效四：两次查询之间手动清空缓存
        SqlSession session = factory.openSession();
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Integer empId = 1;

        //第一次查询:需要查询数据库
        Emp emp01 = employeeMapper.selectEmpById(empId);
        System.out.println("emp01 = " + emp01);

        //清空缓存
        session.clearCache();

        //第二次查询：没有发生SQL语句到数据库，证明数据是从缓存中获取到的
        Emp emp02 = employeeMapper.selectEmpById(empId);
        System.out.println("emp02 = " + emp02);

        session.commit();
        session.close();
    }


    @Test
    public void testFirstLevelCacheNotWork03(){

        //一级缓存失效三：两次查询之间执行了增删改操作
        SqlSession session = factory.openSession();
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Integer empId = 1;

        //第一次查询:需要查询数据库
        Emp emp01 = employeeMapper.selectEmpById(empId);
        System.out.println("emp01 = " + emp01);

        //增删改操作
        employeeMapper.updateEmp(new Emp(5l,"pot",9999.9));

        //第二次查询：没有发生SQL语句到数据库，证明数据是从缓存中获取到的
        Emp emp02 = employeeMapper.selectEmpById(empId);
        System.out.println("emp02 = " + emp02);

        session.commit();
        session.close();
    }

    @Test
    public void testFirstLevelCacheNotWork02(){

        //一级缓存失效二：查询条件不同
        SqlSession session = factory.openSession();
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Integer empId = 1;

        //第一次查询:需要查询数据库
        Emp emp01 = employeeMapper.selectEmpById(empId);
        System.out.println("emp01 = " + emp01);

        //第二次查询：没有发生SQL语句到数据库，证明数据是从缓存中获取到的
        empId = 2;
        Emp emp02 = employeeMapper.selectEmpById(empId);
        System.out.println("emp02 = " + emp02);

        session.commit();
        session.close();
    }


    @Test
    public void testFirstLevelCacheNotWork01(){

        //一级缓存失效情况一：不在同一个SqlSession中
        SqlSession session01 = factory.openSession();
        SqlSession session02 = factory.openSession();
        EmployeeMapper employeeMapper01 = session01.getMapper(EmployeeMapper.class);
        EmployeeMapper employeeMapper02 = session02.getMapper(EmployeeMapper.class);

        Integer empId = 1;
        Emp emp01 = employeeMapper01.selectEmpById(empId);
        System.out.println("emp01 = " + emp01);

        Emp emp02 = employeeMapper02.selectEmpById(empId);
        System.out.println("emp02 = " + emp02);

        session01.commit();
        session01.close();

        session02.commit();
        session02.close();


    }

    @Test
    public void testFirstLevelCache(){
        SqlSession session = factory.openSession();
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Integer empId = 1;

        //第一次查询:需要查询数据库
        Emp emp01 = employeeMapper.selectEmpById(empId);
        System.out.println("emp01 = " + emp01);

        //第二次查询：没有发生SQL语句到数据库，证明数据是从缓存中获取到的
        Emp emp02 = employeeMapper.selectEmpById(empId);
        System.out.println("emp02 = " + emp02);

        session.commit();
        session.close();
    }

    @Before
    public void init() throws IOException {
        factory = new SqlSessionFactoryBuilder().
                build(Resources.getResourceAsStream("mybatis-config.xml"));
    }


}
