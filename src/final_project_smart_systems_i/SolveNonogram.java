/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project_smart_systems_i;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author juanfvasquez
 */
public class SolveNonogram {
    
    List<List<Integer>> rowConstraints;
    List<List<Integer>> columnConstraints;
    Map<Integer, List<String>> map;
    int N;
    List<List<String>> solutions;
    int[] solution;
    
    public SolveNonogram(int N, List<List<Integer>> columnConstraints, List<List<Integer>> rowConstraints) {
        this.N = N;
        this.columnConstraints = columnConstraints;
        this.rowConstraints = rowConstraints;
        this.solutions = new ArrayList<>();
        map = new HashMap<>();
        getSolutionsMap();
        solution = new int[N];
        check(0);
    }
    
    private void getSolutionsMap() {
        for (int i = 0; i < N; i++) {
            SolveRow sr = new SolveRow(i, N, rowConstraints.get(i));
            map.put(i, sr.solveRow());
        }
    }
    
    private void check(int index) {
        for (int i = 0; i < map.get(index).size(); i++) {
            solution[index] = i;
            if (checkConstraints(index)) {
                if (index == N - 1) {
                    addSolution();
                } else {
                    check(index + 1);
                }
            }
        }
    }
    
    private void addSolution() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(map.get(i).get(solution[i]));
        }
        solutions.add(list);
    }
    
    private boolean checkConstraints(int index) {
        for (int i = 0; i < N; i++) {
            int currentConstraintIndex = 0;
            int currentConstraint = columnConstraints.get(i).get(currentConstraintIndex);
            int fullCells = 0;
            for (int j = 0; j <= index; j++) {
                String row = map.get(j).get(solution[j]);
                if (row.charAt(i) == 'X') {
                    fullCells++;
                    if (fullCells > currentConstraint) {
                        return false;
                    }
                } else {
                    if (fullCells > 0) {
                        currentConstraintIndex++;
                        if (currentConstraintIndex < columnConstraints.get(i).size()) {
                            currentConstraint = columnConstraints.get(i).get(currentConstraintIndex);
                        } else {
                            currentConstraint = 0;
                        }
                        fullCells = 0;
                    }
                }
            }
        }
        return true;
    }
    
}