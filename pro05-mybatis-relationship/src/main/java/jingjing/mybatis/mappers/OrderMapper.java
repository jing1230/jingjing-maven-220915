package jingjing.mybatis.mappers;

import jingjing.mybatis.entity.Order;

public interface OrderMapper {


    Order selectOrderWithCustomerTwoStep(Integer orderId);

    Order selectOrderOnly(int i);

    Order selectOrderWithCustomer(Integer orderId);
}
