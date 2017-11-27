# SharedPreferences

This small library aims to make storing primitive datatypes and Stringsets easier than ever.
Download the SharedPreferences.java file and add it to you project. That's it!

## Usage
Calling `SharedPreferences.getInstance(Context context)` instantiates a SharedPreference instance with the default filename `preferences`. This can be changed by calling `SharedPreferences.getInstance(Context context, String filename)` (Note that the filename is now set for all future calls of `SharedPreferences.getInstance(Context context)`).


Every piece of data stored in the file is a key-value pair, which means that for storing and retrieving data, you always need the corresponding key.

## Filetypes

+ String
+ Integer
+ Float
+ Double
+ Long
+ Boolean
+ Map
+ Set

### Storing data
All primitive types can be stored by calling the `save` method while supplying a key 

e.g.: `saveString(String key, String value)`.

This will then be stored like `<key>value</key>`.

### Retrieving data
This can be achieved by calling the `get` method while supplying a default return value in case the key does not exist

e.g.: `getString(String key, String defaultValue)`.

### Additional Methods
`setLogging(boolean)` enables/disables logging

`exists(String key)` returns true if the file contains the supplied key

`removeValue(String key)` removed the key-value pair with the supplied key from the file

`clearAll` removes all values from the file
