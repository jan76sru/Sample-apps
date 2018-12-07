package srujan.com.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

   private final LinkedList<String> mWordList;
   private LayoutInflater mInflater;


    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item,viewGroup,false);
        return new WordViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder wordViewHolder, int i) {

        String mCurrent = mWordList.get(i);
        wordViewHolder.wordItemView.setText(mCurrent);

    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

   class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView wordItemView;
        final WordListAdapter mAdapter;

        public WordViewHolder(View itemView,WordListAdapter adapter){
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            this.mAdapter= adapter;
            itemView.setOnClickListener(this);
        }

       @Override
       public void onClick(View view) {

            // Get teh posidtion of teh item that was clicked
           int mPosition = getLayoutPosition();
           // use that to acces the affected iten in mWordList
           String element = mWordList.get(mPosition);
           // Change teh word in the mWordList
           mWordList.set(mPosition,"Clicked "+element);
           //Notify the adapter ,that the data has a changed so it can
           //update the recyclerview to dipslay teh data
           mAdapter.notifyDataSetChanged();



       }
   }
    public WordListAdapter(Context context,LinkedList<String> wordList){
        mInflater =LayoutInflater.from(context);
        this.mWordList=wordList;
    }
}
