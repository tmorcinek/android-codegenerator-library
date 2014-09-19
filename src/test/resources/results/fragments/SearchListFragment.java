import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class SearchListFragment extends Fragment  {

    private ListView list;
    private TextView empty;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.search_list, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        list = (ListView) view.findViewById(android.R.id.list);
        empty = (TextView) view.findViewById(android.R.id.empty);
    }

    private EditText getSearchEditText(){
        return (EditText) getView().findViewById(R.id.search_edit_text);
    }
}
