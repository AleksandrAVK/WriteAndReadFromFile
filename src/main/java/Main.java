import Controller.CreateAndWriteFile;
import Controller.ReadFile;

public class Main {
    public static void main(String[] args) {
        CreateAndWriteFile createNewFiles = new CreateAndWriteFile();
        ReadFile readFile =new ReadFile();
        createNewFiles.CreateFile();

        readFile.print();
    }
}
