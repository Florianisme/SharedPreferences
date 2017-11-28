# SharedPreferences
Shared Preferences on Android are used to store mostly primitive data types permanently so they can be retrieved after restarting the app. 

This small library aims to make storing values easier than ever.
Download the [SharedPreferences.java file](../master/SharedPreferences.java) and add it to you project. That's it!

This library can also be used with Android's [BackupAgent](https://developer.android.com/guide/topics/data/autobackup.html#EnablingAutoBackup) so when the user restores his phone from a backup, the Shared Preferences files are downloaded automatically.

## Filetypes

+ String
+ Integer
+ Float
+ Double
+ Long
+ Boolean
+ Map
+ Set

## Usage
Calling `SharedPreferences.getInstance(Context context)` instantiates a SharedPreference instance with the default filename `preferences`. This can be changed by calling `SharedPreferences.getInstance(Context context, String filename)` (Note that the filename is now set for all future calls of `SharedPreferences.getInstance(Context context)`).


Every piece of data stored in the file is a key-value pair, which means that for storing and retrieving data, you always need the corresponding key.
### Storing data
All primitive types can be stored by calling the `save` method while supplying a key and a value

e.g.: `saveString(String key, String value)`.

This will then be stored like `<key>value</key>`.

### Retrieving data
Stored data can be retrieved by calling the `get` method while supplying a key and a default return value in case the pair does not exist

e.g.: `getString(String key, String defaultValue)`.

### Additional Methods
`setLogging(boolean)` enables/disables logging

`exists(String key)` returns true if the file contains the supplied key

`removeValue(String key)` removes the key-value pair with the supplied key from the file

`clearAll` removes all values from the file
