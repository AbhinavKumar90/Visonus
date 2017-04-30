package com.visonus.abhi.visonus;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        openCameraListener();
        openGallery();
    }

    //Method to open camera
    public void openCameraListener(){
        Button camera = (Button)findViewById(R.id.cameraButton);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent);
            }
        });
    }

    //Method to open gallery
    public void openGallery(){
        Button gallery = (Button)findViewById(R.id.uploadImage);
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
                startActivityForResult(intent, 12345);
            }
        });
    }

   /* protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // if the result is capturing Image
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 12345) {
            if (resultCode == RESULT_OK) {

                // successfully captured the image
                // launching upload activity
                launchUploadActivity(true);

            } else if (resultCode == RESULT_CANCELED) {

                // user cancelled Image capture
                Toast.makeText(getApplicationContext(),
                        "User cancelled image capture", Toast.LENGTH_SHORT)
                        .show();

            } else {
                // failed to capture image
                Toast.makeText(getApplicationContext(),
                        "Sorry! Failed to capture image", Toast.LENGTH_SHORT)
                        .show();
            }
        }

        else if(requestCode == 789 && resultCode == RESULT_OK
                && null != data)
        {
            Uri selectedImage = data.getData();
            String picturePath = getRealPathFromURI(selectedImage,
                    this);
            Intent i = new Intent(MainActivity.this, UploadActivity.class);
            i.putExtra("filePath", selectedImage);
            i.putExtra("isImage", isImage);
            startActivity(i);
        }
    }

    public String getRealPathFromURI(Uri contentURI, Activity context) {
        String[] projection = { MediaStore.Images.Media.DATA };
        @SuppressWarnings("deprecation")
        Cursor cursor = context.managedQuery(contentURI, projection, null,
                null, null);
        if (cursor == null)
            return null;
        int column_index = cursor
                .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        if (cursor.moveToFirst()) {
            String s = cursor.getString(column_index);
            // cursor.close();
            return s;
        }
        // cursor.close();
        return null;
    }

    private void launchUploadActivity(boolean isImage){
        Intent i = new Intent(MainActivity.this, UploadActivity.class);
        i.putExtra("filePath", fileUri.getPath());
        i.putExtra("isImage", isImage);
        startActivity(i);
    }

    private void browseImage(){
        try {
            Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            // Start the Intent
            fileUri = getOutputMediaFileUri(PICK_IMAGE);//this is m using for camera
            Log.w("ImageAddressOnClick pr", ""+fileUri);
            startActivityForResult(galleryIntent, 789);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),
                    e.getMessage()+"ye show hora h",
                    Toast.LENGTH_LONG).show();
            Log.e(e.getClass().getName(), e.getMessage(), e);
        }*/
}