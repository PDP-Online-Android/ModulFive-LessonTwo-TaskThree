package dev.ogabek.java.model;

public class Chat {
    private final int image;
    private final String fullName;
    private final boolean isOnline;

    public Chat(int image, String fullName, boolean isOnline) {
        this.image = image;
        this.fullName = fullName;
        this.isOnline = isOnline;
    }

    public String getFullName() {
        return fullName;
    }

    public int getImage() {
        return image;
    }

    public boolean getIsOnline() {
        return isOnline;
    }
}
