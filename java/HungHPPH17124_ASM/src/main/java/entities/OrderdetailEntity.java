package entities;

import javax.persistence.*;

@Entity
@Table(name = "orderdetail", schema = "java4")
public class OrderdetailEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "oder_Id", nullable = false)
    private int oderId;
    @Basic
    @Column(name = "product_id", nullable = false)
    private int productId;
    @Basic
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    private double price;
    @ManyToOne
    @JoinColumn(name = "oder_Id", referencedColumnName = "id", nullable = false)
    private OrderEntity orderByOderId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOderId() {
        return oderId;
    }

    public void setOderId(int oderId) {
        this.oderId = oderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderdetailEntity that = (OrderdetailEntity) o;

        if (id != that.id) return false;
        if (oderId != that.oderId) return false;
        if (productId != that.productId) return false;
        if (quantity != that.quantity) return false;
        if (Double.compare(that.price, price) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + oderId;
        result = 31 * result + productId;
        result = 31 * result + quantity;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public OrderEntity getOrderByOderId() {
        return orderByOderId;
    }

    public void setOrderByOderId(OrderEntity orderByOderId) {
        this.orderByOderId = orderByOderId;
    }
}
