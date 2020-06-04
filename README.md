# A micro frondend soluction: Router

The original version of this architecture is: https://github.com/LiushuiXiaoxia/AndroidModular, which is "solution Number 1" below in this article. This version and the new version I will introduce here have been adopted in our enterprise app for around 2 years. 

##### Our goal:

is to have an architecture, where we divide business logic into multiple micro front end modules(able to be put into a seperate repo), and they are able to communicate to each other while not depend on each other. 

##### To illustrate the idea, let us make this simple use case:

in the app, there are 2 businiss features, 
* search feature, where allows user save a search if the user logged in. 
* authentication feature, where allows user sign in. 

##### principles we want to use:

* seperation of concern
* program to an Interface, not an implementation. 


## Monolith

![Diagram](/image/techdiagram1.png)

in this diagram, the dependencies of 2 business blocks are, 

* Search block is Independent: program to an interface ISession(good).
* Auth block depends on Search block(problem): it need access class Search.kt and interface ISession in Search block. 

## Solution Number 1:
**What we want is:** to make Auth block also independent, while still can accss ISession and Search.kt.

*  To be able to access ISession interface, let us create a base module, which sit below the feature modules, problem solved.
*  To be able to access Search.kt, so that we can assign an implementation of ISession for Search.kt, wait a minutes.....

   so the real purpose actually is , let Search.kt get an implemtation of ISession.    
   To achieve this, we are going to introduce the **Router Dictionary** in **base module**.   
   The key/value pair of the dictionary is:` <interface: Class<T>, implementClass: Class<out T>> `
   Then
   - Auth module will add `<ISession::class.java, SessionImp::class.java>` into the dictionary
   - Search module will look up dictionary and use **Reflection to get an instance of SessionImp**.
  
   Problem solved! 

![Diagram](/image/techdiagram2.png)


#### Problem introduced
By adding ISession interface into base module, it violates the principle of clean architecture: **base module should NOT have any business logic**. if we think about another project2 will use this base module, and have a different ISession2 interfaces, we will end up ISession1 is not useless for project 2, and we will add more and more interfaces which other modules don't need. 
In this sense, the problem is base module actually couples with feature module logic. 

#### To solve this problem, let us move ISession back to Search module. 
like below, 

New prolem is, Auth module will not be able to access ISession interface again, see pink circles

![Diagram](/image/techdiagram3.png)





## Solution Number 2
1. Let us introduce another module Router/Coordinator, which sits above feature moduels. 
2. Let us add new interfaces in Auth, and let system know what Auth module can offer by adding them into Router Dictionary
   **note the green circle:**
   - make implmentation private, to NOT allow even Router module access it. 
   - make interface public, which expose this interface to router, and then router can only get the implemetation from  
   dictionary, which again an application of principle of "program to an interface"
   
* For Auth module, it adds what it can provide to dictionary, 
* For Search module, it exposes to Router module what it needs, and check dictionary if there is an implementation of it.
* For router module. it check dictionary to see if any module provides things Search module needs, and then implement it and add to this implemention dictionary

![Diagram](/image/techdiagram4.png)



## Final Version
![Diagram](/image/finaldiagram.png)

**Note!:**  Even app is not allowed to access feature module directly (as much as we can, except extreme cases). 
We also want to app be decoupled with feature modules. The 2-way talk between app and feature module is also done via Router Dictionary. 

- Refer to the demo app for examples: 
  - how app get the entry fragment of feature modules 
  - how feature module get configation from app module


## importatnt code about router dictionary:
- to add into dictionary
  ```
  fun <T> registerService(serviceClass: Class<T>, implementClass: Class<out T>)
  ```
- to look up dictionary
  ```
  fun <T> getServiceImplementClass(serviceClass: Class<T>): Class<out T>?
  ```
  - Helper class for looking up dictionary and get an instance by using reflection:
  ```
  public class InjectHelper {
    @Nullable
    public static <T> T getInstance(Class<T> tClass) {
        IModuleConfig config = getIModuleConfig();
        Class<? extends T> implementClass = config.getServiceImplementClass(tClass);
        if (implementClass != null) {
            try {
                return implementClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
  }
  ```
  - the we call : 
  ```
  ISearchReceiver searchReceiver = InjectHelper.getInstance(ISearchReceiver.class);
  ```


## Note:
  - IReceivedService can require things from multiple IProviderSerivces, including from App
  - There are 2 ways of routing between module A and module B:
    1. get the fragment/activity and navigate from module A
    2. pass content to router, let router do the navigation from A to B
    

