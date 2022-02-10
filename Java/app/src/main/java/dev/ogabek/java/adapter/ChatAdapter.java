package dev.ogabek.java.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.ogabek.java.R;
import dev.ogabek.java.model.Chat;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_FIRST_THIRD_VIEW = 0;
    private static final int TYPE_SIMPLE_VIEW = 1;
    private static final int TYPE_SPACE_VIEW = 2;

    List<Chat> chatList;

    public ChatAdapter(List<Chat> chatList) {
        this.chatList = chatList;
    }

    @Override
    public int getItemViewType(int position) {
        if (position < 3) {
            return TYPE_FIRST_THIRD_VIEW;
        } else if (position == 3) {
            return TYPE_SPACE_VIEW;
        } else {
            return TYPE_SIMPLE_VIEW;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_SIMPLE_VIEW) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
            return new SimpleViewHolder(view);
        } else if (viewType == TYPE_SPACE_VIEW) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.space, parent, false);
            return new SpaceViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_1_3, parent, false);
            return new OneToThirdViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Chat chat = chatList.get(position);

        if (holder instanceof OneToThirdViewHolder) {
            switch (position) {
                case 0: {
                    ((OneToThirdViewHolder) holder).image.setImageResource(R.drawable.add_user);
                    ((OneToThirdViewHolder) holder).title.setText("New Contacts");
                    break;
                }
                case 1: {
                    ((OneToThirdViewHolder) holder).image.setImageResource(R.drawable.ic_baseline_call_24);
                    ((OneToThirdViewHolder) holder).title.setText("Call History");
                    break;
                }
                case 2: {
                    ((OneToThirdViewHolder) holder).image.setImageResource(R.drawable.sms);
                    ((OneToThirdViewHolder) holder).title.setText("New Group Chat");
                    break;
                }
            }
        }
        if (holder instanceof SpaceViewHolder) {

        }
        if (holder instanceof SimpleViewHolder) {
            if (position == 4) {
                ((SimpleViewHolder) holder).image.setImageResource(R.drawable.following);
                ((SimpleViewHolder) holder).isOnline.setVisibility(View.GONE);
                ((SimpleViewHolder) holder).name.setText("Follow");
                ((SimpleViewHolder) holder).call.setImageResource(R.drawable.ic_next);

            } else {
                ((SimpleViewHolder) holder).image.setImageResource(chat.getImage());
                ((SimpleViewHolder) holder).isOnline.setVisibility(View.VISIBLE);
                if (chat.getIsOnline()) {
                    ((SimpleViewHolder) holder).isOnline.setBackgroundResource(R.drawable.shape_circle_green);
                } else {
                    ((SimpleViewHolder) holder).isOnline.setBackgroundResource(R.drawable.shape_circle_orange);
                }
                ((SimpleViewHolder) holder).name.setText(chat.getFullName());
                ((SimpleViewHolder) holder).call.setImageResource(R.drawable.ic_baseline_call_24);
            }
        }
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    private static class SimpleViewHolder extends RecyclerView.ViewHolder {
        ImageView image, call;
        TextView isOnline, name;

        public SimpleViewHolder(View view) {
            super(view);

            image = view.findViewById(R.id.iv_profile);
            isOnline = view.findViewById(R.id.tv_count);
            name = view.findViewById(R.id.contact_name);
            call = view.findViewById(R.id.call);

        }
    }

    private static class SpaceViewHolder extends RecyclerView.ViewHolder {
        public SpaceViewHolder(View view) {
            super(view);
        }
    }

    private static class OneToThirdViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;

        public OneToThirdViewHolder(View view) {
            super(view);

            image = view.findViewById(R.id.item_first_img);
            title = view.findViewById(R.id.item_first_title);
        }
    }
}
