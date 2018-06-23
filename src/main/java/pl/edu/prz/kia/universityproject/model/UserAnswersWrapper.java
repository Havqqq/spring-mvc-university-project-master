package pl.edu.prz.kia.universityproject.model;

import java.util.ArrayList;
import java.util.List;

public class UserAnswersWrapper {

    private List<UserAnswer> answerList;

    public UserAnswersWrapper(List<UserAnswer> answerList) {
        this.answerList = answerList;
    }

    public List<UserAnswer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<UserAnswer> answerList) {
        this.answerList = answerList;
    }
}