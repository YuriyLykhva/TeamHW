package core;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream file = null;
        try {
            file = new FileInputStream("src/main/resources/students.json");
        } catch (Exception e) {
            System.out.println("File not found");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

        TypeFactory typeFactory = TypeFactory.defaultInstance();
        List<StudentsDTO> students = objectMapper.readValue(file,
                typeFactory.constructCollectionType(ArrayList.class, StudentsDTO.class));

        Collections.sort(students, new SortByName());

        students.forEach(System.out::println);

    }

    public static class SortByName implements Comparator<StudentsDTO> {
        @Override
        public int compare(StudentsDTO a, StudentsDTO b) {
            return a.getLastName().compareTo(b.getLastName());
        }
    }

}
