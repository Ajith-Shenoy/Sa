package in.edu.reva.myapplication;

/**
 * Created by Ajith on 3/03/18
 */

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import in.edu.reva.myapplication.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private String[] Names = {"Anuj","Sai Venkat","Vishal","Tanmay"};

    private String[] Contact = {"09999847434","09113594528","8197550774","9035895092"};

    private String[] Department = {"Student President","Cultural & Re-creational Dept.","Technical Dept.","Venue & Management"};

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.itemName.setText(Names[i]);
        viewHolder.itemContact.setText(Contact[i]);
        viewHolder.itemDept.setText(Department[i]);
    }

    @Override
    public int getItemCount() {
        return Names.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        public int currentItem;
        public TextView itemName;
        public TextView itemContact;
        public TextView itemDept;

        public ViewHolder(final View itemView)
        {
            super(itemView);
            itemName = (TextView)itemView.findViewById(R.id.name);
            itemContact= (TextView)itemView.findViewById(R.id.contact);
            itemDept = (TextView)itemView.findViewById(R.id.dept);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();
                    //get no. to call
                    String dial = itemContact.getText().toString();
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel",dial,null));
                    itemView.getContext().startActivity(intent);

                }
            });
        }
    }
}