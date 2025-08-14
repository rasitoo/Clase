	ORG	600H ; Variables
Tabla DB 3,9,1,0
ORG 2000h ; Programa Principal
MOV AH, sum1
MOV AL, sum2
ADD AH, AL
MOV resul, AH
	END
	