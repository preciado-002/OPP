/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arraydata;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Personal
 */
public class Arraydata {

      public static void mainMenu(){ 
        System.out.println("::: MENU ::: \n"
                + "[1]. Crear/Registar Usuario \n"
                + "[2]. Lista de usuarios \n"
                + "[3]. Buscar Usuario \n"
                + "[4]. Actualizar Usuario \n"
                + "[5]. Elimiar Usuario \n"
                + "[6]. Salir \n"
                + ".::: Presione una Opcion : ");
    }
      
          public static void main(String[] args) {
        Scanner data=new Scanner(System.in);
   
        ArrayList<String> identNumbers = new ArrayList<>();
        ArrayList<String> firstNames = new ArrayList<>();
        ArrayList<String> lastNames = new ArrayList<>();
        ArrayList<String> emails = new ArrayList<>();
        ArrayList<Integer> ages = new ArrayList<>();
        String firstname, lastname, email, key, ident_number;
        int age, opt;
        boolean menu_status = true;
        
        int i=1;
        while(menu_status){
            mainMenu();
            opt=data.nextInt();
            data.nextLine();
            
            switch (opt){
                case 1:
                    System.out.println("::: REGISTER NEW USER :::");
                    System.out.println("\nUser Nro.: " + (firstNames.size()+1));   
            
                    while (true) {
                        System.out.println("Identification number: ");   
                        ident_number = data.nextLine();
                        if (identNumbers.contains(ident_number)) {
                            System.out.println("Error: El numero de identificacion ya existe. Intente de nuevo.");
                        } else {
                            break;
                        }
                    }

                    System.out.println("First name: ");   
                    firstname=data.nextLine();
                    System.out.println("Last name: ");   
                    lastname=data.nextLine();

                    while (true) {
                        System.out.println("Email: ");   
                        email=data.nextLine();
                        if (emails.contains(email)) {
                            System.out.println("Error: El correo electronico ya esta registrado. Intente de nuevo.");
                        } else {
                            break;
                        }
                    }

                    System.out.println("Age: ");   
                    age=data.nextInt();
                    data.nextLine();

                    identNumbers.add(ident_number);
                    firstNames.add(firstname);
                    lastNames.add(lastname);
                    emails.add(email);
                    ages.add(age);
                    System.out.println("\nUser has been registered successfully !!!");
                    System.out.println("\nPress any key to back to main menu.");
                    key=data.nextLine();
                    break;
                case 2:
                    
                    System.out.println("Total users: " + firstNames.size());
                    if (firstNames.size() == 0){
                        System.out.println("No users !!!");
                    }else{
                        for(int  j = 0; j < firstNames.size(); j+=1){
                            System.out.println("User " + (j+1) + ": " 
                                    + identNumbers.get(j) + " | " 
                                    + firstNames.get(j) + " | " 
                                    + lastNames.get(j) + " | " 
                                    + emails.get(j) + " | " 
                                    + ages.get(j));
                        }
                    }
                    System.out.println("\nPress any key to back to main menu.");
                    key=data.nextLine();
                    break;
                case 3:
                    System.out.println("::: SEARCH USER :::");
                    System.out.println("Enter identification number to search: ");
                    String searchIdent = data.nextLine();
                    
                    int searchIndex = identNumbers.indexOf(searchIdent);
                    
                    if (searchIndex != -1) {
                        System.out.println("\nUser Found:");
                        System.out.println("ID: " + identNumbers.get(searchIndex));
                        System.out.println("First Name: " + firstNames.get(searchIndex));
                        System.out.println("Last Name: " + lastNames.get(searchIndex));
                        System.out.println("Email: " + emails.get(searchIndex));
                        System.out.println("Age: " + ages.get(searchIndex));
                    } else {
                        System.out.println("User not found.");
                    }
                    
                    System.out.println("\nPress any key to back to main menu.");
                    key=data.nextLine();
                    break;
                case 4:
                    System.out.println("::: UPDATE USER :::");
                    System.out.println("Enter identification number to update: ");
                    String updateIdent = data.nextLine();
                    
                    int updateIndex = identNumbers.indexOf(updateIdent);
                    
                    if (updateIndex != -1) {
                        System.out.println("\nUser found. Enter new data:");
                        
                        System.out.println("New First name: ");   
                        firstNames.set(updateIndex, data.nextLine());
                        
                        System.out.println("New Last name: ");   
                        lastNames.set(updateIndex, data.nextLine());
                        
                        while (true) {
                            System.out.println("New Email: ");   
                            String newEmail = data.nextLine();
                            int emailIndex = emails.indexOf(newEmail);
                            
                            if (emailIndex == -1 || emailIndex == updateIndex) {
                                emails.set(updateIndex, newEmail);
                                break;
                            } else {
                                System.out.println("Error: El correo ya pertenece a otro usuario. Intente de nuevo.");
                            }
                        }
                        
                        System.out.println("New Age: ");   
                        ages.set(updateIndex, data.nextInt());
                        data.nextLine(); 
                        
                        System.out.println("\nUser updated successfully !!!");
                    } else {
                        System.out.println("User not found.");
                    }
                    
                    System.out.println("\nPress any key to back to main menu.");
                    key=data.nextLine();
                    break;
                case 5:
                    System.out.println("::: DELETE USER :::");
                    System.out.println("Enter identification number to delete: ");
                    String deleteIdent = data.nextLine();
                    
                    int deleteIndex = identNumbers.indexOf(deleteIdent);
                    
                    if (deleteIndex != -1) {
                        identNumbers.remove(deleteIndex);
                        firstNames.remove(deleteIndex);
                        lastNames.remove(deleteIndex);
                        emails.remove(deleteIndex);
                        ages.remove(deleteIndex);
                        System.out.println("\nUser deleted successfully !!!");
                    } else {
                        System.out.println("User not found.");
                    }
                    
                    System.out.println("\nPress any key to back to main menu.");
                    key=data.nextLine();
                    break;
                case 6:
                    System.out.println("Bye, bye");
                    menu_status = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
    }
}
 
    