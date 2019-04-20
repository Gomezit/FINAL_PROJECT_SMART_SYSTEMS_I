/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project_smart_systems_i;

import java.util.ArrayList;

/**
 *
 * @author andres
 */
public class ResolveDirectVariant {
    
    private char[][] matrix;
    private ArrayList<String> rowConstraints;
    private ArrayList<String> columnsConstraints;

    public ResolveDirectVariant() {
        
        this.rowConstraints =  new ArrayList<>();
        this.columnsConstraints =  new ArrayList<>();

    }
    
     //Create matrix from text.
    public char[][] createMatrixDirectVariant(String text) {
        
        String[] constrains = text.split("\n");   
                      
        //char[] stringToCharArray = text.toCharArray();
        int n = (int) (constrains.length/2);
               
        //Create empty matrix when will the solution.
        this.matrix = new char[n][n];

        for (int i = 0; i < n; i++) {    
                        
            for (int j = 0; j < n; j++) {
                
                this.matrix[i][j] = '0';
                                
            }
        }
        
        divideColumnsAndRowsConstraints(constrains);
        
        return this.matrix;
    }

    private void divideColumnsAndRowsConstraints(String[] constrains) {
        
        //Divide in columns and rows constraints.
        for (int i = 0; i < constrains.length; i++) {    
            
            boolean add = i < (constrains.length/2) ? this.rowConstraints.add(constrains[i]+"\n") : this.columnsConstraints.add(constrains[i]+"\n");
            
        }      
        
        System.out.println("row constraints" +  this.rowConstraints);
        System.out.println("columns constraints" +  this.columnsConstraints);
    }


}
