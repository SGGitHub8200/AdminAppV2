package com.pratham.admin.ui.home.assignedToMe;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pratham.admin.R;
import com.pratham.admin.interfaces.DevicePrathamIdLisner;
import com.pratham.admin.modalclasses.DeviseList;

import java.util.ArrayList;
import java.util.List;

public class DeviceListAdapter extends RecyclerView.Adapter<DeviceListAdapter.MyViewHolder> {
    List<DeviseList> deviseList;
    Context context;
    private final DevicePrathamIdLisner devicePrathamIdLisner;

    public DeviceListAdapter(Context context, List deviseList, DevicePrathamIdLisner devicePrathamIdLisner) {
        this.deviseList = deviseList;
        this.context=context;
        this.devicePrathamIdLisner = devicePrathamIdLisner;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_device_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      //  if(deviseList.get(position).getPratham_ID()!=null)
        holder.prathamId.setText("PrathamId : "+deviseList.get(position).getPratham_ID());
       // if(deviseList.get(position).getQR_ID()!=null)
/*        holder.qrId.setText("Qr Id :"+deviseList.get(position).getQR_ID());
        holder.deviceId.setText("DeviceId :"+deviseList.get(position).getDeviceid());
        holder.serialID.setText("SerialId :"+deviseList.get(position).getSerialno());
        holder.brand.setText("Model:"+deviseList.get(position).getBrand()+" "+deviseList.get(position).getModel());
        holder.macAdd.setText("Mac Addr :"+deviseList.get(position).getWiFiMacAddress());*/
    }

    @Override
    public int getItemCount() {
        return deviseList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView prathamId;
        TextView qrId;
        TextView deviceId;
        TextView serialID;
        TextView brand;
        TextView macAdd;

        public MyViewHolder(View itemView) {
            super(itemView);
            prathamId = itemView.findViewById(R.id.prathamId);
/*            qrId = itemView.findViewById(R.id.QrId);
            deviceId = itemView.findViewById(R.id.deviceId);
            serialID = itemView.findViewById(R.id.serialNo);
            brand = itemView.findViewById(R.id.brand);
            macAdd = itemView.findViewById(R.id.macAdd);*/
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Log.e("###### : ", deviseList.get(getAdapterPosition()).getPratham_ID());
                  String prathamID=deviseList.get(getAdapterPosition()).getPratham_ID();
                  String qrID=deviseList.get(getAdapterPosition()).getQR_ID();
                  String deviceID=deviseList.get(getAdapterPosition()).getDeviceid();
                  String serNo=deviseList.get(getAdapterPosition()).getSerialno();
                  String tabModel=deviseList.get(getAdapterPosition()).getBrand() +" "+ deviseList.get(getLayoutPosition()).getModel();
                  if(prathamID!=null && qrID!=null){
                      Log.e(":::",prathamID+" : "+qrID);
                      devicePrathamIdLisner.setDeviceDetail(prathamID,qrID,deviceID,serNo,tabModel);
                  }else {
                      Toast.makeText(context, "Pratham id or Qr id is null", Toast.LENGTH_SHORT).show();
                  }
                }
            });
        }
    }

    public void filterList(ArrayList<DeviseList> filterdNames) {
        this.deviseList=filterdNames;
        notifyDataSetChanged();
    }
}
