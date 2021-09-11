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

* **Class hierarchy**: An arrangement where classes are organized in a hierarchy of parents and children. Hierarchy diagrams are usually drawn with the parents shown above children.
* **Child** or **subclass**: Any class that is below another class in the hierarchy.
* **Parent** or **superclass** or **base class**: Any class with one or more child classes.
* **Root** or **top-level class**:  The class at the top (or root) of the class hierarchy.
* **Inheritance**: When a child class includes (or inherits) all the properties and methods of its parent class. This allows you to share and reuse code, which makes programs easier to understand and maintain.

Children inherit all properties of their parents but can have additional unique properties. In this way, child are **more specific** than their parent classes.
For example, a View is a parent class of both a TextView and ImageView. A TextView could have children such as a button or editText field. 

Codelab: See [Dwelling.kt](https://developer.android.com/codelabs/basic-android-kotlin-training-classes-and-inheritance?authuser=1&continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-2-pathway-1%3Fauthuser%3D1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-classes-and-inheritance#2) 

**Abstract Class**: An abstract class is a class that cannot be fully instantiated because it is not fully implemented; think of it as a sketch. You use a sketch (abstract class) to create a blueprint (actual class) from which you build the actual object instance. 

It is beneficial to make a superclass to contain all common properties/functions of a subclass. If ALL of these shared values are not known, make the class abstract. 

When you declare abstract functions and variables, it's like a promise you will give them values and implementations later".
To do this use "override".

```kotlin

abstract class Park {
    abstract val name: String 
    abstract val length: Number
    abstract val width: Number
    abstract fun getParkArea(): Number
}

class NationalMall: Park() {
    override val name = "The National Mall"
    override val length = 800
    override val width = 500
    override fun getParkArea(): Number{
        return length * width
    }
}
```
[Learn more](https://developer.android.com/codelabs/basic-android-kotlin-training-classes-and-inheritance?authuser=1&continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-2-pathway-1%3Fauthuser%3D1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-classes-and-inheritance#7)

#### [Create XML Layouts](https://developer.android.com/codelabs/basic-android-kotlin-training-xml-layouts?authuser=1&continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-2-pathway-1%3Fauthuser%3D1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-xml-layouts#0)

**Android JetPack** is a suite of libraries to help developers follow best practices, reduce boilerplate code, and write code that works consistently across Android versions and devices so that developers can focus on the code they care about.

Android Jetpack elements are imported with `androidx` in their name. XML elements will also start with this (ex `androidx.ConstraintLayout`)

##### High Level Attributes: 
You will notice some of the following attributes on certain components, especially those a the root of the XML file or app activity. 
```xml
<androidx.constraintlayout.widget.ConstraintLayout 
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity" >
    
<!-- Add other widgets here -->
    
</androidx.constraintlayout.widget.ConstraintLayout>
```
Attributes start with a *namespace* that tells the computer to what those attributes belong to. 
For example, `xmlns` is the XML namespace, while `android` is the android namespace. All attributes associated with XML files will start with `xmlns`, while all android system attributes will start with `android`. Another common attribute is `tool` which refers to the AS/tooling only.

These namespaces serve two general purposes: 
1. To distinguish between two elements that have the same name 
   * ex: `tools:text` and `android:text`
    
2. To group elements relating to a common idea together.


#### Constraint Layout Note! 
Note: you can not use `match_parent` in a constraint layout. Instead you need to use `0dp`. 

#### Reformat the XML
Android Studio provides various tools to tidy up your code and make sure it follows recommended coding conventions.

1. In `activity_main.xml`, choose Edit > Select All.
Choose Code > Reformat Code.

2. This will make sure the indenting is consistent, and it may reorder some of the XML of UI elements to group things, for example, putting all the android: attributes of one element together.


#### Gradle 

What's Gradle? 

Gradle is the automated build system used by Android Studio. Whenever you change code, add a resource, or make other changes to your app, Gradle figures out what has changed and takes the necessary steps to rebuild your app. It also installs your app in the emulator or physical device and controls its execution.

#### View Binding
One way to access elements of a view is via `findViewById()`. This method let's you define a view, then access the view elements like so: 
```kotlin
// In the Activity 

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // get view 
        val view = findViewById(R.layout.activity_main)
        // then access elements of the view to make dynamic changes
        view.myTextView.text = "update the text"
        view.myViewBtn.setOnClickListener {
            // set a listener
        }
        
    }
}
```

HOWEVER. Using `findViewById()` can be expense, especially as you have more views. A more scalable option is to use **view binding**. 

View binding requires a little more work upfront, but is a worthy investment if your app will contain multiple views. 

### Part 2: Get User App Input -- Themes and UI Enhancements

* A **style** is set of colors, looks, decorations on a view (ex: color of text, boldness, shadows, etc)
* A **theme** is styling for the entire app, not just ONE view.

A theme consists of a variety of colors that you can use throughout the app for various elements. Themes group colors into 12 groups to apply to various attributes. 
![image](./theme-colors.png)

To observe or edit the theme, go to the `theme.xml` file (app-> res -> values -> themes). To adjust the theme file, you need to define colors first in the `colors.xml`.

**DARK THEME**

To edit the theme for dark mode, change the file in res -> values-night -> `theme.xml`. *Why should you care about the dark theme?*
> Dark themes reduce the luminance emitted by device screens […]. They help improve visual ergonomics by reducing eye strain, adjusting brightness to current lighting conditions, and facilitating screen use in dark environments — all while conserving battery power [for OLED displays].

The above is from the android docs. See [here](https://medium.com/androiddevelopers/dark-theme-with-mdc-4c6fc357d956) 
for more on why and how to use dark theme. Also, check out
[this suggested practice lab](https://github.com/material-components/material-components-android-examples/blob/develop/MaterialThemeBuilder/README.md) 
for making your own material theme.

### Part 3: Display a Scrollable List 

A `List` is a collection of items with a specific order.

Kotlin has two types of lists: 
* `List`: read only; cannot be modified 
* `Mutable List`: can be modified after you create it. 

You can create a list by `listOf(1, 2, ..)` or `mutableListOf("hello", "world")`. If you want to make an empty list (esp
an empty mutable list if you are planning to add elements to it later), then you need to define the type of elements in 
the list when you declare it.  ex: `val mutList = mutableListOf<String>()`

Note: the index of a list is actually the offset of an element from the first element. For example, if you have a list like so: 
> val letters = listOf("a", "b", "c", "d"). 

Then `letters[2]` means return the element that is two spots from the first element, aka the third element. 
> letters[0] = a  // return the letter 0 elements from the first element ==> return the first element
> letters[1] = b  // return the letter 1 element from the first elemet 
> letters[2] = c  // return the letter 2 elements from the first element 
> letters[3] = d  // return the letter 3 elements from the first element 

Looping through lists: 

You can use both `while` and `for` loops to loop through items in a list. Here are some examples of unique was to use for loops:
```kotlin
// Note: Here are some other variations of what you can do with for loops, including using them with ranges with specific steps (instead of incrementing by 1 each time).

for (item in list) print(item) // Iterate over items in a list

for (item in 'b'..'g') print(item) // Range of characters in an alphabet

for (item in 1..5) print(item) // Range of numbers

for (item in 5 downTo 1) print(item) // Going backward

for (item in 3..6 step 2) print(item) // Prints: 35

// You can find more in the documentation listed at the end of this codelab.
```

`vararg`: you can use vararg when you have a method that takes in the same type of parameter n times. 
```kotlin
// ex if you have a method like so: 
class Pizza(
    val topping1: String, 
    val topping2: String,
    val topping3: String
)

// you can rewrite it like so: 
class Pizza(val toppings: List<String>)

// and even further rewrite it like:
class Pizza(vararg toppings: String)
```

Recyclerview: saves CPU by refilling containers on the screen as the user scrolls. 
![recyclerview_visual](./recyclerview-visual.png)

_Setting Up Data_

Data in android apps is usually kept in a class contained in a package called `model`

```
project
│   README.md
│   build.gradle.kts    
|
└───app
│   └───src
|       └───main
|           | AndroidManifest.xml
│           └───java
|           |   └───com.projectname
|           |       | ProjectActivity.kt
│           |       └─── **com.projectname.model**
│           └───res
```

Data that your app is *ready to consume/render* should be stored in this package. However, sometimes you will need to 
load and process data from some data source *before* your app can render it in the format you want.  You should make a 
`Data Source` class in a `data` package that handles loading and transforming data. 

RecyclerView contains 3 parts: 
* Items held in the recyclerview 
* Adapter - takes data and prepares it for a recyclerview
* View Holder - a pool of views for the recyclerview to use and display affirmations

How to add a RecyclerView: 
1. Add the XML component in your activity in a view group
   > 
   > ```xml
   >  <androidx.recyclerview.widget.RecyclerView
   >    android:id="@+id/recycler_view"
   >    android:layout_width="match_parent"
   >    android:layout_height="match_parent"
   >    android:scrollbars="vertical"
   >    app:layoutManager="LinearLayoutManager" />
   > ```
   > The XML of a RecyclerView should have a `layoutManager`. This manager handles how to display the items (ex: linearly or a grid). Some popular ones are `GridLayoutManager`, `LinearLayoutManager`, `StaggeredGridLayoutManager`.
   > <br>
   > <br>
   > To be able to scroll on a RecyclerView, add the following field: 
   > `android:scrollbars="vertical"`
   
2. Implement an Adapter: 
> Your app needs something to take data from the source and format it so each item can be displayed on the recyclerview. 
> An **Adapter** is a deign pattern that **adapts** data for this purpose. The recylcerview uses an adapter to figure out how to display data on the screen

A Note on RecyclerView Adapter and how things work: 
> When you run the app, RecyclerView uses the adapter to figure out how to display your data on screen. RecyclerView asks the adapter to create a new list item view for the first data item in your list. Once it has the view, it asks the adapter to provide the data to draw the item. This process repeats until the RecyclerView doesn't need any more views to fill the screen. If only 3 list item views fit on the screen at once, the RecyclerView only asks the adapter to prepare those 3 list item views (instead of all 10 list item views).
> Via [link](https://developer.android.com/codelabs/basic-android-kotlin-training-recyclerview-scrollable-list?authuser=1&continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-2-pathway-3%3Fauthuser%3D1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-recyclerview-scrollable-list#3)

An adpater has multiple parts: 


-------------------------------------------------------------
## Unit 3: Navigation

### Part 1: Collections in Kotlin
**Collections:** are a group of related items, like a list of words, or a set of employee records. The collection can be ordered or unordered. One type of collection is a list
*list*: ordered set of items but the items do not have to be unique 

Collections can be *mutable* or *immutable*. 

**Mutable:** able to be changed <br>
**Immutable:** unable to be changed. The list set at the definition is what it remain. 

You can create a list and run methods on it: 
```kotlin
val myList = listOf("S", "A", "R", "A", "H", "M", "U", "R", "R", "A" "Y")
println(myList.distinct())  // ["S", "A", "R", "H", "M", "U", "Y"]
println("There are ${myList.distinct().size} unique letters in my name")
```
<hr>

**Sets**: a set is a group of related items but unlike a list there can not be any duplicates. 
```kotlin
val mySet = myList.toSet()
println("my set: $mySet")
```

Sets are equal if they contain the same elements. 
```kotlin
val set1 = setOf(1, 2, 3)
val set2 = mutableSetOf(3, 2, 1)
println("$set1 == $set2 : ${set1 == set2}") // [1, 2, 3] == [3, 2, 1] : true
```

The most common function to preform on a set is checking if an item is in the set. You can do this with the `contains` method. 
```kotlin
println(mySet.contains("S")) // true
```
You can also find the intersection or union of two sets (just like the mathematical operations)

<hr> 

**Maps:**
A map, or dictionary, is another type of collection that consists of a set of *key-value pairs*, where keys are unique and allow you to look up certain values. Each key maps to exactly one value, but values can be duplicates. Values can be string, numbers, objects, or other collections. 
```kotlin
// map people to their sun moon and rising signs
val peopleToSigns = mutableMapOf<String, List<String>>(
    "Sarah" to listOf<String>("Scorpio", "Pisces", "Aquarius"), 
    "Sharon" to listOf<String>("Libra", "Aquarius", "Pisces"),
    "Rachel" to listOf<String>("Pisces", "Capricorn", "Leo")
)
println(peopleToSigns)
// {Sarah=[Scorpio, Pisces, Aquarius], Sharon=[Libra, Aquarius, Pisces], Rachel=[Pisces, Capricorn, Leo]}

// you can add new items like so:
peopleToSigns.put("Lauren", listOf("Leo", "Gemini", "Aries"))

// you can get specific people like so:
peopleToSigns["Sharon"]
```

There are a lot of commands you can run on collections such as `map`, `filter`, `forEach`, `sort` and more. 


Recall Lambdas and Higher Order Functions: 

* **Lambda**: A function with no name. 
   * ex: `peopleAges.forEach { print("${it.key} is ${it.value}") }`
* **Higher Order Function**: passing a function (a lambda) to another function, or returning a function from another function. 
  * ex: `map, forEach, filter`
   
   


### Part 2: Activities and Intents:
