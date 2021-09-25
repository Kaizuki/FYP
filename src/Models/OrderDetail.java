package Models;

public class OrderDetail {
    private int orderDetailId;
    private int orderDetailQty;
    private int inventoryId;
    private int orderId;

    public OrderDetail(int orderDetailId, int orderDetailQty, int inventoryId, int orderId) {
        this.orderDetailId = orderDetailId;
        this.orderDetailQty = orderDetailQty;
        this.inventoryId = inventoryId;
        this.orderId = orderId;
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

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "{" +
            " orderDetailId='" + getOrderDetailId() + "'" +
            ", orderDetailQty='" + getOrderDetailQty() + "'" +
            ", inventoryId='" + getInventoryId() + "'" +
            ", orderId='" + getOrderId() + "'" +
            "}";
    }
}
