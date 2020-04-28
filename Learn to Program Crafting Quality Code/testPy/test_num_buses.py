import a1
import unittest


class TestNumBuses(unittest.TestCase):
    """ Test class for function a1.num_buses. """

    """ Test for case if no buses are needed 
        input = 0
    """
    def test_zero_case(self):
        actual = a1.num_buses(0)
        expected = 0
        self.assertEqual(actual, expected)

    """ Test for general case if value is less than one bus capacity
        input = 25.
    """
    def test_less_than_50(self):
        actual = a1.num_buses(25)
        expected = 1
        self.assertEqual(actual, expected)

    """ Test for case if value is equal to one bus capacity
        input = 50.
    """
    def test_on_50_border(self):
        actual = a1.num_buses(50)
        expected = 1
        self.assertEqual(actual, expected)

    """ Test for case if value is more than one bus capacity
        input = 75.
    """
    def test_more_than_50(self):
        actual = a1.num_buses(75)
        expected = 2
        self.assertEqual(actual, expected)


if __name__ == '__main__':
    unittest.main(exit=False)