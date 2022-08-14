import org.jetbrains.annotations.NotNull;

/**
 * Use record to create a simple player object
 * @param name the player's name
 * @param symbol the player's symbol
 */
public record Player(String name, String symbol) {

    @Override
    public @NotNull String toString() {
        return "{" + symbol() + "} " + name();
    }
}
