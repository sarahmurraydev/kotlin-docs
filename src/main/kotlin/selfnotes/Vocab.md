# Vocab 

## A 
 

## L 

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
