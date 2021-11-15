package com.example.home_gym.ui.dashboard;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.home_gym.R;

public class DashboardFragment extends Fragment {

    TextView buttonHands,buttonSpine,buttonTorso, buttonLegs;
    ImageView image1, image2, image3, image4;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_dashboard, container, false);
        Init(v);


        ImageView[] masImage = {image1, image2, image3, image4};
        TextView[] masTextView = {buttonHands, buttonLegs, buttonSpine, buttonTorso};

        buttonHands.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Change(buttonHands, masTextView, masImage);
            }
        });
        buttonSpine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Change(buttonSpine, masTextView, masImage);
            }
        });


        buttonTorso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Change(buttonTorso, masTextView, masImage);
            }
        });


        buttonLegs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Change(buttonLegs, masTextView, masImage);
            }
        });
        return v;
    }
        private void Change (TextView textView, TextView[] mas, ImageView[] imas){

            String drawable_name = "null";
            String value = textView.getText().toString();

            switch (value){
                case "Hands":
                    drawable_name =  "muscule1";
                    break;
                case "Spine":
                    drawable_name = "spine";
                    break;
                case "Torso":
                    drawable_name = "torso";
                    break;
                case "Legs":
                    drawable_name = "nogi";
            }

            int resID = getResources().getIdentifier(drawable_name, "drawable", getContext().getPackageName());

            for (TextView text : mas)
            {
                if (text.getText().equals(value)){
                    text.setTextColor(getResources().getColor(R.color.white));
                    text.setBackgroundResource(R.color.blue_bg);
                }
                else {
                    text.setTextColor(getResources().getColor(R.color.blue_bg));
                    text.setBackgroundResource(R.drawable.btn_lessons);
                }
            }
                for (ImageView image: imas){
                    image.setImageResource(resID);
                }
            }

            private void Init(View v){
                buttonHands =v.findViewById(R.id.textView13);
                buttonSpine =v.findViewById(R.id.textView14);
                buttonTorso =v.findViewById(R.id.textView15);
                buttonLegs =v.findViewById(R.id.textView16);

                image1 =v.findViewById(R.id.imageView5);
                image2 =v.findViewById(R.id.imageView6);
                image3 =v.findViewById(R.id.imageView7);
                image4 =v.findViewById(R.id.imageView8);
            }
}