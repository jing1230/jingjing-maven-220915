package jingjing.mybatis.entity;

public class Customer {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer.customer_id
     *
     * @mbggenerated Thu Sep 29 17:05:12 GMT+08:00 2022
     */
    private Integer customerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_customer.customer_name
     *
     * @mbggenerated Thu Sep 29 17:05:12 GMT+08:00 2022
     */
    private String customerName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer.customer_id
     *
     * @return the value of t_customer.customer_id
     *
     * @mbggenerated Thu Sep 29 17:05:12 GMT+08:00 2022
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer.customer_id
     *
     * @param customerId the value for t_customer.customer_id
     *
     * @mbggenerated Thu Sep 29 17:05:12 GMT+08:00 2022
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_customer.customer_name
     *
     * @return the value of t_customer.customer_name
     *
     * @mbggenerated Thu Sep 29 17:05:12 GMT+08:00 2022
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_customer.customer_name
     *
     * @param customerName the value for t_customer.customer_name
     *
     * @mbggenerated Thu Sep 29 17:05:12 GMT+08:00 2022
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }
}