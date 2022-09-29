package jingjing.mybatis.test;

import com.sun.tools.corba.se.idl.constExpr.Or;
import jingjing.mybatis.entity.Customer;
import jingjing.mybatis.entity.Order;
import jingjing.mybatis.mappers.CustomerMapper;
import jingjing.mybatis.mappers.OrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class MybatisTest {

    private SqlSession session;

    @Test
    public void testQueryCustomerWithOrderList(){
        CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
        Integer customerId = 1;
        Customer customer = customerMapper.selectCustomerWithOrderList(customerId);
        System.out.println("customer = " + customer);
        List<Order> orderList = customer.getOrderList();
        for (Order order : orderList) {
            System.out.println("order = " + order);
        }

    }


    @Test
    public void testQueryOrderWithCustomer(){
        //目标：查询Order对象的同时，也查询关联的Customer对象
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        Integer orderId = 1;
        //执行关联查询
        Order order = orderMapper.selectOrderWithCustomer(orderId);
        System.out.println("order = " + order);
        //获取order关联的Customer对象
        Customer customer = order.getCustomer();
        System.out.println("customer = " + customer);
    }

    @Test
    public void testQueryOrder(){
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        Order order = orderMapper.selectOrderOnly(1);
        System.out.println("order = " + order);
    }

    @Before
    public void init() throws IOException {
         session = new SqlSessionFactoryBuilder().build(Resources
                        .getResourceAsStream("mybatis-config.xml"))
                .openSession();
    }

    @After
    public void clear(){
        session.commit();
        session.close();
    }
}
