import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
public class WebScrape2
{

    public static void main(String[] args) throws Exception
    {
        String name = "";
        Boolean found = false;
        final Document document = Jsoup.connect("https://en.wikipedia.org/wiki/Special:Random").get();
        name = document.select("h1.firstHeading").text();
        System.out.println(name);
        Scanner inp = new Scanner(System.in);
        System.out.println("Please enter the string you wish to search the page for.");
        String query = inp.nextLine();
        for(Element row : document.select("div.mw-body-content"))
        {
            if(row.text().contains(query))
            {
                found = true;
            }
        }
        
        if(found)
        {
            System.out.println("The page contains " + query);
            System.out.println(document.select("div.mw-body-content").text());
        }
        else
        {
            System.out.println("The page does not contain" + query);
        }
    }
    
}
