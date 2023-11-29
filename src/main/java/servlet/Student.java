package servlet;//package student2;
//
//import lombok.Getter;
//
//import java.time.LocalDateTime;
//
//public class Student {
//    //아이디
//    @Getter
//    private  String id;
//    //이름
//    @Getter
//    private  String name;
//    //성별
//    @Getter
//    private Gender gender;
//    //나이
//    @Getter
//    private  int age;
//    //생성일
//    @Getter
//    private LocalDateTime createdAt;
//
//    public Student(String id, String name, Gender gender, int age) {
//        this.id = id;
//        this.name = name;
//        this.gender = gender;
//        this.age = age;
//        this.createdAt = LocalDateTime.now();
//    }
//
//    private void classInvariant() {
//        if (id == null || name == null || gender == null || age < 0) {
//            throw new IllegalArgumentException("The student invariant illegals");
//        }
//    }
//}
