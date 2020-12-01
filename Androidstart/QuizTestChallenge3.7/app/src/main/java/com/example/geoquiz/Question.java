package com.example.geoquiz;

public class Question {
        private int mTestResId;
        private boolean mAnswerTrue;
        private int isAnswer;

        public Question(int textResId, boolean answerTrue) {
            mTestResId = textResId;
            mAnswerTrue = answerTrue;
        }
        public void setIsAnswered(int isAnswer){
            this.isAnswer = isAnswer;
        }
        public int getIsAnswered(){
            return isAnswer;
        }
        public void setTestResId(int testResId) {
            mTestResId = testResId;
        }

        public int getTestResId() {
            return mTestResId;
        }

        public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }

        public boolean isAnswerTrue() {
            return mAnswerTrue;
        }

}
