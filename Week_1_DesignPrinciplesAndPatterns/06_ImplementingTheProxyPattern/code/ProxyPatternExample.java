public class ProxyPatternExample {

    interface Image {
        void display();
    }

    static class RealImage implements Image {
        private String fileName;

        public RealImage(String fileName) {
            this.fileName = fileName;
            loadFromRemoteServer();
        }

        private void loadFromRemoteServer() {
            System.out.println("Loading image from remote server: " + fileName);
        }

        public void display() {
            System.out.println("Displaying image: " + fileName);
        }
    }

    static class ProxyImage implements Image {
        private String fileName;
        private RealImage realImage;

        public ProxyImage(String fileName) {
            this.fileName = fileName;
        }

        public void display() {
            if (realImage == null) {
                realImage = new RealImage(fileName);
            } else {
                System.out.println("Loading from cache: " + fileName);
            }
            realImage.display();
        }
    }

    public static void main(String[] args) {
        Image image1 = new ProxyImage("nature.jpg");
        Image image2 = new ProxyImage("cityscape.png");

        System.out.println("\nFirst time loading nature.jpg:");
        image1.display();

        System.out.println("\nSecond time loading nature.jpg:");
        image1.display();

        System.out.println("\nFirst time loading cityscape.png:");
        image2.display();
    }
}
