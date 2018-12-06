package srujan.com.tryvol;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.File;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        readFileFromInternalStorage();
    }

    private void readFileFromInternalStorage() {
        ImageView imageView = (ImageView) findViewById(R.id.image);
        ContextWrapper cw = new ContextWrapper(this);

        //path to /data/data/yourapp/app_data/dirName
        File directory = cw.getDir("WhatsApp Profile", Context.MODE_PRIVATE);
        File mypath = new File(directory, "srujan.jpg");

        imageView.setImageDrawable(Drawable.createFromPath(mypath.toString()));


    }

}
