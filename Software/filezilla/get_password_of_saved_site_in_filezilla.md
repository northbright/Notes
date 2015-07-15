# Get Password of Saved Site in FileZilla

#### Export Site

* Open "File" -> "Site Manager"
* Select your site(select the root `My Sites` if you want to export all sites profiles)
* Right Click and Select "Export" to export current site profile in a XML file(`sites.xml`)

#### Get Password in `sites.xml`

    <Server>
        <Host>xx.xx.xx</Host> 
        <Port>21</Port> 
        <User>USERNAME</User> 
        <Pass>PASSWORD</Pass> 
    .....
    </Server>