package com.example.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mTrueButton;                                      //设置所需的按钮、文本框
    private Button mFalseButton;
    private Button mNextButton;
    private Button mPrevButton;
    private TextView mQuestionTextView;
    private int mCurrentIndex = 0;
    private static final String TAG = "MainActivity";
    private static final String KEY_INDEX = "index";                //新增常量用来存储在bundle中键-值对中的键
    private static String KEY_ANSWER="KEY_ANSWER";
    private Question[] mQuestionBank = new Question[]{              //设置数组用来存放问题
            new Question(R.string.question_australia,true),
            new Question(R.string.question_oceans,true),
            new Question(R.string.question_mideast,false),
            new Question(R.string.question_africa,false),
            new Question(R.string.question_americas,true),
            new Question(R.string.question_asia,true)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {             //固定代码
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate(Bundle) called");
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null) {                              //设置暂存区
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);    //将设置的文本框内容与资源相连
        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });

        mTrueButton = (Button) findViewById (R.id.true_button);      //设置所需按钮与监听器
        mTrueButton.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View v){
                checkAnswer(true);
                if ( mQuestionBank[mCurrentIndex % mQuestionBank.length].getIsAnswered() > 0 ) {
                    mTrueButton.setClickable(false);
                    mFalseButton.setClickable(false);
                }
            }
        });
        mFalseButton = (Button) findViewById (R.id.false_button);
        mFalseButton.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View v){
                checkAnswer(false);
                if ( mQuestionBank[mCurrentIndex % mQuestionBank.length].getIsAnswered() > 0 ) {
                    mTrueButton.setClickable(false);
                    mFalseButton.setClickable(false);
                }
            }
        });
        mPrevButton = (Button) findViewById (R.id.prev_button);
        mPrevButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(mCurrentIndex != 0)
                    mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
                prevQuestion();
                if (mQuestionBank[mCurrentIndex % mQuestionBank.length].getIsAnswered() == 0 ){
                    mTrueButton.setClickable(true);
                    mFalseButton.setClickable(true);
                }
            }
        });

        mNextButton = (Button)  findViewById (R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
                if (mQuestionBank[mCurrentIndex % mQuestionBank.length].getIsAnswered() == 0 ){
                    mTrueButton.setClickable(true);
                    mFalseButton.setClickable(true);
                }

            }
        });
        updateQuestion();
     }
     @Override
     public void onStart() {
         super.onStart();
         Log.d(TAG,"onStart() called");
     }
    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG,"onResume() called");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG,"onPause() called");
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG,"onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX,mCurrentIndex);
        }
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG,"onStop() called");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy() called");
    }

    private void prevQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTestResId();//设置问题引用问题数组的id
        mQuestionTextView.setText(question);
    }

    private void updateQuestion(){
        int question = mQuestionBank[mCurrentIndex].getTestResId();         //设置问题引用问题数组的id
        mQuestionTextView.setText(question);

    }

    private void checkAnswer( boolean userPressedTrue ) {                 //检查答案
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
        mQuestionBank[mCurrentIndex % mQuestionBank.length].setIsAnswered(1);

        int messageResId = 0;
        if (userPressedTrue == answerIsTrue){
            messageResId = R.string.correct_toast;
        }
        else{
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this,messageResId,Toast.LENGTH_SHORT).show();
    }
}
