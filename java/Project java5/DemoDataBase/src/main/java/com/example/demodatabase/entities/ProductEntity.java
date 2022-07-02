package com.example.demodatabase.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "product", schema = "com2034", catalog = "")
public class ProductEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ProductId", nullable = false)
    private int productId;
    @Basic
    @Column(name = "ProductName", nullable = false, length = 50)
    private String productName;
    @Basic
    @Column(name = "Price", nullable = false, precision = 0)
    private BigDecimal price;
    @Basic
    @Column(name = "Quantity", nullable = false)
    private int quantity;
    @OneToMany(mappedBy = "productByProductId")
    private Collection<OrderdetailEntity> orderdetailsByProductId;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return productId == that.productId && price == that.price && quantity == that.quantity && Objects.equals(productName, that.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, price, quantity);
    }

    public Collection<OrderdetailEntity> getOrderdetailsByProductId() {
        return orderdetailsByProductId;
    }

    public void setOrderdetailsByProductId(Collection<OrderdetailEntity> orderdetailsByProductId) {
        this.orderdetailsByProductId = orderdetailsByProductId;
    }
}
