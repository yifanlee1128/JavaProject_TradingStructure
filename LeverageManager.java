package Assignment4;

import java.util.Iterator;
import java.util.LinkedList;

public class LeverageManager {
    private double _cash;
    private double _targetLeverage;
    private double _currentPL;
    private LinkedList<Portfolio> _portfolioList=new LinkedList<>();
    public LeverageManager(double initialCash,double targetLeverage,Strategy[] strategies){
        _cash=initialCash;
        _targetLeverage=targetLeverage;
        for(Strategy strategy:strategies){
            _portfolioList.addLast(new Portfolio(strategy));
        }
    }
    private void calculateCurrentPL(){ //summary all the PNL from all portfolios
        double tempsum=0.d;
        Iterator<Portfolio> iterator=_portfolioList.iterator();
        while(iterator.hasNext()){
            tempsum+=iterator.next().getPL();
        }
        _currentPL=tempsum;
    }
    public void keepLeverage(){ //rebalance all portfolios to keep the target leverage when market value changes
        calculateCurrentPL();
        double currentPL=_currentPL;
        double currentCash=_cash+currentPL;
        double assetRebalanceTo=currentCash*_targetLeverage;
        double ratio=assetRebalanceTo/(_cash*_targetLeverage+currentPL);
        _cash=currentCash;
        Iterator<Portfolio> iterator=_portfolioList.iterator();
        while(iterator.hasNext()){
            Portfolio temp=iterator.next();
            temp.rebalanceTo(ratio*temp.getPositions());
        }
    }
}
