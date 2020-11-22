package studentmgt;

public class ScienceAndTechnologyStudent extends Student {
    private String electronicGrade;
    private String programmingGrade;
    private String calculusGrade;
    private final double credit = 3;
    public ScienceAndTechnologyStudent(String firstName, String lastName, int age, String phoneNumber) throws Exception {
        super(firstName, lastName, age, phoneNumber);
    }

    public void setElectronicGrade(String electronicGrade) {
        this.electronicGrade = electronicGrade;
    }

    public void setProgrammingGrade(String programmingGrade) {
        this.programmingGrade = programmingGrade;
    }

    public void setCalculusGrade(String calculusGrade) {
        this.calculusGrade = calculusGrade;
    }

    public String getElectronicGrade() {
        return electronicGrade;
    }

    public String getProgrammingGrade() {
        return programmingGrade;
    }

    public String getCalculusGrade() {
        return calculusGrade;
    }

    @Override
    public String getSemGPA() {
        double gpa;
        if (programmingGrade == null && calculusGrade == null && electronicGrade == null) {
            gpa = 0.0;
        } else if (electronicGrade == null && programmingGrade == null) {
            gpa = getSubjectScore(calculusGrade);
        } else if (electronicGrade == null && calculusGrade == null) {
            gpa = getSubjectScore(programmingGrade);
        } else if (programmingGrade == null && calculusGrade == null) {
            gpa = getSubjectScore(electronicGrade);
        } else if (electronicGrade == null) {
            gpa = (credit * getSubjectScore(programmingGrade) + credit * getSubjectScore(calculusGrade)) / (credit + credit);
        } else if (programmingGrade == null) {
            gpa = (credit * getSubjectScore(electronicGrade) + credit * getSubjectScore(calculusGrade)) / (credit + credit);
        } else if (calculusGrade == null) {
            gpa = (credit * getSubjectScore(electronicGrade) + credit * getSubjectScore(programmingGrade)) / (credit + credit);
        } else {
            gpa = (credit * getSubjectScore(electronicGrade) + credit * getSubjectScore(programmingGrade) + credit * getSubjectScore(calculusGrade)) / (credit + credit + credit);
        }
        return String.format("%.2f", gpa);
    }

    @Override
    public void isDeanList(String gpa) {
        double gpaForDeanList = Double.parseDouble(gpa);
        System.out.println("Confirmed to be in Dean List or not: " + (gpaForDeanList >= 3.5));
    }

    public String achievementInScientificResearch (int numberOfExperimentsJoined) {
        return "Achievement in Scientific Research (Definition 1): " + ((numberOfExperimentsJoined > 20)? "Great": (numberOfExperimentsJoined > 14)? "Satisfactory":
                (numberOfExperimentsJoined > 7)? "Average": (0 <= numberOfExperimentsJoined && numberOfExperimentsJoined <= 7)? "Poor": "nah");
    }

    public String achievementInScientificResearch (int numberOfCompetitionsWon, int numberOfFindings, int numberOfTimesBeingResearchAssistant) {
        double weightingOfCompetitionsWon = 4;
        double weightingOfFindings = 3;
        double weightingOfBeingResearchAssistant = 2;
        double sumOfWeightings = weightingOfCompetitionsWon + weightingOfFindings + weightingOfBeingResearchAssistant;
        double cumulativeWeightedAverage = ((weightingOfCompetitionsWon * numberOfCompetitionsWon) + (weightingOfFindings * numberOfFindings) + (weightingOfBeingResearchAssistant * numberOfTimesBeingResearchAssistant)) / sumOfWeightings;
        return "Achievement in Scientific Research (Definition 2): " + ((cumulativeWeightedAverage >= 4)? "Great": (cumulativeWeightedAverage >= 3)? "Satisfactory": (cumulativeWeightedAverage >= 2)? "Average": "nah");
    }


}
