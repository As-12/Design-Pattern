package ObserverPattern;

/*
  The observer pattern,
   defines one-many relationship.  When state of the subject changes, all of its subscribed are notified.

   Subject = observable
   Observers subscribes to a subject
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

class NewsStationTen extends Observable {

    private List<String> breakingNews;

    NewsStationTen() {
        this.breakingNews = new ArrayList<String>();
    }

    public void addBreakingNews(String news) {
        this.breakingNews.add(news);
        setChanged();
        notifyObservers();
    }

    public String getLatestNews() {
        return this.breakingNews.get(this.breakingNews.size() - 1);
    }


}

class TVMonitor implements Observer {

    private Observable observable;
    TVMonitor(Observable subject) {
        this.observable = subject;
        this.observable.addObserver(this);  // subscribe itself to the subject
    }
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof NewsStationTen) {
            NewsStationTen newsChannelTen = (NewsStationTen) o;
            System.out.println("Breaking News: " + newsChannelTen.getLatestNews());
        }
    }
}

public class main {


    public static void main(String[] args) {
        NewsStationTen news = new NewsStationTen();
        TVMonitor monitor = new TVMonitor(news);
        news.addBreakingNews("USA lands on the moon");

        TVMonitor monitor2 = new TVMonitor(news);
        news.addBreakingNews("This should display two times");
    }


}
