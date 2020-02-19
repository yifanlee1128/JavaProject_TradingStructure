package Assignment4;

import java.util.LinkedList;
import java.util.function.DoubleSupplier;


public class Position {
    private String _assetID;
    private double _costPrice;
    private double _latestPrice;
    private double _qty;
    private double _positions;
    private LinkedList<Order> _orderRecord=new LinkedList<>();
    public Position(String assetID,double initialPrice,double initialQuantity){
        _assetID=assetID;
        _costPrice=initialPrice;
        _latestPrice=initialPrice;
        _qty=initialQuantity;
        _positions=initialPrice*initialQuantity;
    }
    private void recalculatePositions(){_positions=_latestPrice*_qty;}
    public void price(DoubleSupplier doubleSupplier){
        _latestPrice=doubleSupplier.getAsDouble();  //get latest price
        recalculatePositions();  //recalculate positions
    }
    public void fill(String orderID,double fillPrice,double quantity){  //update data after a new order executed
        _costPrice=(_costPrice*_qty+fillPrice*quantity)/(_qty+quantity);
        _qty=_qty+quantity;
        _latestPrice=fillPrice;
        recalculatePositions();  //recalculate positions
        _orderRecord.addLast(new Order(orderID,fillPrice,quantity)); //record the order information
    }
    public String getAssetID(){
        return _assetID;
    }
    public double getPositions(){
        recalculatePositions();
        return _positions;
    }
    public double markToMarket(){
        return _qty*(_latestPrice-_costPrice);
    }
    public void rebalanceTo(double newPositions){
        _qty=newPositions/_latestPrice;
        recalculatePositions();
    }   //rebalance positions
}
