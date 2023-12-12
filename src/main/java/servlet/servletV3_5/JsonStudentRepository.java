package servlet.servletV3_5;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import student.Student;
import student.StudentRepository;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class JsonStudentRepository implements StudentRepository {
    private final ObjectMapper objectMapper;
    //json file 저장 경로
    private static final String JSON_FILE_PATH = "/Users/nyeong/Desktop/servlet-study/exercise/src/main/java/student/student.json";

    public JsonStudentRepository() {
        objectMapper = new ObjectMapper();
        //LocalDatetime json 직열화/역직렬화 가능하도록 설정
        objectMapper.registerModule(new JavaTimeModule());
        //TODO: JSON_FILE_PATH 경로에 json 파일이 존재하면 삭제 합니다.
        File file = new File(JSON_FILE_PATH);

        if (file.exists()) {
            file.delete();
//            if (file.delete()) {
//                log.info("The existing file is deleted.");
//            } else {
//                log.error("failed to delete the existing file.");
//            }
        }
    }

//    private void deleteFile(Path path) {
//        try {
//            Files.delete(path);
//        } catch (IOException e) {
//            log.error("Error occurs during file deletion");
//        }
//    }

    private synchronized List<Student> readJsonFile() {
//        if (!Files.exists(Paths.get(JSON_FILE_PATH))) {
//            return new ArrayList<>();
//        }
        //TODO: json 파일이 존재하지 않다면 비어있는 List<Student> 리턴
        File file = new File(JSON_FILE_PATH);
        if (!file.exists()) {
            return new ArrayList<Student>();
        }

        //json read & 역직렬화 ( json string -> Object )
        try (FileInputStream fileInputStream = new FileInputStream(file);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ) {
            return objectMapper.readValue(bufferedReader, new TypeReference<List<Student>>() {
            });
//            List<Student> students = objectMapper.readValue(bufferedReader, new TypeReference<List<Student>>() {
//            });
//            return students;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private synchronized void writeJsonFile(List<Student> studentList) {
        // List<Student> 객체를 -> json 파일로 저장 : 직렬화
        File file = new File(JSON_FILE_PATH);

        try (
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ) {
            objectMapper.writeValue(bufferedWriter, studentList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void save(Student student) {
        //json String -> Object 형태로 변화 (직렬화)
        System.err.println("This is read");
        List<Student> students = readJsonFile();
        System.err.println("This is after read");
        //List에 student 추가
        students.add(student);
        //List<Student>객체를 -> json String 형태로 저장(직렬화)
        writeJsonFile(students);
    }

    @Override
    public void update(Student student) {
        //json String -> Object 형태로 변화 (직렬화)
        List<Student> students = readJsonFile();
        for (Student s : students) {
            if (s.getId().equals(student.getId())) {
                students.set(students.indexOf(s), student);
            }
        }

        //List<Student>객체를 -> json String 형태로 저장(직렬화)
        writeJsonFile(students);
    }

    @Override
    public void deleteById(String id) {
        //json String -> Object 형태로 변화 (직렬화)
        List<Student> students = readJsonFile();
        for (Student s : students) {
            if (s.getId().equals(id)) {
                students.remove(s);
            }
        }

        //List<Student>객체를 -> json String 형태로 저장(직렬화)
        writeJsonFile(students);
    }

    @Override
    public Student getStudentById(String id) {
        //json String -> Object 형태로 변화 (직렬화)
        List<Student> students = readJsonFile();
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return s;
            }
        }

        return null;
    }

    @Override
    public List<Student> getStudents() {
        return readJsonFile();
    }

    @Override
    public boolean existById(String id) {
        //json String -> Object 형태로 변화 (직렬화)
        List<Student> students = readJsonFile();
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return true;
            }
        }

        return false;
    }
}
