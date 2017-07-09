import java.util.Map;

//OK
public class ReceivingStock extends Stock {
    //Attributes
    private int minStockItems;
    private int maxStockItems;

    //Methods
    public ReceivingStock(int minStockItems, int maxStockItems) throws IllegalArgumentException {
        if(minStockItems < 1 || maxStockItems < minStockItems) throw new IllegalArgumentException();
        this.minStockItems = minStockItems;
        this.maxStockItems = maxStockItems;
    }
    public int getMinStockItems() {
        return this.minStockItems;
    }
    public int getMaxStockItems() {
        return this.maxStockItems;
    }



}
