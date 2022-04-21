package blocks.implementation

import movements.Position

internal fun List<Position>.add(position: Position): Collection<Position> = this.map { p -> p.addAxes(position) }