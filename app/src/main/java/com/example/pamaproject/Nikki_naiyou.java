package com.example.pamaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Calendar;

public class Nikki_naiyou extends AppCompatActivity implements View.OnClickListener {
    ImageButton bo_back;
    Button bo_back2,button;
    EditText nikkinaiyou;
    ImageView photo;
    String hi,tuki,nen,nai;



    private static final int RESULT_PICK_IMAGEFILE = 1001;
    private TextView textView;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nikki_naiyou);

        bo_back =(ImageButton) findViewById(R.id.bo_back);
        bo_back2 =(Button) findViewById(R.id.bo_back2);
        button =(Button)findViewById(R.id.button);
        nikkinaiyou = (EditText) findViewById(R.id.nikkinaiyou);
        photo =(ImageView) findViewById(R.id.image_view);
        bo_back.setOnClickListener(this);
        bo_back2.setOnClickListener(this);
        button.setOnClickListener(this);


        //日付け取得
        Intent intent1;
        intent1 = getIntent();
        hi = intent1.getStringExtra("hi");
        tuki = intent1.getStringExtra("tuki");
        nen = intent1.getStringExtra("nen");
        //日付けの挿入
        TextView textdate =(TextView)findViewById(R.id.textdate);
        textdate.setText(nen+"/"+tuki+"/"+hi);




        //内容取得、挿入
        nai = intent1.getStringExtra("nai");

        nikkinaiyou.setText(nai);
        if(nai == ""){
            nikkinaiyou.setText("日記");
        }


        //textView = findViewById(R.id.text_view);

        imageView = findViewById(R.id.image_view);

        Button button = findViewById(R.id.button);
        imageView.setOnClickListener( v -> {
            // ACTION_OPEN_DOCUMENT is the intent to choose a file via the system's file browser.
            Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);

            // Filter to only show results that can be "opened", such as a
            // file (as opposed to a list of contacts or timezones)
            intent.addCategory(Intent.CATEGORY_OPENABLE);

            // Filter to show only images, using the image MIME data type.
            // it would be "*/*".
            intent.setType("*/*");

            startActivityForResult(intent, RESULT_PICK_IMAGEFILE);
        });



    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent resultData) {
        super.onActivityResult(requestCode, resultCode, resultData);

        // The ACTION_OPEN_DOCUMENT intent was sent with the request code
        // READ_REQUEST_CODE. If the request code seen here doesn't match, it's the
        // response to some other intent, and the code below shouldn't run at all.
        if (requestCode == RESULT_PICK_IMAGEFILE && resultCode == Activity.RESULT_OK) {
            // The document selected by the user won't be returned in the intent.
            // Instead, a URI to that document will be contained in the return intent
            // provided to this method as a parameter.
            // Pull that URI using resultData.getData().
            if(resultData.getData() != null){

                ParcelFileDescriptor pfDescriptor = null;
                try{
                    Uri uri = resultData.getData();
                    // Uriを表示
//                    textView.setText(
//                            String.format(Locale.US, "Uri:　%s",uri.toString()));

                    pfDescriptor = getContentResolver().openFileDescriptor(uri, "r");
                    if(pfDescriptor != null){
                        FileDescriptor fileDescriptor = pfDescriptor.getFileDescriptor();
                        Bitmap bmp = BitmapFactory.decodeFileDescriptor(fileDescriptor);
                        pfDescriptor.close();
                        imageView.setImageBitmap(bmp);


                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try{
                        if(pfDescriptor != null){
                            pfDescriptor.close();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if(v==bo_back || v==bo_back2){
            intent = new Intent(this,Nikki.class);
            intent.putExtra("tuki",tuki);
            intent.putExtra("nen",nen);
            startActivity(intent);
        }


    }


}
