import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        String url = "https://www.simbirsoft.com/";
        Downloader.DownloadWebPage(url);
        LocalDateTime t1 = LocalDateTime.now();
        Parser parser = new Parser();
        parser.read("Download.html");
        LocalDateTime t2 = LocalDateTime.now();
        System.out.println(t1);
        System.out.println(t2);
    }
}
