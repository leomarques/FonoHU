package com.leonardo.fonohu;

import android.app.Fragment;
import android.net.Uri;

import org.androidannotations.annotations.EFragment;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MenuPrincipal.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MenuPrincipal#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
@EFragment(R.layout.fragment_menu_principal)
public class MenuPrincipal extends Fragment {

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
