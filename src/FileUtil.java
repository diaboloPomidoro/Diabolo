import TypeOfObjects.Company;
import TypeOfObjects.Enums;
import TypeOfObjects.Person;
import TypeOfObjects.Relation;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


/**
 * Created by Diabolo on 02.04.2017.
 */
public class FileUtil {
    public static List<List> readFilesToList(Path path) throws IOException {
        List<List> listOfAllEntitiesInFolder = new ArrayList<>();
        List<File> listOfFiles = getFilesFromFolder(path);

        for (File file : listOfFiles) {
            String pathFile = file.getPath();
            BufferedReader reader = new BufferedReader(new FileReader(pathFile));
            Enums.EntityType entityInThisFile = getProperLoad(pathFile);
            List<Object> list = new ArrayList<>();
            switch (entityInThisFile) {
                case PERSON:
                    listOfAllEntitiesInFolder.add(makeListOfPersons(reader, entityInThisFile));
                    break;
                case COMPANY:
                    try {
                        listOfAllEntitiesInFolder.add(makeListOfCompany(reader,entityInThisFile));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                case RELATION:
                    listOfAllEntitiesInFolder.add(makeListOfRelation(reader,entityInThisFile));
                    break;
                case MISTAKE:
                    break;
            }

        }
        return listOfAllEntitiesInFolder;
    }

    private static Enums.EntityType getProperLoad(String path) {
        for (Enums.EntityType e : Enums.EntityType.values()) {
            if (path.toUpperCase().contains(e.name())) {
                return e;
            }
        }
        return Enums.EntityType.MISTAKE;
    }

    private static List<File> getFilesFromFolder(Path path){
        File folder = new File(String.valueOf(path));
        File[] tableOfFiles = folder.listFiles();
        List<File> listOfFiles = new ArrayList<>();

        for (int i = 0; i< tableOfFiles.length;i++){
            listOfFiles.add(tableOfFiles[i]);
        }
        return listOfFiles;

    }

    public static boolean lineValidator (String textLine, Enums.EntityType typeOfEntity ){
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

    private static List<Person> makeListOfPersons (BufferedReader reader, Enums.EntityType typeOfEntity) throws IOException {
        List<Person> list = new ArrayList();
        String textLine = reader.readLine();
        while (FileUtil.lineValidator(textLine,typeOfEntity)){
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

    private static List<Company> makeListOfCompany (BufferedReader reader, Enums.EntityType typeOfEntity) throws IOException, ParseException {
        List<Company> list = new ArrayList();
        String textLine = reader.readLine();
        while (FileUtil.lineValidator(textLine,typeOfEntity)){
            Company company = new Company();
            StringTokenizer tokens = new StringTokenizer(textLine,typeOfEntity.getDELIMITER());

            company.setId(tokens.nextToken());
            company.setName(tokens.nextToken());
            company.setCapital(tokens.nextToken());
            company.setDateOfCreation(tokens.nextToken());

            list.add(company);
            textLine = reader.readLine();
        }
        return list;
    }

    private static List<Relation> makeListOfRelation (BufferedReader reader, Enums.EntityType typeOfEntity) throws IOException {
        List<Relation> list = new ArrayList();
        String textLine = reader.readLine();
        while (FileUtil.lineValidator(textLine,typeOfEntity)){
            Relation relation = new Relation();
            StringTokenizer tokens = new StringTokenizer(textLine,typeOfEntity.getDELIMITER());

            relation.setId(tokens.nextToken());
            relation.setIdPerson(tokens.nextToken());
            relation.setIdCompany(tokens.nextToken());
            relation.setNodeId(tokens.nextToken());

            list.add(relation);
            textLine = reader.readLine();
        }
        return list;
    }

}
