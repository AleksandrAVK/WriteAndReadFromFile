package Controller;

import Model.DataForFile;
import lombok.Data;

import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;

@Data
public class CreateAndWriteFile {
    public static String PATH_TO_FILE = "src/main/java/FilesPack/fileWithName.txt";
    DataForFile dataForFile = new DataForFile();
    public void CreateFile(){
        try {
            Files.write(Paths.get(PATH_TO_FILE),dataForFile.getDataForFiles()
//                    ,
//        StandardCharsets.UTF_8,
//        StandardOpenOption.CREATE,
//        StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
