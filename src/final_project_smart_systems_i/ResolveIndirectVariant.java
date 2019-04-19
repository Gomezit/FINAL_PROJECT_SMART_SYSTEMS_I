/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project_smart_systems_i;

import java.util.LinkedList;

/**
 *
 * @author andres
 */
public class ResolveIndirectVariant {

    private char[][] matrix;

    public ResolveIndirectVariant() {
    }

    //Create matrix from text.
    public char[][] createMatrixIndirectVariant(String text) {

        char[] stringToCharArray = text.toCharArray();
        int n = (int) Math.sqrt(stringToCharArray.length);
        int z = 0;
        this.matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                this.matrix[i][j] = stringToCharArray[z];
                z++;
            }
        }
        
        return this.matrix;
    }
    
    
    //Create rows and columns constraints from matrix.
    public LinkedList<String> createConstraints(){
        
        LinkedList<String> constrains = new LinkedList<>();
        
        //Init count and references constrains for each row and colum.
        int contSequencesRow = 0;
        int contSequencesColumn = 0;
        String constrainsByRows = "Rows constrains ";
        String constrainsByColumns = "Columns constrains ";

        
                
        for(int i = 0; i < this.matrix.length; i++) {
            
            contSequencesRow=0;
            contSequencesColumn=0;
            constrainsByRows = "Rows constrains ";
            constrainsByColumns = "Columns constrains ";
            boolean flagColumnSequence = false;
            boolean flagRowSequence = false;
            
            int j = 0;            
            for ( ;j < this.matrix.length; j++) {                
                
                if(this.matrix[i][j] == '1'){
                    
                    contSequencesRow++;
                    
                    //Row constraints                 
                    while(this.matrix[i][j+1] == '1'){
                            
                            contSequencesRow++;
                            j++;                      

                    }
                    
                    constrainsByRows += contSequencesRow; 
                }
                contSequencesRow = 0;
                               
            }
            
                            
        constrains.add(constrainsByRows+"\n");
        constrains.add(constrainsByColumns+"\n");  
        
        }       
        
        System.out.println(constrains);
        
        return constrains;                
    }
}
