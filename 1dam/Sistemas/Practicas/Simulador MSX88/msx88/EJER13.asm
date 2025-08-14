	ORG	600H ; Variables
sum1 DB 50h
sum2 DB 50h
resul DB 0h
ORG 2000h ; Programa Principal
MOV AH, sum1
MOV AL, sum2
ADD AH, AL
MOV resul, AH
	END
	