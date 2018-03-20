package in.edu.reva.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by soul_reaper on 20/3/18.
 */

public class Venue_Time_Adapter extends RecyclerView.Adapter<Venue_Time_Adapter.ViewHolder> {

    private String[] ENames = {"Technical Quiz", "Port The Code", "Technosapien", "Bug Hunter", "Need For Speed", "Counter Strike", "Hogathon", "Solo Singing", "Cooking W/O Fire", "Art Attack","Dance Auditions"};
    private String[] Evenue = {"Seminar Hall, C&IT Block", "S1 and S2 Lab,C&IT Block", "F1 & F2 lab C&IT Block", "T1 & T2 Lab C&IT Block", "Room No. 207 Lab,C&IT Block", "Room No.207 Lab,C&IT Block", "Open Amphitheatre", "Seminar Hall, C&IT Block", "Seminar Hall, C&IT block", "Floor Space 2nd Floor , C&IT block","Open Amphitheatre"};
    private String[] Edate = {"23/03", "23/03 ", "23/03 ", "23/03 ", "22/03 ", "22/03 ", "23/03 ", "22/03 ", "23/03 ", "22/03","22/03"};
    private String[] Etime ={"10:00 AM","1:00 PM","2:00 PM","2:00 PM","2:00 PM","2:00 PM","11:00 AM","2:00 PM","9:00 AM","2:00 PM","3:00 PM"};
    @Override
    public Venue_Time_Adapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.venue_card, viewGroup, false);
       ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Venue_Time_Adapter.ViewHolder viewHolder, int i) {
        viewHolder.evName.setText(ENames[i]);
        viewHolder.evenue.setText(Evenue[i]);
        viewHolder.evdate.setText(Edate[i]);
        viewHolder.etime.setText(Etime[i]);
    }

    @Override
    public int getItemCount() {
        return ENames.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public int currentItem;
        public TextView evName;
        public TextView evenue;
        public TextView evdate;
        public TextView etime;


        public ViewHolder(final View itemView) {
            super(itemView);
            evName = (TextView) itemView.findViewById(R.id.Evname);
            evenue = (TextView) itemView.findViewById(R.id.Evenue);
            evdate = (TextView) itemView.findViewById(R.id.Edate);
            etime  = (TextView) itemView.findViewById(R.id.Etime);
        }
    }
}













