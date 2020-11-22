package studentmgt;

public class HealthAndEnvironmentStudent extends Student {
    private String psychologyGrade;
    private String geographyGrade;
    private String environmentalDesignGrade;
    private final double credit = 3;
    public HealthAndEnvironmentStudent(String firstName, String lastName, int age, String phoneNumber) throws Exception {
        super(firstName, lastName, age, phoneNumber);
    }

    public void setPsychologyGrade(String psychologyGrade) {
        this.psychologyGrade = psychologyGrade;
    }

    public void setGeographyGrade(String geographyGrade) {
        this.geographyGrade = geographyGrade;
    }

    public void setEnvironmentalDesignGrade(String environmentalDesignGrade) {
        this.environmentalDesignGrade = environmentalDesignGrade;
    }

    public String getPsychologyGrade() {
        return psychologyGrade;
    }

    public String getGeographyGrade() {
        return geographyGrade;
    }

    public String getEnvironmentalDesignGrade() {
        return environmentalDesignGrade;
    }

    @Override
    public String getSemGPA() {
        double gpa;
        if (geographyGrade == null && environmentalDesignGrade == null && psychologyGrade == null) {
            gpa = 0.0;
        } else if (psychologyGrade == null && geographyGrade == null) {
            gpa = getSubjectScore(environmentalDesignGrade);
        } else if (psychologyGrade == null && environmentalDesignGrade == null) {
            gpa = getSubjectScore(geographyGrade);
        } else if (geographyGrade == null && environmentalDesignGrade == null) {
            gpa = getSubjectScore(psychologyGrade);
        } else if (psychologyGrade == null) {
            gpa = (credit * getSubjectScore(geographyGrade) + credit * getSubjectScore(environmentalDesignGrade)) / (credit + credit);
        } else if (geographyGrade == null) {
            gpa = (credit * getSubjectScore(psychologyGrade) + credit * getSubjectScore(environmentalDesignGrade)) / (credit + credit);
        } else if (environmentalDesignGrade == null) {
            gpa = (credit * getSubjectScore(psychologyGrade) + credit * getSubjectScore(geographyGrade)) / (credit + credit);
        } else {
            gpa = (credit * getSubjectScore(psychologyGrade) + credit * getSubjectScore(geographyGrade) + credit * getSubjectScore(environmentalDesignGrade)) / (credit + credit + credit);
        }
        return String.format("%.2f", gpa);
    }

    @Override
    public void isDeanList(String gpa) {
        double gpaForDeanList = Double.parseDouble(gpa);
        System.out.println("Confirmed to be in Dean List or not: " + (gpaForDeanList >= 3.6));
    }

    public String achievementInFieldStudies (int numberOfFieldsVisited) {
        return "Achievement in Field Studies (Definition 1): " + ((numberOfFieldsVisited > 15)? "Great": (numberOfFieldsVisited > 9)? "Satisfactory":
                (numberOfFieldsVisited > 5)? "Average": (0 <= numberOfFieldsVisited && numberOfFieldsVisited <= 5)? "Poor": "nah");
    }

    public String achievementInFieldStudies (int numberOfOrganizationsRecommended, int numberOfPracticesApplied, int numberOfFindings) {
        double weightingOfOrganizationsRecommended = 4;
        double weightingOfPracticesApplied = 3;
        double weightingOfFindings = 2;
        double sumOfWeightings = weightingOfOrganizationsRecommended + weightingOfPracticesApplied + weightingOfFindings;
        double cumulativeWeightedAverage = ((weightingOfOrganizationsRecommended * numberOfOrganizationsRecommended) + (weightingOfPracticesApplied * numberOfPracticesApplied) + (weightingOfFindings * numberOfFindings)) / sumOfWeightings;
        return "Achievement in Field Studies (Definition 2): " + ((cumulativeWeightedAverage >= 4)? "Great": (cumulativeWeightedAverage >= 3)? "Satisfactory": (cumulativeWeightedAverage >= 2)? "Average": "nah");
    }


}
