import pytest
from .main import fizzBuzz

@pytest.mark.parametrize("parameter",
    [
        (1.0),
        ("Hola"),
        (True)
    ]
)
def test_fizzBuzz_only_accept_one_integer_parameter(parameter):
    assert fizzBuzz(parameter) == Exception


@pytest.mark.parametrize("number, expected",
    [
        (1,1),
        (2,2),
        (4,4)
    ]
)
def test_fizzBuzz_have_to_return_number(number, expected):
    assert fizzBuzz(number) == expected


@pytest.mark.parametrize("number",
    [
        (3),
        (6),
        (9)
    ]
)
def test_fizzBuzz_have_to_return_fizz_if_parameter_is_multiple_of_3(number):
    assert fizzBuzz(number) == "fizz"
    
@pytest.mark.parametrize("number",
    [
        (5),
        (10),
        (20)
    ]
)
def test_fizzBuzz_have_to_return_buzz_if_parameter_is_multiple_of_5(number):
    assert fizzBuzz(number) == "buzz"
    
@pytest.mark.parametrize("number",
    [
        (15),
        (30),
        (45)
    ]
)
def test_fizzBuzz_have_to_return_fizzbuzz_if_parameter_is_multiple_of_3_and_5(number):
    assert fizzBuzz(number) == "fizzBuzz"