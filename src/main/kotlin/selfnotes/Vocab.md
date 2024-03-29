# Vocab 

## A

### ACTION_VIEW
> A generic intent that takes in a URI. Kdoc calls it "the most common action performed on data -- it is the generic action you can use on a piece of data to get the most reasonable thing to occur"
> Examples of uses include passing a URL for a webview to open, passing a `mailto` or `tel` URI.

### Activity
> Single, focused thing that the user can do. Class that creates a window for you in which you can place your app's UI. Almost all activities interact with the user. 
>
> The activity lifecycle drives the various UI states of your application. Almost all activities will handle `onCreate` and `onPause` methods. Each app should have at least one activity and it should be defined in the XML. 
> 

### Adapter 
> An element of code necessary for a recyclerview. The adapter makes view holders and runs operations when those view holders are bound to the parent group. 

## B 

## C 

### Compile Time Constant 
> variables in kotlin defined with the `const` keyword are *compile time constants*, meaning their value won't change.

### Configuration Change 
> A configuration change happens when the state of the device changes so radically that the easiest way for the system to resolve the change is to completely shut down and rebuild the activity.
> 
> Ex: user changes language, device is rotated, etc. 

### Control Flow (Kotlin)
> Control flow is the order in which a computer executes statements in a script. 
> Code is run in order from first line to last line except in structures that change the control flow such as conditionals and loops

### Coroutines (Kotlin)

## D 

## E 

## F 
### Fragments 
> Fragments are a subclass of `Activity` and a reusable portion of your app's UI. 
> Fragments can be used to better modularize code and allow for better scaling.
> 
> Fragments **must** be hosted by an activity or another fragment.
> Fragment view hierarchy becomes attached to the host's view hierarchy.
> 
> Fragments are for modular UI (so you can add, remove, rearrange and duplicate these components anywhere and keep track
> of them in the backstack). With this is mind fragments should only contain the information they need for their 
> piece of the UI and you should *not* modify one fragment from another

## G 
### Garbage Collection 
> Garbage collection refers to the automatic cleanup of objects that you'll no longer use.
> 
> Ex: After `onDestroy()` is called, the system knows that those resources are discardable, and it starts cleaning up that memory.

## H
### Higher Order Functions 
> passing a function (generally a [lambda](#lambda)) into another function as a parameter 
> functions that return another function are also higher order functions
> ex: `map`, `filter`, `forEach` - these methods all take in a function to perform that operation on a collection
> more ex: `onClickListener`s for android UI elements. 

## I 
### Intents 
> An object representing some action to be performed. There are two types: explicit and implicit. 
> Explicit is specific, usually when you are performing an action (ex: launching an activity) within your app, so you know where the user is going
> Implicit is more abstract, like when you launch a link or another app from your app (ex: email, text, etc). 

## J 

## K 

## L 
### Lifecycle 
> You should be able to name all lifecycle states (5) and methods (at least 8)
> Fill out this chart: 
> ```markdown
>  -----------------------------
> |           State 4           | // activity visible and focuses 
>  -----------------------------
>            ^                |
>   method 4 |       method 5 |
>            |                v
>  -----------------------------
> |           State 3           | // activity visible 
>  -----------------------------
>            ^                |
>   method 2 |      method 6  |
>   method 3 |                v
>  ------------------------------
> |           State 2            |
>  ------------------------------
>            ^                |
>   method 1 |       method 7 |
>            |                v
>  -------------    -------------
> |   State 1   |  |   State 5   |
>  -------------    -------------
>  ```

### Lambda 
> A function with no name
> ```kotlin
> // ex: 
> myMap.forEach { print("\${it.key} is \${it.value}") }
> ```
See [Higher Order Functions](#higher-order-functions)

### Layout Inflater 
> A **LayoutInfater** class is used to dynamically add views to an android app at runtime. These views are not included in the static XMl of the layout but are instead **added** or **inflated** at runtime.
> <br>
> Usually the layout inflater is defined like so: 
> ```kotlin
> LayoutInflater.from(parent.context)
>   .inflate(@ResInt itemToAttach, parentViewToAttachItemTo, attachToRootBoolean)
> ```
> Where the parentView is usually the recyclerView itself and the attachToRoot bool can be thought of as "do you want to attach this item to the view right now or later?".
* [Android Doc](https://developer.android.com/reference/android/view/LayoutInflater)

## M 
### Menu XML Tags
> the menu resource defines what options are displayed in the app bar, including which icons to use. 
> This resource is defined as its own resource and lives in the `/menu` directory (`res/menu/layout_menu`) like how string values live in `res/values/strings.xml`.
> There are a few different types of menus including and options menu, a popup menu, and a context menu. See [here](https://developer.android.com/guide/topics/ui/menus) for more
> Menus are defined in XML and then inflated in the activity.

## N 

## O 

## P 

## Q 

## R 

## S 

## T 

## U 
### URI 
> Uniform Resource Identifier, more general form of URL. A string of characters used to identify or name a resource
> Protocols include http & ftp
> All URLs are URIs but not all URIs are URLs
> URLs = square, URI = rectangle 
> Other URIs include "tel:1-900-345-6789" or "mailto:email@you.com"
> ![uri-url-urn](./images/URI-URL-URN.png)

### URL 
> Uniform Resource Locator, a string that turns into a webpage

### URN
> Uniform Resource Name, ex: "tel:1-900-345-6789"

## V
### ViewBinding 
> One way binding that binds views (XML layouts) to code, but not vice versa. 
> A binding class is generated for each XML layout. 
> 
> An instance of the binding class contains references to all the views by their ID. So, assuming you have a 
> fragment like `my_fragment_layout.xml`, and you bind that fragment, you can access all elements of the binding via `binding.myTextView`, etc. 
> See "Questions to Know" for steps to add view binding to your app

## W 

## X

## Y 

## Z