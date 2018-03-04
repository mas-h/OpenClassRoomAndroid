package mas_hcorparation.com.topquiz.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;

import mas_hcorparation.com.topquiz.R;
import mas_hcorparation.com.topquiz.model.Question;
import mas_hcorparation.com.topquiz.model.QuestionBank;

public class GameActivity extends AppCompatActivity implements View.OnClickListener { // On implémente l'interface Onclik directement dans le controller
    private TextView textQuestion;
    private Button reponse1;
    private Button reponse2;
    private Button reponse3;
    private Button reponse4;

    private QuestionBank mQuestionBank;
    private Question mQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // On lie les éléments de la vue au controller en les recupérant par leur Id définis dans la vue
        textQuestion = findViewById(R.id.activity_game_question_text);
        reponse1 = findViewById(R.id.activity_game_answer1_btn);
        reponse2 = findViewById(R.id.activity_game_answer2_btn);
        reponse3 = findViewById(R.id.activity_game_answer3_btn);
        reponse4 = findViewById(R.id.activity_game_answer4_btn);

        mQuestionBank = this.generateQuestionBank(); // On initialise la banque de question avec la méthode dédiée

        // On met des clickListener pour tout les boutons de réponses
        reponse1.setOnClickListener(this);
        reponse2.setOnClickListener(this);
        reponse3.setOnClickListener(this);
        reponse4.setOnClickListener(this);

        // Pour savoir sur quel bouton a appuyé l'utilisateur, on tag les boutons.
        reponse1.setTag(0);
        reponse2.setTag(1);
        reponse3.setTag(2);
        reponse4.setTag(3);
    }

    private void displayQuestion (final Question question) {
        textQuestion.setText(question.getQuestion());
        reponse1.setText(question.getChoiceList().get(0));
        reponse2.setText(question.getChoiceList().get(1));
        reponse3.setText(question.getChoiceList().get(2));
        reponse4.setText(question.getChoiceList().get(3));
    }

    @Override
    public void onClick(View v) {
        int reponseChoice = (int) v.getTag(); // on cast en int car la methode getTag() renvoie un objet de base.
        if (reponseChoice == mQuestion.getReponseIndex()){ // Bonne réponse
            Toast.makeText(this,"Correct Genius ! ", Toast.LENGTH_SHORT).show();
        }
        else { // mauvaise réponse
            Toast.makeText(this,"Mauvaise réponse ! Try again ... ", Toast.LENGTH_SHORT).show();
        }
    }

    public QuestionBank generateQuestionBank(){
        Question question1 = new Question("Who is the creator of Android?",

                Arrays.asList("Andy Rubin",

                        "Steve Wozniak",

                        "Jake Wharton",

                        "Paul Smith"),

                0);


        Question question2 = new Question("When did the first man land on the moon?",

                Arrays.asList("1958",

                        "1962",

                        "1967",

                        "1969"),

                3);


        Question question3 = new Question("What is the house number of The Simpsons?",

                Arrays.asList("42",

                        "101",

                        "666",

                        "742"),

                3);

        return new QuestionBank(Arrays.asList(question1,
                                             question2,
                                             question3));
    }
}
