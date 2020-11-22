package studentmgt;

public class HumanitiesStudent extends Student {
    private String historyGrade;
    private String philosophyGrade;
    private String sociologyGrade;
    private final double credit = 3;
    public HumanitiesStudent(String firstName, String lastName, int age, String phoneNumber) throws Exception {
        super(firstName, lastName, age, phoneNumber);
    }

    public void setHistoryGrade(String historyGrade) {
        this.historyGrade = historyGrade;
    }

    public void setPhilosophyGrade(String philosophyGrade) {
        this.philosophyGrade = philosophyGrade;
    }

    public void setSociologyGrade(String sociologyGrade) {
        this.sociologyGrade = sociologyGrade;
    }

    public String getHistoryGrade() {
        return historyGrade;
    }

    public String getPhilosophyGrade() {
        return philosophyGrade;
    }

    public String getSociologyGrade() {
        return sociologyGrade;
    }

    @Override
    public String getSemGPA() {
        double gpa;
        if (philosophyGrade == null && sociologyGrade == null && historyGrade == null) {
            gpa = 0.0;
        } else if (historyGrade == null && philosophyGrade == null) {
            gpa = getSubjectScore(sociologyGrade);
        } else if (historyGrade == null && sociologyGrade == null) {
            gpa = getSubjectScore(philosophyGrade);
        } else if (philosophyGrade == null && sociologyGrade == null) {
            gpa = getSubjectScore(historyGrade);
        } else if (historyGrade == null) {
            gpa = (credit * getSubjectScore(philosophyGrade) + credit * getSubjectScore(sociologyGrade)) / (credit + credit);
        } else if (philosophyGrade == null) {
            gpa = (credit * getSubjectScore(historyGrade) + credit * getSubjectScore(sociologyGrade)) / (credit + credit);
        } else if (sociologyGrade == null) {
            gpa = (credit * getSubjectScore(historyGrade) + credit * getSubjectScore(philosophyGrade)) / (credit + credit);
        } else {
            gpa = (credit * getSubjectScore(historyGrade) + credit * getSubjectScore(philosophyGrade) + credit * getSubjectScore(sociologyGrade)) / (credit + credit + credit);
        }
        return String.format("%.2f", gpa);
    }

    @Override
    public void isDeanList(String gpa) {
        double gpaForDeanList = Double.parseDouble(gpa);
        System.out.println("Confirmed to be in Dean List or not: " + (gpaForDeanList >= 3.85));
    }
    
    public String achievementInAcademicProjects(int numberOfEssaysReleased) {
        return "Achievement in Academic Projects (Definition 1): " + ((numberOfEssaysReleased > 7)? "Great": (numberOfEssaysReleased > 4)? "Satisfactory":
                (numberOfEssaysReleased > 2)? "Average": (0 <= numberOfEssaysReleased && numberOfEssaysReleased <= 2)? "Poor": "nah");
    }

    public String achievementInAcademicProjects(int numberOfTimesBeingCited, int numberOfConferenceAttended, int numberOfTimesBeingResearchAssistant) {
        double weightingOfBeingCited = 4;
        double weightingOfAttendingConference = 3;
        double weightingOfBeingResearchAssistant = 2;
        double sumOfWeightings = weightingOfBeingCited + weightingOfAttendingConference + weightingOfBeingResearchAssistant;
        double cumulativeWeightedAverage = ((weightingOfBeingCited * numberOfTimesBeingCited) + (weightingOfAttendingConference * numberOfConferenceAttended) + (weightingOfBeingResearchAssistant * numberOfTimesBeingResearchAssistant)) / sumOfWeightings;
        return "Achievement in Academic Projects (Definition 2): " + ((cumulativeWeightedAverage >= 0.8)? "Great": (cumulativeWeightedAverage >= 0.4)? "Satisfactory": (cumulativeWeightedAverage >= 0.1)? "Average": "nah");
    }
}
