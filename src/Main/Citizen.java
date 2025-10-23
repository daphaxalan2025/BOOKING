/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import config.config;
import java.util.Scanner;


public class Citizen {
   
    
    Scanner sc = new Scanner(System.in);
    config conf = new config();
    
    public static void viewUsers() {
                String usersQuery = "SELECT * FROM tbl_users";
                String[] usersHeaders = {"id", "name", "age", "adrs", "contact", "email", "type"};
                String[] usersColumns = {"u_id", "u_name","u_age", "u_address", "u_contact", "u_email", "u_type"};
                config conf = new config();
                conf.viewRecords(usersQuery, usersHeaders, usersColumns);
            }
    
    public static void viewtable() {
                String tableQuery = "SELECT * FROM tbl_event";
                String[] tableHeaders = {"ed", "uid", "name", "duration", "max", "price"};
                String[] tableColumns = {"e_id", "u_id","e_name", "e_duration", "e_duration", "e_price"};
                config conf = new config();
                conf.viewRecords (tableQuery, tableHeaders, tableColumns);
          }

   
   public void Citizen(){

                int answer, option, choice, click, age, userid, edu, emax, eprice;
                String nm, adrs, contact, email, pass, ename;
                char cont;
                                    System.out.println("WELCOME TO CITIZEN DASHBOARD");
                                        
                                    System.out.println("1. Book the Court ");
                                    System.out.println("2. Update Booking ");
                                    System.out.println("3. View Bookings");
                                    System.out.println("4. Report a Violation");
                                    System.out.println("5. Update Violation Report");
                                    System.out.println("6. View Violation Report ");
                                    System.out.println("7. Exit");
                                    choice = sc.nextInt();

                                            switch (choice){
                                                case 1:

                                                    viewUsers();
                                                    
                                                    System.out.println("Enter ID:");
                                                    userid = sc.nextInt();
                                                    System.out.println("Enter Event Name:");
                                                    ename = sc.next();
                                                    System.out.println("Enter Event Duration:");
                                                    edu = sc.nextInt();
                                                    System.out.println("Enter Maximum Number of People:");
                                                    emax = sc.nextInt();
                                                    System.out.println("Enter Price:");
                                                    eprice = sc.nextInt();

                                                    System.out.println("Do to want to continue(Y =1 / N = 0)?: ");
                                                    String con = sc.next().charAt(0) ;
                                                    
                                                    while (con = "Y" || con = "y" ){
                                                        
                                                    String sql = "INSERT INTO tbl_event(u_id, e_name, e_duration, e_max, e_price) VALUES (?, ?, ?, ?, ?)";
                                                    conf.addRecord(sql, userid, ename, edu, emax, eprice);

                                                   }
                
                                                break;

                                                case 2: 
                                                    viewtable();

                                                    System.out.println("Enter USER ID to update: ");
                                                    int eid = sc.nextInt();

                                                    System.out.println("Enter new ID:");
                                                    userid = sc.nextInt();
                                                    System.out.println("Enter Event Name:");
                                                    ename = sc.next();
                                                    System.out.println("Enter Event Duration:");
                                                    edu = sc.nextInt();
                                                    System.out.println("Enter Maximum Number of People:");
                                                    emax = sc.nextInt();
                                                    System.out.println("Enter Price:");
                                                    eprice = sc.nextInt();

                                                    String sql = "UPDATE tbl_event SET u_id = ?, u_name = ?, u_eduration = ?, u_max =?, u_price = ? WHERE u_id = ?";
                                                    conf.updateRecord(sql, userid, ename, edu, emax, eprice, eid );

                                                break;

                                                case 3:
                                                    viewtable();

                                                    break;

                                                case 4:

                                                    System.out.println("Enter COMPLAINANT ID: ");
                                                    int cid = sc.nextInt();
                                                    System.out.println("Enter VIOLATOR ID: ");
                                                    int vrid = sc.nextInt();
                                                    System.out.println("Enter WITNESS ID: ");
                                                    int wid = sc.nextInt();
                                                    System.out.println("Enter violation: ");
                                                    String vn= sc.next();
                                                    System.out.println("Enter date: ");
                                                    int date = sc.nextInt();
                                                    System.out.println("Enter time: ");
                                                    int tm = sc.nextInt();
                                                    System.out.println("Enter punishment: ");
                                                    String psh = sc.next();
                                                    System.out.println("Enter status: ");
                                                    String stats = sc.next();

                                                 break;

    
  }
    
}                               
    
}

