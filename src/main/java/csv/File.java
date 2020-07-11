package csv;

import au.com.bytecode.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class File {

    public java.io.File CreateFile(String filename){
        java.io.File myFile = new java.io.File(filename);
        if(myFile.exists()){
            if(myFile.delete()){
                try {
                        myFile.createNewFile();
                        System.out.println("The file was created");

                } catch (IOException e) {
                    System.out.println("There was an error while file is creating");
                }
            }
        } else {
            try {
                myFile.createNewFile();
                System.out.println("New file was created");

            } catch (IOException e) {
                System.out.println("There was an error while file is creating");
            }
        } return myFile;
    }
    public void Save(List<String> information,String csvFile){

        CSVWriter writer = null;
        try {
                writer = new CSVWriter(new FileWriter(csvFile,true));
            }
        catch (IOException e) {
            System.out.println("File is blocked");
            return;
        }
        String[] out = information.toArray(new String[information.size()]);
        System.out.println("Writing info ... Please wait...");
        writer.writeNext(out);
        try {
            writer.close();
        } catch (IOException ignored) {
        }

    }
}
