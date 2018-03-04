package mas_hcorparation.com.topquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mGreetingText;
    private EditText mNameInput;
    private Button mPlayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGreetingText = (TextView) findViewById(R.id.activity_main_greeting_txt);
        mNameInput = (EditText) findViewById(R.id.activity_main_name_input);
        mPlayButton = (Button) findViewById(R.id.activity_main_play_btn);

        mPlayButton.setEnabled(false); // on désactive le button lors de la création pour s'assurer de la saisie d'un prenom par user
        mNameInput.addTextChangedListener(new TextWatcher() { // Notifie quand user commence a taper du text dans l'input
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // c'est ici que l'on peut vérifier user input
                mPlayButton.setEnabled(charSequence.toString().length() != 0);// Si la longueur du text est différent de 0 alors le button s'active
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // The user just clicked
                Intent gameActivity = new Intent(MainActivity.this, GameActivity.class); // permet de lier 2 activités
                startActivity(gameActivity);
            }
        });
    }
}
