
# Hotseats Bar and Search Bar Will Be Vertical for Landscape Mode if swXXdp is Less than sw720dp

You may find `hotseat.xml` under `res`:   

    packages/apps/Launcher2/res$ find -name "hotseat.xml"
    ./layout-land/hotseat.xml
    ./layout-port/hotseat.xml
    ./layout-sw720dp/hotseat.xml

* `./layout-land/hotseat.xml`:  

        launcher:cellCountX="1"  <!-- Vertical Mode -->
        launcher:cellCountY="@integer/hotseat_cell_count">

* `./layout-port/hotseat.xml` and `./layout-sw720dp/hotseat.xml`:

        launcher:cellCountX="@integer/hotseat_cell_count"
        launcher:cellCountY="1">  <!-- HorizontalMode -->


Search Bar is the same behavior as Hotseats bar: 
 
    packages/apps/Launcher2/res$ find -name "search_bar.xml"
    ./layout-land/search_bar.xml
    ./layout-port/search_bar.xml
    ./layout-sw720dp/search_bar.xml
