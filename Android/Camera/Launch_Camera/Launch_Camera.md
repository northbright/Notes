
# How to Launch Camera

Use `MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA` to launch camera app on device.

    public void launchCamera() {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                        | Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            // This will only occur if Camera was disabled while Gallery is open
            // since we cache our availability check. Just abort the attempt.
            Log.e("CameraLauncher", "Camera activity previously detected but cannot be found", e);
        }
    }

Sample Code:  
[./CameraLauncher](./CameraLauncher)
