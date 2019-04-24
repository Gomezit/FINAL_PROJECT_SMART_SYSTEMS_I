/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project_smart_systems_i;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author andres
 */
public class ResolveDirectVariant {
    
    private char[][] matrix;
    private ArrayList<String> rowsConstraints;
    private ArrayList<String> columnsConstraints;

    public ResolveDirectVariant() {
        
        this.rowsConstraints =  new ArrayList<>();
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
                
                this.matrix[i][j] = ' ';
                                
            }
        }
        
        divideColumnsAndRowsConstraints(constrains);
        
        return this.matrix;
    }
    
    private char[] getArrayFromRowColumn(int indexColumnORrow, char ColumnORrow ){
        
                
        int n = this.matrix.length;
        char[] segment = new char[n];
        
        if(ColumnORrow == 'C'){
            for (int i = 0; i < n; i++) {
                           
                segment[i] = this.matrix[i][indexColumnORrow]; 
            }
        }
        
        if(ColumnORrow == 'R'){
            for (int i = 0; i < n; i++) {
                segment[i] = this.matrix[indexColumnORrow][i]; 
            }
        }
        
        return segment;
    }

    private void divideColumnsAndRowsConstraints(String[] constrains) {
        
        //Divide in columns and rows constraints.
        for (int i = 0; i < constrains.length; i++) {    
            
            boolean add = i < (constrains.length/2) ? this.rowsConstraints.add(constrains[i]) : this.columnsConstraints.add(constrains[i]);
            
        }      
        
        System.out.println("row constraints" +  this.rowsConstraints);
        System.out.println("columns constraints" +  this.columnsConstraints);
    }
    
    
    public String showMatrix() {

        String stringMatrix = "";
        int n = this.matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                stringMatrix += this.matrix[i][j] + " ";
            }

            stringMatrix += "\n";
        }

        return stringMatrix;
    }
    
      
    public boolean resolveNonogram(){
        
        preProcessing();        
        
         //   System.out.println( getArrayFromRowColumn(2, 'C')[i]);
        
        
        return false;        
    }
    
    //The initial solution that determine complete fill, complete fills with white spaces defined and parcial fill. 
    private void preProcessing(){     
        
        completeFills();   
        completefillsWhiteSpacesDefined();
        //completePartialsFills();
        
    }
    
    //Complete partials fills
    private void completePartialsFills(){
        
        int L;
                        
        for (int i = 0; i < this.matrix.length; i++) {
            
            if(this.rowsConstraints.get(i).length() == 1 && !this.rowsConstraints.get(i).equalsIgnoreCase(".")){
                
                L = this.matrix.length - (Integer.parseInt(this.rowsConstraints.get(i)) + (this.rowsConstraints.get(i).length()-1));
            
                int NiLessL = Integer.parseInt(this.rowsConstraints.get(i)) - L; 
                
                if(NiLessL > 0){
                    
                    System.out.println("L " + i);
                    
                    
                }
            
            }
            
        }
    }
    
    //Complete fill with white spaces defined
    private void completefillsWhiteSpacesDefined(){
        
        String[] rowConstraints;
        String[] columnConstraints;
        
        for (int i = 0; i < this.matrix.length; i++) {
            
        
            if(this.rowsConstraints.get(i).length() > 1){
                
                rowConstraints = this.rowsConstraints.get(i).split("-");
                
                if(checkSumatoryConstrains(rowConstraints)){    
                    
                    int j = 0;
                    int z = 0;
                                    
                    
                    for (int k = 0; k < rowConstraints.length; k++) {
                        
                        int actualConstraint = Integer.parseInt(rowConstraints[z]);    
                        
                        while(actualConstraint > 0){
                        
                            this.matrix[i][j] = '1';                        
                            j++;                        
                            actualConstraint--;

                            if(actualConstraint == 0 && j < this.matrix.length && this.matrix[i][j] == ' ' ){

                                this.matrix[i][j] = 'x';                         

                            }                        
                        }    
                        z++;
                        j++;
                    }                    
                }                              
            }
            
            if(this.columnsConstraints.get(i).length() > 1){
                
                columnConstraints = this.columnsConstraints.get(i).split("-");
                
                if(checkSumatoryConstrains(columnConstraints)){    
                    
                    int j = 0;
                    int z = 0;
                                    
                    
                    for (int k = 0; k < columnConstraints.length; k++) {
                        
                        int actualConstraint = Integer.parseInt(columnConstraints[z]);    
                        
                        while(actualConstraint > 0){
                        
                            this.matrix[j][i] = '1';                        
                            j++;                        
                            actualConstraint--;

                            if(actualConstraint == 0  && j < this.matrix.length && this.matrix[j][i] == ' '){

                                this.matrix[j][i] = 'x';                    
                                 
                            }
                        }
                        z++;
                        j++;
                    }                    
                }                              
            }
        }    
    }
    
    private boolean checkSumatoryConstrains(String[] constraints){
        
        int sum = 0;
        
        for (int i = 0; i < constraints.length; i++) {
            
            sum += Integer.parseInt(constraints[i]);
            
        }
               
        
        if(sum + (constraints.length-1) == this.matrix.length){
            
            return true;
        }
        
        return false;
    }
    
    
    //Determine complete fill with white spaces and fill spaces.
    private void completeFills(){
        
        for (int i = 0; i < this.matrix.length; i++) {
            
            
            if(this.rowsConstraints.get(i).length() == 1 && this.rowsConstraints.get(i).equalsIgnoreCase(".")){
                
                 System.out.println("Row constraint contain a dot(.) at" + i);
                    for (int j = 0; j < this.matrix.length; j++) {
                        
                        if(this.matrix[i][j] == ' '){
                            this.matrix[i][j] = 'x';
                        }                        
                    }
            }
            
            if(this.columnsConstraints.get(i).length() == 1 && this.columnsConstraints.get(i).equalsIgnoreCase(".")){
                
                 System.out.println("Columns constraint contain a dot(.) at" + i);
                    for (int j = 0; j < this.matrix.length; j++) {
                         if(this.matrix[j][i] == ' '){
                            this.matrix[j][i] = 'x';
                        }
                    }
            }
            
            
            if(this.rowsConstraints.get(i).length() == 1 && !this.rowsConstraints.get(i).equalsIgnoreCase(".")){
                
                if(Integer.parseInt(this.rowsConstraints.get(i)) == this.matrix.length){
                    System.out.println("Row constraint equal to length matrix at " + i);
                    
                    for (int j = 0; j < this.matrix.length; j++) {
                         if(this.matrix[i][j] == ' '){
                            this.matrix[i][j] = '1';
                        }
                    }                   
                }              
            }
            
            if(this.columnsConstraints.get(i).length() == 1 && !this.columnsConstraints.get(i).equalsIgnoreCase(".")){
                
                if(Integer.parseInt(this.columnsConstraints.get(i)) == this.matrix.length){
                    System.out.println("Column constraint equal to length matrix at " + i);
                    for (int j = 0; j < this.matrix.length; j++) {
                        if(this.matrix[j][i] == ' '){
                            this.matrix[j][i] = '1';
                        }
                    }
                }
            }            
        }
    }
}
