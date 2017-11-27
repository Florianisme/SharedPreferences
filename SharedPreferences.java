import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;

import java.util.Map;
import java.util.Set;

public class SharedPreferences {

    private static SharedPreferences mInstance = null;
    private final android.content.SharedPreferences prefs;
    private final String TAG = "SharedPreferences";
    private final android.content.SharedPreferences.Editor editor;
    private final String filename = "preferences";
    private boolean logging = false;

    @SuppressLint("CommitPrefEdits")
    private SharedPreferences(Context context) {
        prefs = context.getSharedPreferences(filename, Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    @SuppressLint("CommitPrefEdits")
    private SharedPreferences(Context context, String filename) {
        prefs = context.getSharedPreferences(filename, Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public static SharedPreferences getInstance(Context context) {
        if (mInstance == null)
            mInstance = new SharedPreferences(context);
        return mInstance;
    }

    public static SharedPreferences getInstance(Context context, String filename) {
        if ((mInstance != null && !mInstance.getFilename().equals(filename)) || mInstance == null)
            mInstance = new SharedPreferences(context, filename);
        return mInstance;
    }

    public void setLogging(boolean enabled) {
        logging = enabled;
    }

    public boolean isLoggingEnabled() {
        return logging;
    }

    public void clearAll() {
        editor.clear();
        editor.apply();
    }

    public boolean contains(String key) {
        return prefs.contains(key);
    }

    public void removeValue(String key) {
        if (logging)
            Log.d(TAG, "Removing key " + key + " from preferences");
        editor.remove(key);
        editor.apply();
    }

    private String getFilename() {
        return filename;
    }

    /*
        Retrieving methods
     */

    public boolean getBoolean(String key, boolean defaultValue) {
        if (logging)
            Log.d(TAG, "Value: " + key + " is " + prefs.getBoolean(key, defaultValue));
        return prefs.getBoolean(key, defaultValue);
    }

    public int getInteger(String key, int defaultValue) {
        if (logging)
            Log.d(TAG, "Value: " + key + " is " + prefs.getInt(key, defaultValue));
        return prefs.getInt(key, defaultValue);
    }

    public String getString(String key, String defaultValue) {
        if (logging)
            Log.d(TAG, "Value: " + key + " is " + (defaultValue != null ? prefs.getString(key, defaultValue).trim() : null));
        return defaultValue != null ? prefs.getString(key, defaultValue).trim() : null;
    }

    public float getFloat(String key, float defaultValue) {
        if (logging)
            Log.d(TAG, "Value: " + key + " is " + prefs.getFloat(key, defaultValue));
        return prefs.getFloat(key, defaultValue);
    }

    public long getLong(String key, long defaultValue) {
        if (logging)
            Log.d(TAG, "Value: " + key + " is " + prefs.getLong(key, defaultValue));
        return prefs.getLong(key, defaultValue);
    }

    public double getDouble(String key, double defaultValue) {
        if (logging)
            Log.d(TAG, "Value: " + key + " is " + Double.longBitsToDouble(prefs.getLong(key, Double.doubleToLongBits(defaultValue))));
        return Double.longBitsToDouble(prefs.getLong(key, Double.doubleToLongBits(defaultValue)));
    }

    public Set<String> getStringSet(String key, Set<String> defaultValue) {
        if (logging)
            Log.d(TAG, "Value: " + key + " is " + prefs.getStringSet(key, defaultValue).toString());
        return prefs.getStringSet(key, defaultValue);
    }

    public Map<String, ?> getAll() {
        if (logging)
            Log.d(TAG, "Total of " + prefs.getAll().size() + " values stored");
        return prefs.getAll();
    }

    /*
        Saving methods
    */

    public void saveBoolean(String key, boolean value) {
        if (logging)
            Log.d(TAG, "Saving " + key + " with value " + value);
        editor.putBoolean(key, value);
        editor.apply();
    }

    public void saveInteger(String key, int value) {
        if (logging)
            Log.d(TAG, "Saving " + key + " with value " + value);
        editor.putInt(key, value);
        editor.apply();
    }

    public void saveString(String key, String value) {
        if (logging)
            Log.d(TAG, "Saving " + key + " with value " + value);
        editor.putString(key, value != null ? value.trim() : null);
        editor.apply();
    }

    public void saveFloat(String key, float value) {
        if (logging)
            Log.d(TAG, "Saving " + key + " with value " + value);
        editor.putFloat(key, value);
        editor.apply();
    }

    public void saveLong(String key, long value) {
        if (logging)
            Log.d(TAG, "Saving " + key + " with value " + value);
        editor.putLong(key, value);
        editor.apply();
    }

    public void saveDouble(String key, double value) {
        if (logging)
            Log.d(TAG, "Saving " + key + " with value " + value);
        editor.putLong(key, Double.doubleToRawLongBits(value));
        editor.apply();
    }

    public void saveStringSet(String key, Set<String> set) {
        if (logging)
            Log.d(TAG, "Saving " + key + " with value " + set.toString());
        editor.putStringSet(key, set);
        editor.apply();
    }
}
