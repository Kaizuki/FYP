package Models;

public class Warehouse {
    private String warehouseId;
    private String location;


    public Warehouse(String warehouseId, String location) {
        this.warehouseId = warehouseId;
        this.location = location;
    }

    public String getWarehouseId() {
        return this.warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "{" +
            " warehouseId='" + getWarehouseId() + "'" +
            ", location='" + getLocation() + "'" +
            "}";
    }

}
