package Models;

import java.io.Serializable;

public class Orders implements Serializable {
    private int orderId;
    private int managerId;
    private int supplierId;
    private int warehouseId;

    public Orders(int orderId, int managerId, int supplierId, int warehouseId) {
        this.orderId = orderId;
        this.managerId = managerId;
        this.supplierId = supplierId;
        this.warehouseId = warehouseId;
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

    public int getWarehouseId() {
        return this.warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Override
    public String toString() {
        return "{" +
            " orderId='" + getOrderId() + "'" +
            ", managerId='" + getManagerId() + "'" +
            ", supplierId='" + getSupplierId() + "'" +
            ", warehouseId='" + getWarehouseId() + "'" +
            "}";
    }   

}
