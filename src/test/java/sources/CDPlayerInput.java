package sources;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

//CDPlayer(5, new Documentation(45), 0, "Samsung");
public class CDPlayerInput implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(

                //SUCCESS
                Arguments.of(4, 84, 0, "Dell", "success"),
                Arguments.of(8, 15, 10, "Skoda", "success"),
                Arguments.of(13, 6, 20, "Kratka znacka", "success"),
                Arguments.of(2, 2, 13, "Jina znacka", "success"),
                Arguments.of(1, 4, 124, "Samsung", "success"),
                //Exception
                //negatie probability and empty name
                Arguments.of(-5, 84, 0, "", "Exception"),
                //probability higher than 100 and negative work time
                Arguments.of(104, 84, -10, "Dell", "Exception"),
                //negative repair time and too long name
                Arguments.of(4, -45, 0, "OpravduDlouhejmenokterepesahuje20charakteru snad", "Exception"),
                //negative work time and repair time
                Arguments.of(8, -156, -45, "Dell", "Exception"),
                //empty name and negative work time
                Arguments.of(4, 84, -7, "", "Exception")
        );
    }
}