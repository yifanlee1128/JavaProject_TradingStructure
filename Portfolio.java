package Assignment4;

import java.util.HashMap;

public class Portfolio{
    private double _PnL;
    private double _positions;
    private HashMap<String,Position> positionMap=new HashMap<>();
    public Portfolio(Strategy strategy){
        double tempsum=0.d;
        for(Position position: strategy._positionList){
            positionMap.put(position.getAssetID(),position);
            tempsum+=position.getPositions();
        }
        _positions=tempsum;
    }
    public double getPL(){ //get PNL of this portfolio
        recalculatePNL();
        return _PnL;
    }
    private void recalculatePNL(){ //recalculate the PNL
        double tempsum=0.d;
        for(Position position:positionMap.values()){
            tempsum+=position.markToMarket();
        }
        _PnL=tempsum;
    }
    private void recalculatePositions(){ //recalculate the positions of the portfolio
        double tempsum=0.d;
        for(Position position:positionMap.values()){
            tempsum+=position.getPositions();
        }
        _positions=tempsum;
    }
    public void rebalanceTo(double newPositions){ //rebalance the positions of the portfolio
        recalculatePositions();
        double ratio =newPositions/_positions;
        for(Position position:positionMap.values()){
            position.rebalanceTo(ratio*position.getPositions());
        }

    }
    public double getPositions(){
        recalculatePositions();
        return _positions;
    }
}
