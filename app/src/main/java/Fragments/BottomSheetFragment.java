package Fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.woofmeow.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import Consts.ButtonType;

@SuppressWarnings("Convert2Lambda")
public class BottomSheetFragment extends BottomSheetDialogFragment {


    public static BottomSheetFragment newInstance() {

        Bundle args = new Bundle();
        BottomSheetFragment fragment = new BottomSheetFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private BottomSheetFragment() {
        super();
    }

    public interface onSheetClicked {
        void onBottomSheetClick(ButtonType buttonType);
    }

    private onSheetClicked callback;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            callback = (onSheetClicked) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement onSheetClicked interface");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_layout, container, false);
        TextView attachFile = view.findViewById(R.id.attachFile);
        TextView attachLocation = view.findViewById(R.id.attachLocation);
        TextView attachCameraPhoto = view.findViewById(R.id.attachCamera);
        TextView attachGalleryPhoto = view.findViewById(R.id.attachGallery);
        TextView TimedMessage = view.findViewById(R.id.delayMessage);
        TextView videoMessage = view.findViewById(R.id.videoMessage);
        this.setCancelable(true);
        attachFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //callback.onFileClicked();
                callback.onBottomSheetClick(ButtonType.attachFile);
            }
        });
        attachLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // callback.onLocationClicked();
                callback.onBottomSheetClick(ButtonType.location);
            }
        });
        attachCameraPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onBottomSheetClick(ButtonType.camera);
            }
        });
        attachGalleryPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onBottomSheetClick(ButtonType.gallery);
            }
        });
        TimedMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onBottomSheetClick(ButtonType.delay);
            }
        });
        videoMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onBottomSheetClick(ButtonType.video);
            }
        });
        return view;
    }

}
