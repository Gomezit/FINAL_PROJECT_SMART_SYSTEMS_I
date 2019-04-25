/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project_smart_systems_i;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanfvasquez
 */
public class SolveRow {
    
    String row;
    List<String> solutions;
    List<Integer> constraints;
    int N;
    int rowIndex;
    
    public SolveRow(int rowIndex, int N, List<Integer> constraints) {
        this.rowIndex = rowIndex;
        this.N = N;
        this.row = "";
        for (int i = 0; i < N; i++) {
            row += "O";
        }
        this.constraints = constraints;
        solutions = new ArrayList<>();
    }
    
    public List<String> solveRow() {
        place(0, 0, row);
        return solutions;
    } 
    
    private void place(int constraint, int begin, String row) {
        int num = constraints.get(constraint);
        int[] data = getLeftAndVoids(constraint);
        int left = data[0];
        int voids = data[1];
        
        for (int i = begin; i < N; i++) {
            if (i + voids + left > N) {
                continue;
            }
            
            String newRow = String.valueOf(row.toCharArray());
            
            for (int j = 0; j < num; j++) {
                char[] arr = newRow.toCharArray();
                arr[i + j] = 'X';
                newRow = String.valueOf(arr);
            }
            
            if (constraint < constraints.size() - 1) {
                place(constraint + 1, i + num + 1, newRow);
            } else {
                solutions.add(newRow);
            }
        }
    }
    
    private int[] getLeftAndVoids(int constraint) {
        int left = 0;
        int voids = -1;
        for (int i = constraint; i < constraints.size(); i++) {
            left += constraints.get(i);
            voids++;
        }
        return new int[]{left, voids};
    }
    
}