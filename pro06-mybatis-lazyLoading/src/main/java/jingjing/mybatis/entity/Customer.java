package jingjing.mybatis.entity;

import java.util.List;

public class Customer {

  private Integer customerId;
  private String customerName;

  private List<Order> orderList;

  @Override
  public String toString() {
    return "Customer{" +
            "customerId=" + customerId +
            ", customerName='" + customerName + '\'' +
            '}';
  }

  public Customer(Integer customerId, String customerName) {
    this.customerId = customerId;
    this.customerName = customerName;
  }

  public Customer() {
  }

  public Integer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }


  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public List<Order> getOrderList() {
    return orderList;
  }

  public void setOrderList(List<Order> orderList) {
    this.orderList = orderList;
  }
}
