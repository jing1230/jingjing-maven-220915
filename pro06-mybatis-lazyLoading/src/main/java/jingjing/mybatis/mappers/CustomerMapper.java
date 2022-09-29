package jingjing.mybatis.mappers;

import jingjing.mybatis.entity.Customer;

public interface CustomerMapper {
    Customer selectCustomerWithTwoStep(Integer customerId);
}
