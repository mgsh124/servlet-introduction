package com.mum;

public class QuizModel {
    private static String[] questions = {
        "3, 1, 4, 1, 5", // pi
        "1, 1, 2, 3, 5", // fibonaci
        "1, 4, 9, 16, 25", // squares
        "2, 3, 5, 7, 11", // primes
        "1, 2, 4, 8, 16" // powers of 2
    };

    private static int[] answers = {9, 8, 36, 13, 32};

    private int score = 0;
    private int count = 3;
    private int questionNo = 1;
    private int age = 0;

    public static String[] getQuestions() {
        return questions;
    }

    public static int[] getAnswers() {
        return answers;
    }

    public int getScore() {
        return score;
    }

    public int getCount() {
        return count;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(int questionNo) {
        this.questionNo = questionNo;
    }

    public void updateScore(int userAnswer) {
        int point = 0;
        switch (count) {
            case 3:
                point = 10; break;
            case 2:
                point = 5; break;
            case 1:
                point = 2; break;
            default:
                break;
        }

        if (QuizModel.getAnswers()[questionNo - 1] == userAnswer) {
            this.setScore(this.getScore() + point);
            this.setCount(3);
            this.setQuestionNo(this.getQuestionNo() + 1);
        } else {
            --count;
        }

        if (count == 0) {
            this.setCount(3);
            this.setQuestionNo(this.getQuestionNo() + 1);
        }
    }

    public boolean validateAge(int userAge) {
        if (userAge > 4 && userAge < 100 ) {
            return true;
        }

        return false;
    }

    public String getGrade() {
        String grade = "NC";
        if (score >= 45 && score <= 50)
            grade = "A";
        if (score >= 35 && score <= 44)
            grade = "B";
        if (score >= 25 && score <= 34)
            grade = "C";
        return grade;
    }

    public boolean isCompleted() {
        if (questionNo > 5) return true;
        return false;
    }
}
