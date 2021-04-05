package in.pci.nrlmta.services;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private SessionManager mInstance;
    private Context mContext;
    private SharedPreferences mSPref;
    private SharedPreferences.Editor mEditor;
    private static final String PREF_NAME = "NRLMTA";

    public synchronized SessionManager getInstance(Context context) {
        if (mInstance == null)
            mInstance = new SessionManager(context);
        return mInstance;
    }

    public SessionManager(Context context) {
        this.mContext = context;
        this.mSPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        this.mEditor = mSPref.edit();
    }

    public void createSession() {
        mEditor.clear().commit();
        mEditor.putBoolean("IS_USER_LOGIN", true);
        mEditor.commit();
    }

    public boolean isLoggedIn() {
        return mSPref.getBoolean("IS_USER_LOGIN", false);
    }
}
