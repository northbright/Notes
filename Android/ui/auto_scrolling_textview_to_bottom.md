
# Auto Scrolling TextView to Bottom

We may get the scroll amount and call scrollTo(): 

    import android.text.Layout;
    ......

    public void showMessage(String msg) {
        TextView outputText = (TextView)findViewById(R.id.output_text_view);
        outputText.append(msg + "\n");

        final Layout layout = outputText.getLayout();
        if (layout != null) {  // check if layout is null
            final int scrollAmount = layout.getLineTop(outputText.getLineCount()) - outputText.getHeight();
            // if there is no need to scroll, scrollAmount will be <=0
            if (scrollAmount > 0)
                outputText.scrollTo(0, scrollAmount);
            else
                outputText.scrollTo(0, 0);
        }
    }
    
#### References
* <http://stackoverflow.com/questions/3506696/auto-scrolling-textview-in-android-to-bring-text-into-view>