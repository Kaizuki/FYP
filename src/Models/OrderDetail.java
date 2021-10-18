package Models;

import java.io.Serializable;

public class OrderDetail implements Serializable {
    private int orderDetailId;
    private int orderDetailQty;
    private int inventoryId;

    public OrderDetail(int orderDetailId, int inventoryId, int orderDetailQty) {
        this.orderDetailId = orderDetailId;
        this.inventoryId = inventoryId;
        this.orderDetailQty = orderDetailQty;
    }

    public int getOrderDetailId() {
        return this.orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public int getOrderDetailQty() {
        return this.orderDetailQty;
    }

    public void setOrderDetailQty(int orderDetailQty) {
        this.orderDetailQty = orderDetailQty;
    }

    public int getInventoryId() {
        return this.inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    @Override
    public String toString() {
        return "{" +
            " orderDetailId='" + getOrderDetailId() + "'" +
            ", orderDetailQty='" + getOrderDetailQty() + "'" +
            ", inventoryId='" + getInventoryId() + "'" +
            "}";
    }
}
