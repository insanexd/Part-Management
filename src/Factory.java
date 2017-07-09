import java.awt.*;

public class Factory {
    //Attributes
    private Purchasing purchasing;
    private ReceivingStock stock;

    //Methods
    //OK
    public Factory(Purchasing purchasing, ReceivingStock receivingStock) throws NullPointerException {
        if(purchasing == null || receivingStock == null) throw new NullPointerException();
        this.purchasing = purchasing;
        this.stock = receivingStock;
    }
    public Purchasing getPurchasing() {
        return this.purchasing;
    }
    public ReceivingStock getStock() {
        return this.stock;
    }

    public static Part create(PartType partType, String id, String name)
            throws NullPointerException, IllegalArgumentException{
        if(partType == null || id == null || name == null) throw new NullPointerException();
        if(id == "" || name == "") throw new IllegalArgumentException();
        if(partType == PartType.COMPONENTS) {
            return new Components(id, name);
        } else if(partType == PartType.RESOURCE) {
            return new Resource(id, name);
        } else  {
            return new SingleComponent(id, name);
        }
    }
}
