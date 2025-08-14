import random
import time
#No sabía hacer que el programa esperara determinado tiempo, lo saqué de https://stackoverflow.com/questions/510348/how-do-i-make-a-time-delay

def random_num():
    _number = random.randint(3, 12)
    _time = random.randint(2, 8)

    time.sleep(_time)
    print(_number)



if __name__ == '__main__' :
    random_num()