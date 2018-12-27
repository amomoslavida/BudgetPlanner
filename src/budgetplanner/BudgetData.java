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
public class BudgetData {
    
    String name;
    Double amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
     /* Double Food;
      Double Accomodation;
      Double Health;
      Double Savings;
      Double Transportation;
      Double SocialEvents;
      Double Education;
      Double Clothes;
      Double Utilities; */

    public BudgetData(String name, Double amount) {
        this.name = name;
        this.amount = amount;
    }
}
