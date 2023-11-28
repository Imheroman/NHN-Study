package servlet.servletV1.servlets;//package student2;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//public class MapStudentRepository implements StudentRepository {
//    private Map<String, Student> studentMap = new ConcurrentHashMap<>();
//
//    @Override
//    public void save(Student student) {
//        studentMap.put(student.getId(), student);
//    }
//
//    @Override
//    public void update(Student student) {
//        studentMap.replace(student.getId(), student);
//    }
//
//    @Override
//    public void deleteById(String id) {
//        System.err.println("This is delete in MapStudent");
//        studentMap.remove(id);
//    }
//
//    @Override
//    public Student getStudentById(String id) {
//        return studentMap.get(id);
//    }
//
//    @Override
//    public List<Student> getStudents() {
//        List<Student> list = new ArrayList<>();
//        for (Student s:
//             this.studentMap.values()) {
//            list.add(s);
//        }
//        return list;
////        return studentMap.entrySet().stream()
////                .map(s -> s.getValue())
////                .collect(Collectors.toList());
//    }
//
//    @Override
//    public boolean existById(String id) {
//        return studentMap.containsKey(id);
//    }
//}
