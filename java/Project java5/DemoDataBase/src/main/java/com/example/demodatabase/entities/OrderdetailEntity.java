package com.example.demodatabase.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "orderdetail", schema = "com2034", catalog = "")
@IdClass(OrderdetailEntityPK.class)
public class OrderdetailEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "OrderId", nullable = false)
    private int orderId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ProductId", nullable = false)
    private int productId;
    @Basic
    @Column(name = "PurchasedQuantity", nullable = false)
    private int purchasedQuantity;
    @Basic
    @Column(name = "PurchasedMoney", nullable = false, precision = 0)
    private int purchasedMoney;
    @ManyToOne
    @JoinColumn(name = "OrderId", referencedColumnName = "OrderId", nullable = false)
    private OrderEntity orderByOrderId;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPurchasedQuantity() {
        return purchasedQuantity;
    }

    public void setPurchasedQuantity(int purchasedQuantity) {
        this.purchasedQuantity = purchasedQuantity;
    }

    public int getPurchasedMoney() {
        return purchasedMoney;
    }

    public void setPurchasedMoney(int purchasedMoney) {
        this.purchasedMoney = purchasedMoney;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderdetailEntity that = (OrderdetailEntity) o;
        return orderId == that.orderId && productId == that.productId && purchasedQuantity == that.purchasedQuantity && purchasedMoney == that.purchasedMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, productId, purchasedQuantity, purchasedMoney);
    }

    public OrderEntity getOrderByOrderId() {
        return orderByOrderId;
    }

    public void setOrderByOrderId(OrderEntity orderByOrderId) {
        this.orderByOrderId = orderByOrderId;
    }
}
