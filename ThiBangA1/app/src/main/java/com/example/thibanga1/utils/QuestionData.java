package com.example.thibanga1.utils;

public class QuestionData {
    String question,Da1,Da2,Da3,Da4,imageQuestion,explain,cau,answer;
    private String useAnswer = "";

    public QuestionData() {
    }

    public QuestionData(String question, String da1, String da2, String da3, String da4, String imageQuestion,
                        String explain, String cau, String answer, String useAnswer) {
        this.question = question;
        Da1 = da1;
        Da2 = da2;
        Da3 = da3;
        Da4 = da4;
        this.imageQuestion = imageQuestion;
        this.explain = explain;
        this.cau = cau;
        this.answer = answer;
        this.useAnswer = useAnswer;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDa1() {
        return Da1;
    }

    public void setDa1(String da1) {
        Da1 = da1;
    }

    public String getDa2() {
        return Da2;
    }

    public void setDa2(String da2) {
        Da2 = da2;
    }

    public String getDa3() {
        return Da3;
    }

    public void setDa3(String da3) {
        Da3 = da3;
    }

    public String getDa4() {
        return Da4;
    }

    public void setDa4(String da4) {
        Da4 = da4;
    }

    public String getImageQuestion() {
        return imageQuestion;
    }

    public void setImageQuestion(String imageQuestion) {
        this.imageQuestion = imageQuestion;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getCau() {
        return cau;
    }

    public void setCau(String cau) {
        this.cau = cau;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getUseAnswer() {
        return useAnswer;
    }

    public void setUseAnswer(String useAnswer) {
        this.useAnswer = useAnswer;
    }
}
