/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import config.config;
import java.util.Scanner;


public class Secretary {
    
    Scanner sc = new Scanner(System.in);
    config conf = new config();
    
    public static void viewUsers() {
                String usersQuery = "SELECT * FROM tbl_users";
                String[] usersHeaders = {"id", "name", "age", "adrs", "contact", "email", "type"};
                String[] usersColumns = {"u_id", "u_name","u_age", "u_address", "u_contact", "u_email", "u_type"};
                config conf = new config();
                conf.viewRecords(usersQuery, usersHeaders, usersColumns);
            }
    
    public void Sercretary(){
    
    System.out.println("WELCOME TO SECRETARY DASHBOARD");
                                        System.out.println("1. View Users");    
                                        System.out.println("2. Update Booking ");
                                        System.out.println("3. View Bookings");
                                        System.out.println("4. Update Violation Report");
                                        System.out.println("5. View Violation Report ");
                                        System.out.println("6. Exit");
                                            System.out.println("Enter your choice: ");
                                            int sec = sc.nextInt();

                                        switch(sec){
                                            case 1:
                                                viewUsers();
                                                break;

                                        }
                                         
                               
    }
}
