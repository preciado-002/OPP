/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.rolldices;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Personal
 */
public class Rolldices {
     public static int rolldices(){
        Random random = new Random();
        return random.nextInt(6) + 1;
     }

    public static void main(String[] args) {
         Scanner data = new Scanner(System.in);
        
        int lives = 5, dice1, dice2;
        String player_name;
        
        int totalLanzamientos = 0;
        int rachasIguales = 0;
        
        int totalPares = 0;
        int totalImpares = 0;
        int totalIguales = 0;
        
        System.out.println("::: WELCOME TO ROLL DICES :::");
        System.out.println("Your player name: ");
        player_name = data.nextLine();
        System.out.println("\n Press any key to start the game !!!");
        data.nextLine();
        
        while (lives > 0) {
            totalLanzamientos++;
            System.out.println("\n--- Lanzamiento" + totalLanzamientos + " ---");
            
            dice1 = rolldices();
            dice2 = rolldices();
            
            System.out.println("Player name: " + player_name);
            System.out.println("Dice 1: " + dice1);
            System.out.println("Dice 2: " + dice2);
            
            int suma = dice1 + dice2;
            
            if (dice1 == dice2) {
                totalIguales++;
                rachasIguales++;
                
                if (dice1 == 6) {
                    lives++;
                    System.out.println("¡Par de 6! Ganas una vida extra.");
                }
            } else {
                rachasIguales = 0;
            }
            
            if (suma % 2 != 0) {
                lives--;
                totalImpares++;
                System.out.println("La suma es impar. !Perdiste una vida!");
            } else {
                totalPares++;
                System.out.println("La suma es par. El juego continua.");
            }
            
            System.out.println("Player lives: " + lives);
            
            if (rachasIguales == 3) {
                System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("!!! YOU WIN !!! OBTUVISTE DADOS IGUALES 3 VECES SEGUIDAS");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                break;
            }
            
            if (lives > 0) {
                System.out.println("Presiona Enter para el siguiente lanzamiento...");
                data.nextLine();
            }
        }
        
        if (lives <= 0) {
            System.out.println("\n###################");
            System.out.println("#    GAME OVER    #");
            System.out.println("###################");
        }
        
        System.out.println("######## INFORME FINAL ########");
        System.out.println("Numero total de lanzamientos: " + totalLanzamientos);
        System.out.println("Total de tiros con suma par: " + totalPares);
        System.out.println("Total de tiros con suma impar: " + totalImpares);
        System.out.println("Total de tiros con dados iguales: " + totalIguales);
    }
}
