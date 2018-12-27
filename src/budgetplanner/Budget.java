/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budgetplanner;

import java.util.Date;

/**
 *
 * @author Bulut
 */
public class Budget {
    private String budgetName;
    private String budgetStartDate;
    private String budgetEndDate;
    private int budgetId;

    Budget() {
        
    }

    public int getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(int budgetId) {
        this.budgetId = budgetId;
    }
    
    
       public Budget(String name, String start , String end){
           budgetName=name;
           budgetStartDate=start;
           budgetEndDate=end;
       }
    
        public String getBudgetName() {
		return budgetName;
	}

	public void setBudgetName(String budgetName) {
		this.budgetName = budgetName;
	}

	public String getBudgetStartDate() {
		return budgetStartDate;
	}

	public void setBudgetStartDate(String budgetStartDate) {
		this.budgetStartDate = budgetStartDate;
	}

	public String getBudgetEndDate() {
		return budgetEndDate;
	}

	public void setBudgetEndDate(String budgetEndDate) {
		this.budgetEndDate = budgetEndDate;
	}
    
}
