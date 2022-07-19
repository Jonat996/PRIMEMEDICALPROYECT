/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sia;

import java.util.ArrayList;

/**
 *
 * @author jonathan
 */
public class sia {
    static int abc(int[] input){
        int cont=0;
        int product = 0;
        int largest = Integer.MIN_VALUE;
        while(cont < input.length-1){
            product = input[cont]*input[cont+1];
            cont++;
            if(product > largest){
                largest= product;
            }
        }
        System.out.println(largest);
        return largest;
        
        
    }
        //abc([3, 6, -2, -5, 7, 3]);
public static void main (String [] args){
    ArrayList hola = new ArrayList();
     
int holas[]={3, 6, -2, -5, 7, 3};
        abc(holas);
} 
        
}

