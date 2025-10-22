
package Main;

import config.config;
import java.util.Scanner;


public class Main {
    
 
    public static void main(String[] args) {
        
        config db = new config();
        db.connectDB();
        
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        
        int answer, option, choice, click, age, userid, edu, emax, eprice;
        String nm, adrs, contact, email, pass, ename;
        char cont;
        
        System.out.println("---DALHIA'S HOME COVERED COURT BOKING & VIOLATION REPORT---");
        
        
        do{
 
            System.out.println("====MAIN MENU====");
            System.out.println("1. LOG IN");
            System.out.println("2. SIGN UP");
            System.out.println("3. EXIT");
            System.out.println("Enter your choice: ");
            answer = sc.nextInt();
            
            switch(answer){
                case 1:
                    System.out.println("Enter your email: ");
                    String em = sc.next();
                    System.out.println("Enter password: ");
                    String pas = sc.next();
                    
                    String hashedpass = conf.hashPassword(pas);
                    
                    while(true){
                    String qry = "SELECT * FROM tbl_users WHERE u_email = ? AND u_pass = ?";
                    java.util.List<java.util.Map<String, Object>> result = conf.fetchRecords(qry, em, hashedpass);
                    

                    if (result.isEmpty()) {
                             
                                System.out.println("INVALID CREDENTIALS");
                                break;
                            } else {
                                java.util.Map<String, Object> user = result.get(0);
                                String stat = user.get("u_status").toString();
                                String type = user.get("u_type").toString();
                               
                                if(stat.equals("Pending")){
                                    System.out.println("Account is Pending, Contact the Admin!");
                                    break;
                                }else{
                                    System.out.println("LOGIN SUCCESS!");
                                    
                                 if(type.equals("Citizen")){
                                      Citizen citizen = new Citizen();
                                        citizen.Citizen();
                                    
                                            break;
}
                                           
                                    }if(type.equals("President")){
                                        President president = new President();
                                            president.President();
                                            
                                            break;
                                            
                                    }if(type.equals("Secretary")){
                                        
                            }
                    }

        }
            break;
            
                case 2: //sign-up

                        System.out.println("Enter user name: ");
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
                            java.util.List<java.util.Map<String, Object>> result = conf.fetchRecords(qry, email);

                            if (result.isEmpty()) {
                                break;
                            } else {
                                System.out.print("Email already exists, Enter other Email: ");
                                email = sc.next();
                            }
                        }

                    System.out.print("Enter user Type (1 - Citizen/2 -President/ 3 -Secretary): ");
                    int type = sc.nextInt();
                        while(type > 3 || type < 1){
                            System.out.print("Invalid, choose between 1, 2, & 3 only: ");
                            type = sc.nextInt();
                        }
                    String tp = "";
                        if (type == 1){
                            tp = "Citizen";
                        }else if ( type ==2 ){
                            tp = "President";
                        }else if ( type == 3 ){
                            tp = "Secretary";    
                        
                        }
                        
                        System.out.println("Enter password: ");
                        pass = sc.next();
                        
                        String hashedPassword = conf.hashPassword(pass);
                        
                        String sql = "INSERT INTO tbl_users(u_name, u_age, u_address, u_contact, u_email, u_pass, u_status, u_type) VALUES (?, ?, ?, ?, ?, ?, ? ,?)";
                        conf.addRecord(sql, nm, age, adrs, contact, email, hashedPassword, "PENDING", tp);
                break;
       
                case 3:
                    
                    return;
   
                }
                System.out.println("Do you want to continue?(Y/N): ");
                 cont = sc.next().charAt(0);
                
        }while (cont == 'Y' || cont == 'y');
        System.out.println("THANK YOU FOR USING THE PRORAM!");
        
        } 

    }

