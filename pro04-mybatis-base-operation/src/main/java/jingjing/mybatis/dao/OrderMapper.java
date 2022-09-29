package jingjing.mybatis.dao;

import jingjing.mybatis.entity.Order;

public interface OrderMapper {
    Order selectOrderWithCustomer(Integer orderId);
}
