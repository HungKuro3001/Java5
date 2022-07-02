package entities;

import javax.persistence.*;

@Entity
@Table(name = "order", schema = "java4")
public class OrderEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "user_id", nullable = false)
    private int userId;
    @Basic
    @Column(name = "phuong_thuc", nullable = false)
    private int phuongThuc;
    @Basic
    @Column(name = "tinh_trang", nullable = false)
    private int tinhTrang;
    @Basic
    @Column(name = "total", nullable = false, precision = 0)
    private double total;
    @Basic
    @Column(name = "mo_ta", nullable = true, length = 255)
    private String moTa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPhuongThuc() {
        return phuongThuc;
    }

    public void setPhuongThuc(int phuongThuc) {
        this.phuongThuc = phuongThuc;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (phuongThuc != that.phuongThuc) return false;
        if (tinhTrang != that.tinhTrang) return false;
        if (Double.compare(that.total, total) != 0) return false;
        if (moTa != null ? !moTa.equals(that.moTa) : that.moTa != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + userId;
        result = 31 * result + phuongThuc;
        result = 31 * result + tinhTrang;
        temp = Double.doubleToLongBits(total);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (moTa != null ? moTa.hashCode() : 0);
        return result;
    }
}
