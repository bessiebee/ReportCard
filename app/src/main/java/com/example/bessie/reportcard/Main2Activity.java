package com.example.bessie.reportcard;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    DataBaseHelper myDb;
    EditText editName, editSurname, editMarks, editID;
    Button btnAddData;
    Button btnviewAll;
    Button btnUpdate;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        myDb= new DataBaseHelper(this);
        editName = (EditText)findViewById(R.id.etName);
        editSurname = (EditText)findViewById(R.id.editText_surname);
        editMarks = (EditText)findViewById(R.id.editText_marks);
        editID = (EditText)findViewById(R.id.editText_id);
        btnAddData = (Button)findViewById(R.id.button2_Add);
        btnviewAll= (Button)findViewById(R.id.viewBtn);
        btnUpdate = (Button)findViewById(R.id.updatebtn);
        btnDelete = (Button)findViewById(R.id.btndelete);
        AddData();
        viewAll();
        UpdateData();
        DeleteData();
    }

    public void DeleteData(){
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(editID.getText().toString());

                        if(deletedRows > 0)
                            Toast.makeText(Main2Activity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Main2Activity.this,"Data not Deleted",Toast.LENGTH_LONG).show();

                    }
                }
        );
    }

    public void UpdateData (){

        btnUpdate.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                    boolean isUpdate = myDb.updateData(editID.getText().toString(),
                            editName.getText().toString(),
                            editSurname.getText().toString(),
                            editMarks.getText().toString());

                        if(isUpdate == true)
                            Toast.makeText(Main2Activity.this,"Data Updated",Toast.LENGTH_LONG).show();
                            else
                            Toast.makeText(Main2Activity.this,"Data not Updated",Toast.LENGTH_LONG).show();


                    }
                }

        );

    }

    public void AddData(){

        btnAddData.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                 boolean isInserted = myDb.insertData(editName.getText().toString(),
                        editSurname.getText().toString(),
                        editMarks.getText().toString());
                        if(isInserted ==true)
                            Toast.makeText(Main2Activity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Main2Activity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }

        );




                        }
    public void viewAll(){
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if (res.getCount() == 0) {
                            //show message

                            showmessage("Error", "Nothing found");

                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :" + res.getString(0)+"\n");
                            buffer.append("Name :" + res.getString(1)+"\n");
                            buffer.append("Surname :" + res.getString(2)+"\n");
                            buffer.append("Marks :" + res.getString(3)+"\n\n");
                        }
                        //show all data
                        showmessage("Data",buffer.toString());

                    }
                }
        );
    }

    public void showmessage(String title, String message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    }





