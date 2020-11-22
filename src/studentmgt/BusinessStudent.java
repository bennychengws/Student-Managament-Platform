package studentmgt;

public class BusinessStudent extends Student {
    private String accountingGrade;
    private String economicsGrade;
    private String statisticsGrade;
    private final double credit = 3;
    public BusinessStudent(String firstName, String lastName, int age, String phoneNumber) throws Exception {
        super(firstName, lastName, age, phoneNumber);
    }

    public void setAccountingGrade(String accountingGrade) {
        this.accountingGrade = accountingGrade;
    }

    public void setEconomicsGrade(String economicsGrade) {
        this.economicsGrade = economicsGrade;
    }

    public void setStatisticsGrade(String statisticsGrade) {
        this.statisticsGrade = statisticsGrade;
    }

    public String getAccountingGrade() {
        return accountingGrade;
    }

    public String getEconomicsGrade() {
        return economicsGrade;
    }

    public String getStatisticsGrade() {
        return statisticsGrade;
    }

    @Override
    public String getSemGPA() {
        double gpa;
        if (economicsGrade == null && statisticsGrade == null && accountingGrade == null) {
            gpa = 0.0;
        } else if (accountingGrade == null && economicsGrade == null) {
            gpa = getSubjectScore(statisticsGrade);
        } else if (accountingGrade == null && statisticsGrade == null) {
            gpa = getSubjectScore(economicsGrade);
        } else if (economicsGrade == null && statisticsGrade == null) {
            gpa = getSubjectScore(accountingGrade);
        } else if (accountingGrade == null) {
            gpa = (credit * getSubjectScore(economicsGrade) + credit * getSubjectScore(statisticsGrade)) / (credit + credit);
        } else if (economicsGrade == null) {
            gpa = (credit * getSubjectScore(accountingGrade) + credit * getSubjectScore(statisticsGrade)) / (credit + credit);
        } else if (statisticsGrade == null) {
            gpa = (credit * getSubjectScore(accountingGrade) + credit * getSubjectScore(economicsGrade)) / (credit + credit);
        } else {
            gpa = (credit * getSubjectScore(accountingGrade) + credit * getSubjectScore(economicsGrade) + credit * getSubjectScore(statisticsGrade)) / (credit + credit + credit);
        }
        return String.format("%.2f", gpa);
    }

    @Override
    public void isDeanList(String gpa) {
        double gpaForDeanList = Double.parseDouble(gpa);
        System.out.println("Confirmed to be in Dean List or not: " + (gpaForDeanList >= 3.75));
    }

    public String achievementInBusinessCompetitions (int numberOfCompetitionsJoined) {
        return "Achievement in Business Competitions (Definition 1): " + ((numberOfCompetitionsJoined > 10)? "Great": (numberOfCompetitionsJoined > 5)? "Satisfactory":
                (numberOfCompetitionsJoined > 1)? "Average": (0 <= numberOfCompetitionsJoined && numberOfCompetitionsJoined <= 1)? "Poor": "nah");
    }

    public String achievementInBusinessCompetitions (int numberOfChampion, int numberOf1stRunnerUp, int numberOf2ndRunnerUp, int numberOfMerits) {
        double weightingOfChampion = 4;
        double weightingOf1stRunnerUp = 3;
        double weightingOf2ndRunnerUp = 2;
        double sumOfWeightings = weightingOfChampion + weightingOf1stRunnerUp + weightingOf2ndRunnerUp + 1;
        double cumulativeWeightedAverage = ((weightingOfChampion * numberOfChampion) + (weightingOf1stRunnerUp * numberOf1stRunnerUp) + (weightingOf2ndRunnerUp * numberOf2ndRunnerUp) + numberOfMerits) / sumOfWeightings;
        return "Achievement in Business Competitions (Definition 2): " + ((cumulativeWeightedAverage >= 0.8)? "Great": (cumulativeWeightedAverage >= 0.4)? "Satisfactory": (cumulativeWeightedAverage >= 0.1)? "Average": "nah");
    }


}
