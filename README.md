#View Filters
[![](https://jitpack.io/v/mirrajabi/ViewEffects.svg)](https://jitpack.io/#mirrajabi/ViewEffects) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-ViewEffects-green.svg?style=true)](https://android-arsenal.com/details/1/4360)&nbsp;<a href="http://www.methodscount.com/?lib=com.github.mirrajabi%3AViewEffects%3A1.0"><img src="https://img.shields.io/badge/Methods and size-50 | 8 KB-e91e63.svg"/></a>

At the beginning the only purpose was to blur all layers below.
Now you can do more :
- Blur background views easily
- Create custom filters and apply them to views backgrounds

###Screenshot
![](https://cloud.githubusercontent.com/assets/8886687/18458361/c1b9227c-7975-11e6-8105-84a58c37c2aa.jpg)![](https://cloud.githubusercontent.com/assets/8886687/18769067/bab40082-8136-11e6-9083-90a74fc86fde.jpg)


###Usage
First add jitpack to your projects build.gradle file
```	
allprojects {
   	repositories {
   		...
   		maven { url "https://jitpack.io" }
   	}
}
```
Then add the dependency in modules build.gradle file
```
dependencies {
	  compile 'com.github.mirrajabi:ViewEffects:e355a1bac4'
 }
```
Just do the normal ui stuff
```xml
<RelativeLayout
     android:layout_width="match_parent" 
     android:layout_height="match_parent"
     android:id="@+id/root_view">
     <View
         android:layout_width="match_parent"
         android:layout_height="100dp"
         android:layout_marginTop="100dp"
         android:layout_marginLeft="20dp"
         android:layout_marginRight="10dp"
         android:id="@+id/my_view"/>
</RelativeLayout>
```

Then in your code : 
```java
ViewFilter.getInstance(this)
          //Use blur effect or implement your custom IRenderer
          .setRenderer(new BlurRenderer(16)) 
          .applyFilterOnView(findViewById(R.id.my_view),
                            findViewById(R.id.root_view));
```

You can also implement your own  [_IRenderer_](https://github.com/mirrajabi/ViewEffects/blob/master/library/src/main/java/ir/mirrajabi/viewfilter/core/IRenderer.java) and use it as the renderer.
in some situations you might want the view background to handle it yourself
```
ViewFilter.getInstance(this)
          .getFilteredBackgroundOfView(findViewById(R.id.my_view),
                                       findViewById(R.id.root_view));
```
#####Any contributions are welcome

######[About me](https://about.me/mohammadmirrajabi)
######[My Website](http://mirrajabi.ir)

