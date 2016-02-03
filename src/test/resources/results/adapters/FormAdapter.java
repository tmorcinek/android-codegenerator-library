import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.List;

public class FormAdapter extends BaseAdapter {

    private List<T> objects = new ArrayList<T>();

    private Context context;
    private LayoutInflater layoutInflater;

    public FormAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public T getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.form, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((T)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(T object, ViewHolder holder) {
        //TODO implement
    }

    protected class ViewHolder {
        private ImageButton button;
    private EditText editTextName;
    private EditText editTextCity;
    private TextView headerText;
    private List list;

        public ViewHolder(View view) {
            button = (ImageButton) view.findViewById(R.id.button);
            editTextName = (EditText) view.findViewById(R.id.edit_text_name);
            editTextCity = (EditText) view.findViewById(R.id.edit_text_city);
            headerText = (TextView) view.findViewById(R.id.header_text);
            list = (List) view.findViewById(android.R.id.list);
        }
    }
}
