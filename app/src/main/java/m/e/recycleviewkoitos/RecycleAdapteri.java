package m.e.recycleviewkoitos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecycleAdapteri extends RecyclerView.Adapter<RecycleAdapteri.ViewHolder> {

    private ArrayList<UserEntity> data;
    private LayoutInflater layoutInflater;
    public RecycleAdapteri(Context context, ArrayList<UserEntity> data) {
        this.data = data;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.listanriviview, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name = data.get(position).name;
        holder.nimiTextView.setText(name);
        String email = data.get(position).email;
        holder.emailTextView.setText(email);
        String city = data.get(position).city;
        holder.cityTextView.setText(city);
    }



    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nimiTextView;
        TextView emailTextView;
        TextView cityTextView;
        ViewHolder(@NonNull View itemView){
            super(itemView);
            nimiTextView = itemView.findViewById(R.id.nimi);
            emailTextView = itemView.findViewById(R.id.email);
            cityTextView = itemView.findViewById(R.id.city);
        }


    }
}
