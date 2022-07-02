package entities;

import java.util.List;

public class ListCartEntity {
    private List<CartEntity> order;
    private boolean status;
    private UsersEntity user;

    public List<CartEntity> getOrder() {
        return order;

    }
    public void setOrder(List<CartEntity> order) {
        this.order = order;
    }

    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    public UsersEntity getUser() {
        return user;
    }
    public void setUser(UsersEntity user) {
        this.user = user;
    }
}
