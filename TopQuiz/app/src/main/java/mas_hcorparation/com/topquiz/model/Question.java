package mas_hcorparation.com.topquiz.model;

import java.util.List;

/**
 * Created by mash on 04/03/18.
 */

public class Question {

    private String question;
    private List<String> choiceList;
    private int reponseIndex;

    public Question(String question, List<String> choiceList, int reponseIndex) {
        setQuestion(question);
        setChoiceList(choiceList);
        setReponseIndex(reponseIndex);
    }



    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getChoiceList() {
        return choiceList;
    }

    public void setChoiceList(List<String> choiceList) {
        if (choiceList == null) {
            throw new IllegalArgumentException("Liste de réponses null");
        }
        this.choiceList = choiceList;
    }

    public int getReponseIndex() {
        return reponseIndex;
    }

    public void setReponseIndex(int reponseIndex) {
        if (reponseIndex<0 || reponseIndex>= choiceList.size()){
            throw new IllegalArgumentException("L'index de la réponse est en dehors des choix possibles");
        }
        this.reponseIndex = reponseIndex;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", choiceList=" + choiceList +
                ", reponseIndex=" + reponseIndex +
                '}';
    }
}
