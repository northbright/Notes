
# Difference between this and Activity.this

`this` may refer to your current object of inner class of your activity.  
`Activity.this` points to the instance of the Activity you are currently in:

        public class MyActivity extends Activity {
        ......
            private class MyTask extends AsyncTask {
                @Override
                protected void onPostExecute(Void result) {
                    // WRONG: "this" points to instance of inner class(MyTask).  
                    // this.finish();
                    
                    // "Activity.this" points to the instance of the Activity you are currently in.
                    MyActivity.this.finish();
                }
            }
        }

#### References

* <http://stackoverflow.com/questions/10102151/whats-the-difference-between-this-and-activity-this>