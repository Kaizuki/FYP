package Blockchain;

import java.util.ArrayList;
import java.util.List;

import Models.Orders;

public class OrderOperation extends BlockchainOperation{

    public OrderOperation(BlockType blockType) {
        super(blockType);
    }

    public List<Orders> getOrders() {
        List<Orders> filteredOrders = new ArrayList<Orders>();
        removeDuplicateData();
        for (Block blockOrders : filteredBlockchain) {
            filteredOrders.add(new Orders(
                ( (Orders) blockOrders.getBlockchainData() ).getOrderId(),
                ( (Orders) blockOrders.getBlockchainData() ).getManagerId(),
                ( (Orders) blockOrders.getBlockchainData() ).getSupplierId(),
                ( (Orders) blockOrders.getBlockchainData() ).getWarehouseId()
                )
            );
        }
        return filteredOrders;
    }


    
}
