import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void ifFirstPlayerWins() {
        Player q11 = new Player(11, "q11", 10);
        Player a22 = new Player(22, "a22", 20);
        Game game = new Game();
        game.register(q11);
        game.register(a22);
        int expected = 2;
        int actual = game.round("q11", "a22");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ifSecondPlayerWins() {
        Player q11 = new Player(11, "q11", 10);
        Player a22 = new Player(22, "a22", 20);
        Game game = new Game();
        game.register(q11);
        game.register(a22);
        int expected = 1;
        int actual = game.round("a22", "q11");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ifNoOneIsWins() {
        Player q11 = new Player(11, "q11", 20);
        Player a22 = new Player(22, "a22", 20);
        Game game = new Game();
        game.register(q11);
        game.register(a22);
        int expected = 0;
        int actual = game.round("a22", "q11");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ifFirstPlayerIsNotRegistered() {
        Player q11 = new Player(11, "q11", 20);
        Player a22 = new Player(22, "a22", 20);
        Game game = new Game();
        game.register(q11);
        game.register(a22);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("a22", "t18")
        );
    }

    @Test
    public void ifSecondPlayerIsNotRegistered() {
        Player q11 = new Player(11, "q11", 20);
        Player a22 = new Player(22, "a22", 20);
        Game game = new Game();
        game.register(q11);
        game.register(a22);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("q11", "t18")
        );
    }
}