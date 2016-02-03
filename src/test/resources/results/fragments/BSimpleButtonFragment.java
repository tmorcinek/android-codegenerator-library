import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class MainFragment extends Fragment  {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.button) void onButtonClick() {
        //TODO implement
    }

    @OnLongClick(R.id.button) boolean onButtonLongClick() {
        //TODO implement
        return true;
    }

    @OnClick(R.id.imageButton) void onImageButtonClick() {
        //TODO implement
    }

    @OnLongClick(R.id.imageButton) boolean onImageButtonLongClick() {
        //TODO implement
        return true;
    }
}
