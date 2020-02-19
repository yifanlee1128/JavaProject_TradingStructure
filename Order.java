package Assignment4;

public class Order{  //basic structure of market order
    private String _orderId;
    private double _orderDealPrice;
    private double _orderDealQuantity;
    public Order(String orderId,double orderDealPrice, double orderDealQuantity){
        _orderId=orderId;
        _orderDealPrice=orderDealPrice;
        _orderDealQuantity=orderDealQuantity;
    }
}

