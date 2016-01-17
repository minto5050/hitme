package in.co.geekninja.hitme;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GameFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GameFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_NO_TRIES = "no_of_tries";
    private int no_of_tries=5;
    private View v;
    private LinearLayout canvas;

    public GameFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param no_of_tries Total number of trials for a user.
     *
     * @return A new instance of fragment GameFragment.
     */
    public static GameFragment newInstance(int no_of_tries) {
        GameFragment fragment = new GameFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_NO_TRIES, no_of_tries);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            no_of_tries = getArguments().getInt(ARG_NO_TRIES);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Table layout for holding cat tiles
        LinearLayout verticalRoot=new LinearLayout(getActivity());
        verticalRoot.setOrientation(LinearLayout.VERTICAL);
        verticalRoot.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        verticalRoot.setWeightSum(4f);
        // for loop for filling 4 rows
        for (int i=0;i<4;i++) {
            LinearLayout row=new LinearLayout(getActivity());
            row.setOrientation(LinearLayout.HORIZONTAL);
            row.setLayoutParams(new TableLayout.LayoutParams(0,TableLayout.LayoutParams.MATCH_PARENT,1f));
            for (int j = 0; j < 3; j++) {
                //for loop for filling cells in rows
                View cat = inflater.inflate(R.layout.tile, null, false);
                cat.setOnClickListener(this);
                row.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
                row.addView(cat);
            }
            verticalRoot.addView(row);
        }
        return verticalRoot;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


    @Override
    public void onClick(View v) {

    }
}
