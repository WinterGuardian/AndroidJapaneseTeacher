package me.winter.japteacher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FailedActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_failed);

        JapaneseCharacter answered = (JapaneseCharacter)getIntent().getSerializableExtra("answered");
        JapaneseCharacter actual = (JapaneseCharacter)getIntent().getSerializableExtra("actual");

        TextView correctAnswer = (TextView)findViewById(R.id.correct_answer);
        correctAnswer.setText("The answer was " + actual.getRomaji());

        TextView answeredText = (TextView)findViewById(R.id.answered);
        TextView answeredSymbol = (TextView)findViewById(R.id.answered_symbol);
        TextView answeredComment = (TextView)findViewById(R.id.ansered_comment);

        if(answered != null)
        {
            answeredText.setText(answered.getRomaji());
            answeredSymbol.setText(answered.getSymbol());
            answeredComment.setText(answered.getComment());
        }
        else
        {
            answeredText.setText("");
            answeredSymbol.setText("");
            answeredComment.setText("");
        }

        TextView actualText = (TextView)findViewById(R.id.actual);
        TextView actualSymbol = (TextView)findViewById(R.id.actual_symbol);
        TextView actualComment = (TextView)findViewById(R.id.actual_comment);

        actualText.setText(actual.getRomaji());
        actualSymbol.setText(actual.getSymbol());
        actualComment.setText(actual.getComment());

        TextView scoreDisplay = (TextView)findViewById(R.id.score);

        int score = getIntent().getIntExtra("score", -1);
        float avgTime = getIntent().getFloatExtra("avgTime", -1);

        scoreDisplay.setText("Score: " + score + "\nAverage time: " + avgTime + "s");

        Button retry = (Button)findViewById(R.id.retry);
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button different = (Button)findViewById(R.id.different);
        different.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FailedActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
