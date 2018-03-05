package in.edu.reva.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class TechEventsAdapter extends RecyclerView.Adapter<TechEventsAdapter.ViewHolder> {

    private String[] TTitle = {"TECHNICAL JAM", "TECH QUIZ", "PAPER PRESENTATION", "IDEATE", "BUG HUNTER", "Tech. TREASURE HUNT", "PORT THE CODE"};
    private String[] TDescription = {"Technical jam is an all round-fun event on technical talks.",
            "Test your technical skills in this curious and fun-filled tech quiz to be declared the biggest techie.",
            "Have an innovation you want to put across ? Come reach out to an audience !!",
            "Think you have the creativity and ideas for better solutions?Exhibit them here.",
            "Rectify the toughest and the easiest logical and syntactical eorrors.",
            "A jumbled set of C program will be given to the participant.\n" +
                    "The participant must rearrange the statements in order to generate logically and syntactically correct program.",
            "Port the code where you'll have to translate a few lines of code to another.",
    };

    private String[] TRegAmount = {"Reg.Amount: 100", "Reg.Amount: 100", "Reg.Amount: 200", "Reg.Amount: 100", "Reg.Amount: 50", "Reg.Amount: 100", "Reg.Amount: 100"};
    private String[] TPrizeMoney = {"Prize : 1000", "Prize : 1000", "Prize : 2000", "Prize : 1000", "Prize : 1000", "Prize : 1000", "Prize : 1000"};

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
                    itemView.getContext().startActivity(i);

                }
            });
        }
    }

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
}




