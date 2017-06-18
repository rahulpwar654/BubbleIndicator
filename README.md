# BubbleIndicator


This is android library to add bubble shaped indicator to your App.

## Add Gradle dependency:

```gradle
dependencies {
   compile 'com.github.rahulpwar654:BubbleIndicator:1.0beta'
}
```

## Code Example
Add it in your root build.gradle at the end of repositories:
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```




```
public class MainActivity extends AppCompatActivity implements IndicatorClickListener {

    NumberedIndicator numberedIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NumberedIndicator numberedIndicator;
        numberedIndicator= (NumberedIndicator) findViewById(R.id.numberedindicator);
        numberedIndicator.setBubbleNumbers(4);
        numberedIndicator.setBackgroundColor(Color.WHITE);
        numberedIndicator.setBubbleWidgetClickListener(this);
    }

    @Override
    public void onBubbleClicked(int bubbleNum) {
        Toast.makeText(this, ""+bubbleNum+" clicked ", Toast.LENGTH_SHORT).show();
    }
}

```

## Add following XML snippet to your XML resource file
```
    <com.rahulpwar654.bubbleindicatorlibrary.NumberedIndicator
        android:id="@+id/numberedindicator"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        />
```



## Contributors

Want to contribute? You are welcome! 

## Developed By
------------

* Rahul Pawar - <rahulpwar654@gmail.com>

## License

MIT License

Copyright (c) 2017 rahulpwar654

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
