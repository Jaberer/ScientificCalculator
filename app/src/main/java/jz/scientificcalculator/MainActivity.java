package jz.scientificcalculator;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity
{
    private TextView display;
    private Operation operation;
    private double first;
    private double second;
    private Button decimal;
    private boolean firstOp;

    private enum Operation
    {
        ADD,
        SUBTRACT,
        DIVIDE,
        MULTIPLY,
        NONE
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = (TextView) findViewById(R.id.display);
        operation = Operation.NONE;
        decimal = (Button) findViewById(R.id.Decimal);
        firstOp = true;
    }

    public void numberClick(View view)
    {
        Button button = (Button) view;
        if(button.getText().equals(".") && display.getText().toString().contains(".")) // if decimal already used
        {
            return;
        } // do nothing
        if(!firstOp)
        {
            display.setText(button.getText());
            //second = Double.parseDouble(button.getText().toString());
            firstOp = true;
            return;
        }
        display.append(button.getText());
    }

    public void operationClick(View view)
    {
        Button button = (Button) view;
        if(display.getText().equals(""))
        {
            first = 0;
            display.append("0");
        }
        else
        {
            first = Double.parseDouble(display.getText().toString());
        }

        button.setBackgroundColor(Color.rgb(34,98,219));
        switch (view.getId())
        {
            case R.id.Add:
                operation = Operation.ADD;
                break;
            case R.id.Subtract:
                operation = Operation.SUBTRACT;
                break;
            case R.id.Divide:
                operation = Operation.DIVIDE;
                break;
            case R.id.Multiply:
                operation = Operation.MULTIPLY;
                break;
        }
        firstOp = false;
    }

    public void equalsClick(View view)
    {
        firstOp = true;
        if(display.getText().toString().equals(""))
        {
            second = 0;
        }
        else
        {
            second = Double.parseDouble(display.getText().toString());
        }
        Button button;
        switch (operation)
        {
            case ADD:
                first += second;
                button = (Button) findViewById(R.id.Add);
                button.setBackgroundColor(Color.LTGRAY);
                break;
            case SUBTRACT:
                first -= second;
                button = (Button) findViewById(R.id.Subtract);
                button.setBackgroundColor(Color.LTGRAY);
                break;
            case DIVIDE:
                first /= second;
                button = (Button) findViewById(R.id.Divide);
                button.setBackgroundColor(Color.LTGRAY);
                break;
            case MULTIPLY:
                first *= second;
                button = (Button) findViewById(R.id.Multiply);
                button.setBackgroundColor(Color.LTGRAY);
                break;
            default:
                first = second;
                break;
        }

        display.setText(first + "");
        operation = Operation.NONE;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
