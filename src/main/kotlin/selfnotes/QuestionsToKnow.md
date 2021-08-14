# Questions You Should Be Able to Answer 

## Kotlin 
* What's the difference between a class and abstract class? What's the difference between a class and an interface?

## Android 
* What's view binding? Why should you use it?  
* What are prefixes on XML attributes such as `xmlns` or `app`?
* What should you set the width of an element within a constraint layout?



# Answers

## Kotlin
* What's the difference between a class and abstract class? What's the difference between a class and an interface?
> 

## Android
* What's view binding? Why should you use it?
  > View binding is a way to select and dynamic adjust elements of a view. You should use it over `findViewById()` because it is less expensive and more scalable
* What are prefixes on XML attributes such as `xmlns` or `app`?
  > These prefixes are known as namespaces. Namespaces help associate attributes with a given item: XML, android, the app, tools, etc. Namespaces serve two purposes. 1) To distinguish between attritbutes of the same name and 2) to allow attributes that affect the same space to be grouped together.
* What should you set the width of an element within a constraint layout?
  > `match_parent` cannot be used in a constraint layout. Instead, developers should use `0dp` to mean "match the constraints"