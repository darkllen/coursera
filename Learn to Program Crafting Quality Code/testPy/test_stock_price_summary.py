import a1
import unittest


class TestStockPriceSummary(unittest.TestCase):
    """ Test class for function a1.stock_price_summary. """

    """ Test for general case 
        input include positive, negative and zero values
        input = [0.01, 0.03, -0.02, -0.14, 0, 0, 0.10, -0.01]
    """
    def test_general_case(self):
        values = [0.01, 0.03, -0.02, -0.14, 0, 0, 0.10, -0.01]
        actual = a1.stock_price_summary(values)
        expected = (0.14, -0.17)
        self.assertEqual(actual, expected)

    """ Test for case if list is empty 
        input = []
    """
    def test_zero_list_case(self):
        values = []
        actual = a1.stock_price_summary(values)
        expected = (0, 0)
        self.assertEqual(actual, expected)

    """ Test for case if list consists of one zero value 
        input = [0]
    """
    def test_one_zero_case(self):
        values = [0]
        actual = a1.stock_price_summary(values)
        expected = (0, 0)
        self.assertEqual(actual, expected)

    """ Test for case if list consists of one positive value 
        input = [0.4]
    """
    def test_one_positive_case(self):
        values = [0.4]
        actual = a1.stock_price_summary(values)
        expected = (0.4, 0)
        self.assertEqual(actual, expected)

    """ Test for case if list consists of one negative value 
        input = [-0.4]
    """
    def test_one_negative_case(self):
        values = [-0.4]
        actual = a1.stock_price_summary(values)
        expected = (0, -0.4)
        self.assertEqual(actual, expected)

    """ Test for case if list consists of few zero values 
        input = [0, 0, 0]
    """
    def test_few_zeroes_case(self):
        values = [0, 0, 0]
        actual = a1.stock_price_summary(values)
        expected = (0, 0)
        self.assertEqual(actual, expected)

    """ Test for case if list consists of few positive values
        input = [0.01, 0.03, 0.10]
    """
    def test_few_positive_case(self):
        values = [0.01, 0.03, 0.10]
        actual = a1.stock_price_summary(values)
        expected = (0.14, 0)
        self.assertEqual(actual, expected)

    """ Test for case if list consists of few negative values
        input = [-0.02, -0.14, -0.01]
    """
    def test_few_negative_case(self):
        values = [-0.02, -0.14, -0.01]
        actual = a1.stock_price_summary(values)
        expected = (0, -0.17)
        self.assertEqual(actual, expected)



if __name__ == '__main__':
    unittest.main(exit=False)