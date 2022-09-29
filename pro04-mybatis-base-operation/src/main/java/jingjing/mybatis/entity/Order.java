package jingjing.mybatis.entity;


public class Order {

  private long orderId;
  private String orderName;
  private long customerId;

  @Override
  public String toString() {
    return "Order{" +
            "orderId=" + orderId +
            ", orderName='" + orderName + '\'' +
            ", customerId=" + customerId +
            ", customer=" + customer +
            '}';
  }

  public Order(long orderId, String orderName, long customerId, Customer customer) {
    this.orderId = orderId;
    this.orderName = orderName;
    this.customerId = customerId;
    this.customer = customer;
  }

  public Order() {
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  //对一
  private Customer customer;


  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }


  public String getOrderName() {
    return orderName;
  }

  public void setOrderName(String orderName) {
    this.orderName = orderName;
  }


  public long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(long customerId) {
    this.customerId = customerId;
  }

}
