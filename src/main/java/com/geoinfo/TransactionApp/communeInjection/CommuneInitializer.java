package com.geoinfo.TransactionApp.communeInjection;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
public class CommuneInitializer {

    public void importShapefileToPostgreSQL() {
        // Replace with the actual path to your SHP file
        String shpFilePath = "C:\\Users\\PC\\Desktop\\Communes\\Communes.shp";

        // Replace with the actual table name in your database
        String tableName = "commune";

        // Replace <SRID> with the appropriate Spatial Reference Identifier (SRID)
        int srid = 4326; // Example SRID for WGS 84

        String shp2pgsqlPath = "C:\\Program Files\\PostgreSQL\\15\\bin\\shp2pgsql"; // Mettez le chemin absolu correct
        String command = shp2pgsqlPath + " -I -s " + srid + " " + shpFilePath + " " + tableName + " | psql -d transaction";


        try {
            Process process = Runtime.getRuntime().exec(command);

            // Récupérer la sortie de la commande
            InputStream inputStream = process.getInputStream();
            InputStream errorStream = process.getErrorStream();
            InputStreamReader inputReader = new InputStreamReader(inputStream);
            InputStreamReader errorReader = new InputStreamReader(errorStream);
            BufferedReader inputBufferedReader = new BufferedReader(inputReader);
            BufferedReader errorBufferedReader = new BufferedReader(errorReader);

            // Lire la sortie de la commande et l'afficher
            String line;
            while ((line = inputBufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            while ((line = errorBufferedReader.readLine()) != null) {
                System.err.println(line);
            }

            // Attendre la fin de l'exécution de la commande
            int exitValue = process.waitFor();

            // Gérer le succès/échec du processus d'importation
            if (exitValue == 0) {
                System.out.println("Shapefile imported successfully!");
            } else {
                System.err.println("Failed to import the Shapefile.");
            }
        } catch (IOException | InterruptedException e) {
            // Gérer les exceptions
            e.printStackTrace();
        }

    }
}
