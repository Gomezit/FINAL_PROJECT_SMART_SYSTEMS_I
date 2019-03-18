/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project_smart_systems_i;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

    public String clearText() {

        String normalized = this.outputRead.trim();
        String replace = normalized.replace("#", "");
        String replaceAll = replace.replaceAll("\\s", "");

        this.outputRead = replaceAll;

        return this.outputRead;
    }

}
