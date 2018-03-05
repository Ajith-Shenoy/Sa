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

    private String[] RTitle = {"NFS MW 2005", "COUNTER STRIKE 1.6", "Cooking W/O FIRE","Hogathon","Blogging"};
    private String[] RDescription = {"Arcade racing game, be the first one across the finish line to win.","FPS shooter, max. 5 in a team, 3 min. rounds",
                                     "Create the best dish fit for consumtion without fire.",
                                      "Eat as much as you can faster than others",
                                      "Make a  V-Log of all the events of SAVISKARA and make a 2 minutes video."
                                    };

    private String[] RRegAmount = {"Reg.Amount: 50", "Reg.Amount: 100", "Reg.Amount: 50", "Reg.Amount: 50", "Reg.Amount: 50"};
    private String[] RPrizeMoney = {"Prize : 1000", "Prize : 1500", "Prize : 500", "Prize : 500", "Prize : 500"};

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
                    itemView.getContext().startActivity(i);

                }
            });
        }
    }

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
}




