/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import config.config;
import java.util.Scanner;

public class President {
    
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
    
    public void President(){
        
        int answer, option, choice, click, age, userid, edu, emax, eprice;
                String nm, adrs, contact, email, pass, ename, result;
                char cont;
    
        System.out.println("WELCOME TO PRESIDENT DASHBOARD");
                                        System.out.println("1. View users information ");
                                        System.out.println("2. Update User");
                                        System.out.println("3. Delete User");
                                        System.out.println("4. Update Booking ");
                                        System.out.println("5. View Bookings");
                                        System.out.println("6. Delete Booking ");
                                        System.out.println("7. Update Violation Report");
                                        System.out.println("8. View Violation Report ");
                                        System.out.println("9. Delete Violation Report");
                                        System.out.println("10. Exit"); 
                                        System.out.println("Enter your choice");
                                         click = sc.nextInt();

                                            switch(click){
                                                case 1:
                                                    viewUsers();
                                                    System.out.print("Enter ID to Approve: ");
                                                    int ids = sc.nextInt();
                                                   
                                                    String sql = "UPDATE tbl_users SET u_status = ? WHERE u_id = ?";
                                                    conf.updateRecord(sql, "Approved", ids);
                                                    
                                                    break;

                                                case 2:
                                                    viewUsers();

                                                    System.out.println("Enter ID to update");
                                                    int id = sc.nextInt();

                                                    System.out.println("Enter new user name: ");
                                                    nm = sc.next();
                                                    System.out.println("Enter age: ");
                                                    age = sc.nextInt();
                                                    System.out.println("Enter address: ");
                                                    adrs = sc.next();
                                                    System.out.println("Enter contact: ");
                                                    contact = sc.next();
                                                    System.out.println("Enter email: ");
                                                    email = sc.next();
                                                    
                                                     while (true) {
                           
                                                    String qry = "SELECT * FROM tbl_users WHERE u_email = ?";
                                                    result = conf.fetchRecords(qry, email);
                                                     
                                                    if (result.isEmpty()) {
                                                        break;
                                                    } else {
                                                        System.out.print("Email already exists, Enter other Email: ");
                                                       email = sc.next();
                                                    }
                                                }

                                                    System.out.print("Enter user Type (1 - Citizen/2 -President/ 3 -Secretary): ");
                                                    int te = sc.nextInt();
                                                        while(te > 3 || te < 1){
                                                            System.out.print("Invalid, choose between 1, 2, & 3 only: ");
                                                            te = sc.nextInt();
                                                        }
                                                    String tp = "";
                                                        if (te == 1){
                                                            tp = "Citizen";
                                                        }else if ( te ==2 ){
                                                            tp = "President";
                                                        }else if ( te == 3 ){
                                                            tp = "Secretary";    

                                                        }

                                                            System.out.println("Enter password: ");
                                                            pass = sc.next();

                                                   sql = "UPDATE tbl_users SET u_name = ?, u_age = ?, u_address = ?, u_contact = ?, u_email = ?, u_pass =?, u_status=?, u_type =? WHERE u_id = ?";
                                                   conf.updateRecord(sql, nm, age, adrs, contact, email, pass, "Approved", tp, id);

                                                break;

                                                case 3:
                                                    viewUsers();

                                                    System.out.println("Enter ID to delete: ");
                                                     int idlt = sc.nextInt();

                                                    sql = "DELETE FROM tbl_users WHERE u_id = ?";
                                                    conf.deleteRecord(sql, idlt);

                                                    break;

                                            }

                                           
                                    }
    
    }
    

