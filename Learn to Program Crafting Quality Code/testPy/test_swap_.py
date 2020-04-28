import a1
import unittest


class TestSwapK(unittest.TestCase):
    """ Test class for function a1.swap_k. """

    """ Test general case
        input =  [1, 2, 3, 4, 5, 6]
        k = 2
    """
    def test_general_case(self):
        actual = [1, 2, 3, 4, 5, 6]
        k = 2
        a1.swap_k(actual, k)
        expected = [5, 6, 3, 4, 1, 2]
        self.assertEqual(actual, expected)

    """ Test for case if list is empty 
        input =  []
        k = 0
    """
    def test_zero_list_case(self):
        actual = []
        k = 0
        a1.swap_k(actual, k)
        expected = []
        self.assertEqual(actual, expected)

    """ Test for case if list consists of 1 value 
        input =  [1]
        k = 0
    """
    def test_one_value_case(self):
        actual = [1]
        k = 0
        a1.swap_k(actual, k)
        expected = [1]
        self.assertEqual(actual, expected)

    """ Test for case if list consists of 2 values
        input =  [1, 2]
        k = 1
    """
    def test_two_values_case(self):
        actual = [1, 2]
        k = 1
        a1.swap_k(actual, k)
        expected = [2, 1]
        self.assertEqual(actual, expected)

    """ Test for case if list consists of odd number of values and k is max possible
        input =   [1, 2, 3, 4, 5, 6, 7]
        k = 3
    """
    def test_full_swap_odd_case(self):
        actual = [1, 2, 3, 4, 5, 6, 7]
        k = 3
        a1.swap_k(actual, k)
        expected = [5, 6, 7, 4, 1, 2, 3]
        self.assertEqual(actual, expected)

    """ Test for case if list consists of even number of values and k is max possible
        input =   [1, 2, 3, 4, 5, 6]
        k = 3
    """
    def test_full_swap_even_case(self):
        actual = [1, 2, 3, 4, 5, 6]
        k = 3
        a1.swap_k(actual, k)
        expected = [4, 5, 6, 1, 2, 3]
        self.assertEqual(actual, expected)

if __name__ == '__main__':
    unittest.main(exit=False)