package jingjing.mybatis.test;

import jingjing.mybatis.dao.EmployeeMapper;
import jingjing.mybatis.dao.OrderMapper;
import jingjing.mybatis.entity.Customer;
import jingjing.mybatis.entity.Emp;
import jingjing.mybatis.entity.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImprovedMybatisTest {
    private SqlSession session;

    @Test
    public void testGetOrderWithCustomer(){
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        Order order = orderMapper.selectOrderWithCustomer(1);
        System.out.println("order = " + order);
        Customer customer = order.getCustomer();
        System.out.println("customer = " + customer);

    }
    
    @Test
    public void testSelectWithResult(){
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        List<Emp> empList = employeeMapper.selectWithResultMap();

        for (Emp emp : empList) {
            System.out.println("emp = " + emp);
        }
    }
    

    @Test
    public void testGetGeneratedKey(){
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Emp emp = new Emp(null, "hell", 17878.66);
        int rowCount = employeeMapper.insertWithKey(emp);
        System.out.println("rowCount = " + rowCount);

        Long empId = emp.getEmpId();
        System.out.println("empId = " + empId);
        
    }
    
    @Test
    public void testSelectForList(){
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        List<Emp> empList = employeeMapper.selectAll();
        for (Emp emp : empList) {
            System.out.println("emp = " + emp);
        }
    }

    @Test
    public void testSelectForMap(){
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Map<String,Object> mapResult = employeeMapper.selectForMap(1);
        Set<String> keySet = mapResult.keySet();
        for (String key : keySet) {
            Object value = mapResult.get(key);
            System.out.println(key + " = " + value);

        }
    }

    @Test
    public void testSelectCount(){
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Integer count = employeeMapper.selectCount();
        System.out.println("count = " + count);
    }

    @Test
    public void testUpdateEmpByMap(){
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Map <String,Object> paramMap = new HashMap<>();

        paramMap.put("empIdKey",1L);
        paramMap.put("empNameKey","Justin");
        paramMap.put("empSalaryKey",7777.77);

        employeeMapper.updateByMap(paramMap);

    }


    @Test
    public void testUpdateSalaryById(){
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Long empId = 1L;
        Double empSalary = 6666.66;
        employeeMapper.updateSalaryById(empId,empSalary);

    }

    @Test
    public void testDollar(){
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        Emp emp = employeeMapper.selectEmpByName("o");
        System.out.println("emp = " + emp);
    }


    @Test
    public void testInsert(){
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        int rowCount = employeeMapper.insertEmp(new Emp(null,"jerry",1111.11));

        System.out.println("rowCount = " + rowCount);
    }
    
    @Test
    public void testDelete(){
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        int rowCount = employeeMapper.deleteById(9);
        System.out.println("rowCount = " + rowCount);
    }

    @Test
    public void testUpdate(){
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        int rowCount = employeeMapper.updateEmp(new Emp(3L,"harry",999.99));


    }

    
    @Test
    public void testUseMapperInterface(){
        //1.根据EmployeeMapper接口的class对象获取Mapper接口类型的对象
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        System.out.println("employeeMapper.getClass().getName() = " + employeeMapper.getClass().getName());
        
        //2.调用EmployeeMapper接口的方法完成对数据库的操作
        Emp emp = employeeMapper.selectEmpById(1L);
        System.out.println("emp = " + emp);
        
    }
    
    
    /* junit会在每个@Test方法前执行@before方法*/
    @Before
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.config.xml")).openSession();
    }

    /* junit会在每个@Test方法后执行@After方法*/
    @After
    public void clear(){
        session.commit();
        session.close();
    }
}
