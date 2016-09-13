#View Filters

At the beginning the only purpose was to blur all layers below.
Now you can do more :
- Blur background views easily
- Create custom filters and apply them to views backgrounds
<br/>
**Screenshot**

![Screenshot](https://cloud.githubusercontent.com/assets/8886687/18458361/c1b9227c-7975-11e6-8105-84a58c37c2aa.jpg)

<br/>
**Usage**
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
Any contributions are welcome
<br/>
[About me](https://about.me/mohammadmirrajabi)
[My Website](http://mirrajabi.ir)

