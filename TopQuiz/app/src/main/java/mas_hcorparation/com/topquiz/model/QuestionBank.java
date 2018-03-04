package mas_hcorparation.com.topquiz.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by mash on 04/03/18.
 */

public class QuestionBank {

    private List<Question> mQuestionList;

    private int mNextQuestionIndex;


    public QuestionBank(List<Question> questionList) {

        this.mQuestionList = questionList;
        this.mNextQuestionIndex = 0;

        Collections.shuffle(mQuestionList);

    }


    public Question getQuestion() {

        if (mNextQuestionIndex==mQuestionList.size()){ // si on a parcouru toutes les questions alors on remet l'index à 0
            mNextQuestionIndex = 0;
        }

        return mQuestionList.get(mNextQuestionIndex++); // On retourne la question à l'index en cours qui est incrémenté de 1 par la suite

    }
}
