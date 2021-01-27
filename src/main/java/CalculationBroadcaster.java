public interface CalculationBroadcaster {

    void addCalculationReceiver(CalculationReceiver calculationReceiver);
    void removeCalculationReceiver(CalculationReceiver calculationReceiver);
    void calculationBroadcast(double displayDouble,Boolean isDouble);

}
