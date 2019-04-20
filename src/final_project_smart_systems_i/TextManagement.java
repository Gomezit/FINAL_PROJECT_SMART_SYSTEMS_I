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
public class TextManagement {

    public TextManagement() {
    }

    public String clearTextIndirectVariant(String text) {

        String normalized = text.trim();
        String replace = normalized.replace("#", "");
        String replaceAll = replace.replaceAll("\\s", "");

        return replaceAll;
    }

    public String clearTextDirectVariant(String text) {

        String[] constrains = text.split("\n");
        String constrainsCleanedString = "";

        for (String constrain : constrains) {

            if (!constrain.contains("#") && !constrain.trim().isEmpty()) {

                constrainsCleanedString += constrain+"\n";
                
            }
        }

        return constrainsCleanedString;

    }

}
