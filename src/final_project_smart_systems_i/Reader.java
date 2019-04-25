/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project_smart_systems_i;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanfvasquez
 */
public class Reader {
    
    public List<List<Integer>> rowConstraints;
    public List<List<Integer>> columnConstraints;
    public List<String> lines;
    public List<String> matrix;
    public int N;
    
    public Reader() {
        rowConstraints = new ArrayList<>();
        columnConstraints = new ArrayList<>();
        lines = new ArrayList<>();
        matrix = new ArrayList<>();
    }
    
    public List<String> readFile(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "";
            while((line = reader.readLine()) != null) {
                if (!line.trim().startsWith("#") && line.trim().length() > 0) {
                    lines.add(line.trim());
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return lines;
    }
    
    public void straightMode(String separator) {
        if (lines.size() % 2 != 0) {
            System.out.println("No coinciden numero de lineas!");
            return;
        }
        
        N = lines.size() / 2;
        
        for (int i = 0; i < N; i++) {
            String line = lines.get(i);
            String parts[] = line.split(separator);
            List<Integer> constraints = new ArrayList<>();
            for (int j = 0; j < parts.length; j++) {
                constraints.add(Integer.parseInt(parts[j]));
            }
            rowConstraints.add(constraints);
        }
        
        for (int i = N; i < lines.size(); i++) {
            String line = lines.get(i);
            String parts[] = line.split(separator);
            List<Integer> constraints = new ArrayList<>();
            for (int j = 0; j < parts.length; j++) {
                constraints.add(Integer.parseInt(parts[j]));
            }
            columnConstraints.add(constraints);
        }
    }
    
    public void reverseMode() {
        N = lines.size();
        for (int i = 0; i < N; i++) {
            matrix.add(lines.get(i));
        }
    }
}