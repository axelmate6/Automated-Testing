public class Park {
    private String name;
    private String country;
    private String city;
    private String address;
    public class Attractions{
        String attractionName;
        String openingHours;
        int price;
        public Attractions(String attractionName, String openingHours, int price) {
            this.attractionName = attractionName;
            this.openingHours = openingHours;
            this.price = price;
        }
        public void getAttractionInfo(){
            System.out.println(this.attractionName);
            System.out.println(this.openingHours);
            System.out.println(this.price);
        }
    }
}
