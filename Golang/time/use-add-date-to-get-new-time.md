# Use `AddDate` to Get New Time

#### Problem
* We have a start date.
* We want to know the new date after XX days added.

#### Solution
* Use [AddDate](http://godoc.org/time#Time.AddDate)

AddDate normalizes its result in the same way that Date does, so, for example, adding one month to October 31 yields December 1, the normalized form for November 31. 

        loc, _ := time.LoadLocation("Local")
	startTime := time.Date(int(year), time.Month(month), int(day), 0, 0, 0, 0, loc)
        t := startTime.AddDate(0, 0, 1)

#### References
* [AddDate](http://godoc.org/time#Time.AddDate)
