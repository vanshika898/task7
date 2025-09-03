package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public  class Operations{
    public static void insertEmployee(Employee emp){
    String sql = "INSERT INTO employees(name,salary, city, department, designation, phoneNumber) VALUES (?, ?, ?, ?, ?, ?)";
    try(Connection  conn = DBConnection.getConnection();PreparedStatement stmt = conn.prepareStatement(sql)){

      stmt.setString(1, emp.getName());
      stmt.setInt(2, emp.getSalary());
     stmt.setString(3, emp.getCity());
     stmt.setString(4, emp.getDepartment());
    stmt.setString(5, emp.getDesignation());
    stmt.setLong(6, emp.getPhoneNumebr());
    stmt.executeUpdate();
    System.out.println("Insert done sucesssfully");

    }catch(SQLException e ){
        System.out.println("Insert failed !!! :"+e.getMessage());

    }
    }


    public  static void getAllEmployee() {
    List<Employee> l1 = new ArrayList<>();
    String sql = "SELECT * FROM employees";

    try (Connection conn = DBConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            
            Employee emp = new Employee(
                rs.getString("name"),
                rs.getInt("salary"),
                rs.getString("city"),
                rs.getString("department"),
                rs.getString("designation"),
                rs.getLong("phoneNumber")
            );

           
            l1.add(emp);

          
            System.out.println("Name : " + emp.getName());
            System.out.println("Salary : " + emp.getSalary());
            System.out.println("City : " + emp.getCity());
            System.out.println("Department : " + emp.getDepartment());
            System.out.println("Designation : " + emp.getDesignation());
            System.out.println("Phone Number : " + emp.getPhoneNumebr());
            System.out.println("---------------------------");
        }

    } catch (SQLException e) {
        System.out.println(" Fetch Failed: " + e.getMessage());
    }
}


       
    

    public static void  UpdateSalary(String name,int newSalary){
    String sql = "UPDATE employees SET salary = ? where name = ?";
    try(Connection conn = DBConnection.getConnection();PreparedStatement stmt = conn.prepareStatement(sql)){
        stmt.setInt(1, newSalary);
        stmt.setString(2, name);
        int rows = stmt.executeUpdate();

        if (rows > 0) System.out.println("Salary updated!");
            else System.out.println("No employee found with that name.");
    }catch(SQLException e){
        System.out.println("Update failed : " + e.getMessage());
    }
    }



    public static void DeleteEmployee(String name){
        String sql = "DELETE from employees where name = ?";

        try(Connection conn = DBConnection.getConnection();PreparedStatement stmt = conn.prepareStatement(sql)){

         stmt.setString(1, name);
          int rows = stmt.executeUpdate();
           if (rows > 0) System.out.println("Employee deleted!");
           else System.out.println("No employee found with this name");


        }catch(SQLException e){
            System.out.println("Deletion failed : "+ e.getMessage());
        }
    }








}