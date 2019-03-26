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
    
    private LinkedList<String> createConstraints(){
        
        
        
        
        return null;
    }
    
    
    

}
