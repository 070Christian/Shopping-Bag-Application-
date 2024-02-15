
public class ShoppingBag implements Retail {

	//Attributes of ShoppingBag
	private int totalItems;
    private double retailCost;
    private double taxRate;

	//Constructor accepting a tax rate
    public ShoppingBag(double taxRate) {
        this.totalItems = 0;
        this.retailCost = 0.0;
        this.taxRate = taxRate;
    }

    //Method to add items to the bag
    public void buy(int quantity, double itemCost) {
        totalItems += quantity;
        retailCost += quantity * itemCost;
    }

    //Implementing Retail interface methods
    @Override
    public double RetailCost() {
        return retailCost;
    }
    
  //Calculating average cost 
    @Override 
    public double AverageCost() {
    	return retailCost / totalItems;
    }

    //Calculating total cost including tax 
    @Override
    public double TotalCost() {
        return retailCost * (1 + (taxRate / 100));
    }

    @Override
    public int TotalItems() {
        return totalItems;
    }

    //toString for a nicely formatted summary
    @Override
    public String toString() {
        return String.format("Items: %d%nRetail cost: $%.2f%nAverage item cost: $%.2f%nTotal cost including tax (%.2f%%): $%.2f%n",
                totalItems, RetailCost(), AverageCost(), taxRate, TotalCost());
    }

  
    public double getTaxRate() {
        return taxRate;
    }

   
    public static void main(String[] args) {
    	
    	//Creating new bag object using 7% tax rate and buying items 
        ShoppingBag myBag = new ShoppingBag(7);  
        myBag.buy(5, 10.50);  
        myBag.buy(3, 7.00);    

        //Printing current state of the shopping bag
        System.out.println(myBag.toString());
    }
}
/*
 Output:
 Items: 8
Retail cost: $73.50
Average item cost: $9.19
Total cost including tax (7.00%): $78.65

 */
