package com.mostafaabdel_fatah.captureimage;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    final  int requestCode = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView =(ImageView) findViewById(R.id.imageView);
    }

    public void CaptureImage_btnClicked(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File file = getFile();
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file) );
        startActivityForResult(intent,requestCode);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String path = "sdcard/camerapictures/picture1.jpg";
        imageView.setImageDrawable(Drawable.createFromPath(path));
    }

    private File getFile(){
        File folder = new File("sdcard/camerapictures");
        if (!folder.exists())
            folder.mkdir();
        File file = new File(folder,"picture1.jpg");
        return file;
    }
}
