import TypeOfObjects.Enums;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String path = "B:\\j\\B2B\\Companies\\people.csv";
        try {
            FileUtil.readFileToList(path, Enums.EntityType.PERSON);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
