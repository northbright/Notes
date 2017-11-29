# Use `.each()` to Iterate JSON Array and Objects

#### For JSON Array

    var campuses = ["A", "B"];
    
    $.each(campuses, function(index, value) {
        console.log(index + ":" + value);
    });

#### For JSON Object

    var data = {"A":["P1", "P2"], "B":["P3", "P4"]};
    
    $.each(campusPeriods, function(key, value) {
        console.log("key: " + key + ", value:" + value);
    });

#### References
* [jQuery.each()](http://api.jquery.com/jQuery.each/)
