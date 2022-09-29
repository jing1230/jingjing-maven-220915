package jingjing.mybatis.test;

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
import java.util.concurrent.TimeUnit;

public class MybatisTest {

    private SqlSession session;

    @Test
    public void testQueryCustomerWithTwoStep() throws InterruptedException {
        CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
        Integer customerId = 1;
        Customer customer = customerMapper.selectCustomerWithTwoStep(customerId);
        System.out.println("customer = " + customer);

        TimeUnit.SECONDS.sleep(3);
        List<Order> orderList = customer.getOrderList();
        for (Order order : orderList) {
            System.out.println("order = " + order);

        }
    }

    @Test
    public void testQueryOrderWithCustomerTwoStep(){
        OrderMapper orderMapper = session.getMapper(OrderMapper.class);
        Integer orderId = 1;
        Order order = orderMapper.selectOrderWithCustomerTwoStep(orderId);
        System.out.println("order = " + order);
        Customer customer = order.getCustomer();
        System.out.println("customer = " + customer);

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
