package com.example.notekeeper;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteRecyclerAdapter extends RecyclerView.Adapter<NoteRecyclerAdapter.ViewHolder> {

    public final Context mContext;
    public final List<NoteInfo> mNotes;
    private final LayoutInflater mLayoutInflater;

    public NoteRecyclerAdapter(Context context, List<NoteInfo> notes) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mNotes = notes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = mLayoutInflater.inflate(R.layout.item_note_list, parent, false);
        return new ViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NoteInfo note = mNotes.get(position);
        holder.mMTextCourse.setText(note.getCourse().getTitle());
        holder.mTextTitle.setText(note.getTitle());
        holder.mId = note.getId();

    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView mMTextCourse;
        public final TextView mTextTitle;
        public int mId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mMTextCourse = itemView.findViewById(R.id.text_course);
            mTextTitle = itemView.findViewById(R.id.text_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, NotesActivity.class);
                    intent.putExtra(NotesActivity.NOTE_ID, mId);
                    mContext.startActivity(intent);
                }
            });
        }

    }
}
