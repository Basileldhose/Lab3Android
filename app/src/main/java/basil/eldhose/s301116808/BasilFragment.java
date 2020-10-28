/*
 * Basil Eldhose
 * 301116808
 * Sec 002
 * */

package basil.eldhose.s301116808;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BasilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BasilFragment extends Fragment implements AdapterView.OnItemSelectedListener {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private Spinner spinner;
    private static final String[] paths = {"10", "20", "30"};
    public static int thinkess=10;
    public static int color= Color.RED;
    public Paint paint;
    public Bitmap bitmap;
    public Canvas canvas;
    RadioGroup radioGroup;
    RadioButton red,blue,green;
    ImageView imageView;
    private static int startx = 10;
    private static int starty = 10;
    private static int endx=500;
    private static int endy=500;
    ImageButton up,down,left,right;


    public BasilFragment() {
        paint = new Paint();
        paint.setColor(Color.MAGENTA);
        //paint.setStrokeMiter((float)0.5);
        paint.setStrokeWidth(30);

        //creating a bitmap as content view for the image
        bitmap = Bitmap.createBitmap(Resources.getSystem().getDisplayMetrics().widthPixels,Resources.getSystem().getDisplayMetrics().heightPixels, Bitmap.Config.ARGB_8888);
        //tell canvas about the content view
        canvas = new Canvas(bitmap);
        //set the background for your drawings
        canvas.drawColor(Color.CYAN); //background
        //setup the image view

        //tell image view for the bitmap format/content

        // Required empty public constructor
    }




    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentA.
     */
    // TODO: Rename and change types and number of parameters
    public static BasilFragment newInstance(String param1, String param2) {
        BasilFragment fragment = new BasilFragment();
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
        return inflater.inflate(R.layout.fragment_a, container, false);
    }
    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bitmap = Bitmap.createBitmap(Resources.getSystem().getDisplayMetrics().widthPixels,Resources.getSystem().getDisplayMetrics().heightPixels, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        canvas.drawColor(Color.BLACK);
        imageView = (ImageView)view.findViewById(R.id.ImageViewForDrawing);
        imageView.setImageBitmap(bitmap);
        imageView.setVisibility(View.VISIBLE);
        //canvas.drawPoint(15,15,paint);
        spinner = (Spinner)view.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        radioGroup=(RadioGroup)view.findViewById(R.id.colorGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) view.findViewById(checkedId);
                if(radioButton.getText().equals("Red"))
                    color=Color.RED;
                if(radioButton.getText().equals("Blue"))
                    color=Color.BLUE;
                if(radioButton.getText().equals("Green"))
                    color=Color.GREEN;
                Toast.makeText(getActivity().getApplicationContext(), String.valueOf(color), Toast.LENGTH_LONG).show();

            }
        });
        down=(ImageButton)view.findViewById(R.id.down);
        down.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                endy=endy+5;
                drawLine();
                return false;
            }
        });
        up=(ImageButton)view.findViewById(R.id.up);
        up.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                endy=endy-5;
                drawLine();
                return false;
            }
        });
        left=(ImageButton)view.findViewById(R.id.left);
        left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                endx=endx-5;
                drawLine();
                return false;
            }
        });
        right=(ImageButton)view.findViewById(R.id.right);
        right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                endx=endx+5;
                drawLine();
                return false;
            }
        });
    view.findViewById(R.id.canvasClear).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            clearCanvas();
        }
    });

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                thinkess=10;
                break;
            case 1:
                thinkess=20;
                break;
            case 2:
                thinkess=30;
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void drawLine()
    {
        paint = new Paint();
        paint.setColor(color);
        paint.setStrokeWidth(thinkess);
        canvas.drawLine(startx, starty, endx, endy, paint);
        startx=endx;
        starty=endy;

    }

    public void clearCanvas()
    {
        canvas.drawColor(Color.BLACK);
        startx = 10;
        starty = 10;
        endx = 300;
        endy = 300;
    }
}