package blocks;

public interface Block {
    char display();

    boolean fallsThrough();

    boolean fallsWithGravity();
}
