/*
 * Basil Eldhose
 * 301116808
 * Sec 002
 * */

package basil.eldhose.s301116808;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EldhoseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EldhoseFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ImageView img;
    AnimationDrawable mframeAnimation = null;
    Button startAnimation,stopAmination;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    int reasonableDuration;
    public EldhoseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentB.
     */
    // TODO: Rename and change types and number of parameters
    public static EldhoseFragment newInstance(String param1, String param2) {
        EldhoseFragment fragment = new EldhoseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false);

    }
    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        img = (ImageView)view.findViewById(R.id.ImageViewG);


        view.findViewById(R.id.launchService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL); //use ACTION_CALL class
                callIntent.setData(Uri.parse("tel:6777656566"));
                if (ActivityCompat.checkSelfPermission(getActivity().getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    //request permission from user if the app hasn't got the required permission
                    requestPermissions(
                            new String[]{Manifest.permission.CALL_PHONE},   //request specific permission from user
                            10);
                    return;
                }else {     //have got permission
                    try{
                        startActivity(callIntent);  //call activity and make phone call
                    }
                    catch (android.content.ActivityNotFoundException ex){
                        Toast.makeText(getActivity().getApplicationContext(),"yourActivity is not founded", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        view.findViewById(R.id.startAnimation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation(100);
            }
        });
        view.findViewById(R.id.stopAnimation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopAnimation();
            }
        });
        view.findViewById(R.id.d50).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation(50);
            }
        });
        view.findViewById(R.id.d100).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation(100);
            }
        });
        view.findViewById(R.id.d150).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation(150);
            }
        });
        view.findViewById(R.id.d200).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation(200);
            }
        });
    }
    public void startAnimation(int duration)
    {

       ArrayList<BitmapDrawable> frames=new ArrayList<BitmapDrawable>();

        frames.add((BitmapDrawable)getResources().getDrawable(R.drawable.g1));
        frames.add((BitmapDrawable)getResources().getDrawable(R.drawable.g2));
        frames.add((BitmapDrawable)getResources().getDrawable(R.drawable.g3));
        frames.add((BitmapDrawable)getResources().getDrawable(R.drawable.g4));
        frames.add((BitmapDrawable)getResources().getDrawable(R.drawable.g5));
        frames.add((BitmapDrawable)getResources().getDrawable(R.drawable.g6));
        frames.add((BitmapDrawable)getResources().getDrawable(R.drawable.g7));
        frames.add((BitmapDrawable)getResources().getDrawable(R.drawable.g8));
        frames.add((BitmapDrawable)getResources().getDrawable(R.drawable.g9));
        frames.add((BitmapDrawable)getResources().getDrawable(R.drawable.g10));

        reasonableDuration = duration;
        mframeAnimation = new AnimationDrawable();
        mframeAnimation.setOneShot(false);
        for (BitmapDrawable b:frames)
            mframeAnimation.addFrame(b, reasonableDuration);
        img.setBackground(mframeAnimation);
        mframeAnimation.setVisible(true,true);

        mframeAnimation.start();
    }
    public void stopAnimation()
    {
        mframeAnimation.stop();
        mframeAnimation.setVisible(false,false);

    }
}