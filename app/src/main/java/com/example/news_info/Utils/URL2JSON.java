//package com.example.news_info.Utils;
//
//
//import org.json.JSONObject;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.InputStreamReader;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutput;
//import java.io.ObjectOutputStream;
//
///**
// * 抓取数据序列化到磁盘
// */
//public class URL2JSON {
//    // Create a new HTTP Client
//
//    DefaultHttpClient defaultClient = new DefaultHttpClient();
//
//// Setup the get request
//
//    HttpGet httpGetRequest = new HttpGet("http://example.json");
//
//// Execute the request in the client
//
//    HttpResponse httpResponse = defaultClient.execute(httpGetRequest);
//
//// Grab the response
//
//    BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(), "UTF-8"));
//
//    String json = reader.readLine();
//
//// Instantiate a JSON object from the request response
//
//    JSONObject jsonObject = new JSONObject(json);
//
//// Save the JSONOvject
//
//    ObjectOutput out = new ObjectOutputStream(new FileOutputStream(new File(getCacheDir(), "") + "cacheFile.srl"));
//
//out.writeObject(jsonObject );
//
//out.close();
//
//    将JSONObject序列化并保存到磁盘后,您可以随时使用以下命令将其加载回来：
//
//// Load in an object
//
//    ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(new File(getCacheDir(), "") + "cacheFile.srl")));
//
//    JSONObject jsonObject = (JSONObject) in.readObject();
//
//in.close();
//}
