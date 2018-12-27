/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budgetplanner;

/**
 *
 * @author Bulut
 */
public class BudgetItem {
       private String itemName;
    private double amount;
    private String category;
    private int itemID;

    BudgetItem() {
        
    }

    public int getItemId() {
        return itemID;
    }

    public void setItemId(int itemID) {
        this.itemID = itemID;
    }
    
    
       public BudgetItem(int id, String name, double amnt , String ctgry){
           itemName=name;
           category=ctgry;
           amount=amnt;
           itemID=id;
       }
    
        public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getAmount() {
            return amount;
        }
        
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
    
}
