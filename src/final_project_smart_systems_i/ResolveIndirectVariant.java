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
        this.matrix = new char[n+1][n+1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                
                this.matrix[i][j] = stringToCharArray[z];
                z++;
            }
        }
        
        createArtificialRowColumn();
                
        return this.matrix;
    }
    
    
    private void createArtificialRowColumn(){
        
        for (int i = 0; i < this.matrix.length; i++) {            
                
                this.matrix[i][this.matrix.length-1] = 0;
                this.matrix[this.matrix.length-1][i] = 0;            
        }       
        
        
    }
    
        
    
    //Create rows constraints from matrix.
    public LinkedList<String> createRowsConstraints(){
        
        LinkedList<String> constrains = new LinkedList<>();
        
        //Init count and references constrains for each row.
        int contSequencesRow = 0;
        String constrainsByRows = "";
                
        for(int i = 0; i < this.matrix.length-1 ; i++) {
            
            contSequencesRow=0;
            constrainsByRows = "";
            
            //Row constraints 
            int j = 0;            
            for ( ;j < this.matrix.length-1; j++) {                
                
                if(this.matrix[i][j] == '1'){
                    
                    contSequencesRow++;                    
                                    
                    while(this.matrix[i][j+1] == '1' ){
                            
                            contSequencesRow++;
                            j++;                      

                    }
                    
                    constrainsByRows += contSequencesRow; 
                }
                
                contSequencesRow = 0;
                               
            }           
            
                            
        constrains.add(constrainsByRows+"\n");
        
        }       
        
        constrains.addFirst("Rows constrains"+"\n");
        return constrains;                
    }
    
    
    //Create rows constraints from matrix.
    public LinkedList<String> createColumnsConstraints(){
        
        LinkedList<String> constrains = new LinkedList<>();
        
        //Init count and references constrains for each row.
        int contSequencesColumn = 0;
        String constrainsByColumns = "";
                
        for(int i = 0; i < this.matrix.length-1; i++) {
            
            contSequencesColumn=0;
            constrainsByColumns = "";
            
            //Columns constraints 
            int j = 0;            
            for ( ;j < this.matrix.length-1; j++) {   
             
                
                if(this.matrix[j][i] == '1' ){
                    
                    contSequencesColumn++;                   
                    
                    while(this.matrix[j+1][i] == '1'){
                            
                            contSequencesColumn++;
                            j++;                      

                    }
                   
                    constrainsByColumns += contSequencesColumn; 
                }
                
                contSequencesColumn = 0;                               
            }
                            
        constrains.add(constrainsByColumns);
        
        }       
        
        constrains.addFirst("Columns constrains");
        return constrains;                
    }
}
