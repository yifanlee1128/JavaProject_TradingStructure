package Assignment4;

import java.util.Random;
import java.util.function.DoubleSupplier;


public class Exchange {
    private DoubleSupplier doubleSupplier=()->(10+Math.random());
    private String forOrderID="1";   //
    private void priceUpdate(Position position){
        position.price(doubleSupplier);
    }   //update latest price for each position
    private void finishOrder(Position position){
        //return executed order information to each position
        position.fill(forOrderID,doubleSupplier.getAsDouble(),new Random().nextInt()*100);
        Integer integer=Integer.valueOf(forOrderID);
        integer=integer+1;
        forOrderID=integer.toString();   //generate a new orderid for next executed order

    }
    public String placeOrder(){
        //unfinished
        String orderID=new String();
        return orderID;
    }
    public void cancelOrder(){
        //unfinished
    }
}
