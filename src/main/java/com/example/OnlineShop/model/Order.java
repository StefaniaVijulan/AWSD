package com.example.OnlineShop.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity(name = "Order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrder;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateOrder;

    private Double priceOrder;

    @NotNull(message = "Price cannot be null")
    private Double taxPriceOrder;

    @Min(value = 5, message = "Min quantity should be at least 5")
    private Double totalPriceOrder;

    @NotNull(message = "Voucher cannot be null")
    private Double voucherOrder;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;


    @ManyToMany()
    @JoinTable(name = "order_product", joinColumns = @JoinColumn(name = "id_order"),
    inverseJoinColumns = @JoinColumn(name = "id_product"))

    private List<Product> products = new ArrayList<>();

    public Order(int idOrder, Date dateOrder, Double priceOrder, Double taxPriceOrder, Double totalPriceOrder, Double voucherOrder, User user, List<Product> products) {
        this.idOrder = idOrder;
        this.dateOrder = dateOrder;
        this.priceOrder = priceOrder;
        this.taxPriceOrder = taxPriceOrder;
        this.totalPriceOrder = totalPriceOrder;
        this.voucherOrder = voucherOrder;
        this.user = user;
        this.products = products;
    }

    public Order() {
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public void setPriceOrder(Double priceOrder) {
        this.priceOrder = priceOrder;
    }

    public void setTaxPriceOrder(Double taxPriceOrder) {
        this.taxPriceOrder = taxPriceOrder;
    }

    public Double getTotalPriceOrder() {
        return totalPriceOrder;
    }

    public void setTotalPriceOrder(Double totalPriceOrder) {
        this.totalPriceOrder = totalPriceOrder;
    }

    public void setVoucherOrder(Double voucherOrder) {
        this.voucherOrder = voucherOrder;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
