package in.edu.reva.myapplication;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by soul_reaper on 6/3/18.
 */

public class CulturalRecyclerAdapter extends RecyclerView.Adapter<CulturalRecyclerAdapter.ViewHolder> {

    private String[] CTitle = {"ART ATTACK", "Solo Singing", "Rangoli","Dance"};
    private String[] CDescription = {"Take up any instrument and draw, paint , colour on a sheet of paper/canvas.",
            "The event provides a platform to all the budding singers to mesmerize the audience.The participants will not be allowed to refer to the lyrics while singing.",
            "The time limit is 1 hour 30 mins, and the participants need to get their own supplies","Team as well as solo performers are welcome. Winner represents C&IT for REVAMP 2018."};
    private String[] CReg = {"50","50","100","Free!"};
    private String[] CPrizeMoney = {"500","500","1000","NA"};

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cultural_card, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CulturalRecyclerAdapter.ViewHolder viewHolder, int i) {
        viewHolder.CultTitle.setText(CTitle[i]);
        viewHolder.CDesc.setText(CDescription[i]);
        viewHolder.CRegAmount.setText(CReg[i]);
        viewHolder.CPrize.setText(CPrizeMoney[i]);
    }

    @Override
    public int getItemCount() {
        return CTitle.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView CultTitle;
        public TextView CDesc;
        public TextView CRegAmount;
        public TextView CPrize;

        public ViewHolder(final View itemView) {
            super(itemView);
            CultTitle = (TextView) itemView.findViewById(R.id.CTittle);
            CDesc = (TextView) itemView.findViewById(R.id.CDesc);
            CRegAmount = (TextView) itemView.findViewById(R.id.Creg);
            CPrize = (TextView) itemView.findViewById(R.id.CPrize);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    Intent i =new Intent(itemView.getContext(),Firebase.class);
                    //Send data to next activity
                    i.putExtra("regAmount",CRegAmount.getText().toString());
                    i.putExtra("Ename",CultTitle.getText().toString());
                    itemView.getContext().startActivity(i);

                }
            });
        }
    }
}





