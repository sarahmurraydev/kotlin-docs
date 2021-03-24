# Google Android Code Labs

[Link](https://developer.android.com/courses/android-basics-kotlin/course)

## Unit 1: Kotlin Basics for Android 

### Part 4: Dice Roll App 

#### Make an Activity:
**Activity**: An Activity provides the window in which the app draws the UI

To make an activity: 
```kotlin

class MyActivity: AppCompatActivity() {
    // in kotlin apps you have a `main()` function that is called on load 
    // in android apps, the `onCreate()` function of the activity is called on load 
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // sets the layout of the activity 
    }
} 
```

#### Resources
Each item of the XML layout may have a resource ID attached to it which serves as the unique identifier for that ID.
Android automatically assigns ID numbers to the resources in your app and uses those (instead of the text id you see). 

Note: Kotlin doesn't copy entire objects when variables are assigned. Instead, it saves a reference to the object. 

Kotlin Android Style Guide: https://developer.android.com/kotlin/style-guide?authuser=1 

Note: image resources are known as "drawables"
