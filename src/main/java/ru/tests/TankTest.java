package ru.tests;

import com.badlogic.gdx.math.GridPoint2;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

<<<<<<< HEAD
import ru.mipt.bit.platformer.entity.objects.Tank;
import ru.mipt.bit.platformer.playerinput.keys.Direction;
=======
import ru.mipt.bit.platformer.entity.tank.Tank;
import ru.mipt.bit.platformer.entity.tank.Direction;
>>>>>>> 4fe93b7764387c3a3f40158528b2cb4ed6ee3efe

public class TankTest {
    @ParameterizedTest
    @EnumSource(Direction.class)
    public void testTankMoveToNewDirectionWithCoordinates(Direction direction){
        GridPoint2 directionPoint = direction.getDirectionPoint();

        Tank tank = new Tank(new GridPoint2(1, 0));
<<<<<<< HEAD
        tank.move(direction);
=======
        tank.move(directionPoint, direction.getDirectionRotation());
>>>>>>> 4fe93b7764387c3a3f40158528b2cb4ed6ee3efe

        GridPoint2 targetCoordinates = tank.getCoordinates();
        targetCoordinates.add(directionPoint.x, directionPoint.y);

        assertEquals(targetCoordinates, tank.getDestinationCoordinates());
        assertEquals(direction.getDirectionRotation(), tank.getRotation());
    }

    @ParameterizedTest
    @EnumSource(Direction.class)
    void testTankFinishedMovement(Direction direction) {
        GridPoint2 directionPoint = direction.getDirectionPoint();
        float directionRotation = direction.getDirectionRotation();

        Tank tank = new Tank(new GridPoint2(1, 0));
        float deltaTime = 1f;
<<<<<<< HEAD
        float movementSpeed = 0.4f;
=======
>>>>>>> 4fe93b7764387c3a3f40158528b2cb4ed6ee3efe

        GridPoint2 targetCoordinates = tank.getCoordinates();
        targetCoordinates.add(directionPoint.x, directionPoint.y);

<<<<<<< HEAD
        tank.move(direction);
        tank.updateState(deltaTime, movementSpeed);
=======
        tank.move(directionPoint, directionRotation);
        tank.updateState(deltaTime);
>>>>>>> 4fe93b7764387c3a3f40158528b2cb4ed6ee3efe

        assertEquals(targetCoordinates, tank.getCoordinates());
        assertEquals(targetCoordinates, tank.getDestinationCoordinates());
        assertEquals(directionRotation, tank.getRotation());

    }
}
