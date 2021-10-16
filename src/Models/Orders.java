package Models;

import java.io.Serializable;
import java.util.List;

public class Orders extends Models implements Serializable {
    private int orderId;
    private int managerId;
    private int supplierId;
    private List<OrderDetail> orderList;
    private String ordersStatus;
    public static enum OrdersStatus {PENDING, ACCEPTED, REJECTED, CANCELED}

    public Orders(int orderId, int managerId, int supplierId, List<OrderDetail> orderList, String ordersStatus) {
        this.orderId = orderId;
        this.managerId = managerId;
        this.supplierId = supplierId;
        this.orderList = orderList;
        this.ordersStatus = ordersStatus;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getManagerId() {
        return this.managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getSupplierId() {
        return this.supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public List<OrderDetail> getOrderList() {
        return this.orderList;
    }

    public void setOrderList(List<OrderDetail> orderList) {
        this.orderList = orderList;
    }

    public String getOrdersStatus() {
        return this.ordersStatus;
    }

    public void setOrdersStatus(String ordersStatus) {
        this.ordersStatus = ordersStatus;
    }

    @Override
    public String toString() {
        return "{" +
            " orderId='" + getOrderId() + "'" +
            ", managerId='" + getManagerId() + "'" +
            ", supplierId='" + getSupplierId() + "'" +
            ", orderList='" + getOrderList() + "'" +
            ", ordersStatus='" + getOrdersStatus() + "'" +
            "}";
    }   
    
    @Override
    public int getModelId() {
        return this.orderId;
    }
}