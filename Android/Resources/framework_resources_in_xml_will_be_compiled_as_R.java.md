
# Framework Resources in XML Will be Compiled as R.java

Resource in xml files under `framework/base/core/res/res` will be compiled as:  
`out/target/common/obj/APPS/framework-res_intermediates/src/com/android/internal/R.java`

If you want to add some new resources in framework:  

* Add the resource at the end of xml file - That will keep exsiting resource ids no change. 
* If you insert the new resources before exsiting resource and some APK will failed to load the resource if it use resource id to find the resource(resource id will changed after new resource inserted).