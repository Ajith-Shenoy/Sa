package in.edu.reva.myapplication;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by soul_reaper on 3/3/18.
 */

public class FAQRecyclerAdapter extends RecyclerView.Adapter<FAQRecyclerAdapter.ViewHolder>
{
    private String[] Question = {"Prize for Dance event ?","When can I register ?","How will we verify payment ?","Will there be cash prizes ?",
            "Are there On-Spot registrations ?",
            "Can I get a refund if I can't make it to the event ?",
            "Will I be getting attendance if i'm not from Reva University or school of C&IT ?",
            "Will every participant get a certificate?",
            "Can I register via. the website?", "Can I participate in more than one event?", "How can i make payments?"};
    private String[] Answers = {"Winner represents the C&IT dept.for REVAMP 2018. No Other monetary prize.","Incampus registrations shall only be open during the Tea and Lunch break, and after 3 pm.","Online payments shall be verified prior to the event.Please get reliable proof.","No. Amazon Vouchers Only"
            , "No. Event registrations shall be closed 24 hours in advance.",
            "No. But under special circumstances a refund might be considered.Contact us well in advance.",
            "Yes. Submission of the participation certificate shall fetch you attendance.",
            "Yes, But for technical events only.",
            "No. App registrations only.",
            "No. We're helpless if the events coincide.",
            "Via. PAYTM, or at the registration desks payments can be made."};

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.faq_card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.Ques.setText(Question[i]);
        viewHolder.Ans.setText(Answers[i]);
    }

    @Override
    public int getItemCount() {
        return Answers.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView Ques;
        public TextView Ans;

        public ViewHolder(final View itemView) {
            super(itemView);
            Ques = (TextView) itemView.findViewById(R.id.Question);
            Ans = (TextView) itemView.findViewById(R.id.Answer);
            // cardView moves to contact us section
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    Intent i =new Intent(itemView.getContext(), Contact_Us.class);
                    itemView.getContext().startActivity(i);

                }
            });

        }
    }
}