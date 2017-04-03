import TypeOfObjects.Enums;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Path rootPath = Paths.get("B:\\j\\B2B\\Companies\\");
        try {
            List<List> list = FileUtil.readFilesToList(rootPath);
            for (Object o : list){
                System.out.println(o.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
