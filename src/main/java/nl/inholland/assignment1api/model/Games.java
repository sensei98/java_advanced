package nl.inholland.assignment1api.model;

import java.util.UUID;

public class Games {
    private UUID uuid;
    private String name;
    private String type;
    private Double price;

    public Games(String name, String type, Double price) {
        this.uuid = uuid.randomUUID();
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Games{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
