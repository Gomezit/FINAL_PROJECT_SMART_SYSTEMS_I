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
public class Matrix {

    private char[][] matrix;

    public Matrix() {

    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

    public void createMatrixIndirectVariant(String text) {

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

    public void createMatrixDirectVariant(ArrayList<String> clearConstrains) {
    }
}
