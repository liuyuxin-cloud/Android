package com.example.geoquiz;

public class Question {
        private int mTestResId;
        private boolean mAnswerTrue;

        public Question(int textResId, boolean answerTrue) {
            mTestResId = textResId;
            mAnswerTrue = answerTrue;
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
