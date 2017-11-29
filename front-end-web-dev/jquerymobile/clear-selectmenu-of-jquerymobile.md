# Clear Select Menu of jQueryMobile

#### Problem
* We use `$('#select_id').html('')` to clear select but selected option still remains.

#### Solution
* Call `refresh()` after `$('#select_id').empty()` or `$('#select_id').html('')`

        $('#select_id').html('')
        $('#select_id').selectmenu("refresh");

#### Reference
* [Selectmenu Widget](https://api.jquerymobile.com/selectmenu/)



