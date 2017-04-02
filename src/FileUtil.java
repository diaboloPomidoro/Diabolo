import TypeOfObjects.Enums;
import TypeOfObjects.Person;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


/**
 * Created by Diabolo on 02.04.2017.
 */
public class FileUtil {
    public static List<Object> readFileToList(String path, Enums.EntityType entityType) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        Enums.EntityType entityInThisFile = entityType;

        List<Object> list = new ArrayList();
        switch(entityInThisFile){
            case PERSON:
                list = makeListOfPerson(reader,entityType);
                break;
            case COMPANY:
                break;
            case RELATION:
                break;
        }
        return list;
    }

    private static List<Object> makeListOfPerson (BufferedReader reader, Enums.EntityType typeOfEntity) throws IOException {
        List<Object> list = new ArrayList();
        String textLine = reader.readLine();
        while (lineValidator(textLine,typeOfEntity)){
            Person person = new Person();
            StringTokenizer tokens = new StringTokenizer(textLine,typeOfEntity.getDELIMITER());

            person.setId(tokens.nextToken());
            person.setFirstName(tokens.nextToken());
            person.setName(tokens.nextToken());
            person.setSex(tokens.nextToken());
            person.setEducation(tokens.nextToken());

            list.add(person);
            textLine = reader.readLine();
        }
        return list;
    }

    private static boolean lineValidator (String textLine,Enums.EntityType typeOfEntity ){
        if(textLine == null){
            return false;
        }

        int requiredQuantityOfColumns = typeOfEntity.getCOLLUMNS_QUANTITY();
        String delimiter = typeOfEntity.getDELIMITER();
        int quantityOfColumns = new StringTokenizer(textLine,delimiter).countTokens();

        if (requiredQuantityOfColumns == quantityOfColumns){
            return true;
        }else
            return false;

    }
}
