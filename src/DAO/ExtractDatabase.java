package DAO;



import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;

import register.ProductOffers;
import register.Shops;

import android.util.Log;
import android.widget.TextView;


public class ExtractDatabase {
    
	TextView resultView;
	
    public void ExtractDatabase(){
    	String result = "";
    	InputStream isr = null;
    	try{
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://localhost/tahseen0amin/php/getAllCustomers.php"); //YOUR PHP SCRIPT ADDRESS 
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            isr = entity.getContent();
        }
        catch(Exception e){
                Log.e("log_tag", "Error in http connection "+e.toString());
                
				resultView.setText("Couldnt connect to database");
        }
        //convert response to string
        try{
                BufferedReader reader = new BufferedReader(new InputStreamReader(isr,"iso-8859-1"),8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                        sb.append(line + "\n");
                }
                isr.close();

                result=sb.toString();
        }
        catch(Exception e){
                Log.e("log_tag", "Error  converting result "+e.toString());
        }

        //parse json data
      //καλεί τις κλάσης του μαγαζιού και τον προσφορών και καταχωρεί μέσα τους γραμμή γραμμή τα περιεχόμενα του ερωτήματος του php 
        
       try {
               String s = "";
               JSONArray jArray = new JSONArray(result);
               Shops nShop = new Shops();
               ProductOffers nProductOffers = new ProductOffers();
               
               for(int i=0; i<jArray.length();i++){
		   JSONObject json = jArray.getJSONObject(i);
                   
		   nShop.setName(json.getString("Name"));
                   nShop.setShopX(json.getFloat("X"));
                   nShop.setShopY(json.getFloat("Y"));
                   
                   nProductOffers.setProductName(json.getString("ProductName"));
                   nProductOffers.setOffer(json.getInt("Offer"));		   
                }

               

       } catch (Exception e) {
            // TODO: handle exception
               Log.e("log_tag", "Error Parsing Data "+e.toString());
       }
    
   }
    
}
