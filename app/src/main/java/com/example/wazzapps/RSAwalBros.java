package com.example.wazzapps;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RSAwalBros extends ListActivity {
    protected void onCreate (Bundle icicle) {
        super.onCreate(icicle);
        String[] listAction = new String[] {"Call Center", "SMS Center", "Driving Direction", "Website", "Info di Google","Exit"};
        this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listAction));
    }

    protected void onListItemClick (ListView l, View view, int postion, long id) {
        super.onListItemClick(l,view,postion,id);
        Object o = this.getListAdapter().getItem(postion);
        String pilihan = o.toString();
        tampilkanpilihan(pilihan);
    }

    private void tampilkanpilihan(String pilihan) {
        try {
            Intent a = null;
            if (pilihan.equals("Call Center")) {
               String notel ="tel:0761-47333";
               a = new Intent(Intent.ACTION_DIAL, Uri.parse(notel));


            } else if (pilihan.equals("SMS Center")) {
                String smstext ="M Fahrizal/L";
                a = new Intent(Intent.ACTION_VIEW);
                a.setData(Uri.parse("sms:082170748694"));
                a.putExtra("sms_body",smstext);

            } else if (pilihan.equals("Driving Directionr")) {
                String lokasirs ="google.navigation:q=0.463823,101.390353";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(lokasirs));

            } else if (pilihan.equals("Website")) {
                String website = "http://awalbros.com/branch/pekanbaru/";
                a = new Intent(Intent.ACTION_VIEW,Uri.parse(website));

            } else if (pilihan.equals("Info di Google")) {
                a = new Intent(Intent.ACTION_WEB_SEARCH);
                a.putExtra(SearchManager.QUERY,"Rumah Sakit Awal Bros Pekanbaru");
            }

            startActivity(a);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
