public class Exercise06_ProxyImageDemo {
    public static void main(String[] args) {
        RemoteImage imageOne = new CachedRemoteImageProxy("https://images.example.com/banner.png");
        RemoteImage imageTwo = new CachedRemoteImageProxy("https://images.example.com/banner.png");
        RemoteImage imageThree = new CachedRemoteImageProxy("https://images.example.com/profile.png");

        imageOne.display();
        imageTwo.display();
        imageThree.display();
    }
}

interface RemoteImage {
    void display();
}

final class RealRemoteImage implements RemoteImage {
    private final String imageUrl;

    RealRemoteImage(String imageUrl) {
        this.imageUrl = imageUrl;
        loadImageFromServer();
    }

    private void loadImageFromServer() {
        System.out.println("Loading image from remote server: " + imageUrl);
    }

    @Override
    public void display() {
        System.out.println("Displaying remote image: " + imageUrl);
    }
}

final class CachedRemoteImageProxy implements RemoteImage {
    private static final java.util.Map<String, RealRemoteImage> CACHE = new java.util.HashMap<>();
    private final String imageUrl;

    CachedRemoteImageProxy(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public void display() {
        RealRemoteImage realImage = CACHE.get(imageUrl);
        if (realImage == null) {
            realImage = new RealRemoteImage(imageUrl);
            CACHE.put(imageUrl, realImage);
        } else {
            System.out.println("Using cached image for: " + imageUrl);
        }
        realImage.display();
    }
}