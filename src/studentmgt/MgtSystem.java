package studentmgt;

public class MgtSystem {

    public static void main(String[] args) throws Exception {
        BusinessStudent student1 = new BusinessStudent("Adam", "Smith", 18, "34567890");
        student1.setAccountingGrade("A");
        student1.setEconomicsGrade("B+");
        student1.setStatisticsGrade("C+");
        student1.showInfo();
        student1.isDeanList(student1.getSemGPA());
        System.out.println(student1.achievementInBusinessCompetitions(7));
        System.out.println(student1.achievementInBusinessCompetitions(0, 0, 3, 1));

        HumanitiesStudent student2 = new HumanitiesStudent("David", "Hume", 19, "23456789");
        student2.setHistoryGrade("A+");
        student2.setPhilosophyGrade("A");
        student2.setSociologyGrade("A");
        student2.showInfo();
        student2.isDeanList(student2.getSemGPA());
        System.out.println(student2.achievementInAcademicProjects(8));
        System.out.println(student2.achievementInAcademicProjects(2,4,2));

        HealthAndEnvironmentStudent student3 = new HealthAndEnvironmentStudent("Desmond", "Miles", 19, "65432100");
        student3.setPsychologyGrade("B+");
        student3.setGeographyGrade("B");
        student3.setEnvironmentalDesignGrade("C+");
        student3.showInfo();
        student3.isDeanList(student3.getSemGPA());
        System.out.println(student3.achievementInFieldStudies(8));
        System.out.println(student3.achievementInFieldStudies(0,3,4));

        ScienceAndTechnologyStudent student4 = new ScienceAndTechnologyStudent("Desmond", "Miles", 19, "65432100");
        student4.setElectronicGrade("B+");
        student4.setProgrammingGrade("A");
        student4.setCalculusGrade("B+");
        student4.showInfo();
        student4.isDeanList(student4.getSemGPA());
        System.out.println(student4.achievementInScientificResearch(25));
        System.out.println(student4.achievementInScientificResearch(3,7,4));

        System.out.println(Student.getNumberOfStudents());
    }
}
