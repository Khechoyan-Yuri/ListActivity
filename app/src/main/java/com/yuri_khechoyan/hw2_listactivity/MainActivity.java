package com.yuri_khechoyan.hw2_listactivity;

/* ========================================================================== */
/*	PROGRAM List View Activity

    AUTHOR: Yuri Khechoyan
    COURSE NUMBER: CIS 472
    COURSE SECTION NUMBER: 02
    INSTRUCTOR NAME: Dr. Tian
    PROJECT NUMBER: 1
    DUE DATE: 02/16/2017

SUMMARY

    This program is a simple ListView Application where the user selects the company that
    they would like to know the stock information for. When Clicked, WebView goes to the
    respective hyperlink that is associated with the company that they have clicked on.:

        Companies Include (in this order):
        -Google (GOOG)
        -Tesla (TSLA)
        -Apple Inc. (AAPL)
        -Microsoft (MSFT)
        -Oracle (ORCL)
        -Verizon (VZ)
        -Amazon (AMZN)

INPUT

       User scrolls through a list of companies then
       taps on the company that they would like to see stock information for

OUTPUT

    The most up-to-date- Stock Information for the company that was clicked, is shown

ASSUMPTIONS
- User knows how to scroll and tap on an item from a list
*/


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    //List of Stock URLS (in order - Google, Tesla, Apple, Microsoft, Oracle, Verizon, Amazon)
    String [] companyUrl = { "https://www.msn.com/en-us/money/stockdetails/fi-126.1.GOOGL.NAS",
            "http://www.msn.com/en-us/money/stockdetails/fi-126.1.TSLA.NAS",
            "http://www.msn.com/en-us/money/stockdetails/fi-126.1.AAPL.NAS?symbol=AAPL&form=PRFISB",
            "http://www.msn.com/en-us/money/stockdetails/fi-126.1.MSFT.NAS?symbol=MSFT&form=PRFISB",
            "https://www.msn.com/en-us/money/stockdetails/fi-126.1.ORCL.NYS",
            "https://www.msn.com/en-us/money/stockdetails/fi-126.1.VZ.NYS?symbol=VZ&form=PRFISB",
            "https://www.msn.com/en-us/money/stockdetails/fi-126.1.AMZN.NAS?symbol=AMZN&form=PRFISB",
            "https://www.msn.com/en-us/money/stockdetails/fi-126.1.T.NYS",
            "https://www.msn.com/en-us/money/stockdetails/fi-126.1.F.NYS?symbol=F&form=PRFISB"
    };

    //Initializes WebView UI
    WebView websiteview;

    //Creates Scrollable List containing these companies
    //& their respective logos
    ListView list;
    private final String[] Stocks = {"Google (GOOG)", "Tesla (TSLA)", "Apple Inc. (AAPL)",
            "Microsoft (MSFT)", "Oracle (ORCL)", "Verizon (VZ)", "Amazon (AMZN)", "AT&T Inc. (T)", "Ford Motor Co. (F)"};
    private final String[] Stock_logo_ids = {"google", "tesla", "apple", "microsoft", "oracle",
            "verizon", "amazon", "att", "ford"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sets Default WebView to Google.com at Application Launch
        websiteview = (WebView) findViewById(R.id.websiteview);
        websiteview.loadUrl("https://www.google.com");

        //Creates List object with listview context from 'activity_main.xml' file
        list = (ListView) findViewById(R.id.listview);

        //Creates certain orientation for Scrollable list (logos - left, text - right)
        ListAdapter adapter = new ListAdapter(this, Stock_logo_ids, Stocks);

        //Sets ListViewAdaptor - from activity_main.xml file
        list.setAdapter(adapter);

        //Target the OnClickListener to the ListView - WebView will change based on
        //what company user taps on
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Loading the URL of thw website based on the position
                //of the company in the array - companyURl
                websiteview.loadUrl(companyUrl[position]);

                //When company name is pressed,
                //a toast will appear letting the user know
                //what company they have pressed - receives
                //Information form - Stock array position element
                Toast.makeText(getApplicationContext(), "Selected: " +Stocks[position] +" Stock",
                        Toast.LENGTH_SHORT).show();

                //------------------------------------------------------------------------

                //ViewHolder Class is used in order avoid constantly
                //using the findViewById() method
                //getTag method returns object types

            }
        });
    }
}