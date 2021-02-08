package ProxyPattern;

/**
 * Caching Proxy provides a surrogate object to provides a temporary storage for result of operations that are expensive.
 * Though implementation is similar, this is different than a decorator in a sense that
 * proxy does not add responsibility to the class.
 */

interface Content {
    public String getData();
}
// The real content object that load the data from remote sources (simulated).
class WebContent implements Content {

    private String data;

    // Simulate the delayed from loading from remote sources
    private int count;


    public WebContent(String url) {
        this.count = 0;

        //Maybe the object perform remote call to load data after object creation.
        //...
        this.data = "Real Data";
    }

    public String getData() {
        if(this.count  < 1) {
            ++this.count;
            return null;
        }
        return this.data;
    }

}

class ProxyWebContent implements Content {

    private Content realWebContent;

    public ProxyWebContent(String url) {
        //load some website from url
        this.realWebContent = new WebContent(url);
    }


    public String getData() {
        final String data = realWebContent.getData();

        if(data == null || data.isEmpty()) {
            return "Fake Placeholder Data";
        }
        // We could use an observer pattern here to hook the UI element to update once data is loaded.
        return data;
    }

}
public class CachingProxy {

    public static void main(String[] args) {
        //Create webContent from URL
        Content content = new ProxyWebContent("www.example.com");

        System.out.println("Printing Web Content");
        System.out.println(content.getData());

        //Loading is completed.
        System.out.println("Printing Web Content");
        System.out.println(content.getData());
    }
}
