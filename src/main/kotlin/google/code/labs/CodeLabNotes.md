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

## Unit 2: Layouts

### Part 1: Get User Input in an App

Class hierarchy -- for the most part in kotlin/java (android) development, classes are often extensions of other classes. 
For example, in the dialog components you have used, those classes were an extension of an alert class that set up all different types of popups. 
The following terminology is associate with class hierarchy:
    - **Class hierarchy**: An arrangement where classes are organized in a hierarchy of parents and children. Hierarchy diagrams are usually drawn with the parents shown above children.
    - **Child** or **subclass**: Any class that is below another class in the hierarchy.
    - **Parent** or **superclass** or **base class**: Any class with one or more child classes.
    - **Root** or **top-level class**:  The class at the top (or root) of the class hierarchy.
    - **Inheritance**: When a child class includes (or inherits) all the properties and methods of its parent class. This allows you to share and reuse code, which makes programs easier to understand and maintain.

Children inherit all properties of their parents but can have additional unique properties. In this way, child are **more specific** than their parent classes.
For example, a View is a parent class of both a TextView and ImageView. A TextView could have children such as a button or editText field. 

Codelab: See Dwelling.kt -- https://developer.android.com/codelabs/basic-android-kotlin-training-classes-and-inheritance?authuser=1&continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-2-pathway-1%3Fauthuser%3D1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-classes-and-inheritance#2 

*Abstract Class*: An abstract class is a class that cannot be fully instantiated because it is not fully implemented; think of it as a sketch. You use a sketch (abstract class) to create a blueprint (actual class) from which you build the actual object instance. 

It is beneficial to make a superclass to contain all common properties/functions of a subclass. If ALL of these shared values are not known, make the class abstract. 

"When you declare abstract functions and variables, it's like a promise you will give them values and implementations later". To do this use `override`.
