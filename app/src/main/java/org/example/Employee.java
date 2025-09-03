package org.example;


public class Employee {
    private String name;
    private int salary;
    private  String city;
    private String department;
    private String designation;
    private long phoneNumber;

   public  Employee(String name,int salary,String city, String department, String designation,long phoneNumber){
    this.name = name;
    this.salary = salary;
    this.city = city;
    this.department = department;
    this.designation = designation;
    this.phoneNumber = phoneNumber;
   }


   public void setName(String name){
    this.name = name;
   }
   public String getName(){
    return this.name;
   }





   public void setCity(String  city){
    this. city =  city;
   }
   public String getCity(){
    return this. city;
   }





   public void setDepartment(String department){
    this. department = department;
   }
   public String getDepartment(){
    return this.department;
   }


    public void setDesignation(String designation){
    this. designation= designation;
   }
   public String getDesignation(){
    return this.designation;
   }



public void setSalary(int salary){
    this.salary = salary;
}

public int getSalary(){
    return this.salary;
}




   public void setPhoneNumber(long phoneNumber){
    this.phoneNumber = phoneNumber;
   }

   public long getPhoneNumebr(){
    return this.phoneNumber;
   }
}
