**源码分析**

NavHostFragment

**create(int graphResId, Bundle startDestinationArgs)**

1. 初始化Bundle将startDestinationArgs存入该Bundle

2. 创建NavHostFragment并返回

**onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState)**

1. 解析xml中的两个属性
   - app:navGraph  navGraph
   - app:name         defaultNavHost

**onCreate**

​    创建mNavController    

​    调用onCreateNavController

​        mNavController.getNavigatorProvider().addNavigator(createFragmentNavigator())

​        创建FragmentNavigator

​    NavigatorProvider

```java
// key: 类全限定名 value: Navigator
private final HashMap<String, Navigator<? extends NavDestination>> 
  mNavigators = new HashMap<>();
```



**Navigator的几个重要的实现类**

```java
FragmentNavigator()
ActivityNavigator()
NavGraphNavigator()
DiaglogFragmentNavigator()
```

Navigator 能够实例化对应的NavDestination，实现导航功能，拥有自己的回退栈



**NavController分析**



**NavInflater**解析xml生成NavDestination





















