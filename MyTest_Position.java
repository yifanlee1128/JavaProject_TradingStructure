package Assignment4;

import java.util.function.DoubleSupplier;

public class MyTest_Position extends junit.framework.TestCase {
    public void test_getAssetID(){
        Position position=new Position("AAPL",13,300);
        assertTrue(position.getAssetID().equals("AAPL"));
    }
    public void test_getPositions(){
        Position position=new Position("AAPL",13,300);
        assertTrue(Math.abs(position.getPositions()-3900)<1e-7);
    }
    public void test_markToMarket(){
        DoubleSupplier doubleSupplier=()->14;
        Position position=new Position("AAPL",13,300);
        position.price(doubleSupplier);
        assertTrue(Math.abs(position.markToMarket()-300)<1e-7);
    }
    public void test_rebalanceTo(){
        Position position=new Position("AAPL",13,300);
        position.rebalanceTo(4000);
        assertTrue(Math.abs(position.getPositions()-4000)<1e-7);
    }
    public void test_price(){
        DoubleSupplier doubleSupplier=()->14;
        Position position=new Position("AAPL",13,300);
        position.price(doubleSupplier);
        assertTrue(Math.abs(position.getPositions()-4200)<1e-7);
    }
    public void test_fill(){
        Position position=new Position("AAPL",10,100);
        position.fill("111",11,100);
        assertTrue(Math.abs(position.getPositions()-2200)<1e-7);
    }
}
