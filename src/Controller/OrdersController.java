package Controller;

import java.util.Arrays;
import java.util.List;
import Blockchain.BlockchainOperation.BlockType;
import Blockchain.OrdersOperation;
import Helper.IdGenerator;
import Models.OrderDetail;
import Models.Orders;
import Models.Orders.OrdersStatus;

public class OrdersController {
    OrdersOperation ordersOperation;

    public OrdersController() {
        ordersOperation = new OrdersOperation(BlockType.ORDER);
    }

    public void createOrders(String managerId, String supplierId, List<OrderDetail> ordersList) throws Exception {
        ordersOperation.createBlock( new Orders( "OD" + IdGenerator.generateUUID(), managerId, supplierId, ordersList, OrdersStatus.PENDING.toString()) );
    }

    public void deleteOrder(String orderId, String managerId, String supplierId, List<OrderDetail> ordersList) throws Exception {
        //!CANNOT CANCEL ORDER IF ORDERSTATUS IS ACCEPT / REJECT
        if (chkConfirmStatus(orderId)) {
            System.out.println("ORDER has been processed, no cancelation is allowed");
        } else {
            ordersOperation.createBlock( new Orders(orderId, managerId, supplierId, ordersList, OrdersStatus.CANCELED.toString()) );
        }
    }

    public void confirmOrders(String orderId, String managerId, String supplierId, List<OrderDetail> ordersList, OrdersStatus ordersStatus) throws Exception {
        ordersOperation.createBlock( new Orders(orderId, managerId, supplierId, ordersList, ordersStatus.toString()) );
    }

    private boolean chkConfirmStatus(String searchOrderId) {
        String orderStatus = ordersOperation.getSingleOrder(searchOrderId).getOrdersStatus();
        String[] rejectList = {OrdersStatus.ACCEPTED.toString(), OrdersStatus.REJECTED.toString()};
        return Arrays.stream(rejectList).anyMatch(orderStatus::contains);
    }

    public List<Orders> getOrders() {
       return ordersOperation.getOrders();
    }
}