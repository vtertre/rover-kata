package model

import spock.lang.Specification

class PositionTest extends Specification {

  def "can get the full position as a string"() {
    given:
    def position = new Position(x: 2, y: 3, direction: Direction.NORTH)

    expect:
    position.toString() == "2,3,N"
  }

  def "changes according to a rotation"() {
    given:
    def position = new Position(direction: preDirection)

    expect:
    position.rotate(rotation) == postDirection
    position.direction() == postDirection

    where:
    preDirection    | rotation       || postDirection
    Direction.NORTH | Rotation.RIGHT || Direction.EAST
    Direction.NORTH | Rotation.LEFT  || Direction.WEST
    Direction.SOUTH | Rotation.RIGHT || Direction.WEST
    Direction.SOUTH | Rotation.LEFT  || Direction.EAST
    Direction.WEST  | Rotation.RIGHT || Direction.NORTH
    Direction.WEST  | Rotation.LEFT  || Direction.SOUTH
    Direction.EAST  | Rotation.RIGHT || Direction.SOUTH
    Direction.EAST  | Rotation.LEFT  || Direction.NORTH
  }
}