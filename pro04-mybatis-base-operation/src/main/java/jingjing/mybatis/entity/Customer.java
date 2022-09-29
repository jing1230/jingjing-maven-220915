package jingjing.mybatis.entity;

import javax.swing.*;
import java.util.List;

public class Customer {

  private long customerId;
  private String customerName;

  public Customer() {
  }

  @Override
  public String toString() {
    return "Customer{" +
            "customerId=" + customerId +
            ", customerName='" + customerName + '\'' +
            ", orderList=" + orderList +
            '}';
  }

  public Customer(long customerId, String customerName, List<Order> orderList) {
    this.customerId = customerId;
    this.customerName = customerName;
    this.orderList = orderList;
  }

  public List<Order> getOrderList() {
    return orderList;
  }

  public void setOrderList(List<Order> orderList) {
    this.orderList = orderList;
  }

  //对多
  private List<Order> orderList;



  public long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(long customerId) {
    this.customerId = customerId;
  }


  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

}
