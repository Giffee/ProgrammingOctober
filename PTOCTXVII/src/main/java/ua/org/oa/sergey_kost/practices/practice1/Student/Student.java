package ua.org.oa.sergey_kost.practices.practice1.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String fullName;
    private Group group;
    private List<Exam> exams;

    Student(String fullName, String faculty, int course){
        this.fullName = fullName;
        setGroup(new Group(faculty, course));
        exams = new ArrayList<>();
        Exam studentExam = new Exam();
        exams = studentExam.createFullExamList();
        exams.removeIf(exam -> exam.getCourse() > course);
    }

    public Exam addMark(String subject, int course, int semester, int mark){
        Exam currentExam = null;
        for (Exam exam : exams){
            if(exam.getTitle().equalsIgnoreCase(subject) && exam.getCourse() == course && exam.getSemester() == semester){
                exam.setMark(mark);
                currentExam = exam;
            }
        }
        return currentExam;
    }

    public Exam removeMark(String subject, int course, int semester) throws Exception {
        Exam currentExam = null;
        for (Exam exam : exams){
            if(exam.getTitle().equalsIgnoreCase(subject) && exam.getCourse() == course && exam.getSemester() == semester && exam.getMark() == 0) {
                throw new Exception("The student haven't passed this exam yet");
            }
            if(exam.getTitle().equalsIgnoreCase(subject) && exam.getCourse() == course && exam.getSemester() == semester && exam.getMark() != 0){
                exam.setMark(0);
                currentExam = exam;
            }
        }
        return currentExam;
    }

    public int getMaxSubjectMark(String subject){
        int score = 0;
        for (Exam exam : exams){
            if(exam.getTitle().equalsIgnoreCase(subject) && exam.getMark() > score){
                score = exam.getMark();
            }
        }
        return score;
    }

    public int getNumberOfExamsWithSetMark(int mark){
        int count = 0;
        for (Exam exam : exams){
            if(exam.getMark() == mark){
                count++;
            }
        }
        return count;
    }

    public double getAverageScore(int course, int semester){
        double sum = 0.0;
        int count = 0;
        for (Exam exam : exams){
            if(exam.getCourse() == course && exam.getSemester() == semester && exam.getMark() != 0){
                sum = sum + exam.getMark();
                count++;
            }
        }
        return sum/count;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", group=" + group +
                ", exams=" + exams +
                '}';
    }
}