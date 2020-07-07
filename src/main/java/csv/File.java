package csv;

import au.com.bytecode.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class File {
    public void Save(List<String> information) throws IOException {
        String csv = "C://data.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(csv));
        //Create record
        String[] record = new String[information.size()];
        for (int i = 0; i<information.size(); i++) {
            record[i] = "link №"+i+" : "+information.get(i);
        }
        //Write the record to file
        writer.writeNext(record);
        //close the writer
        writer.close();
    }
}
