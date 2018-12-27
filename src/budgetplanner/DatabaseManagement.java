/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package budgetplanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author bulut
 */
public class DatabaseManagement {

    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private Connection connect() { //main connection to database originates from here
        // SQLite connection string

        String url = "jdbc:sqlite:C:/Users/Bulut/Documents/NetBeansProjects/BudgetPlanner/db/se360.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public int returnRowSize() {
        System.out.println("returnRowSize");
        String sql = "select count(*) from metatable";
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            return rs.getRow();
            // loop through the result set

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public ArrayList<Budget> getAllBudgets(ArrayList<Budget> budgets) {
System.out.println(" getAllBudgets");        
        String sql = "select * from metatable";
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Budget bd = new Budget();
                bd.setBudgetId(rs.getInt("id"));
                bd.setBudgetName(rs.getString("name"));
                bd.setBudgetStartDate(rs.getString("startDate"));
                bd.setBudgetEndDate(rs.getString("endDate"));
                budgets.add(bd);

            }
            return budgets;
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return null;
    }

    public void insertBudget(Budget budget) throws SQLException {
        System.out.println("inserbudget"); 
        String sql = "insert into metatable(name,startDate,endDate) values('" + budget.getBudgetName() + "','" + budget.getBudgetStartDate() + "','" + budget.getBudgetEndDate() + "')";
        Connection conn = this.connect();
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }

    
     
      public void removeBudget(Budget budget) {
         System.out.println(" removeBudget"); 
        String sql = "delete from metatable where id="+budget.getBudgetId();
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
           System.out.println(e.getMessage());
        } 
        
        String sql2 = "drop table "+budget.getBudgetName().replaceAll("\\s", "");
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql2);
        } catch (SQLException e) {
           System.out.println(e.getMessage());
        } 
      }    
     
    public ArrayList<BudgetItem> getAllItems(ArrayList<BudgetItem> items) {  // kaldırılabilir.System.out.println(" getAllBudgets"); 
        System.out.println(" getAllItems"); 
        String sql = "select * from budget";
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                BudgetItem item = new BudgetItem();
                item.setItemId(rs.getInt("id"));
                item.setItemName(rs.getString("name"));
                item.setAmount(rs.getDouble("amount"));
                item.setCategory(rs.getString("category"));
                items.add(item);

            }
            return items;
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return null;
    }

    public ArrayList<BudgetItem> getBudgetTable(String budgetname) {
System.out.println(" getBudgetTable"); 
        budgetname = budgetname.replaceAll("\\s", "");
        ArrayList<BudgetItem> items = new ArrayList<BudgetItem>();

        String sql = "select * from " + budgetname;
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                BudgetItem item = new BudgetItem();
                item.setItemId(rs.getInt("id"));
                item.setItemName(rs.getString("name"));
                item.setAmount(rs.getDouble("amount"));
                item.setCategory(rs.getString("category"));
                items.add(item);

            }
            return items;
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return null;

    }

    public void createBudgetTable(String budgetname) {System.out.println("createBudgetTable"); 
        
        budgetname = budgetname.replaceAll("\\s", "");
        String sql = "CREATE TABLE " + budgetname + "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name   VARCHAR,amount   DOUBLE  NOT NULL,category VARCHAR NOT NULL)";
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
           System.out.println(e.getMessage());
        } 
    }
    
    public void insertBudgetItem(String budgetname, BudgetItem item) throws SQLException {
        System.out.println("insertBudgetItem"); 
          budgetname = budgetname.replaceAll("\\s", "");
        try{String sql = "insert into '" +budgetname+ "'(name,amount,category) values('" + item.getItemName() + "','" + item.getAmount() + "','" + item.getCategory() + "')";
        Connection conn = this.connect();
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void removeItem(BudgetItem item, String budgetName) {
        System.out.println(""); 
        
        budgetName = budgetName.replaceAll("\\s", "");
        String sql = "delete from '" +budgetName+ "' where id="+item.getItemId();
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
           System.out.println(e.getMessage());
        } 
        
        
      }   
}
