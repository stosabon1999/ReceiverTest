package ru.production.ssobolevsky.receivertest;

/**
 * Created by pro on 15.06.2018.
 */

class MySingleton {

    private static final String mFirst = "A";

    private static final String mSecond = "B";

    private static final String mThird = "C";

    private static final String mFourth = "D";

    private static final String mFifth = "E";


    private String mCurrentState;

    private static final MySingleton ourInstance = new MySingleton();

    static MySingleton getInstance() {
        return ourInstance;
    }

    private MySingleton() {

    }

    public void changeState(String data) {
        switch (data) {
            case "1":
                mCurrentState = mFirst;
                break;
            case "2":
                mCurrentState = mSecond;
                break;
            case "3":
                mCurrentState = mThird;
                break;
            case "4":
                mCurrentState = mFourth;
                break;
            case "5":
                mCurrentState = mFifth;
                break;
            default:
                break;
        }
    }

    public String getState() {
        return mCurrentState;
    }

}
