/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project_smart_systems_i;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author andres
 */
public class FileClass {

    private String outputRead;

    public FileClass() {

        this.outputRead = "";
    }

    public String getOutputRead() {
        return outputRead;
    }

    public String readFile(File file) {

        BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader(file);
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                this.outputRead += sCurrentLine + "\n";

            }

            br.close();
            fr.close();

        } catch (IOException e) {

            e.getMessage();

        }

        return this.outputRead;
    }

    public void writeFile(String message)  {

            try {
                String path = "/home/andres/Escritorio/resolvednonogram.txt";
                File file = new File(path);
                // Si el archivo no existe es creado
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(message);
                bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
