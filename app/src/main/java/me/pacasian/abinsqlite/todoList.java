package me.pacasian.abinsqlite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class todoList extends AppCompatActivity {

    String AdminLevel;
    private ArrayList<ModelClass> itemArrayList;  //List items Array
    private MyAppAdapter myAppAdapter; //Array Adapter
    private RecyclerView recyclerView; //RecyclerView
    private RecyclerView.LayoutManager mLayoutManager;
    private boolean success = false; // boolean
     DatabaseHelper databaseHelper; //Connection Class Variable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);
        //AdminLevel=getIntent().getExtras().getString("level");


        Toast.makeText(this, AdminLevel, Toast.LENGTH_SHORT).show();

        TextView txtLeveLNot = findViewById(R.id.Textvv);
        txtLeveLNot.setText(" Viewing Todo Under " + AdminLevel);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView); //Recylcerview Declaration
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        databaseHelper = new DatabaseHelper(this); // Connection Class Initialization
        itemArrayList = new ArrayList<ModelClass>(); // Arraylist Initialization

        Cursor res = databaseHelper.getAllData();
        if (res.getCount() == 0) {
            // show message
            Toast.makeText(this, "Nothing found", Toast.LENGTH_SHORT).show();
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            itemArrayList.add(new ModelClass(res.getString(0),res.getString(1),res.getString(2)));
            /**
             *
            buffer.append("Id :" + res.getString(0) + "\n");
            buffer.append("Name :" + res.getString(1) + "\n");
            buffer.append("Company Name :" + res.getString(2) + "\n");

             */
        }
        myAppAdapter = new MyAppAdapter(itemArrayList , todoList.this);
        recyclerView.setAdapter(myAppAdapter);

        // Show all data
        Toast.makeText(this, "Data \n"+ buffer.toString(), Toast.LENGTH_SHORT).show();
    }
    public class MyAppAdapter extends RecyclerView.Adapter<MyAppAdapter.ViewHolder> {
        private List<ModelClass> values;
        public Context context;



        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
        {
            // public image title and image url
            public TextView showType;
            public TextView showTD;
            public View layout;

            public ViewHolder(View v)
            {
                super(v);
                v.setOnClickListener(this);
                layout = v;
                showType = (TextView) v.findViewById(R.id.matter);
                showTD = (TextView) v.findViewById(R.id.date);
            }

            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "position = " + itemArrayList.get(getLayoutPosition()).matter, Toast.LENGTH_SHORT).show();
               // Intent intent =new Intent(GrevienceListView.this,GrevienceAdmin.class);
                //intent.putExtra("idNumber",itemArrayList.get(getLayoutPosition()).number+"");
                //startActivity(intent);
                //System.out.println(itemArrayList.getClass());
                //String wh,loca,add;
                if(itemArrayList.contains(3)){//check if the list contains the element
                    System.out.println(itemArrayList.get(itemArrayList.indexOf(3)));//get the element by passing the index of the element
                }
                //go through each item if you have few items within recycler view
                if(getLayoutPosition()==0){
                    //Do whatever you want here

                }else if(getLayoutPosition()==1){
                    //Do whatever you want here

                }else if(getLayoutPosition()==2){

                }else if(getLayoutPosition()==3){

                }else if(getLayoutPosition()==4){

                }else if(getLayoutPosition()==5){

                }

                //or you can use For loop if you have long list of items. Use its length or size of the list as
                for(int i = 0; i<itemArrayList.size(); i++){
                    //itemArrayList.set(1)
                    //System.out.println(itemArrayList.get(i));
                    //System.out.println("itemArrayList.get(i)");
                    // System.out.println(());
                    /**
                     */
                }
            }
        }

        // Constructor
        public MyAppAdapter(List<ModelClass> myDataset, Context context)
        {
            values = myDataset;
            this.context = context;
        }

        // Create new views (invoked by the layout manager) and inflates
        @Override
        public MyAppAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            // create a new view
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View v = inflater.inflate(R.layout.todo_list_model, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        // Binding items to the view
        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {

            final ModelClass todoModel = values.get(position);
            holder.showType.setText(todoModel.getMatter());
            // Seperate the time and date and only show the date
            //String[] dateTime = todoModel.getImg().split("\\s+");
            //System.out.println();
            holder.showTD.setText(todoModel.getDate());

            //Picasso.with(context).load("http://"+classListItems.getImg()).into(holder.imageView);
        }


        // get item count returns the list item count
        @Override
        public int getItemCount() {
            return values.size();
        }

    }
}
/*



 */