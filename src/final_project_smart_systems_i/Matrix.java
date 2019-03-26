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

    public Matrix() {
    }

    public String showMatrix(char[][] matrix) {

        String stringMatrix = "";
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                stringMatrix += matrix[i][j] + " ";
            }

            stringMatrix += "\n";
        }

        return stringMatrix;
    }

}
