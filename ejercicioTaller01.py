import logging
import threading
import time

# Logger Config
format = "%(asctime)s: %(message)s"
logging.basicConfig(format = format, level = logging.INFO, datefmt= "%H:%M:%S")


# Funcion a ejecutar
def process(limiteSup: int, par: bool):
         
    if par == True:
        for num1 in range(2, limiteSup+1, 2):
            if num1 % 2 == 0:
                logging.info(num1)
                time.sleep(0.05)  
    else:
        for num2 in range (1, limiteSup+1, 2):
            logging.info(num2)
            time.sleep(0.05)

limiteSup = int(input("Ingrese el número que será el límite superior: ")) 
thread1 = threading.Thread(target = process, args = (limiteSup,True)) # la funcion process es basicamente el run
thread2 = threading.Thread(target = process, args = (limiteSup,False))
thread1.start()
thread2.start()