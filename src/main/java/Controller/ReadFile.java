package Controller;

import Model.PreparedData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ReadFile {

    List<PreparedData> classCollection = new ArrayList<>();
    List<String> lines = new ArrayList();

    public List readFiles(){

        try {
            lines = Files.readAllLines(Paths.get(CreateAndWriteFile.PATH_TO_FILE), UTF_8);

            Path fileWithName = Paths.get(CreateAndWriteFile.PATH_TO_FILE);
            Path fileName = fileWithName.getFileName();

            for (int i = 0; i < lines.size(); i++) {
                    PreparedData preparedData  = new PreparedData();

                    String row = lines.get(i);
                    String[] rowArray = row.split(" ");
                if(rowArray.length > 3 || rowArray.length < 3) {
                throw new IOException("Не верный формат данных. Необходимо иметь три слова(ФИО) в строке");
                }
                    preparedData.setSurname(rowArray[0]);
                    preparedData.setFirstName(rowArray[1]);
                    preparedData.setSecondName(rowArray[2]);
                    preparedData.setId(String.valueOf(i));
                    preparedData.setNameFile(String.valueOf(fileName));
                    classCollection.add(preparedData);
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classCollection;
    }

    public void print()
    {
        readFiles();
        for (int i = 0; i < classCollection.size(); i++) {
            PreparedData classWithRow = (PreparedData) classCollection.get(i);

            String firstName =   classWithRow.getFirstName();
            String secondName =  classWithRow.getSecondName();
            String surname =  classWithRow.getSurname();
            String id =  classWithRow.getId();
            String fileName =  classWithRow.getNameFile();

            System.out.println("firstName: " + firstName +
                    "; secondName: " + secondName + "; surname: " + surname + "; id: " + id +
                    "; fileName: " + fileName );
        }
    }

}
