package in.edu.reva.myapplication;

/**
 * Created by soul_reaper on 5/3/18.
 */

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class RecreationalAdapter extends RecyclerView.Adapter<RecreationalAdapter.ViewHolder>
{

    private String[] RTitle = {"NFS MW 2005", "COUNTER STRIKE 1.6", "Cooking W/O FIRE","Hogathon","V-logging","Arm Wrestling"};
    private String[] RDescription = {"Arcade racing game, be the first one across the finish line to win.","FPS shooter, max. 5 in a team, 3 min. rounds",
                                     "Create the best dish fit for consumption without fire.",
                                      "Eat as much as you can faster than others",
                                      "Make a  V-Log of all the events and submit post Saviskara , duration 2 min.",
                                      "Show'em who's the strongest ! Free event ! "

                                    };

    private String[] RRegAmount = {"50", "100", "50", "50", "50","Free!"};
    private String[] RPrizeMoney = {"1000", "1500", "500", "500", "500","100"};

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recreational_card, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i)
    {
        viewHolder.RTitle.setText(RTitle[i]);
        viewHolder.RDesc.setText(RDescription[i]);
        viewHolder.RecreationalRegAmount.setText(RRegAmount[i]);
        viewHolder.RPrize.setText(RPrizeMoney[i]);
    }

    @Override
    public int getItemCount() {
        return RTitle.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView RTitle;
        public TextView RDesc;
        public TextView RecreationalRegAmount;
        public TextView RPrize;

        public ViewHolder(final View itemView) {
            super(itemView);
            RTitle = (TextView) itemView.findViewById(R.id.RTittle);
            RDesc = (TextView) itemView.findViewById(R.id.RDesc);
            RecreationalRegAmount = (TextView)itemView.findViewById(R.id.Rreg);
            RPrize = (TextView)itemView.findViewById(R.id.RPrize);
            //go to registration form
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    Intent i =new Intent(itemView.getContext(),Firebase.class);
                    //send to next intent
                    i.putExtra("regAmount",RecreationalRegAmount.getText().toString());
                    i.putExtra("Ename",RTitle.getText().toString());
                    itemView.getContext().startActivity(i);

                }
            });
        }
    }
}




