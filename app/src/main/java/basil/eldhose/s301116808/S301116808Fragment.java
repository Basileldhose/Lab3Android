/*
 * Basil Eldhose
 * 301116808
 * Sec 002
 * */

package basil.eldhose.s301116808;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link S301116808Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class S301116808Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ImageView moon;
    Button animStart,animStop;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public S301116808Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentC.
     */
    // TODO: Rename and change types and number of parameters
    public static S301116808Fragment newInstance(String param1, String param2) {
        S301116808Fragment fragment = new S301116808Fragment();
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
        return inflater.inflate(R.layout.fragment_c, container, false);

    }
    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        moon=(ImageView)view.findViewById(R.id.moon);
        final Animation animation= AnimationUtils.loadAnimation(getActivity().getApplicationContext(),R.anim.moon);
        view.findViewById(R.id.animStart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moon.startAnimation(animation);
            }
        });
        view.findViewById(R.id.animStop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moon.clearAnimation();
            }
        });




    }
    }