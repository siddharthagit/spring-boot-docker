package com.bootng;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

  public List<String> getAllLinks( String url) {
    
    List<String> result =  new ArrayList<String>();
  
    Document doc;
    try {
      doc = Jsoup.connect(url).get();
      Elements links = doc.select("a[href]");
      for (Element link : links) {
        result.add(String.format(" %s : %s", link.attr("abs:href"), link.text()));
      }
    
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
       
    return result;
  }
}
