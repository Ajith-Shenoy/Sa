package in.edu.reva.myapplication;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class TechEventsAdapter extends RecyclerView.Adapter<TechEventsAdapter.ViewHolder> {

    private String[] TTitle = {"TECHNICAL JAM", "TECHNICAL QUIZ", "IDEATE", "BUG HUNTER", "TECHNOSAPIEN", "PORT THE CODE"};
    private String[] TDescription = {"Technical jam is an all round fun event on technical talks.",
            "Test your technical skills in this curious and fun-filled tech quiz to be declared the biggest techie.",
            "Think you have the creativity and ideas for better solutions?Exhibit them here.",
            "Rectify the logical and syntactical errors.",
            "Rules of this event shall be given on the spot. Maximum Of 3 in a team.",
            "Translate a few lines of code from one language to another.",
    };

    private String[] TRegAmount = {"100", "100","100", "50", "100", "100"};
    private String[] TPrizeMoney = {"1000","1000","1000","500","1000","1000"};

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.techcard, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.techTitle.setText(TTitle[i]);
        viewHolder.techDesc.setText(TDescription[i]);
        viewHolder.techRegAmount.setText(TRegAmount[i]);
        viewHolder.techPrize.setText(TPrizeMoney[i]);
    }

    @Override
    public int getItemCount() {
        return TTitle.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView techTitle;
        public TextView techDesc;
        public TextView techRegAmount;
        public TextView techPrize;

        public ViewHolder(final View itemView) {
            super(itemView);
            techTitle = (TextView) itemView.findViewById(R.id.TechTittle);
            techDesc = (TextView) itemView.findViewById(R.id.TechDesc);
            techRegAmount = (TextView) itemView.findViewById(R.id.Techreg);
            techPrize = (TextView) itemView.findViewById(R.id.TechPrize);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    Intent i =new Intent(itemView.getContext(),Firebase.class);
                    i.putExtra("regAmount",techRegAmount.getText().toString());
                    i.putExtra("Ename",techTitle.getText().toString());
                    itemView.getContext().startActivity(i);

                }
            });
        }
    }
}




