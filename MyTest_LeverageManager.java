package Assignment4;

import java.util.function.DoubleSupplier;

public class MyTest_LeverageManager extends junit.framework.TestCase {
    public void test_keepLeverage(){
        Position position=new Position("AAPL",10,2000);
        Position[] positions={position};
        Strategy strategy=new Strategy(positions);
        Strategy[] strategies={strategy};
        LeverageManager leverageManager=new LeverageManager(10000,2,strategies);
        DoubleSupplier doubleSupplier=()->9;
        position.price(doubleSupplier);
        leverageManager.keepLeverage();
        assertTrue(Math.abs(position.getPositions()-16000)<1e-7);
    }
}
