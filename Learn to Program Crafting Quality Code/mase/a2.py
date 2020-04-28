# Do not import any modules. If you do, the tester may reject your submission.

# Constants for the contents of the maze.

# The visual representation of a wall.
WALL = '#'

# The visual representation of a hallway.
HALL = '.'

# The visual representation of a brussels sprout.
SPROUT = '@'

# Constants for the directions. Use these to make Rats move.

# The left direction.
LEFT = -1

# The right direction.
RIGHT = 1

# No change in direction.
NO_CHANGE = 0

# The up direction.
UP = -1

# The down direction.
DOWN = 1

# The letters for rat_1 and rat_2 in the maze.
RAT_1_CHAR = 'J'
RAT_2_CHAR = 'P'


class Rat:
    """ A rat caught in a maze. """

    # Write your Rat methods here.
    def __init__(self, symbol, row, col):
        self.symbol = symbol
        self.row = row
        self.col = col
        self.num_sprouts_eaten = 0

    def set_location(self, row, col):
        self.row = row
        self.col = col

    def eat_sprout(self):
        self.num_sprouts_eaten += 1

    def __str__(self):
        return self.symbol+" at ("+str(self.row)+", "+str(self.col)+") ate "+str(self.num_sprouts_eaten)+" sprouts."


class Maze:
    """ A 2D maze. """

    # Write your Maze methods here.
    def __init__(self, maze, rat_1, rat_2):
        self.maze = maze
        self.rat_1 = rat_1
        self.rat_2 = rat_2
        self.num_sprouts_left = maze.count(SPROUT)

    def is_wall(self, row, col):
        if self.maze[row][col] == WALL:
            return True
        return False

    def get_character(self, row, col):
        if self.rat_1.row == row and self.rat_1.col == col:
            return self.rat_1.symbol
        elif self.rat_2.row == row and self.rat_2.col == col:
            return self.rat_2.symbol
        else:
            return self.maze[row][col]

    def move(self, rat, row, col):
        if row == UP and not self.is_wall(rat.row - 1, rat.col):
            if self.get_character(rat.row - 1, rat.col) == SPROUT:
                self.maze[rat.row - 1][rat.col] = HALL
                rat.eat_sprout()
                self.num_sprouts_left -= 1
            rat.set_location(rat.row - 1, rat.col)
            return True
        elif row == DOWN and not self.is_wall(rat.row + 1, rat.col):
            if self.get_character(rat.row + 1, rat.col) == SPROUT:
                self.maze[rat.row + 1][rat.col] = HALL
                rat.eat_sprout()
                self.num_sprouts_left -= 1
            rat.set_location(rat.row + 1, rat.col)
            return True
        elif col == LEFT and not self.is_wall(rat.row, rat.col - 1):
            if self.get_character(rat.row, rat.col - 1) == SPROUT:
                self.maze[rat.row][rat.col - 1] = HALL
                rat.eat_sprout()
                self.num_sprouts_left -= 1
            rat.set_location(rat.row, rat.col - 1)
            return True
        elif col == RIGHT and not self.is_wall(rat.row, rat.col + 1):
            if self.get_character(rat.row, rat.col + 1) == SPROUT:
                self.maze[rat.row][rat.col + 1] = HALL
                rat.eat_sprout()
                self.num_sprouts_left -= 1
            rat.set_location(rat.row, rat.col + 1)
            return True
        return False

    def __str__(self):
        res = ''
        for i in range(len(self.maze)):
            for j in range(len(self.maze[i])):
                res += self.get_character(i, j)
            res += "\n"
        res += str(self.rat_1)
        res += "\n"
        res += str(self.rat_2)
        return res
