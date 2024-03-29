/*
 * Copyright (C) 2016 Olmo Gallegos Hernández.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package es.voghdev.pdfviewpager;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import es.voghdev.pdfviewpager.library.PDFViewPager;
import es.voghdev.pdfviewpager.library.adapter.BasePDFPagerAdapter;
import es.voghdev.pdfviewpager.library.adapter.PDFPagerAdapter;

public class MainActivity extends AppCompatActivity {
    PDFViewPager pdfViewPager;
    BasePDFPagerAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setTitle(R.string.std_example);
        setContentView(R.layout.activity_main);
        configureActionBar();

        pdfViewPager = (PDFViewPager) findViewById(R.id.pdfViewPager);

        adapter = new PDFPagerAdapter(this, "sample.pdf");
        pdfViewPager.setAdapter(adapter);
    }

    private void configureActionBar() {
        int color = getResources().getColor(R.color.pdfViewPager_ab_color);
        ActionBar ab = getSupportActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(color));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(adapter != null) {
            adapter.close();
            adapter = null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_sample2) {
            RemotePDFActivity.open(this);
            return false;
        }
        else if(id == R.id.action_sample3) {
            AssetOnSDActivity.open(this);
            return false;
        }
        else if(id == R.id.action_sample4) {
            Toast.makeText(this, R.string.dummy_msg, Toast.LENGTH_LONG).show();
        }
        else if(id == R.id.action_sample5) {
            AssetOnXMLActivity.open(this);
        }
        else if(id == R.id.action_sample6) {
            //LegacyPDFActivity.open(this);
        }
        else if(id == R.id.action_sample7) {
            ZoomablePDFActivityIVZoom.open(this);
        }
        else if(id == R.id.action_sample8) {
            ZoomablePDFActivityPhotoView.open(this);
        }
        else if(id == R.id.action_sample9) {
            PDFWithScaleActivity.open(this);
        }

        return super.onOptionsItemSelected(item);
    }
}
