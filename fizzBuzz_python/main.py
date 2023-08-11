def fizzBuzz(number: int):
    if type(number) == int:
        
        if number % 15 == 0:
            return "fizzBuzz"
        if number % 5 ==0:
            return "buzz"
        if number % 3 == 0:
            return "fizz"
        return number
    
    return Exception