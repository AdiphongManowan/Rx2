package com.example.adiphong.rx2;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ScrollView;

public class BlankFragment extends Fragment {

    public BlankFragment() {
        // Required empty public constructor
    }

    public static BlankFragment newInstance() {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
//
        EditText editText = view.findViewById(R.id.edit_text);
        editText.setImeActionLabel(getString(R.string.app_name), EditorInfo.IME_ACTION_DONE);
//        ScrollView scrollView = view.findViewById(R.id.scroll_view);
//
//        hideKeyboardOnTouchScrollview(getActivity(), scrollView, editText);
//        prepareShowKeyboardOnScrollview(getActivity(), editText);

        return view;
    }

    public static void prepareShowKeyboardOnScrollview(Activity activity, EditText editText) {
        editText.setOnTouchListener((v, event) -> {
                    editText.setCursorVisible(true);
                    showKeyboard(activity, editText);
                    return false;
                }
        );
    }

    private static void showKeyboard(Context context, EditText editText) {
        editText.post(() -> {
            editText.requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(context.INPUT_METHOD_SERVICE);
            inputMethodManager.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
//            inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public static void hideKeyboardOnTouchScrollview(Activity activity, ScrollView scrollView, EditText editText) {
        scrollView.setOnTouchListener(
                (v, event) -> {
                    if (editText.isCursorVisible()) {
                        forceHideKeyboard(activity, editText);
                    }
                    return false;
                }
        );
    }

    public static void forceHideKeyboard(Activity activity, EditText editText) {
        if (activity.getCurrentFocus() != null && activity.getCurrentFocus().getWindowToken() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
            editText.setCursorVisible(false);
        }
    }

}
