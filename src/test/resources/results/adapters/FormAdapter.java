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
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.button = (ImageButton) convertView.findViewById(R.id.button);
            viewHolder.editTextName = (EditText) convertView.findViewById(R.id.edit_text_name);
            viewHolder.editTextCity = (EditText) convertView.findViewById(R.id.edit_text_city);
            viewHolder.headerText = (TextView) convertView.findViewById(R.id.header_text);
            viewHolder.list = (List) convertView.findViewById(android.R.id.list);

            convertView.setTag(viewHolder);
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

    }
}
