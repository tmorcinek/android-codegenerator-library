import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.List;

public class FormFragment extends Fragment  {

    @Bind(R.id.edit_text_name) EditText editTextName;
    @Bind(R.id.edit_text_city) EditText editTextCity;
    @Bind(R.id.header_text) TextView headerText;
    @Bind(android.R.id.list) List list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.form, null);
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

    @OnClick(R.id.imageButton) void onClickImageButton() {
        //TODO implement
    }

    @OnLongClick(R.id.imageButton) boolean onLongClickImageButton() {
        //TODO implement
        return true;
    }

    @OnClick(R.id.button) void onClickButton() {
        //TODO implement
    }

    @OnLongClick(R.id.button) boolean onLongClickButton() {
        //TODO implement
        return true;
    }

    @OnItemClick(android.R.id.list) void onItemClick(int position) {
        //TODO implement
    }
}
