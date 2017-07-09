public class Purchasing implements Observation {
    //Attributes
    private ReceivingStock stock;


    public Purchasing(ReceivingStock receivingStock) throws NullPointerException{
        if(receivingStock == null) throw new NullPointerException();
        this.stock = receivingStock;
    }
    public void buy(Part part, int count) throws NullPointerException, IllegalArgumentException {
        if(part == null) throw new NullPointerException();
        if(count <= 0) throw new IllegalArgumentException();
        System.out.println("Foram compradas " + count + " pecas de " + part.getName());
        this.stock.insert(part, count);

    }
    //OK
    ReceivingStock getStock() {
        return this.stock;
    }

    @Override
    public void alarm(Part part) throws NullPointerException {
        if(part == null) throw new NullPointerException();
        System.out.println("Quantidade em estoque: " + stock.get(part));
        System.out.println("Quantidade minima: " + stock.getMinStockItems());
        if(stock.get(part) < stock.getMinStockItems()) {
            buy(part, stock.getMaxStockItems()-stock.get(part));
            System.out.println("depois da compra: " + stock.get(part) + " pecas em estoque");
        }


    }
}
