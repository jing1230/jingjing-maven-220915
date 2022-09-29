package jingjing.mybatis.entity;

public class Order {

  private Integer orderId;
  private String orderName;
  private Integer customerId;

  private Customer customer;

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  @Override
  public String toString() {
    return "Order{" +
            "orderId=" + orderId +
            ", orderName='" + orderName + '\'' +
            ", customerId=" + customerId +
            '}';
  }

  public Order(Integer orderId, String orderName, Integer customerId) {
    this.orderId = orderId;
    this.orderName = orderName;
    this.customerId = customerId;
  }

  public Order() {
  }

  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }


  public String getOrderName() {
    return orderName;
  }

  public void setOrderName(String orderName) {
    this.orderName = orderName;
  }


  public Integer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

}
